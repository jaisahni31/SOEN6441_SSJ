package actors;

import models.*;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.PoisonPill;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Reddit.RedditHelper;
import play.libs.ws.*;
import play.libs.Json;

import java.util.List;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.AbstractAction;

public class UserActor extends AbstractActor {
    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private RedditHelper helper;

    private ActorRef actorInstance;

    public UserActor(ActorRef out, WSClient ws, String endpoint) {
        this.actorInstance = out;
        this.helper = new RedditHelper(ws, endpoint);
    }

    public static Props props(ActorRef out, WSClient ws, String endpoint) {
        return Props.create(
            UserActor.class,
            () -> new UserActor(out, ws, endpoint)
        );
    }

    public static class Response {
        public final String type;
        public final String keyword;
        public final List<SearchResult> result;

        public Response(List<SearchResult> results, String type, String keyword) {
            this.type = type;
            this.keyword = keyword;
            this.result = results;
        }
    }

    @Override
    public void preStart() throws Exception {
        log.info(
            "Messenger actor started at {}",
            OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        );
    }

    @Override
    public void postStop() throws Exception {
        log.info(
            "Messenger actor stopped at {}",
            OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        );
    }

    private void onSendMessage(Response node) throws JsonProcessingException  {
        final ObjectNode response = Json.newObject();
        ObjectMapper objectMapper = new ObjectMapper();

        response.put("type", node.type);
        response.put("query", node.keyword);
        response.put("data", objectMapper.writeValueAsString(node.result));

        actorInstance.tell(response, self());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
          .match(Response.class, (response) -> onSendMessage(response))
          .match(JsonNode.class, (json) -> registerNewActor(json))
          .matchAny(o -> log.error("Received unknown message: {}", o.getClass()))
          .build();
    }

    private void registerNewActor(JsonNode json) {
        String type = json.get("type").asText();
        String keyword = json.get("query").asText();

        var actor = context().actorSelection("/user/" + type);

        switch (type) {
	    case "close": {
                self().tell(PoisonPill.getInstance(), self());
                break;
            }
			
            case "thread": {
                actor.tell(new SubredditActor.RegisterMsg(keyword), self());
                break;
            }
			
	    case "userProfile": {
                actor.tell(new UserProfileActor.RegisterMsg(keyword), self());
                break;
            }
		

            default: {
                actor.tell(new SearchActor.RegisterMsg(keyword), self());
                break;
            }
        }
	}
}
