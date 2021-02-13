package model;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.muscleexercises.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static ui.FitnessApp.*;

public class WorkoutSession {

    private final List<Workout> queue;

    public WorkoutSession() {
        queue = new ArrayList<>();
    }

    //EFFECTS: returns the queue
    public List<Workout> getQueue() {
        return this.queue;
    }

    //MODIFIES: queue
    //EFFECTS: adds workout to queue
    public void addWorkout(Workout w) {
        this.queue.add(w);
    }

    //MODIFIES: queue
    //EFFECTS: removes all instances of a workout from queue
    public void removeWorkout(String s) {
        Iterator<Workout> i = queue.iterator();
        while (i.hasNext()) {
            Workout w = i.next();
            if (w.getWorkoutName().toLowerCase().equals(s)) {
                i.remove();
            }
        }
    }

    //EFFECTS: clears all workouts from queue
    public void clearWorkouts() {
        Iterator<Workout> i = queue.iterator();
        while (i.hasNext()) {
            Workout w = i.next();
            i.remove();
        }
    }

    public void choosePresetList(String c) {
        if (c.equals(LEG_DAY_COMMAND)) {
            addLegDayExercises();
        } else if (c.equals(CHEST_DAY_COMMAND)) {
            addChestDayExercises();
        } else if (c.equals(ARM_DAY_COMMAND)) {
            addArmDayExercises();
        } else if (c.equals(SHOULDER_DAY_COMMAND)) {
            addShoulderDayExercises();
        } else if (c.equals(ABS_DAY_COMMAND)) {
            addAbsDayExercises();
        } else {
            addBackDayExercises();
        }
    }


    private void addBackDayExercises() {
        this.addWorkout(new BarbellRow());
        this.addWorkout(new Deadlift());
        this.addWorkout(new ChinUp());
        this.addWorkout(new PullUp());
        this.addWorkout(new SeatedRow());
        this.addWorkout(new ReverseDumbellFly());
        this.addWorkout(new DumbellRow());
        this.addWorkout(new LatPulldown());
        this.addWorkout(new HyperExtension());
        this.addWorkout(new LandmineRow());

    }

    private void addAbsDayExercises() {
        this.addWorkout(new BicycleCrunch());
        this.addWorkout(new RussianTwist());
        this.addWorkout(new MountainClimber());
        this.addWorkout(new SitUp());
        this.addWorkout(new ScissorKick());
        this.addWorkout(new LegRaise());

    }

    private void addShoulderDayExercises() {
        this.addWorkout(new DumbellShoulderPress());
        this.addWorkout(new FacePull());
        this.addWorkout(new UprightRow());
        this.addWorkout(new ReverseDumbellFly());
        this.addWorkout(new MountainClimber());
        this.addWorkout(new PushUp());
        this.addWorkout(new PullUp());
    }

    private void addArmDayExercises() {
        this.addWorkout(new DumbellCurl());
        this.addWorkout(new DumbellExtension());
        this.addWorkout(new CableCurl());
        this.addWorkout(new CableExtension());
        this.addWorkout(new BarbellCurl());
    }

    private void addChestDayExercises() {
        this.addWorkout(new BarbellPress());
        this.addWorkout(new ChestPress());
        this.addWorkout(new DumbellPress());
        this.addWorkout(new CableFly());
        this.addWorkout(new DumbellFly());
        this.addWorkout(new PushUp());
        this.addWorkout(new DumbellPullover());
    }

    public void addLegDayExercises() {
        this.addWorkout(new BarbellSquat());
        this.addWorkout(new CalfRaise());
        this.addWorkout(new SeatedLegPress());
        this.addWorkout(new LegExtension());
        this.addWorkout(new HamstringCurl());
        this.addWorkout(new Lunge());
        this.addWorkout(new Bicycle());
    }
}
