//package models;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CacheManagerTest {
//
//
//
////    @Mock
////    HashMap<String, QuerySearchResult> userResults;
//
//    @InjectMocks
//    CacheManager cacheManager;
//
//    @Before
//    public void setUp() throws Exception{
//        MockitoAnnotations.initMocks(this);
//    }
//
////    @Test
////    public void getUserInfoTest() throws ExecutionException, InterruptedException {
////        HashMap<String, QuerySearchResult> userResults = new HashMap<>();
////
////        SearchResult searchResult = new SearchResult();
////        SearchResult searchResult2 = new SearchResult();
////        List<SearchResult> searchResultList = new ArrayList<>();
////        searchResultList.add(searchResult);
////        searchResultList.add(searchResult2);
////
////        QuerySearchResult querySearchResult = mock(QuerySearchResult.class);
////        when(querySearchResult.getAllPosts()).thenReturn(searchResultList);
////
////        userResults.put("query",querySearchResult);
////
////
//////        HashMap<String, QuerySearchResult> userResultsMock = mock(HashMap.class);
//////        when(userResultsMock.containsKey(anyString())).thenReturn(false);
//////        when(userResultsMock.get(anyString())).thenReturn(querySearchResult);
//////        CacheManager.class.getDeclaredField()
//////        when(anyMap().containsKey(anyString())).thenReturn(false);
//////        when(anyMap().get(anyString())).thenReturn(querySearchResult);
////        when(userResults.containsKey(anyString())).thenReturn(false);
////        when(userResults.get(anyString())).thenReturn(querySearchResult);
////        CompletableFuture<QuerySearchResult> userInfo = cacheManager.GetUserInfo("query");
////        QuerySearchResult querySearchResult1 = userInfo.toCompletableFuture().get();
////
////
////    }
//}
