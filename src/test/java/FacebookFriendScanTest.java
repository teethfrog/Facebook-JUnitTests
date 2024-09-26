import org.junit.jupiter.api.Test;
import org.example.FacebookFriendScan;

import static org.junit.jupiter.api.Assertions.*;

public class FacebookFriendScanTest {
    String ListOfNames = "testnames.txt";
    String ListOfNamesEmpty = "nonames.txt";
    @Test
    public void testValidFacebookLink() {
        String[] friends = FacebookFriendScan.getFriends(ListOfNames);
        assertArrayEquals(new String[]{"David Miller", "David Johnson","Robert Davis"}, friends);
    }

    @Test
    public void testInvalidFacebookLink() {
        String[] friends = FacebookFriendScan.getFriends("invalidLink");
        assertEquals(0, friends.length);
    }

    @Test
    public void testEmptyFriendlist() {
        String[] friends = FacebookFriendScan.getFriends(ListOfNamesEmpty);
        assertEquals(0, friends.length);
    }

    @Test
    public void testNullFacebookLink() {
        String[] friends = FacebookFriendScan.getFriends(null);
        assertEquals(0, friends.length);
    }
}
