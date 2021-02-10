package model;

import model.listofexercises.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static model.Workout.*;

public class WorkoutSession {

    private List<Workout> queue;

    public WorkoutSession() {
        queue = new ArrayList<>();
    }

    public List<Workout> getQueue() {
        return this.queue;
    }

    public void addWorkout(Workout w) {
        this.queue.add(w);
    }

    public void removeWorkout(String s) {
        Iterator<Workout> i = queue.iterator();
        while (i.hasNext()) {
            Workout w = i.next();
            if (w.getWorkoutName().equals(s)) {
                i.remove();
            }
        }
    }

    public void printCurrentSelections() {
        System.out.println("\nCurrently in your list: ");
        for (Workout w : this.getQueue()) {
            System.out.println(w.getWorkoutName());
        }
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
        } else {
            whichWorkoutToAdd2(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 2 of 7 because i have approx. 40 cases.
    private void whichWorkoutToAdd2(String n) {
        if (n.equals(BICRUNCH.toLowerCase())) {
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
    private void whichWorkoutToAdd3(String n) {
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
    private void whichWorkoutToAdd4(String n) {
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
    private void whichWorkoutToAdd5(String n) {
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
    private void whichWorkoutToAdd6(String n) {
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
    private void whichWorkoutToAdd7(String n) {
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
