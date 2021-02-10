package ui;


import model.Workout;
import model.WorkoutSession;
import model.listofexercises.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static model.Workout.*;

public class FitnessApp {
    public static final String APPNAME = "EZ Fitness";
    public static final String WORKOUT_SESSION_COMMAND = "start";
    public static final String QUIT_COMMAND = "quit";
    public static final String BEGIN_WORKOUT_COMMAND = "start";


    private Scanner input;
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
            input = new Scanner(System.in);
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
        System.out.println("Welcome to " + APPNAME);
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

    //MODIFIES: this
    //EFFECTS: instantiates a new workout session where users can then change view, start exercises, or begin workout
    private void doWorkoutSession() {
        session = new WorkoutSession();
        boolean stillAddingExercises = true;
        printSelectionScreenInstructions();

        while (stillAddingExercises) {
            String c = input.nextLine().toLowerCase();
            if (c.equals(BEGIN_WORKOUT_COMMAND)) {
                stillAddingExercises = false;
            } else if (isEqualToViewSelection(c)) {
                changeView(c);
            } else if (isEqualToWorkoutSelection(c)) {
                session.whichWorkoutToAdd(c);
                session.printCurrentSelections();
            } else {
                System.out.println("Selection not valid...");
            }
        }
        beginWorkout();
    }

    //EFFECTS: changes console view of exercises available depending on muscle group
    public void changeView(String c) {
        for (Workout w : selectionList) {
            for (String s : w.getMuscleGroup()) {
                if (s.toLowerCase().equals(c)) {
                    System.out.println(w.getWorkoutName());
                }
            }
        }
    }

    //EFFECTS: returns true if input is equal to one of the muscle groups
    private boolean isEqualToViewSelection(String c) {
        return (c.equals(BI.toLowerCase()) || c.equals(TRI.toLowerCase()) || c.equals(FDELTS.toLowerCase())
                || c.equals(LDELTS.toLowerCase()) || c.equals(RDELTS.toLowerCase()) || c.equals(TRAPS.toLowerCase())
                || c.equals(UBACK.toLowerCase()) || c.equals(LATS.toLowerCase()) || c.equals(LBACK.toLowerCase())
                || c.equals(PECS.toLowerCase()) || c.equals(ABS.toLowerCase()) || c.equals(OBLQ.toLowerCase())
                || c.equals(GLUTES.toLowerCase()) || c.equals(QUADS.toLowerCase()) || c.equals(HAMSTR.toLowerCase())
                || c.equals(CALVES.toLowerCase()));
    }

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

    private void beginWorkout() {
        for (Workout w : session.getQueue()) {
            System.out.println("Please enter the number of sets for " + w.getWorkoutName());
            int sets = input.nextInt();
            w.setNumberOfSets(sets);
            for (int i = 0; i < w.getSets(); i++) {
                System.out.println("\nPlease enter the number of reps for set number " + (i + 1));
                int reps = input.nextInt();
                System.out.println("\nPlease enter the weight done for set " + (i + 1));
                int weight = input.nextInt();
                w.setReps(reps);
                w.setWeight(weight);
            }
        }
    }
    
    public void printSelectionScreenInstructions() {
        System.out.println("Type in the name of the exercise to add it to your workout session");
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
    }

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
    }
}
