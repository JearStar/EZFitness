package model;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.Elliptical;
import listofexercises.cardioexercises.RowingMachine;
import listofexercises.cardioexercises.TreadMill;
import listofexercises.muscleexercises.*;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static model.Workout.*;
import static ui.FitnessApp.*;

public class WorkoutSession {

    private List<Workout> queue;

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


    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 1 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd(String n) {
        if (n.equals(BCURL.toLowerCase())) {
            this.addWorkout(new BarbellCurl());
        } else if (n.equals(BPRESS.toLowerCase())) {
            this.addWorkout(new BarbellPress());
        } else if (n.equals(BROW.toLowerCase())) {
            this.addWorkout(new BarbellRow());
        } else if (n.equals(BSQUAT.toLowerCase())) {
            this.addWorkout(new BarbellSquat());
        } else if (n.equals(BIKE.toLowerCase())) {
            this.addWorkout((new Bicycle()));
        } else if (n.equals(ELLPT.toLowerCase())) {
            this.addWorkout(new Elliptical());
        } else {
            whichWorkoutToAdd2(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 2 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd2(String n) {
        if (n.equals(ROWING.toLowerCase())) {
            this.addWorkout(new RowingMachine());
        } else if (n.equals(TREAD.toLowerCase())) {
            this.addWorkout(new TreadMill());
        } else if (n.equals(BICRUNCH.toLowerCase())) {
            this.addWorkout(new BicycleCrunch());
        } else if (n.equals(CCURL.toLowerCase())) {
            this.addWorkout(new CableCurl());
        } else if (n.equals(CEXT.toLowerCase())) {
            this.addWorkout(new CableExtension());
        } else if (n.equals(CFLY.toLowerCase())) {
            this.addWorkout(new CableFly());
        } else {
            whichWorkoutToAdd3(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 3 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd3(String n) {
        if (n.equals(CALFR.toLowerCase())) {
            this.addWorkout(new CalfRaise());
        } else if (n.equals(CHTPRS.toLowerCase())) {
            this.addWorkout(new ChestPress());
        } else if (n.equals(CHUP.toLowerCase())) {
            this.addWorkout(new ChinUp());
        } else if (n.equals(CLEAN.toLowerCase())) {
            this.addWorkout(new Clean());
        } else if (n.equals(DLIFT.toLowerCase())) {
            this.addWorkout(new Deadlift());
        } else if (n.equals(DCURL.toLowerCase())) {
            this.addWorkout(new DumbellCurl());
        } else {
            whichWorkoutToAdd4(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 4 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd4(String n) {
        if (n.equals(DEXT.toLowerCase())) {
            this.addWorkout(new DumbellExtension());
        } else if (n.equals(DFLY.toLowerCase())) {
            this.addWorkout(new DumbellFly());
        } else if (n.equals(DPRESS.toLowerCase())) {
            this.addWorkout(new DumbellPress());
        } else if (n.equals(DPULLO.toLowerCase())) {
            this.addWorkout(new DumbellPullover());
        } else if (n.equals(DRAISE.toLowerCase())) {
            this.addWorkout(new DumbellRaise());
        } else if (n.equals(DROW.toLowerCase())) {
            this.addWorkout(new DumbellRow());
        } else {
            whichWorkoutToAdd5(n);
        }

    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 5 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd5(String n) {
        if (n.equals(DSHPR.toLowerCase())) {
            this.addWorkout(new DumbellShoulderPress());
        } else if (n.equals(FPULL.toLowerCase())) {
            this.addWorkout(new FacePull());
        } else if (n.equals(HMCURL.toLowerCase())) {
            this.addWorkout(new HamstringCurl());
        } else if (n.equals(HPREXT.toLowerCase())) {
            this.addWorkout(new HyperExtension());
        } else if (n.equals(LMROW.toLowerCase())) {
            this.addWorkout(new LandmineRow());
        } else if (n.equals(LATPD.toLowerCase())) {
            this.addWorkout(new LatPulldown());
        } else {
            whichWorkoutToAdd6(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 6 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd6(String n) {
        if (n.equals(LGEXT.toLowerCase())) {
            this.addWorkout(new LegExtension());
        } else if (n.equals(LGRAISE.toLowerCase())) {
            this.addWorkout(new LegRaise());
        } else if (n.equals(LNG.toLowerCase())) {
            this.addWorkout(new Lunge());
        } else if (n.equals(MTCLB.toLowerCase())) {
            this.addWorkout(new MountainClimber());
        } else if (n.equals(PLUP.toLowerCase())) {
            this.addWorkout(new PullUp());
        } else if (n.equals(PSUP.toLowerCase())) {
            this.addWorkout(new PushUp());
        } else {
            whichWorkoutToAdd7(n);
        }

    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 7 of 7 because i have approx. 40 cases.
    public void whichWorkoutToAdd7(String n) {
        if (n.equals(RVDFLY.toLowerCase())) {
            this.addWorkout(new ReverseDumbellFly());
        } else if (n.equals(RTWIST.toLowerCase())) {
            this.addWorkout(new RussianTwist());
        } else if (n.equals(SCKICK.toLowerCase())) {
            this.addWorkout(new ScissorKick());
        } else if (n.equals(STLGPRS.toLowerCase())) {
            this.addWorkout(new SeatedLegPress());
        } else if (n.equals(STROW.toLowerCase())) {
            this.addWorkout(new SeatedRow());
        } else if (n.equals(SUP.toLowerCase())) {
            this.addWorkout(new SitUp());
        } else if (n.equals(UROW.toLowerCase())) {
            this.addWorkout(new UprightRow());

        }
    }
}
