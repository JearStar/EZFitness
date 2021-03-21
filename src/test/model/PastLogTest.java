package model;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.TreadMill;
import listofexercises.muscleexercises.Deadlift;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PastLogTest {
    PastLog testPastLog;
    WorkoutSession testWorkoutSession1;
    WorkoutSession testWorkoutSession2;
    TreadMill testTreadmill;
    Deadlift testDeadlift;
    Bicycle testBicycle;


    @BeforeEach
    public void setup() {
        testBicycle = new Bicycle();
        testDeadlift = new Deadlift();
        testTreadmill = new TreadMill();
        testPastLog = new PastLog();
        testWorkoutSession1 = new WorkoutSession();
        testWorkoutSession1.setSessionName("testSession1");
        testWorkoutSession1.addWorkout(testTreadmill);
        testWorkoutSession1.addWorkout(testDeadlift);

        testWorkoutSession2 = new WorkoutSession();
        testWorkoutSession2.setSessionName("testSession2");
        testWorkoutSession2.addWorkout(testTreadmill);
        testWorkoutSession2.addWorkout(testDeadlift);
        testWorkoutSession2.addWorkout(testBicycle);

    }

    @Test
    public void testAddAndGetSession() {
        testPastLog.addSession(testWorkoutSession1);
        assertEquals(1, testPastLog.getPastWorkoutSessions().size());
        assertEquals(testWorkoutSession1, testPastLog.getPastWorkoutSessions().get(0));

        testPastLog.addSession(testWorkoutSession2);
        assertEquals(2, testPastLog.getPastWorkoutSessions().size());
        assertEquals(testWorkoutSession2, testPastLog.getPastWorkoutSessions().get(1));
    }

    @Test
    public void testRemoveSession() {
        testPastLog.addSession(testWorkoutSession1);
        testPastLog.addSession(testWorkoutSession2);

        testPastLog.removeWorkoutSession("testSession1");
        assertEquals(1, testPastLog.getPastWorkoutSessions().size());
        assertFalse(testPastLog.getPastWorkoutSessions().contains(testWorkoutSession1));

        testPastLog.removeWorkoutSession("testSession2");
        assertEquals(0, testPastLog.getPastWorkoutSessions().size());
        assertFalse(testPastLog.getPastWorkoutSessions().contains(testWorkoutSession2));
    }

    @Test
    public void testClearAllWorkoutSessions() {
        testPastLog.addSession(testWorkoutSession1);
        testPastLog.addSession(testWorkoutSession2);
        assertEquals(2, testPastLog.getPastWorkoutSessions().size());
        testPastLog.clearAllWorkoutSessions();
        assertEquals(0, testPastLog.getPastWorkoutSessions().size());
    }

    @Test
    public void testGetPastSessionNames() {
        testPastLog.addSession(testWorkoutSession1);
        testPastLog.addSession(testWorkoutSession2);
        List<String> expectedList = new ArrayList<>();
        expectedList.add("testSession1");
        expectedList.add("testSession2");

        assertEquals(expectedList, testPastLog.getPastSessionNames());
    }

    @Test
    public void testFindWorkoutSession() {
        testPastLog.addSession(testWorkoutSession1);
        testPastLog.addSession(testWorkoutSession2);
        assertEquals(testWorkoutSession1, testPastLog.findWorkoutSession("testSession1"));
        assertEquals(testWorkoutSession2, testPastLog.findWorkoutSession("testSession2"));
    }
}
