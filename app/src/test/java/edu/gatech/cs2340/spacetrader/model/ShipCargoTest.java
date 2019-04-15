package edu.gatech.cs2340.spacetrader.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ShipCargoTest {

    private static Ship ship;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        ship = new Ship();
        ship.addCargo("Single", 1);
        ship.addCargo("Moar", 2);
    }

    @Test
    public void getCargoTest() {
        // quantity test
        assertEquals(1, ship.getCargo("Single"));
        assertNotEquals(2, ship.getCargo("Single"));

        // non-existent cargo
        assertEquals(0, ship.getCargo("Double"));

        // add new brand new item
        ship.addCargo("Triple", 3);
        assertEquals(3, ship.getCargo("Triple"));

        // add additional cargo
        assertEquals(2, ship.getCargo("Moar"));
        ship.addCargo("Moar", 5);
        assertEquals(7, ship.getCargo("Moar"));
    }

    @Test
    public void removeCargoTest() {
        // Remove Completely
        ship.removeCargo("Single", 1);
        assertEquals(0, ship.getCargo("Single"));

        // Partial Remove
        ship.removeCargo("Moar", 1);
        assertEquals(1, ship.getCargo("Moar"));
    }

    @Test
    public void removeNonexistentCargoTest() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("No such cargo itemName to remove");
        ship.removeCargo("Triple", 1);

    }

    @Test
    public void removeTooMuchCargoTest() {
        exception.expect(RuntimeException.class);
        exception.expectMessage("Not enough cargo of this type to remove!");
        ship.removeCargo("Moar", 3);
    }

}