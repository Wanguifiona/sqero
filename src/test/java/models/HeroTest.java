package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = new Hero("Ironman");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithContent_true() throws Exception {
        Hero hero = new Hero("Ironman");
        assertEquals("Ironman", hero.getName());

    }

    @After
    public void tearDown() {
        Hero.clearAllHeros(); //clear out all the posts before each test.
    }

    @Test
    public void AllHerosAreCorrectlyReturned_true() {
        Hero hero = new Hero("Ironman");
        Hero otherHero = new Hero("Hulk");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllHerosContainsAllHeros_true() {
        Hero hero = new Hero("Ironman");
        Hero otherHero = new Hero("Hulk");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getId_heroInstantiateWithAnID_1() throws Exception {
        Hero.clearAllHeros();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Hero myHero = new Hero("Day 1: Intro");
        assertEquals(1, myHero.getId());

    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero hero = new Hero("Ironman");
        Hero otherHero = new Hero("Hulk");
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }
}