package actors;

import models.*;
import actors.*;
import Reddit.*;

import org.junit.*;
import play.mvc.*;
import play.libs.ws.*;

import static play.mvc.Results.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.*;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

import play.server.Server;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import play.routing.RoutingDsl;

import scala.concurrent.duration.FiniteDuration;
import java.util.concurrent.TimeUnit;

import akka.testkit.TestProbe;
import akka.testkit.javadsl.TestKit;

public class UserActorTest {
	private WSClient ws;
  private Server server;
  private RedditHelper helper;

  static ActorSystem system;

  /**
   * Setup mock server to listen to http requests being made from tests to route '/submission'
   * and instantiate WSClient, QuerySearchResult, RedditHelper Java
   * @author Saghana Mahesh Sarma
   * */
  @Before
  public void Setup() {
    server = Server.forRouter((components) ->
      RoutingDsl.fromComponents(components)
      .GET("/submission")
      .routingTo(request -> {
        return ok().sendResource("reddit.json");
      }).build()
    );

    ws = play.test.WSTestClient.newClient(server.httpPort());
    helper = new RedditHelper(ws, "");
  }

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		TestKit.shutdownActorSystem(system);
		system = null;
	}

	@Test
	public void test() {
		try {
			final FiniteDuration wait = FiniteDuration.create(20, TimeUnit.SECONDS);
			JsonNodeFactory factory = JsonNodeFactory.instance;
			new TestKit(system) {{
				ActorRef userActor = system.actorOf(UserActor.props(getRef()), "user1");
				ActorRef threadActor = system.actorOf(SubredditActor.props(helper, 1), "thread");

				// Subreddit
				ObjectNode root = factory.objectNode();
				root.put("type", "thread");
				root.put("query", "test");
				userActor.tell(root, getRef());

				ObjectNode response = factory.objectNode();
				response.put("type", "thread");
				response.put("query", "test");
				response.put("data", "[{\"title\":\"test\",\"author\":\"test\",\"selftext\":\"test\",\"subreddit\":\"test\",\"author_fullname\":\"test\",\"author_is_blocked\":\"test\",\"author_premium\":\"test\"}]");

				expectMsgClass(wait, ObjectNode.class);
				expectMsg(wait, response);
			}};
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSearch() {
		try {
			final FiniteDuration wait = FiniteDuration.create(20, TimeUnit.SECONDS);
			JsonNodeFactory factory = JsonNodeFactory.instance;
			new TestKit(system) {{
				ActorRef userActor = system.actorOf(UserActor.props(getRef()), "user2");
				ActorRef searchActor = system.actorOf(SearchActor.props(helper, 1), "search");

				ObjectNode searchRoot = factory.objectNode();
				searchRoot.put("type", "search");
				searchRoot.put("query", "test");
				userActor.tell(searchRoot, getRef());

				ObjectNode searchResponse = factory.objectNode();
				searchResponse.put("type", "search");
				searchResponse.put("query", "test");
				searchResponse.put("data", "[{\"title\":\"test\",\"author\":\"test\",\"selftext\":\"test\",\"subreddit\":\"test\",\"author_fullname\":\"test\",\"author_is_blocked\":\"test\",\"author_premium\":\"test\"}]");

				expectMsgClass(wait, ObjectNode.class);
				expectMsg(wait, searchResponse);
			}};
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
