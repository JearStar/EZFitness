package model;

import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.Elliptical;
import listofexercises.cardioexercises.RowingMachine;
import listofexercises.cardioexercises.TreadMill;
import listofexercises.muscleexercises.*;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static model.Workout.*;
import static ui.FitnessApp.*;

/**
 * A workout session that has a queue and methods that operate on this queue
 */

public class WorkoutSession implements Writable {

    private List<Workout> queue;
    private List<Workout> finishedList;
    private String sessionName;

    public WorkoutSession() {
        queue = new LinkedList<>();
        finishedList = new LinkedList<>();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        sessionName = dtf.format(now);
    }

    public void setSessionName(String name) {
        this.sessionName = name;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    //EFFECTS: returns the queue
    public List<Workout> getQueue() {
        return this.queue;
    }

    //EFFECTS: returns the final list
    public List<Workout> getFinishedList() {
        return this.finishedList;
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

    //EFFECTS: adds a workout to the finishedList
    public void addToFinalList(Workout w) {
        finishedList.add(w);
    }

    //MODIFIES: this
    //EFFECTS: removes the first workout in the queue
    public void removeFirstOfQueue() {
        this.queue = queue.subList(1, queue.size());
    }

    //EFFECTS: returns this workout session as a JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("sessionName", this.sessionName);
        json.put("finishedList", finishedListToJson());
        json.put("remainingList", remainingListToJson());

        return json;
    }

    //EFFECTS: returns a converted finishedList to a jsonArray
    private JSONArray finishedListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout w : finishedList) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;
    }

    //EFFECTS: returns a converted remainingList to a jsonArray
    private JSONArray remainingListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout w : queue) {
            jsonArray.put(w.toJson());
        }
        return jsonArray;
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 1 of 7 because i have approx. 40 cases.
    public static Workout whichWorkoutToAdd(String n) {
        n = n.toLowerCase();
        if (n.equals(BCURL.toLowerCase())) {
            return new BarbellCurl();
        } else if (n.equals(BPRESS.toLowerCase())) {
            return new BarbellPress();
        } else if (n.equals(BROW.toLowerCase())) {
            return new BarbellRow();
        } else if (n.equals(BSQUAT.toLowerCase())) {
            return new BarbellSquat();
        } else if (n.equals(BIKE.toLowerCase())) {
            return (new Bicycle());
        } else if (n.equals(ELLPT.toLowerCase())) {
            return new Elliptical();
        } else {
            return whichWorkoutToAdd2(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 2 of 7 because i have approx. 40 cases.
    protected static Workout whichWorkoutToAdd2(String n) {
        n = n.toLowerCase();
        if (n.equals(ROWING.toLowerCase())) {
            return new RowingMachine();
        } else if (n.equals(TREAD.toLowerCase())) {
            return new TreadMill();
        } else if (n.equals(BICRUNCH.toLowerCase())) {
            return new BicycleCrunch();
        } else if (n.equals(CCURL.toLowerCase())) {
            return new CableCurl();
        } else if (n.equals(CEXT.toLowerCase())) {
            return new CableExtension();
        } else if (n.equals(CFLY.toLowerCase())) {
            return new CableFly();
        } else {
            return whichWorkoutToAdd3(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 3 of 7 because i have approx. 40 cases.
    protected static Workout whichWorkoutToAdd3(String n) {
        n = n.toLowerCase();
        if (n.equals(CALFR.toLowerCase())) {
            return new CalfRaise();
        } else if (n.equals(CHTPRS.toLowerCase())) {
            return new ChestPress();
        } else if (n.equals(CHUP.toLowerCase())) {
            return new ChinUp();
        } else if (n.equals(CLEAN.toLowerCase())) {
            return new Clean();
        } else if (n.equals(DLIFT.toLowerCase())) {
            return new Deadlift();
        } else if (n.equals(DCURL.toLowerCase())) {
            return new DumbellCurl();
        } else {
            return whichWorkoutToAdd4(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 4 of 7 because i have approx. 40 cases.
    protected static Workout whichWorkoutToAdd4(String n) {
        n = n.toLowerCase();
        if (n.equals(DEXT.toLowerCase())) {
            return new DumbellExtension();
        } else if (n.equals(DFLY.toLowerCase())) {
            return new DumbellFly();
        } else if (n.equals(DPRESS.toLowerCase())) {
            return new DumbellPress();
        } else if (n.equals(DPULLO.toLowerCase())) {
            return new DumbellPullover();
        } else if (n.equals(DRAISE.toLowerCase())) {
            return new DumbellRaise();
        } else if (n.equals(DROW.toLowerCase())) {
            return new DumbellRow();
        } else {
            return whichWorkoutToAdd5(n);
        }

    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 5 of 7 because i have approx. 40 cases.
    protected static Workout whichWorkoutToAdd5(String n) {
        n = n.toLowerCase();
        if (n.equals(DSHPR.toLowerCase())) {
            return new DumbellShoulderPress();
        } else if (n.equals(FPULL.toLowerCase())) {
            return new FacePull();
        } else if (n.equals(HMCURL.toLowerCase())) {
            return new HamstringCurl();
        } else if (n.equals(HPREXT.toLowerCase())) {
            return new HyperExtension();
        } else if (n.equals(LMROW.toLowerCase())) {
            return new LandmineRow();
        } else if (n.equals(LATPD.toLowerCase())) {
            return new LatPulldown();
        } else {
            return whichWorkoutToAdd6(n);
        }
    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 6 of 7 because i have approx. 40 cases.
    protected static Workout whichWorkoutToAdd6(String n) {
        n = n.toLowerCase();
        if (n.equals(LGEXT.toLowerCase())) {
            return new LegExtension();
        } else if (n.equals(LGRAISE.toLowerCase())) {
            return new LegRaise();
        } else if (n.equals(LNG.toLowerCase())) {
            return new Lunge();
        } else if (n.equals(MTCLB.toLowerCase())) {
            return new MountainClimber();
        } else if (n.equals(PLUP.toLowerCase())) {
            return new PullUp();
        } else if (n.equals(PSUP.toLowerCase())) {
            return new PushUp();
        } else {
            return whichWorkoutToAdd7(n);
        }

    }

    //MODIFIES: queue
    //EFFECTS: will a new workout to queue given the name of a workout. Part 7 of 7 because i have approx. 40 cases.
    protected static Workout whichWorkoutToAdd7(String n) {
        n = n.toLowerCase();
        if (n.equals(RVDFLY.toLowerCase())) {
            return new ReverseDumbellFly();
        } else if (n.equals(RTWIST.toLowerCase())) {
            return new RussianTwist();
        } else if (n.equals(SCKICK.toLowerCase())) {
            return new ScissorKick();
        } else if (n.equals(STLGPRS.toLowerCase())) {
            return new SeatedLegPress();
        } else if (n.equals(STROW.toLowerCase())) {
            return new SeatedRow();
        } else if (n.equals(SUP.toLowerCase())) {
            return new SitUp();
        } else if (n.equals(UROW.toLowerCase())) {
            return new UprightRow();
        }
        return null;
    }


    //EFFECTS: chooses which preset workout list to use
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


    //EFFECTS: adds exercises for a back day preset list
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

    //EFFECTS: adds exercises for an abs day preset list
    private void addAbsDayExercises() {
        this.addWorkout(new BicycleCrunch());
        this.addWorkout(new RussianTwist());
        this.addWorkout(new MountainClimber());
        this.addWorkout(new SitUp());
        this.addWorkout(new ScissorKick());
        this.addWorkout(new LegRaise());

    }

    //EFFECTS: adds exercises for a shoulder day preset list
    private void addShoulderDayExercises() {
        this.addWorkout(new DumbellShoulderPress());
        this.addWorkout(new FacePull());
        this.addWorkout(new UprightRow());
        this.addWorkout(new ReverseDumbellFly());
        this.addWorkout(new MountainClimber());
        this.addWorkout(new PushUp());
        this.addWorkout(new PullUp());
    }

    //EFFECTS: adds exercises for an arm day preset list
    private void addArmDayExercises() {
        this.addWorkout(new DumbellCurl());
        this.addWorkout(new DumbellExtension());
        this.addWorkout(new CableCurl());
        this.addWorkout(new CableExtension());
        this.addWorkout(new BarbellCurl());
    }

    //EFFECTS: adds exercises for a chest day preset list
    private void addChestDayExercises() {
        this.addWorkout(new BarbellPress());
        this.addWorkout(new ChestPress());
        this.addWorkout(new DumbellPress());
        this.addWorkout(new CableFly());
        this.addWorkout(new DumbellFly());
        this.addWorkout(new PushUp());
        this.addWorkout(new DumbellPullover());
    }

    //EFFECTS: adds exercises for a leg day preset list
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
