package model;

import listofexercises.muscleexercises.BarbellCurl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Workout.BCURL;
import static model.Workout.BI;
import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    Workout testMuscleExercise;
    List<String> barbellCurlMuscleGroups;

    @BeforeEach
    public void setup() {
        testMuscleExercise = new BarbellCurl();
        barbellCurlMuscleGroups = new ArrayList<>();
        barbellCurlMuscleGroups.add(BI);
    }

    @Test
    public void testGetMuscleGroup() {

        assertEquals(barbellCurlMuscleGroups, testMuscleExercise.getMuscleGroup());
    }

    @Test
    public void testAddOneMuscleGroup() {

        assertEquals(1, testMuscleExercise.getMuscleGroup().size());
        assertEquals(barbellCurlMuscleGroups, testMuscleExercise.getMuscleGroup());

        barbellCurlMuscleGroups.add("Test Muscle Group");

        testMuscleExercise.addMuscleGroup("Test Muscle Group");

        assertEquals(2, testMuscleExercise.getMuscleGroup().size());
        assertEquals(barbellCurlMuscleGroups, testMuscleExercise.getMuscleGroup());
    }

    @Test
    public void testAddMultipleMuscleGroup() {
        assertEquals(1, testMuscleExercise.getMuscleGroup().size());
        testMuscleExercise.addMuscleGroup("a");
        testMuscleExercise.addMuscleGroup("b");
        testMuscleExercise.addMuscleGroup("c");
        testMuscleExercise.addMuscleGroup("d");
        testMuscleExercise.addMuscleGroup("e");
        testMuscleExercise.addMuscleGroup("f");
        testMuscleExercise.addMuscleGroup("g");
        testMuscleExercise.addMuscleGroup("h");
        testMuscleExercise.addMuscleGroup("i");
        testMuscleExercise.addMuscleGroup("j");
        testMuscleExercise.addMuscleGroup("k");
        testMuscleExercise.addMuscleGroup("l");
        testMuscleExercise.addMuscleGroup("m");
        testMuscleExercise.addMuscleGroup("n");
        testMuscleExercise.addMuscleGroup("o");
        testMuscleExercise.addMuscleGroup("p");
        testMuscleExercise.addMuscleGroup("q");
        assertEquals(18, testMuscleExercise.getMuscleGroup().size());

        barbellCurlMuscleGroups.add("a");
        barbellCurlMuscleGroups.add("b");
        barbellCurlMuscleGroups.add("c");
        barbellCurlMuscleGroups.add("d");
        barbellCurlMuscleGroups.add("e");
        barbellCurlMuscleGroups.add("f");
        barbellCurlMuscleGroups.add("g");
        barbellCurlMuscleGroups.add("h");
        barbellCurlMuscleGroups.add("i");
        barbellCurlMuscleGroups.add("j");
        barbellCurlMuscleGroups.add("k");
        barbellCurlMuscleGroups.add("l");
        barbellCurlMuscleGroups.add("m");
        barbellCurlMuscleGroups.add("n");
        barbellCurlMuscleGroups.add("o");
        barbellCurlMuscleGroups.add("p");
        barbellCurlMuscleGroups.add("q");

        assertEquals(barbellCurlMuscleGroups, testMuscleExercise.getMuscleGroup());

    }

    @Test
    public void testGetWorkoutName() {
        assertEquals(BCURL, testMuscleExercise.getWorkoutName());
    }
}