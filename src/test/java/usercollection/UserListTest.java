package usercollection;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
/**
 * Created by eduard on 1/7/16.
 */
public class UserListTest {

    UserList sut;

    @Before
    public void setUp() throws Exception {
        sut = new UserList();
    }

    @Test
    public void shouldReturnEmptyList(){
        assertNotNull(sut.getUsers());
        assertThat(sut.getUsers(), empty());
    }

    @Test
    public void shouldReturnListWithOneObject(){
        User user = mock(User.class);

        sut.addUser(user);

        assertThat(sut.getUsers(), hasSize(1));
        assertThat(sut.getUsers(), containsInAnyOrder(user));
    }

    @Test
    public void shouldReturnListWithTwoObjects(){
        User userA = mock(User.class, "UserA");
        User userB = mock(User.class, "UserB");

        sut.addUser(userA);
        sut.addUser(userB);

        assertThat(sut.getUsers(), hasSize(2));
        assertThat(sut.getUsers(), contains(userA,userB));
    }
}