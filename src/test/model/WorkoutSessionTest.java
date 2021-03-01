package model;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.muscleexercises.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Workout.*;
import static model.WorkoutSession.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ui.FitnessApp.*;

public class WorkoutSessionTest {
    WorkoutSession testSession;

    @BeforeEach
    public void setup() {
        testSession = new WorkoutSession();
    }

    @Test
    public void testAddWorkout() {
        Bicycle testBicycle = new Bicycle();
        assertEquals(0, testSession.getQueue().size());
        testSession.addWorkout(testBicycle);
        assertEquals(1, testSession.getQueue().size());
        assertTrue(testSession.getQueue().contains(testBicycle));
    }

    @Test
    public void testAddMultipleWorkout() {
        Bicycle testBicycle = new Bicycle();
        Deadlift testDeadlift = new Deadlift();
        ReverseDumbellFly testRDF = new ReverseDumbellFly();

        assertEquals(0, testSession.getQueue().size());
        testSession.addWorkout(testBicycle);
        testSession.addWorkout(testDeadlift);
        testSession.addWorkout(testRDF);
        assertEquals(3, testSession.getQueue().size());
        assertEquals(testBicycle, testSession.getQueue().get(0));
        assertEquals(testDeadlift, testSession.getQueue().get(1));
        assertEquals(testRDF, testSession.getQueue().get(2));
    }

    @Test
    public void testRemoveWorkoutOnlyOneWorkout() {
        Bicycle testBicycle = new Bicycle();
        Deadlift testDeadlift = new Deadlift();
        ReverseDumbellFly testRDF = new ReverseDumbellFly();

        testSession.addWorkout(testBicycle);
        testSession.addWorkout(testDeadlift);
        testSession.addWorkout(testRDF);

        assertEquals(3, testSession.getQueue().size());

        testSession.removeWorkout("deadlift");
        assertEquals(2, testSession.getQueue().size());

        testSession.removeWorkout("reverse dumbell fly");
        assertEquals(1, testSession.getQueue().size());

        testSession.removeWorkout("bicycle");
        assertEquals(0, testSession.getQueue().size());
    }

    @Test
    public void testClearWorkouts() {
        Bicycle testBicycle = new Bicycle();
        Deadlift testDeadlift = new Deadlift();
        ReverseDumbellFly testRDF = new ReverseDumbellFly();

        testSession.addWorkout(testBicycle);
        testSession.addWorkout(testDeadlift);
        testSession.addWorkout(testRDF);

        assertEquals(3, testSession.getQueue().size());
        testSession.clearWorkouts();
        assertEquals(0, testSession.getQueue().size());
    }

    @Test
    public void testLegPresetList() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add(BSQUAT);
        expectedList.add(CALFR);
        expectedList.add(STLGPRS);
        expectedList.add(LGEXT);
        expectedList.add(HMCURL);
        expectedList.add(BIKE);
        expectedList.add(LNG);

