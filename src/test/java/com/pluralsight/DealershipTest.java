package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {

    @Test
    void getName() {
        Dealership deal1 = new Dealership("bob","12234 beradgert","09231");
        assertEquals("bob", deal1.getName());
    }

    @Test
    void getAddress() {
        Dealership deal1 = new Dealership("bob","12234 beradgert","09231");
        assertEquals("12234 beradgert",deal1.getAddress());
    }

    @Test
    void getPhone() {
        Dealership deal1 = new Dealership("bob","12234 beradgert","09231");
        assertEquals("09231", deal1.getPhone());
    }

}