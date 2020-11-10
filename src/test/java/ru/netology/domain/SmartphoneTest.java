package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(3, "GalaxyS8", 20000, "Samsung");

    @Test

        void matchesForExistingSmartphone() {
            smartphone.matches("GalaxyS8");
            assertEquals(true,smartphone.matches("GalaxyS8"));
        }

        @Test
        void matchesForExistingSmartphoneWithoutName() {
            smartphone.matches("Samsung");
            assertEquals(true,smartphone.matches("Samsung"));
        }

        @Test
        void matchesForNonExistingSmartphone() {
            smartphone.matches("Iphone8");
            assertEquals(false,smartphone.matches("Iphone8"));
        }
    }
