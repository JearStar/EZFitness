package persistence;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.Treadmill;
import listofexercises.muscleexercises.BarbellSquat;
import listofexercises.muscleexercises.Deadlift;
import model.PastLog;
import model.WorkoutSession;
import model.exceptions.NegativeValueException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterPastTest {

    @Test
    void testWriterPastInvalidFile() {
        try {
            PastLog pl = new PastLog();
            JsonWriterPast writer = new JsonWriterPast("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterPastEmptyPastLog() {
        try {
            PastLog pl = new PastLog();
            JsonWriterPast writer = new JsonWriterPast("./data/testWriterPastEmptyPastLog.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReaderPast reader = new JsonReaderPast("./data/testWriterPastEmptyPastLog.json");
            pl = reader.read();
            assertEquals(0, pl.getPastWorkoutSessions().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterPastGeneralPastLog() {
        List<Double> testInfoList1 = new ArrayList<>();
        List<Double> testInfoList2 = new ArrayList<>();
        BarbellSquat testBarbellSquat = new BarbellSquat();
        Bicycle testBicycle = new Bicycle();
        Deadlift testDeadlift = new Deadlift();
        Treadmill testTreadmill = new Treadmill();


        testInfoList1.add(3.0);
        testInfoList1.add(10.0);
        testInfoList1.add(180.0);
        testInfoList1.add(9.0);
        testInfoList1.add(195.0);
        testInfoList1.add(8.0);
        testInfoList1.add(190.0);
        testInfoList2.add(10.0);

        try {
            testBarbellSquat.goThroughWorkout(testInfoList1);
            testBicycle.goThroughWorkout(testInfoList2);
            testDeadlift.goThroughWorkout(testInfoList1);
            testTreadmill.goThroughWorkout(testInfoList2);
        } catch (NegativeValueException e) {
            fail("Not expecting exception here");
        }
        WorkoutSession testWorkoutSession1 = new WorkoutSession();
        testWorkoutSession1.addToFinalList(testBarbellSquat);
        testWorkoutSession1.addToFinalList(testBicycle);

        WorkoutSession testWorkoutSession2 = new WorkoutSession();
        testWorkoutSession2.addToFinalList(testDeadlift);
        testWorkoutSession2.addToFinalList(testTreadmill);


        try {
            PastLog pl = new PastLog();
            pl.addSession(testWorkoutSession1);
            pl.addSession(testWorkoutSession2);
            JsonWriterPast writer = new JsonWriterPast("./data/testWriterPastGeneralPastLog.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReaderPast reader = new JsonReaderPast("./data/testWriterPastGeneralPastLog.json");
            pl = reader.read();
            assertEquals(2,
                    pl.getPastWorkoutSessions().size());
            assertEquals("Barbell Squat",
                    pl.getPastWorkoutSessions().get(0).getFinishedList().get(0).getWorkoutName());
            assertEquals("Bicycle",
                    pl.getPastWorkoutSessions().get(0).getFinishedList().get(1).getWorkoutName());

            assertEquals("Sets: 3\n" +
                            "Reps: 10 9 8 \n" +
                            "Weights: 180 195 190 ",
                    pl.getPastWorkoutSessions().get(0).getFinishedList().get(0).getSummary());

            assertEquals("Time: 10.0 minutes",
                    pl.getPastWorkoutSessions().get(0).getFinishedList().get(1).getSummary());

            assertEquals("Deadlift",
                    pl.getPastWorkoutSessions().get(1).getFinishedList().get(0).getWorkoutName());
            assertEquals("Treadmill",
                    pl.getPastWorkoutSessions().get(1).getFinishedList().get(1).getWorkoutName());

            assertEquals("Sets: 3\n" +
                            "Reps: 10 9 8 \n" +
                            "Weights: 180 195 190 ",
                    pl.getPastWorkoutSessions().get(1).getFinishedList().get(0).getSummary());

            assertEquals("Time: 10.0 minutes",
                    pl.getPastWorkoutSessions().get(1).getFinishedList().get(1).getSummary());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
