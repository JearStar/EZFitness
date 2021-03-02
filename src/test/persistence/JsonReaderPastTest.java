package persistence;

import model.PastLog;
import model.WorkoutSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderPastTest {
    @Test
    void testReaderPastNonExistentFile(){
        JsonReaderPast reader = new JsonReaderPast("./data/noSuchFile.json");
        try {
            PastLog pl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderPastEmptyPastLog(){
        JsonReaderPast reader = new JsonReaderPast("./data/testReaderPastEmptyPastLog.json");
        try {
            PastLog pl = reader.read();
            assertEquals(0, pl.getPastWorkoutSessions().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderPastGeneralPastLog(){
        JsonReaderPast reader = new JsonReaderPast("./data/testReaderPastGeneralPastLog.json");
        try {
            PastLog pl = reader.read();
            assertEquals(2, pl.getPastWorkoutSessions().size());
            assertEquals("Treadmill", pl.getPastWorkoutSessions().get(0).getFinishedList().get(0).getWorkoutName());
            assertEquals("Deadlift", pl.getPastWorkoutSessions().get(0).getFinishedList().get(1).getWorkoutName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
