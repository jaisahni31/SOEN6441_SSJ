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

// TODO: Auto-generated Javadoc
/**
 * The Class SearchActorTest.
 */
public class SearchActorTest {
	
	/** The ws. */
	private WSClient ws;
  
  /** The server. */
  private Server server;
  
  /** The helper. */
  private RedditHelper helper;

  /** The system. */
  static ActorSystem system;

  /**
   * Setup mock server to listen to http requests being made from tests to route '/submission'
   * and instantiate WSClient, QuerySearchResult, RedditHelper Java.
   *
   * @author Saghana Mahesh Sarma
   */
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

	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	/**
	 * Teardown.
	 */
	@AfterClass
	public static void teardown() {
		TestKit.shutdownActorSystem(system);
		system = null;
	}

	/**
	 * Test.
	 */
	@Test
	public void test() {
		try {
			final FiniteDuration wait = FiniteDuration.create(20, TimeUnit.SECONDS);
			JsonNodeFactory factory = JsonNodeFactory.instance;
			new TestKit(system) {{
				ActorRef threadActor = system.actorOf(SearchActor.props(helper, 1), "search");

				var root = new SearchActor.RegisterMsg("test");
				threadActor.tell(root, getRef());

				expectMsgClass(wait, UserActor.Response.class);
			}};
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
