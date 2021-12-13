package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Avengers");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void SquadInstantiatesWithContent_true() throws Exception {
        Squad squad = new Squad("Ironman");
        assertEquals("Ironman", squad.getName());

    }

    @After
    public void tearDown() {
        Squad.clearAllSquads(); //clear out all the posts before each test.
    }

    @Test
    public void AllSquadAreCorrectlyReturned_true() {
        Squad squad = new Squad("Avengers ");
        Squad otherSquad = new Squad("justice league");
        assertEquals(2, Squad.getAll().size());
    }

    @Test
    public void AllSquadsContainsAllSquads_true() {
        Squad squad = new Squad("Avengers ");
        Squad otherSquad= new Squad("Justice league");
        assertTrue(Squad.getAll().contains(squad));
        assertTrue(Squad.getAll().contains(otherSquad));
    }

    @Test
    public void getId_squadInstantiateWithAnID_1() throws Exception {
        Squad.clearAllSquads();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Squad mySquad = new Squad("Avengers");
        assertEquals(1, mySquad.getId());

    }
    @Test
    public void findReturnsCorrectSquadWhenMoreThanOneSquadExists() throws Exception {
        Squad squad = new Squad("Avengers");
        Squad otherSquad = new Squad("Justice league");
        assertEquals(2, Squad.findById(otherSquad.getId()).getId());
    }
}

