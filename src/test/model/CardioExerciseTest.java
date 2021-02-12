package model;

import listofexercises.cardioexercises.Bicycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardioExerciseTest {
    CardioExercise testExercise;
    @BeforeEach
    public void setup(){
        testExercise = new Bicycle();
    }

    @Test
    public void testSetTime(){
        testExercise.setTime(-1);
        assertEquals(1, testExercise.getTime());
        testExercise.setTime(2);
        assertEquals(2, testExercise.getTime());
        testExercise.setTime(5);
        assertEquals(5, testExercise.getTime());
    }

    @Test
    public void testGetDetails(){
        testExercise.setTime(10);
        assertEquals("Time: 10.0 minutes", testExercise.getSummary());

    }
}
