package model;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.muscleexercises.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Workout.*;
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

//    @Test
//    public void testWhichWorkoutToAdd() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(BCURL);
//        expectedList.add(BPRESS);
//        expectedList.add(BROW);
//        expectedList.add(BSQUAT);
//        expectedList.add(BIKE);
//        expectedList.add(ELLPT);
//        expectedList.add(ROWING);
//
//        testSession.whichWorkoutToAdd(BCURL);
//        testSession.whichWorkoutToAdd(BPRESS);
//        testSession.whichWorkoutToAdd(BROW);
//        testSession.whichWorkoutToAdd(BSQUAT);
//        testSession.whichWorkoutToAdd(BIKE);
//        testSession.whichWorkoutToAdd(ELLPT);
//        testSession.whichWorkoutToAdd(ROWING);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }
//
//    @Test
//    public void testWhichWorkoutToAdd2() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(ROWING);
//        expectedList.add(TREAD);
//        expectedList.add(BICRUNCH);
//        expectedList.add(CCURL);
//        expectedList.add(CEXT);
//        expectedList.add(CFLY);
//        expectedList.add(CALFR);
//
//        testSession.whichWorkoutToAdd2(ROWING);
//        testSession.whichWorkoutToAdd2(TREAD);
//        testSession.whichWorkoutToAdd2(BICRUNCH);
//        testSession.whichWorkoutToAdd2(CCURL);
//        testSession.whichWorkoutToAdd2(CEXT);
//        testSession.whichWorkoutToAdd2(CFLY);
//        testSession.whichWorkoutToAdd2(CALFR);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }
//
//    @Test
//    public void testWhichWorkoutToAdd3() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(CALFR);
//        expectedList.add(CHTPRS);
//        expectedList.add(CHUP);
//        expectedList.add(CLEAN);
//        expectedList.add(DLIFT);
//        expectedList.add(DCURL);
//        expectedList.add(DEXT);
//
//        testSession.whichWorkoutToAdd3(CALFR);
//        testSession.whichWorkoutToAdd3(CHTPRS);
//        testSession.whichWorkoutToAdd3(CHUP);
//        testSession.whichWorkoutToAdd3(CLEAN);
//        testSession.whichWorkoutToAdd3(DLIFT);
//        testSession.whichWorkoutToAdd3(DCURL);
//        testSession.whichWorkoutToAdd3(DEXT);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }
//
//    @Test
//    public void testWhichWorkoutToAdd4() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(DEXT);
//        expectedList.add(DFLY);
//        expectedList.add(DPRESS);
//        expectedList.add(DPULLO);
//        expectedList.add(DRAISE);
//        expectedList.add(DROW);
//        expectedList.add(DSHPR);
//
//        testSession.whichWorkoutToAdd4(DEXT);
//        testSession.whichWorkoutToAdd4(DFLY);
//        testSession.whichWorkoutToAdd4(DPRESS);
//        testSession.whichWorkoutToAdd4(DPULLO);
//        testSession.whichWorkoutToAdd4(DRAISE);
//        testSession.whichWorkoutToAdd4(DROW);
//        testSession.whichWorkoutToAdd4(DSHPR);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }
//    @Test
//    public void testWhichWorkoutToAdd5() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(DSHPR);
//        expectedList.add(FPULL);
//        expectedList.add(HMCURL);
//        expectedList.add(HPREXT);
//        expectedList.add(LMROW);
//        expectedList.add(LATPD);
//        expectedList.add(LGEXT);
//
//        testSession.whichWorkoutToAdd5(DSHPR);
//        testSession.whichWorkoutToAdd5(FPULL);
//        testSession.whichWorkoutToAdd5(HMCURL);
//        testSession.whichWorkoutToAdd5(HPREXT);
//        testSession.whichWorkoutToAdd5(LMROW);
//        testSession.whichWorkoutToAdd5(LATPD);
//        testSession.whichWorkoutToAdd5(LGEXT);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }
//    @Test
//    public void testWhichWorkoutToAdd6() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(LGEXT);
//        expectedList.add(LGRAISE);
//        expectedList.add(LNG);
//        expectedList.add(MTCLB);
//        expectedList.add(PLUP);
//        expectedList.add(PSUP);
//        expectedList.add(RVDFLY);
//
//        testSession.whichWorkoutToAdd6(LGEXT);
//        testSession.whichWorkoutToAdd6(LGRAISE);
//        testSession.whichWorkoutToAdd6(LNG);
//        testSession.whichWorkoutToAdd6(MTCLB);
//        testSession.whichWorkoutToAdd6(PLUP);
//        testSession.whichWorkoutToAdd6(PSUP);
//        testSession.whichWorkoutToAdd6(RVDFLY);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }
//    @Test
//    public void testWhichWorkoutToAdd7() {
//        List<String> expectedList = new ArrayList<>();
//        expectedList.add(RVDFLY);
//        expectedList.add(RTWIST);
//        expectedList.add(SCKICK);
//        expectedList.add(STLGPRS);
//        expectedList.add(STROW);
//        expectedList.add(SUP);
//        expectedList.add(UROW);
//
//        testSession.whichWorkoutToAdd7(RVDFLY);
//        testSession.whichWorkoutToAdd7(RTWIST);
//        testSession.whichWorkoutToAdd7(SCKICK);
//        testSession.whichWorkoutToAdd7(STLGPRS);
//        testSession.whichWorkoutToAdd7(STROW);
//        testSession.whichWorkoutToAdd7(SUP);
//        testSession.whichWorkoutToAdd7(UROW);
//
//        for (Workout w : testSession.getQueue()) {
//            assertTrue(expectedList.contains(w.getWorkoutName()));
//        }
//
//    }


}