        testSession.choosePresetList(LEG_DAY_COMMAND);
        assertEquals(7, testSession.getQueue().size());

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }
    }

    @Test
    public void testChestPresetList() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add(BPRESS);
        expectedList.add(CHTPRS);
        expectedList.add(DPRESS);
        expectedList.add(CFLY);
        expectedList.add(DFLY);
        expectedList.add(PSUP);
        expectedList.add(DPULLO);

        testSession.choosePresetList(CHEST_DAY_COMMAND);
        assertEquals(7, testSession.getQueue().size());

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));

        }
    }

    @Test
    public void testAbsPresetList() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add(BICRUNCH);
        expectedList.add(RTWIST);
        expectedList.add(MTCLB);
        expectedList.add(SUP);
        expectedList.add(SCKICK);
        expectedList.add(LGRAISE);

        testSession.choosePresetList(ABS_DAY_COMMAND);
        assertEquals(6, testSession.getQueue().size());

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }
    }

    @Test
    public void testBackPresetList() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add(BROW);
        expectedList.add(DLIFT);
        expectedList.add(CHUP);
        expectedList.add(PLUP);
        expectedList.add(STROW);
        expectedList.add(RVDFLY);
        expectedList.add(DROW);
        expectedList.add(LATPD);
        expectedList.add(HPREXT);
        expectedList.add(LMROW);

        testSession.choosePresetList(BACK_DAY_COMMAND);
        assertEquals(10, testSession.getQueue().size());

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }
    }

    @Test
    public void testShoulderPresetList() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add(DSHPR);
        expectedList.add(FPULL);
        expectedList.add(UROW);
        expectedList.add(RVDFLY);
        expectedList.add(MTCLB);
        expectedList.add(PSUP);
        expectedList.add(PLUP);

        testSession.choosePresetList(SHOULDER_DAY_COMMAND);
        assertEquals(7, testSession.getQueue().size());

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }
    }

    @Test
    public void testArmPresetList() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add(DCURL);
        expectedList.add(DEXT);
        expectedList.add(CCURL);
        expectedList.add(CEXT);
        expectedList.add(BCURL);

        testSession.choosePresetList(ARM_DAY_COMMAND);
        assertEquals(5, testSession.getQueue().size());

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }
    }

    @Test
    public void testWhichWorkoutToAddNull(){
        List<String> expectedList = new ArrayList<>();
        testSession.addWorkout(whichWorkoutToAdd7("asdf"));
        assertEquals(0, expectedList.size());
    }

    @Test
    public void testWhichWorkoutToAdd() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(BCURL);
        expectedList.add(BPRESS);
        expectedList.add(BROW);
        expectedList.add(BSQUAT);
        expectedList.add(BIKE);
        expectedList.add(ELLPT);
        expectedList.add(ROWING);

        testSession.addWorkout(whichWorkoutToAdd(BCURL));
        testSession.addWorkout(whichWorkoutToAdd(BPRESS));
        testSession.addWorkout(whichWorkoutToAdd(BROW));
        testSession.addWorkout(whichWorkoutToAdd(BSQUAT));
        testSession.addWorkout(whichWorkoutToAdd(BIKE));
        testSession.addWorkout(whichWorkoutToAdd(ELLPT));
        testSession.addWorkout(whichWorkoutToAdd(ROWING));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }

    @Test
    public void testWhichWorkoutToAdd2() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(ROWING);
        expectedList.add(TREAD);
        expectedList.add(BICRUNCH);
        expectedList.add(CCURL);
        expectedList.add(CEXT);
        expectedList.add(CFLY);
        expectedList.add(CALFR);

        testSession.addWorkout(whichWorkoutToAdd2(ROWING));
        testSession.addWorkout(whichWorkoutToAdd2(TREAD));
        testSession.addWorkout(whichWorkoutToAdd2(BICRUNCH));
        testSession.addWorkout(whichWorkoutToAdd2(CCURL));
        testSession.addWorkout(whichWorkoutToAdd2(CEXT));
        testSession.addWorkout(whichWorkoutToAdd2(CFLY));
        testSession.addWorkout(whichWorkoutToAdd2(CALFR));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }

    @Test
    public void testWhichWorkoutToAdd3() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(CALFR);
        expectedList.add(CHTPRS);
        expectedList.add(CHUP);
        expectedList.add(CLEAN);
        expectedList.add(DLIFT);
        expectedList.add(DCURL);
        expectedList.add(DEXT);

        testSession.addWorkout(whichWorkoutToAdd3(CALFR));
        testSession.addWorkout(whichWorkoutToAdd3(CHTPRS));
        testSession.addWorkout(whichWorkoutToAdd3(CHUP));
        testSession.addWorkout(whichWorkoutToAdd3(CLEAN));
        testSession.addWorkout(whichWorkoutToAdd3(DLIFT));
        testSession.addWorkout(whichWorkoutToAdd3(DCURL));
        testSession.addWorkout(whichWorkoutToAdd3(DEXT));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }

    @Test
    public void testWhichWorkoutToAdd4() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(DEXT);
        expectedList.add(DFLY);
        expectedList.add(DPRESS);
        expectedList.add(DPULLO);
        expectedList.add(DRAISE);
        expectedList.add(DROW);
        expectedList.add(DSHPR);

        testSession.addWorkout(whichWorkoutToAdd4(DEXT));
        testSession.addWorkout(whichWorkoutToAdd4(DFLY));
        testSession.addWorkout(whichWorkoutToAdd4(DPRESS));
        testSession.addWorkout(whichWorkoutToAdd4(DPULLO));
        testSession.addWorkout(whichWorkoutToAdd4(DRAISE));
        testSession.addWorkout(whichWorkoutToAdd4(DROW));
        testSession.addWorkout(whichWorkoutToAdd4(DSHPR));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }

    @Test
    public void testWhichWorkoutToAdd5() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(DSHPR);
        expectedList.add(FPULL);
        expectedList.add(HMCURL);
        expectedList.add(HPREXT);
        expectedList.add(LMROW);
        expectedList.add(LATPD);
        expectedList.add(LGEXT);

        testSession.addWorkout(whichWorkoutToAdd5(DSHPR));
        testSession.addWorkout(whichWorkoutToAdd5(FPULL));
        testSession.addWorkout(whichWorkoutToAdd5(HMCURL));
        testSession.addWorkout(whichWorkoutToAdd5(HPREXT));
        testSession.addWorkout(whichWorkoutToAdd5(LMROW));
        testSession.addWorkout(whichWorkoutToAdd5(LATPD));
        testSession.addWorkout(whichWorkoutToAdd5(LGEXT));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }

    @Test
    public void testWhichWorkoutToAdd6() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(LGEXT);
        expectedList.add(LGRAISE);
        expectedList.add(LNG);
        expectedList.add(MTCLB);
        expectedList.add(PLUP);
        expectedList.add(PSUP);
        expectedList.add(RVDFLY);

        testSession.addWorkout(whichWorkoutToAdd6(LGEXT));
        testSession.addWorkout(whichWorkoutToAdd6(LGRAISE));
        testSession.addWorkout(whichWorkoutToAdd6(LNG));
        testSession.addWorkout(whichWorkoutToAdd6(MTCLB));
        testSession.addWorkout(whichWorkoutToAdd6(PLUP));
        testSession.addWorkout(whichWorkoutToAdd6(PSUP));
        testSession.addWorkout(whichWorkoutToAdd6(RVDFLY));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }

    @Test
    public void testWhichWorkoutToAdd7() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add(RVDFLY);
        expectedList.add(RTWIST);
        expectedList.add(SCKICK);
        expectedList.add(STLGPRS);
        expectedList.add(STROW);
        expectedList.add(SUP);
        expectedList.add(UROW);

        testSession.addWorkout(whichWorkoutToAdd7(RVDFLY));
        testSession.addWorkout(whichWorkoutToAdd7(RTWIST));
        testSession.addWorkout(whichWorkoutToAdd7(SCKICK));
        testSession.addWorkout(whichWorkoutToAdd7(STLGPRS));
        testSession.addWorkout(whichWorkoutToAdd7(STROW));
        testSession.addWorkout(whichWorkoutToAdd7(SUP));
        testSession.addWorkout(whichWorkoutToAdd7(UROW));

        for (Workout w : testSession.getQueue()) {
            assertTrue(expectedList.contains(w.getWorkoutName()));
        }

    }


}