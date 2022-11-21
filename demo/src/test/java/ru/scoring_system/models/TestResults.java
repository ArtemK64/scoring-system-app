package ru.scoring_system.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestResults {

    @Test
    void checkResults() {
        ru.scoring_system.models.Test firstTest = new ru.scoring_system.models.Test("A","A", "A", "A", "A");
        assertEquals(5, firstTest.checkResults(firstTest, List.of("A", "a", "a", "A", "a")));

        ru.scoring_system.models.Test secondTest = new ru.scoring_system.models.Test("B","A", "c", "A", "C");
        assertEquals(3, secondTest.checkResults(secondTest, List.of("b", "a", "a", "A", "a")));

        ru.scoring_system.models.Test thirdTest = new ru.scoring_system.models.Test("b","b", "b", "c", "b");
        assertEquals(0, thirdTest.checkResults(thirdTest, List.of("a", "a", "a", "a", "a")));
    }

    @Test
    void testConclusion() {
        ru.scoring_system.models.Test test = new ru.scoring_system.models.Test();
        assertEquals("You understood our article!", test.testConclusion(4));
        assertEquals("You understood our article!", test.testConclusion(5));
        assertEquals("Bad. Should read our article again", test.testConclusion(2));
    }
}