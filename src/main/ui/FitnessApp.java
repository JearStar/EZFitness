package ui;


import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.Elliptical;
import listofexercises.cardioexercises.RowingMachine;
import listofexercises.cardioexercises.TreadMill;
import listofexercises.muscleexercises.*;
import model.Workout;
import model.WorkoutSession;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.Workout.*;

public class FitnessApp {
    public static final String APPNAME = "EZ Fitness";
    public static final String WORKOUT_SESSION_COMMAND = "start";
    public static final String QUIT_COMMAND = "quit";
    public static final String BEGIN_WORKOUT_COMMAND = "start";
    public static final String LEG_DAY_COMMAND = "Leg Day";
    public static final String CHEST_DAY_COMMAND = "Chest Day";
    public static final String ARM_DAY_COMMAND = "Arm Day";
    public static final String SHOULDER_DAY_COMMAND = "Shoulder Day";
    public static final String ABS_DAY_COMMAND = "Abs Day";
    public static final String BACK_DAY_COMMAND = "Back Day";


    private Scanner input = new Scanner(System.in);
    List<Workout> selectionList = new ArrayList<>();
    WorkoutSession session;


    //EFFECTS: runs fitness application
    public FitnessApp() {
        runFitnessApp();
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runFitnessApp() {
        boolean keepGoing = true;
        String command;
        initSelectionList1();
        initSelectionList2();

        while (keepGoing) {
            displayTitleScreen();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals(QUIT_COMMAND)) {
                keepGoing = false;
            } else {
                handleUserInput(command);
            }
        }
        System.out.println("Until next time!");
    }

    //EFFECTS: displays the title screen
    private void displayTitleScreen() {
        System.out.println("\nWelcome to " + APPNAME);
        System.out.println("To start a new workout session, please enter '" + WORKOUT_SESSION_COMMAND + "'");
        System.out.println("To quit this program, please enter '" + QUIT_COMMAND + "'");
    }


