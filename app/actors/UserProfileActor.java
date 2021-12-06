package actors;

import Reddit.RedditHelper;
import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Creates actor system which fetches the User Profile Info from PushShift API
 * and notify the client of the response
 * @author Sumit Ramesh Bhiungade
 */
public class UserProfileActor extends AbstractActorWithTimers {
    private Map<String, ActorRef> actorsList = new LinkedHashMap<>();
    private RedditHelper helper;


    /**
     * Constructor of the given Class
     * @param helper PushShift api helper instance
     */
    public UserProfileActor(RedditHelper helper) {
        this.helper = helper;
    }

    /**
     * this method is used to create the instantiate a new Props
     * @returns Props
     */
    public static Props props(RedditHelper instance) {
        return Props.create(UserProfileActor.class, instance);
    }



    private static final class Tick {}

    /**
     * this class is used to register messaging instance for actor
     * @author Sumit Ramesh Bhiungade
     */
    public static class RegisterMsg {
        private final String keyword;
        public RegisterMsg(String keyword) {
            this.keyword = keyword;
        }
    }
    
    @Override
    public void preStart() {
        getTimers().startPeriodicTimer(
                        "Timer",
                        new Tick(),
                        Duration.create(10, TimeUnit.SECONDS)
                );
    }

    /**
     * Notifies clients about updates to the User Profile
     * @author Sumit Ramesh Bhiungade
     */

    private void notifyClients() {
        actorsList.forEach((key, instance) -> helper
                .getUserPosts(key)
                .thenApply((list) -> {
                    UserActor.Response data = new UserActor.Response(list, "userProfile", key);
                    instance.tell(data, self());
                    return list;
                }));
    }

    /**
     * Action used to receive and manage the response with Actor class
     * @author Sumit Ramesh Bhiungade
     * @return Receive
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(UserProfileActor.RegisterMsg.class, register -> actorsList.put(register.keyword, sender()))
                .match(UserProfileActor.Tick.class, obj -> notifyClients())
                .matchEquals("stopActors", s -> System.out.println("got stop sign"))
                .build();
    }
}
