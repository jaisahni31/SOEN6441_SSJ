package actors;

import models.*;

import akka.actor.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Reddit.RedditHelper;
import play.libs.ws.*;
import play.libs.Json;

import scala.concurrent.duration.Duration;
import java.util.concurrent.TimeUnit;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class SubredditActor extends AbstractActorWithTimers {
  private Map<String, ActorRef> actorsList = new LinkedHashMap<>();
	private RedditHelper helper;

  public SubredditActor(RedditHelper helper) {
    this.helper = helper;
  }

  public static Props props(RedditHelper instance) {
    return Props.create(
      SubredditActor.class,
      () -> new SubredditActor(instance)
    );
  }

  private static final class Tick {}
  public static class RegisterMsg {
		private final String keyword;
		public RegisterMsg(String keyword) {
			this.keyword = keyword;
		}
	}

  @Override
	public void preStart() {
		getTimers()
      .startPeriodicTimer(
      "Timer",
      new Tick(),
      Duration.create(10, TimeUnit.SECONDS)
    );
	}

  private void notifyClients() {
    actorsList.forEach((key, instance) -> {
      helper
        .getSubredditPosts(key)
        .thenApply((list) -> {
          UserActor.Response data = new UserActor.Response(list, "thread", key);
          instance.tell(data, self());
          return list;
        });
    });
  }

  @Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(RegisterMsg.class, register -> {
          actorsList.put(register.keyword, sender());
        })
				.match(Tick.class, obj -> notifyClients())
				.matchEquals("stopActors", s -> {
          System.out.println("got stop sign");
        })
				.build();
	}
}
