package persistence;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.TreadMill;
import listofexercises.muscleexercises.BarbellSquat;
import listofexercises.muscleexercises.Deadlift;
import model.WorkoutSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterCurrentTest {

    @Test
    public void testWriterCurrentInvalidFile() {
        try {
            WorkoutSession ws = new WorkoutSession();
            JsonWriterCurrent writer = new JsonWriterCurrent("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    public void testWriterCurrentEmptyWorkoutSession() {
        try {
            WorkoutSession ws = new WorkoutSession();
            ws.setSessionName("testSession");
            JsonWriterCurrent writer = new JsonWriterCurrent("./data/testWriterCurrentEmptyWorkoutSession.json");
            writer.open();
            writer.write(ws);
            writer.close();

            JsonReaderCurrent reader = new JsonReaderCurrent("./data/testWriterCurrentEmptyWorkoutSession.json");
            ws = reader.read();
            assertEquals("testSession", ws.getSessionName());
            assertEquals(0, ws.getFinishedList().size());
            assertEquals(0, ws.getQueue().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    public void testWriterCurrentGeneralWorkoutSession() {
        List<Double> infoListBSquat = new ArrayList<>();
        List<Double> infoListBicycle = new ArrayList<>();
        Deadlift testDeadlift = new Deadlift();
        TreadMill testTreadmill = new TreadMill();
        BarbellSquat testBarbellSquat = new BarbellSquat();
        Bicycle testBicycle = new Bicycle();

        infoListBSquat.add(3.0);
        infoListBSquat.add(10.0);
        infoListBSquat.add(180.0);
        infoListBSquat.add(9.0);
        infoListBSquat.add(195.0);
        infoListBSquat.add(3.0);
        infoListBSquat.add(190.0);
        infoListBicycle.add(10.0);

        testBarbellSquat.goThroughWorkout(infoListBSquat);
        testBicycle.goThroughWorkout(infoListBicycle);

        try {
            WorkoutSession ws = new WorkoutSession();
            ws.setSessionName("testSession");
            ws.addWorkout(testDeadlift);
            ws.addWorkout(testTreadmill);

            ws.addToFinalList(testBarbellSquat);
            ws.addToFinalList(testBicycle);

            JsonWriterCurrent writer = new JsonWriterCurrent("./data/testWriterCurrentGeneralWorkoutSession.json");
            writer.open();
            writer.write(ws);
            writer.close();

            JsonReaderCurrent reader = new JsonReaderCurrent("./data/testWriterCurrentGeneralWorkoutSession.json");
            ws = reader.read();
            assertEquals(2, ws.getFinishedList().size());
            assertEquals(2, ws.getQueue().size());
            assertEquals("Deadlift", ws.getQueue().get(0).getWorkoutName());
            assertEquals("Treadmill", ws.getQueue().get(1).getWorkoutName());
            assertEquals("Barbell Squat", ws.getFinishedList().get(0).getWorkoutName());
            assertEquals("Bicycle", ws.getFinishedList().get(1).getWorkoutName());
            assertEquals("Sets: 3\n" +
                    "Reps: 10 9 3 \n" +
                    "Weights: 180 195 190 ", ws.getFinishedList().get(0).getSummary());
            assertEquals("Time: 10.0 minutes", ws.getFinishedList().get(1).getSummary());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