    //MODIFIES: this
    //EFFECTS: handles user input on title screen
    private void handleUserInput(String command) {
        if (command.equals(WORKOUT_SESSION_COMMAND)) {
            doWorkoutSession();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //EFFECTS: instantiates a new workout session where users can then change view, start exercises, or begin workout
    private void doWorkoutSession() {
        session = new WorkoutSession();
        boolean stillAddingExercises = true;
        printSelectionScreenInstructions();
        while (stillAddingExercises) {
            String c = input.nextLine().toLowerCase();
            if (c.equals(BEGIN_WORKOUT_COMMAND)) {
                stillAddingExercises = false;
            } else {
                handleOtherUserInputs(c);
            }
        }
        proceedAfterAddingExercise();
    }

    private void handleOtherUserInputs(String c) {
        if (isEqualToViewSelection(c)) {
            changeView(c);
        } else if (isEqualToWorkoutSelection(c)) {
            session.whichWorkoutToAdd(c);
            printCurrentSelections();
        } else if (c.equals("delete")) {
            deleteWorkOut();
        } else if (c.equals("clear")) {
            clearAllWorkouts();
        } else if (isEqualToPresetListSelection(c)) {
            session.choosePresetList(c);
            printCurrentSelections();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    private void proceedAfterAddingExercise() {
        beginWorkout();
        printWorkoutSummary();
    }

    //EFFECTS: begins the workout
    private void beginWorkout() {
        for (Workout w : session.getQueue()) {
            w.goThroughWorkout();
        }
    }

    //EFFECTS: returns true if user selection is equal to a preset list command
    private boolean isEqualToPresetListSelection(String c) {
        return (c.equals(LEG_DAY_COMMAND.toLowerCase()) || c.equals(CHEST_DAY_COMMAND.toLowerCase())
                || c.equals(ARM_DAY_COMMAND.toLowerCase()) || c.equals(SHOULDER_DAY_COMMAND.toLowerCase())
                || c.equals(ABS_DAY_COMMAND.toLowerCase()) || c.equals(BACK_DAY_COMMAND.toLowerCase()));
    }


    //MODIFIES: session
    //EFFECTS: clears current list of selected workouts
    private void clearAllWorkouts() {
        session.clearWorkouts();
        printCurrentSelections();
    }

    //MODIFIES: session
    //EFFECTS: gets user input to delete a workout from queue
    private void deleteWorkOut() {
        System.out.println("Please enter name of workout to delete");
        session.removeWorkout(input.nextLine().toLowerCase());
        printCurrentSelections();
    }

    //EFFECTS: changes console view of exercises available depending on muscle group
    private void changeView(String c) {
        for (Workout w : selectionList) {
            for (String s : w.getMuscleGroup()) {
                if (s.toLowerCase().equals(c)) {
                    System.out.println("\t\t" + w.getWorkoutName());
                }
            }
        }
    }


    //EFFECTS: informs user to input time on cardio machine
    public static void informUserMinutesOnCardio(String s) {
        System.out.println("Please enter number of minutes on " + s);
    }

    //EFFECTS: prints the workout summary of this session
    private void printWorkoutSummary() {
        System.out.println("Workout Summary:");
        for (Workout w : session.getQueue()) {
            System.out.println("\n" + w.getWorkoutName());
            System.out.println(w.getSummary());
        }
    }

    //EFFECTS: prints out current selections that have been added to queue
    private void printCurrentSelections() {
        System.out.println("\nCurrently in your list: ");
        for (Workout w : session.getQueue()) {
            System.out.println(w.getWorkoutName());
        }
    }


    //EFFECTS: returns true if input is equal to one of the muscle groups
    private boolean isEqualToViewSelection(String c) {
        return (c.equals(BI.toLowerCase()) || c.equals(TRI.toLowerCase()) || c.equals(FDELTS.toLowerCase())
                || c.equals(LDELTS.toLowerCase()) || c.equals(RDELTS.toLowerCase()) || c.equals(TRAPS.toLowerCase())
                || c.equals(UBACK.toLowerCase()) || c.equals(LATS.toLowerCase()) || c.equals(LBACK.toLowerCase())
                || c.equals(PECS.toLowerCase()) || c.equals(ABS.toLowerCase()) || c.equals(OBLQ.toLowerCase())
                || c.equals(GLUTES.toLowerCase()) || c.equals(QUADS.toLowerCase()) || c.equals(HAMSTR.toLowerCase())
                || c.equals(CALVES.toLowerCase())) || c.equals(CARDIO.toLowerCase());
    }

    //EFFECTS: checks if user input was equal to a workout selection
    private boolean isEqualToWorkoutSelection(String c) {
        boolean result = false;
        for (Workout w : selectionList) {
            if (c.equals(w.getWorkoutName().toLowerCase())) {
                result = true;
                break;
            }
        }
        return result;
    }

    //EFFECTS: prints instructions as well as all workouts
    private void printSelectionScreenInstructions() {
        System.out.println("Type in the name of the exercise or one of '" + LEG_DAY_COMMAND + "' or '"
                + CHEST_DAY_COMMAND + "' or '" + ARM_DAY_COMMAND + "' or '" + SHOULDER_DAY_COMMAND + "' or '"
                + ABS_DAY_COMMAND + "' or '" + BACK_DAY_COMMAND + "' to add it to your workout session");
        System.out.println("Once you are satisfied with your list, simply type 'start' to being your workout");
        System.out.println("To view exercises, please enter one of the following muscle groups:");
        System.out.println("\t" + BI);
        System.out.println("\t" + TRI);
        System.out.println("\t" + FDELTS);
        System.out.println("\t" + LDELTS);
        System.out.println("\t" + RDELTS);
        System.out.println("\t" + TRAPS);
        System.out.println("\t" + UBACK);
        System.out.println("\t" + LATS);
        System.out.println("\t" + LBACK);
        System.out.println("\t" + PECS);
        System.out.println("\t" + ABS);
        System.out.println("\t" + OBLQ);
        System.out.println("\t" + GLUTES);
        System.out.println("\t" + QUADS);
        System.out.println("\t" + HAMSTR);
        System.out.println("\t" + CALVES);
        System.out.println("\t" + CARDIO);
    }

    //EFFECTS: initializes the selection list by adding one of each workout to the list (1 of 2 parts)
    private void initSelectionList1() {
        selectionList.add(new BarbellCurl());
        selectionList.add(new BarbellPress());
        selectionList.add(new BarbellRow());
        selectionList.add(new BarbellSquat());
        selectionList.add(new BicycleCrunch());
        selectionList.add(new CableCurl());
        selectionList.add(new CableExtension());
        selectionList.add(new CableFly());
        selectionList.add(new CalfRaise());
        selectionList.add(new ChestPress());
        selectionList.add(new ChinUp());
        selectionList.add(new Clean());
        selectionList.add(new Deadlift());
        selectionList.add(new DumbellCurl());
        selectionList.add(new DumbellExtension());
        selectionList.add(new DumbellFly());
        selectionList.add(new DumbellPress());
        selectionList.add(new DumbellPullover());
        selectionList.add(new DumbellRaise());

    }

    //EFFECTS: initializes the selection list by adding one of each workout to the list (2 of 2 parts)
    private void initSelectionList2() {
        selectionList.add(new DumbellRow());
        selectionList.add(new DumbellShoulderPress());
        selectionList.add(new FacePull());
        selectionList.add(new HamstringCurl());
        selectionList.add(new HyperExtension());
        selectionList.add(new LandmineRow());
        selectionList.add(new LatPulldown());
        selectionList.add(new LegExtension());
        selectionList.add(new LegRaise());
        selectionList.add(new Lunge());
        selectionList.add(new MountainClimber());
        selectionList.add(new PullUp());
        selectionList.add(new PushUp());
        selectionList.add(new ReverseDumbellFly());
        selectionList.add(new RussianTwist());
        selectionList.add(new ScissorKick());
        selectionList.add(new SeatedLegPress());
        selectionList.add(new SeatedRow());
        selectionList.add(new UprightRow());
        selectionList.add(new Bicycle());
        selectionList.add(new Elliptical());
        selectionList.add(new RowingMachine());
        selectionList.add(new TreadMill());
    }
}
