package persistence;

import model.CardioExercise;
import model.WorkoutSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderCurrentTest {
    @Test
    void testReaderCurrentNonExistentFile(){
        JsonReaderCurrent reader = new JsonReaderCurrent("./data/noSuchFile.json");
        try {
            WorkoutSession ws = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkoutSession(){
        JsonReaderCurrent reader = new JsonReaderCurrent("./data/testReaderCurrentEmptyWorkoutSession.json");
        try {
            WorkoutSession ws = reader.read();
            assertEquals("01/01/2000 00:00:00", ws.getSessionName());
            assertEquals(0, ws.getFinishedList().size());
            assertEquals(0, ws.getQueue().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkoutSession(){
        JsonReaderCurrent reader = new JsonReaderCurrent("./data/testReaderCurrentGeneralWorkoutSession.json");
        try {
            WorkoutSession ws = reader.read();
            assertEquals("01/01/2000 00:00:00", ws.getSessionName());
            assertEquals("Treadmill", ws.getFinishedList().get(0).getWorkoutName());
            assertEquals("Time: 10.0 minutes", ws.getFinishedList().get(0).getSummary());
            assertEquals("Deadlift", ws.getQueue().get(0).getWorkoutName());
            assertEquals("Bicycle", ws.getQueue().get(1).getWorkoutName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
