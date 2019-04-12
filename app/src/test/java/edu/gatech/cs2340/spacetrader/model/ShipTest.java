package edu.gatech.cs2340.spacetrader.model;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ShipTest {

    private static Ship ship;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @BeforeClass
    public static void setUp() {
        ship = new Ship();
        ship.addCargo("Test1", 1);
    }

    @Test
    public void addCargoTest() {
        assertTrue(ship.getCargo("Test1") == 1);
    }

    @Test(expected = RuntimeException.class)
    public void addOverLimitTest() {
        ship.addCargo("Test2", 99);
    }

    @Test
    public void getCargoTest() {
        // assert get cargo works
        assertEquals(1, ship.getCargo("Test1"));
        // assert Test2 is not added
        assertNotEquals(99, ship.getCargo("Test2"));
        // assert if statement, where the key is present in map, and assert correct cargo amount
        ship.addCargo("Test1", 1);
        assertEquals(2, ship.getCargo("Test1"));

        // Get item that does not exist from map
        assertEquals(0, ship.getCargo("Test5"));

        // assert else statement, where the key is currently not in map, and assert cargo amount
        ship.addCargo("Test3", 5);
        assertEquals(5, ship.getCargo("Test3"));
    }

}