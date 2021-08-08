package com.example.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        assertEquals("Bob zip", restaurant.getName());
        assertEquals("Seoul", restaurant.getAddress());
        assertEquals(1004, restaurant.getId());
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        assertEquals("Bob zip in Seoul", restaurant.getInformation());

    }

}