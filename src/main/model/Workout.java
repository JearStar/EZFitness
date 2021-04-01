package model;

import model.exceptions.NegativeValueException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.awt.*;
import java.util.List;

/**
 * Abstract class that contains all properties and methods of all workouts.
 */

public abstract class Workout implements Writable {
    //muscle group names
    public static final String BI = "Biceps";
    public static final String TRI = "Triceps";
    public static final String FDELTS = "Front Deltoids";
    public static final String LDELTS = "Lateral Deltoids";
    public static final String RDELTS = "Rear Deltoids";
    public static final String TRAPS = "Traps";
    public static final String UBACK = "Upper Back";
    public static final String LATS = "Lats";
    public static final String LBACK = "Lower Back";
    public static final String PECS = "Pectorals";
    public static final String ABS = "Abdominals";
    public static final String OBLQ = "Obliques";
    public static final String GLUTES = "Glutes";
    public static final String QUADS = "Quads";
    public static final String HAMSTR = "Hamstrings";
    public static final String CALVES = "Calves";
    public static final String CARDIO = "Cardio";

    //workout names
    public static final String BCURL = "Barbell Curl";
    public static final String BPRESS = "Barbell Press";
    public static final String BROW = "Barbell Row";
    public static final String BSQUAT = "Barbell Squat";
    public static final String BICRUNCH = "Bicycle Crunch";
    public static final String CCURL = "Cable Curl";
    public static final String CEXT = "Cable Extension";
    public static final String CFLY = "Cable Fly";
    public static final String CALFR = "Calf Raise";
    public static final String CHTPRS = "Chest Press";
    public static final String CHUP = "Chin Up";
    public static final String CLEAN = "Clean";
    public static final String DLIFT = "Deadlift";
    public static final String DCURL = "Dumbell Curl";
    public static final String DEXT = "Dumbell Extension";
    public static final String DFLY = "Dumbell Fly";
    public static final String DPRESS = "Dumbell Press";
    public static final String DPULLO = "Dumbell Pullover";
    public static final String DRAISE = "Dumbell Raise";
    public static final String DROW = "Dumbell Row";
    public static final String DSHPR = "Dumbell Shoulder Press";
    public static final String FPULL = "Face Pull";
    public static final String HMCURL = "Hamstring Curl";
    public static final String HPREXT = "Hyper Extension";
    public static final String LMROW = "Landmine Row";
    public static final String LATPD = "Lat Pulldown";
    public static final String LGEXT = "Leg Extension";
    public static final String LGRAISE = "Leg Raise";
    public static final String LNG = "Lunge";
    public static final String MTCLB = "Mountain Climber";
    public static final String PLUP = "Pull Up";
    public static final String PSUP = "Push Up";
    public static final String RVDFLY = "Reverse Dumbell Fly";
    public static final String RTWIST = "Russian Twist";
    public static final String SCKICK = "Scissor Kick";
    public static final String STLGPRS = "Seated Leg Press";
    public static final String STROW = "Seated Row";
    public static final String SUP = "Sit Up";
    public static final String UROW = "Upright Row";
    public static final String ELLPT = "Elliptical";
    public static final String TREAD = "Treadmill";
    public static final String BIKE = "Bicycle";
    public static final String ROWING = "Rowing Machine";


    protected String workoutName;
    protected List<String> muscleGroup;

    //MODIFIES: this
    //EFFECTS: adds muscle group to this exercise
    public void addMuscleGroup(String s) {
        this.muscleGroup.add(s);
    }

    //EFFECTS: returns list of muscle groups of workout
    public List<String> getMuscleGroup() {
        return this.muscleGroup;
    }

    //EFFECTS: returns workout name
    public String getWorkoutName() {
        return this.workoutName;
    }

    //EFFECTS: will set details of workout given details of a cardio exercise
    public abstract void goThroughWorkout(List<Double> infoList) throws NegativeValueException;

    //EFFECTS: retrieves the summary for this workout
    public abstract String getSummary();


}
