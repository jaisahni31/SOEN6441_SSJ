package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class SearchResultTest {
    @Test
    public void constructorTest(){
        SearchResult searchResult = new SearchResult();
        assertNotNull(searchResult);
    }
}
