package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private ArrayList<City> cityList = new ArrayList<>();

    @Test
    public void testAddCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton","AB");
        list.addCity(city);
        assertEquals(1, list.getCount());
    }

    @Test
    public void testHasCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        City city2 = new City("Calgary","AB");
        assertFalse(list.hasCity(city));
        list.addCity(city);
        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(city2));
    }

    @Test
    public void testDeleteCity() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertEquals(1, list.getCount());
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertEquals(0, list.getCount());
        assertFalse(list.hasCity(city));
    }
    @Test
    void testDeleteCityException() {
        CustomList list = new CustomList(null, cityList);
        City city = new City("Edmonton", "AB");
        assertThrows(IllegalArgumentException.class, ()-> {
            list.deleteCity(city);
        });
    }

    @Test
    void testCountCities() {
        CustomList list = new CustomList(null, cityList);
        assertEquals(0, list.countCities());
        assertEquals(0, list.getCount());
        City city = new City("Edmonton", "AB");
        cityList.add(city);
        assertEquals(1, list.countCities());
        assertEquals(1, list.getCount());
    }

}
