package actors;
import Reddit.RedditHelper;
import models.QuerySearchResult;
import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;


import java.util.LinkedHashMap;
import java.util.Map;

public class WordCountActor extends AbstractActorWithTimers {
    private Map<String, ActorRef> actorsList = new LinkedHashMap<>();
    private QuerySearchResult helper;

    public WordCountActor(QuerySearchResult helper) {
        this.helper = helper;
    }

    public static Props props(QuerySearchResult instance) {
        return Props.create(WordCountActor.class, instance);
    }
    private static final class Tick {}

    public static class RegisterMsg {
        private final String keyword;
        public RegisterMsg(String keyword) {
            this.keyword = keyword;
        }
    }

    private void notifyClients() {
        actorsList.forEach((key, instance) -> {
            helper
                    .getAnalytics()
                    .thenApply((list) -> {
                        UserActor.Response data = new UserActor.Response(list, "word_analytics");
                        instance.tell(data, self());
                        return list;
                    });
        });
    }
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WordCountActor.RegisterMsg.class, register -> actorsList.put(register.keyword, sender()))
                .match(WordCountActor.Tick.class, obj -> notifyClients())
                .matchEquals("stopActors", s -> System.out.println("got stop sign"))
                .build();
    }
}
