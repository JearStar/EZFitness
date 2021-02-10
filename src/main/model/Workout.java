package model;

import java.util.List;

public abstract class Workout implements Exercises {
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



    protected String workoutName;
    protected List<String> muscleGroup;
    protected int sets;
    protected List<Integer> reps;
    protected List<Integer> weights;

    @Override
    //REQUIRES: n > 0
    //MODIFIES: this
    //EFFECTS: sets number of sets of workout
    public void setNumberOfSets(int n) {
        this.sets = n;
    }

    @Override
    public void addMuscleGroup(String s) {
        this.muscleGroup.add(s);
    }

    @Override
    //REQUIRES: n > 0
    //MODIFIES: this
    //EFFECTS: sets number of reps of a set
    public void setReps(int n) {
        this.reps.add(n);
    }

    @Override
    //EFFECTS: returns number of sets
    public int getSets() {
        return this.sets;
    }

    @Override
    //EFFECTS: returns list of reps for however many sets
    public List<Integer> getReps() {
        return this.reps;
    }

    @Override
    //EFFECTS: returns list of muscle groups of workout
    public List<String> getMuscleGroup() {
        return this.muscleGroup;
    }

    @Override
    //EFFECTS: returns list of weights for however many sets
    public List<Integer> getWeight() {
        return this.weights;
    }

    @Override
    //REQUIRES: n >= 0
    //MODIFIES: this
    //EFFECTS: sets weight of a set
    public void setWeight(int w) {
        this.weights.add(w);
    }

    @Override
    //EFFECTS: returns workout name
    public String getWorkoutName() {
        return this.workoutName;
    }
}
