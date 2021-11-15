package Reddit;

import models.*;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import play.mvc.*;
import play.api.libs.json.Json;
import play.libs.ws.*;
import play.api.Application;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import com.fasterxml.jackson.databind.*;
/**
 * This class provides the implementations of different Reddit post lookups
 * @author Saghana Mahesh Sarma
 * @author Sumit Ramesh Bhiungade
 * @author Jai Sahni
 * */
public class RedditHelper {
  private final WSClient ws;
  private final String endpoint;

  public RedditHelper(WSClient ws, String endpoint) {
    this.ws = ws;
    this.endpoint = endpoint;
  }

  private WSRequest getWSInstance() {
    WSRequest req = ws.url(endpoint + "/submission");
    req.addQueryParameter("over_18", "false");
    return req;
  }

  private Function<WSResponse, List<SearchResult>> formatResponse() throws NullPointerException {
    return (WSResponse res) -> {
      try {
        ObjectMapper mapper = new ObjectMapper();
        List<SearchResult> postList = new ArrayList<SearchResult>();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        postList = Arrays.asList(
          mapper.readValue(
            res.asJson().get("data").toString(),
            SearchResult[].class
          )
        );
        return postList;
      } catch (Exception e) {
        return null;
      }
    };
  }
 /**
   * This method is used to search for Reddit Posts for a given subreddit.
   * @author Jai Sahni
   * @param sr - The subreddit for which we need to fetch Reddit posts
   * @return List of reddit posts for a given subreddit
   * */
  public CompletionStage<List<SearchResult>> getSubredditPosts(String sr) {
    WSRequest req = this.getWSInstance();
    req.addQueryParameter("q", "");
    req.addQueryParameter("subreddit", sr);
    req.addQueryParameter("size", "10");

    return req.get().thenApply(formatResponse());
  }
 /**
   * This method is used to search for Reddit Posts for a given author.
   * @author Saghana Mahesh Sarma
   * @param author - The author for which we need to fetch Reddit posts
   * @return List of reddit posts for a given user
   * */
  public CompletionStage<List<SearchResult>> getUserPosts(String author) {
    WSRequest req = this.getWSInstance();
    req.addQueryParameter("q", "");
    req.addQueryParameter("author", author);
    req.addQueryParameter("size", "10");

    return req.get().thenApply(formatResponse());
  }
  /**
   * This method is used to search for Reddit Posts for a given search term.
   * @author Saghana Mahesh Sarma
   * @author Sumit Ramesh Bhiungade
   * @author Jai Sahni
   * @param query - The search term for which reddit posts need to be obtained
   * @return List of reddit posts for a given query
   * */
  public CompletionStage<List<SearchResult>> getSearchResult(String query) {
    WSRequest req = this.getWSInstance();
    req.addQueryParameter("q", query);
    req.addQueryParameter("size", "50");

    return req.get().thenApply(formatResponse());
  }
}
