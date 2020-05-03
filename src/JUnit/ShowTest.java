package JUnit;

import ADT.Performance;
import ADT.Show;
import Utils.LinkedList.LinkedList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//Necessary JUnit tests
public class ShowTest {

    private Show s = new Show("Shawshank Redemption", 240, null, null, 20, 30, 40);
    private Performance p = new Performance(s, null, true);

    @Before
    public void setUp() throws Exception {
        s.performanceList = new LinkedList<Performance>();
        s.performanceList.AddNode(new Performance(s, null, true));
    }

    @After
    public void tearDown() throws Exception {
        p = null;
        s = null;
    }

    @Test
    public void getPerformanceList() {
        assertEquals(p.isTimeIsMatinee(), s.performanceList.GetNodeAtPos(0).isTimeIsMatinee());
    }

    @Test
    public void getTitle() {
        assertEquals("Shawshank Redemption", s.getTitle());
    }

    @Test
    public void getRunningTime() {
        assertEquals(240, s.getRunningTime());
    }

    @Test
    public void getBalconyTicketPrice() {
        assertEquals(20, s.getBalconyTicketPrice(), 0);
    }

    @Test
    public void getCircleTicketPrice() {
        assertEquals(30, s.getCircleTicketPrice(), 0);
    }

    @Test
    public void getStallTicketPrice() {
        assertEquals(40, s.getStallTicketPrice(), 0);
    }
}