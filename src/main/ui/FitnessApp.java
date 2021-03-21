package ui;


import listofexercises.cardioexercises.Bicycle;
import listofexercises.cardioexercises.Elliptical;
import listofexercises.cardioexercises.RowingMachine;
import listofexercises.cardioexercises.TreadMill;
import listofexercises.muscleexercises.*;
import model.MuscleExercise;
import model.PastLog;
import model.Workout;
import model.WorkoutSession;
import persistence.JsonReaderCurrent;
import persistence.JsonReaderPast;
import persistence.JsonWriterCurrent;
import persistence.JsonWriterPast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;
import static model.Workout.*;
import static model.WorkoutSession.whichWorkoutToAdd;

/**
 * Fitness app class that combines user interface and classes in model
 */

public class FitnessApp extends JFrame {
    public static final String APP_NAME = "EZ Fitness";
    public static final String WORKOUT_SESSION_COMMAND = "start";
    public static final String QUIT_COMMAND = "quit";
    public static final String BEGIN_WORKOUT_COMMAND = "start";
    public static final String LEG_DAY_COMMAND = "Leg Day";
    public static final String CHEST_DAY_COMMAND = "Chest Day";
    public static final String ARM_DAY_COMMAND = "Arm Day";
    public static final String SHOULDER_DAY_COMMAND = "Shoulder Day";
    public static final String ABS_DAY_COMMAND = "Abs Day";
    public static final String BACK_DAY_COMMAND = "Back Day";
    public static final String LOAD_COMMAND = "load";
    public static final String VIEW_PAST_WORKOUTS_COMMAND = "view";
    public static final String DELETE_COMMAND = "delete";
    public static final String CLEAR_COMMAND = "clear";
    public static final String GO_BACK_COMMAND = "back";
    public static final int WIDTH = 900;
    public static final int HEIGHT = 500;
    public static final String TITLE_SCREEN_LABEL = "Menu";
    public static final String VIEWING_TAB_LABEL = "View Past Logs";
    public static final String ADDING_TAB_LABEL = "Workout Session";
    public static final int TITLE_SCREEN_INDEX = 0;
    public static final int VIEWING_TAB_INDEX = 1;
    public static final int ADDING_TAB_INDEX = 2;
    private final JTabbedPane sidebar = new JTabbedPane();

    private static final String SESSION_STORE = "./data/currentsession.json";
    private static final String LOGS_STORE = "./data/pastlogs.json";
    private static final Scanner input = new Scanner(System.in);
    private final JsonWriterCurrent jsonWriterCurrent = new JsonWriterCurrent(SESSION_STORE);
    private final JsonReaderCurrent jsonReaderCurrent = new JsonReaderCurrent(SESSION_STORE);
    private final JsonWriterPast jsonWriterPast = new JsonWriterPast(LOGS_STORE);
    private final JsonReaderPast jsonReaderPast = new JsonReaderPast(LOGS_STORE);
    List<Workout> selectionList = new ArrayList<>();
    WorkoutSession session = new WorkoutSession();
    PastLog pastLog = new PastLog();
    JPanel viewingTab = new JPanel();
    JPanel titleScreen = new JPanel(new BorderLayout());
    JPanel addingTab = new JPanel(new BorderLayout());
    JComboBox<String> comboBox = new JComboBox<>();
    JComboBox<String> muscleGroupDropDown = new JComboBox<>();
    JComboBox<String> exerciseDropDown = new JComboBox<>();
    JComboBox<String> myQueue = new JComboBox<>();
    JPanel viewingTabTopPanel = new JPanel();
    JTextPane summaryField = new JTextPane();
    JPanel centerOfPagePanel = new JPanel();
    JButton newSessionButton = new JButton("New Session");
    JButton loadSessionButton = new JButton("Load Previous Session");
    JPanel titleCentralPanel = new JPanel();
    JButton toViewingScreenButton = new JButton(VIEWING_TAB_LABEL);
    JButton toAddingScreenButton = new JButton(ADDING_TAB_LABEL);
    JButton addButton = new JButton("Add");
    JButton deleteWorkoutButton = new JButton("Delete");
    JButton clearAllWorkoutsButton = new JButton("Clear");
    JButton startWorkoutButton = new JButton("Start Workout");

    public static void main(String[] args) {
        new FitnessApp();
    }

    //EFFECTS: runs fitness application
    public FitnessApp() {
        initSelectionList1();
        initSelectionList2();
        this.setTitle(APP_NAME);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(WIDTH, HEIGHT);

        loadTabs();
        add(sidebar);

        this.setVisible(true);
        runFitnessApp();
    }

    public void loadTabs() {
        loadTitleTab();
        loadViewingTab();
        loadAddingTab();
    }

    public void loadTitleTab() {
        titleCentralPanel.setBackground(new Color(129, 121, 141));
        titleCentralPanel.setLayout(null);
        JLabel titleScreenLabel = new JLabel(TITLE_SCREEN_LABEL);
        titleScreenLabel.setBounds(WIDTH / 4, HEIGHT / 8, WIDTH / 2, HEIGHT / 10);
        titleScreenLabel.setHorizontalAlignment(JLabel.CENTER);
        titleCentralPanel.add(titleScreenLabel, BorderLayout.PAGE_START);
        titleScreen.add(titleCentralPanel);
        addTitleScreenButtons(titleScreen);
        sidebar.add(titleScreen, TITLE_SCREEN_INDEX);
        sidebar.setTitleAt(TITLE_SCREEN_INDEX, TITLE_SCREEN_LABEL);
    }

    public void addTitleScreenButtons(JPanel titleScreen) {
        toViewingScreenButton.setBounds(WIDTH / 4, HEIGHT / 8 * 2, WIDTH / 2, HEIGHT / 10);
        toAddingScreenButton.setBounds(WIDTH / 4, HEIGHT / 8 * 4, WIDTH / 2, HEIGHT / 10);
        titleCentralPanel.add(toViewingScreenButton, BorderLayout.CENTER);
        titleCentralPanel.add(toAddingScreenButton, BorderLayout.CENTER);

        toAddingScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ADDING_TAB_LABEL)) {
                    sidebar.setSelectedIndex(ADDING_TAB_INDEX);
                }
            }
        });

        toViewingScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(VIEWING_TAB_LABEL)) {
                    sidebar.setSelectedIndex(VIEWING_TAB_INDEX);
                }
            }
        });
    }

    public void loadViewingTab() {
        JLabel viewingTabLabel = new JLabel("Viewing Tab");
        viewingTab.add(viewingTabLabel, TOP_ALIGNMENT);
        viewingTab.setLayout(new BorderLayout());
        addViewingTabDeleteButton();
        addViewingTabClearButton();
        addViewingTabDropDownList();
        initializeSummaryField();
        viewingTab.add(viewingTabTopPanel, BorderLayout.PAGE_START);
        sidebar.add(viewingTab, VIEWING_TAB_INDEX);
        sidebar.setTitleAt(VIEWING_TAB_INDEX, VIEWING_TAB_LABEL);
    }

    public void addViewingTabDeleteButton() {
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(pastLog.getPastWorkoutSessions().isEmpty())) {
                    if (confirmAction()) {
                        String sessionName = (String) comboBox.getSelectedItem();
                        pastLog.removeWorkoutSession(sessionName);
                        updateComboBox();
                        updateSummaryField();
                    }
                }
            }
        });
        viewingTabTopPanel.add(deleteButton);
    }

    public void addViewingTabClearButton() {
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(pastLog.getPastWorkoutSessions().isEmpty())) {
                    if (confirmAction()) {
                        clearAllWorkoutSessions();
                        updateComboBox();
                        summaryField.setText("");
                    }
                }
            }
        });
        viewingTabTopPanel.add(clearButton);
    }

    public boolean confirmAction() {
        int input = JOptionPane.showConfirmDialog(null,
                "Please confirm action", "Confirm action", JOptionPane.YES_NO_OPTION);
        return input == 0;
    }

    public void updateComboBox() {
        DefaultComboBoxModel model = new DefaultComboBoxModel(pastLog.getPastSessionNames().toArray());
        comboBox.setModel(model);
    }

    public void addViewingTabDropDownList() {

        loadPastLogsIntoDropDown();
        viewingTabTopPanel.add(comboBox);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSummaryField();
            }
        });
    }

    public void initializeSummaryField() {

        JScrollPane scrollPane = new JScrollPane(summaryField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        viewingTab.setBounds(WIDTH / 4, HEIGHT / 8, WIDTH / 2, HEIGHT / 8 * 7);
        viewingTab.add(scrollPane, BorderLayout.CENTER);
        summaryField.setEditable(false);

        viewingTabTopPanel.setBackground(new Color(120, 134, 154));

        updateSummaryField();
    }

    public void updateSummaryField() {
        String logName = (String) comboBox.getSelectedItem();
        if (pastLog.getPastWorkoutSessions().isEmpty()) {
            summaryField.setText("");
        } else {
            summaryField.setText(pastLog.findWorkoutSession(logName).getSessionSummary());
        }
    }

    public void loadPastLogsIntoDropDown() {
        try {
            this.pastLog = jsonReaderPast.read();
        } catch (IOException e) {
            // Handle Exception
        } finally {
            for (WorkoutSession ws : pastLog.getPastWorkoutSessions()) {
                comboBox.addItem(ws.getSessionName());
            }
        }
    }

    public void loadAddingTab() {
        JPanel topOfPagePanel = new JPanel();
        sidebar.add(addingTab, ADDING_TAB_INDEX);
        sidebar.setTitleAt(ADDING_TAB_INDEX, ADDING_TAB_LABEL);

        topOfPagePanel.add(newSessionButton);
        topOfPagePanel.add(loadSessionButton);

        setActionListenerNewSessionButton();
        setActionListenerLoadSessionButton();

        addingTab.add(topOfPagePanel, BorderLayout.PAGE_START);
        addLowerHalfPanelAdding();
        centerOfPagePanel.setVisible(false);
        initializeDropDowns();
    }

    public void setActionListenerNewSessionButton() {
        newSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    WorkoutSession dummySession = jsonReaderCurrent.read();
                    if (!(dummySession.getQueue().isEmpty())) {
                        int input = JOptionPane.showConfirmDialog(null,
                                "You currently have an old session in progress, would you like to start a new one?",
                                "Confirm action", JOptionPane.YES_NO_OPTION);
                        if (input == 0) {
                            session = new WorkoutSession();
                            centerOfPagePanel.setVisible(true);
                        }
                    } else {
                        session = new WorkoutSession();
                        centerOfPagePanel.setVisible(true);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }

    public void setActionListenerLoadSessionButton() {
        loadSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    session = jsonReaderCurrent.read();
                    if (!(session.getQueue().isEmpty())) {
                        startWorkoutGUI();
                    }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void addLowerHalfPanelAdding() {
        centerOfPagePanel.setLayout(null);
        initializeLowerPanelButtons();
        JLabel muscleGroupLabel = new JLabel("Muscle Groups");
        muscleGroupLabel.setBounds(WIDTH / 20, HEIGHT / 16, WIDTH / 10, HEIGHT / 32);
        JLabel exerciseLabel = new JLabel("Exercises");
        exerciseLabel.setBounds(WIDTH / 20, HEIGHT / 16 * 8, WIDTH / 10, HEIGHT / 32);
        JLabel queueLabel = new JLabel("Your Queue");
        queueLabel.setBounds(WIDTH / 20 * 10, HEIGHT / 16 * 5, WIDTH / 10, HEIGHT / 32);
        muscleGroupDropDown.setBounds(WIDTH / 20, HEIGHT / 16 * 2, WIDTH / 10 * 2, HEIGHT / 20);
        exerciseDropDown.setBounds(WIDTH / 20, HEIGHT / 16 * 9, WIDTH / 10 * 2, HEIGHT / 20);
        myQueue.setBounds(WIDTH / 20 * 10, HEIGHT / 16 * 6, WIDTH / 10 * 2, HEIGHT / 20);

        centerOfPagePanel.add(muscleGroupLabel);
        centerOfPagePanel.add(exerciseLabel);
        centerOfPagePanel.add(queueLabel);
        centerOfPagePanel.add(muscleGroupDropDown);
        centerOfPagePanel.add(exerciseDropDown);
        centerOfPagePanel.add(myQueue);
        addingTab.add(centerOfPagePanel);
    }

    public void initializeLowerPanelButtons() {
        addButton.setBounds(WIDTH / 20 * 5, HEIGHT / 16 * 9, WIDTH / 20 * 2, HEIGHT / 20);
        centerOfPagePanel.add(addButton);
        deleteWorkoutButton.setBounds(WIDTH / 20 * 14, HEIGHT / 16 * 6, WIDTH / 20 * 2, HEIGHT / 20);
        centerOfPagePanel.add(deleteWorkoutButton);
        clearAllWorkoutsButton.setBounds(WIDTH / 20 * 16, HEIGHT / 16 * 6, WIDTH / 20 * 2, HEIGHT / 20);
        centerOfPagePanel.add(clearAllWorkoutsButton);
        startWorkoutButton.setBounds(WIDTH / 20 * 13, HEIGHT / 16 * 10, WIDTH / 20 * 6, HEIGHT / 20 * 2);
        centerOfPagePanel.add(startWorkoutButton);

        setActionListenerAddButton();
        setActionListenerDeleteButton();
        setActionListenerClearButton();
        setActionListenerStartButton();
    }

    public void setActionListenerStartButton() {
        startWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (session.getQueue().isEmpty()) {
                    sidebar.setSelectedIndex(TITLE_SCREEN_INDEX);

                } else {
                    startWorkoutGUI();
                }
                centerOfPagePanel.setVisible(false);
            }
        });
    }

    public void startWorkoutGUI() {
        beginWorkoutGUI(session);
        pastLog.addSession(session);
        overwritePastLogs();
        clearCurrentSession();
        updateComboBox();
        comboBox.setSelectedIndex(pastLog.getPastWorkoutSessions().size() - 1);
        updateSummaryField();
        sidebar.setSelectedIndex(VIEWING_TAB_INDEX);
    }

    public void setActionListenerClearButton() {
        clearAllWorkoutsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                session.clearWorkouts();
                initializeQueueDropDown();
            }
        });
    }

    public void setActionListenerAddButton() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String workoutName = (String) exerciseDropDown.getSelectedItem();
                session.addWorkout(whichWorkoutToAdd(workoutName));
                initializeQueueDropDown();
            }
        });
    }

    public void setActionListenerDeleteButton() {
        deleteWorkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String workoutName = null;
                try {
                    workoutName = ((String) myQueue.getSelectedItem()).toLowerCase();
                } catch (NullPointerException exception) {
                    // do nothing
                }
                session.removeWorkout(workoutName);
                initializeQueueDropDown();
            }
        });
    }

    public void initializeDropDowns() {
        initializeMuscleGroupDropDown();
        initializeExerciseDropDown();
        initializeQueueDropDown();
        setActionListenerMuscleGroupDropDown();
    }

    public void initializeQueueDropDown() {
        List<String> workoutsInQueue = new ArrayList<>();
        for (Workout w : session.getQueue()) {
            workoutsInQueue.add(w.getWorkoutName());
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(workoutsInQueue.toArray());
        myQueue.setModel(model);
    }

    public void setActionListenerMuscleGroupDropDown() {
        muscleGroupDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeExerciseDropDown();
            }
        });
    }

    public void initializeMuscleGroupDropDown() {
        List<String> muscleGroups = new ArrayList<>();
        for (Workout w : selectionList) {
            for (String mg : w.getMuscleGroup()) {
                if (!muscleGroups.contains(mg)) {
                    muscleGroups.add(mg);
                }
            }
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(muscleGroups.toArray());
        muscleGroupDropDown.setModel(model);
    }

    public void initializeExerciseDropDown() {
        List<String> exercises = new ArrayList<>();
        for (Workout w : selectionList) {
            String selectedMuscleGroup = (String) muscleGroupDropDown.getSelectedItem();
            if (w.getMuscleGroup().contains(selectedMuscleGroup)) {
                exercises.add(w.getWorkoutName());
            }
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(exercises.toArray());
        exerciseDropDown.setModel(model);
    }

    //MODIFIES: this
    //EFFECTS: processes user input
    private void runFitnessApp() {
        boolean keepGoing = true;
        String command;

        while (keepGoing) {
            displayTitleScreen();
            Scanner in = new Scanner(System.in);
            command = in.nextLine();
            command = command.toLowerCase();

            if (command.equals(QUIT_COMMAND)) {
                keepGoing = false;
            } else if (command.equals(VIEW_PAST_WORKOUTS_COMMAND)) {
                userInputsPastWorkouts();
            } else if (command.equals(LOAD_COMMAND)) {
                loadWorkoutSession();
                proceedAfterAddingExercise();
            } else if (command.equals(WORKOUT_SESSION_COMMAND)) {
                doWorkoutSession();
            } else {
                System.out.println("Selection not valid...");
            }
        }
        System.out.println("Until next time!");
    }

    //EFFECTS: handles user input on the viewing screen
    private void userInputsPastWorkouts() {

        boolean stillViewing = true;
        printViewScreenInstructions();
        loadPastLogs();

        while (stillViewing) {
            String userCommand = input.nextLine().toLowerCase();
            if (pastLog.getPastSessionNames().contains(userCommand)) {
                pastLogsContainsSessionName(userCommand);
            } else if (userCommand.equals(DELETE_COMMAND)) {
                deleteWorkoutSession();
            } else if (userCommand.equals(CLEAR_COMMAND)) {
                clearAllWorkoutSessions();
                showAllSessionNames();
            } else if (userCommand.equals(GO_BACK_COMMAND)) {
                stillViewing = false;
            } else if (userCommand.equals("")) {
                stillViewing = true;
            } else {
                System.out.println("Selection not valid...");
            }
        }
    }

    //EFFECTS: prints summary of a past workout given name of workout
    private void pastLogsContainsSessionName(String s) {
        for (WorkoutSession ws : pastLog.getPastWorkoutSessions()) {
            if (s.equals(ws.getSessionName())) {
                printWorkoutSummary(ws);
                break;
            }
        }
    }

    //MODIFIES: session
    //EFFECTS: gets user input to delete a workout from queue
    private void deleteWorkoutSession() {
        System.out.println("Please enter name of the workout session to delete");
        pastLog.removeWorkoutSession(input.nextLine().toLowerCase());
        overwritePastLogs();
        showAllSessionNames();
    }

    //MODIFIES: session
    //EFFECTS: gets user input to delete a workout from queue
    private void clearAllWorkoutSessions() {
        pastLog.clearAllWorkoutSessions();
        overwritePastLogs();
    }


    //EFFECTS: prints view screen instructions
    private void printViewScreenInstructions() {
        System.out.println("\nTo view a past workout log, please enter the name of the workout session");
        System.out.println("To delete a past workout log, please enter '" + DELETE_COMMAND + "'");
        System.out.println("To delete all workout logs, please enter '" + CLEAR_COMMAND + "'");
        System.out.println("To go back to the main menu, please enter '" + GO_BACK_COMMAND + "'");
        System.out.println("\t");
    }

    //EFFECTS: displays the title screen
    private void displayTitleScreen() {
        System.out.println("\nWelcome to " + APP_NAME);
        System.out.println("To continue your workout in progress, please enter '" + LOAD_COMMAND + "'");
        System.out.println("To start a new workout session, please enter '" + WORKOUT_SESSION_COMMAND + "'");
        System.out.println("To view past workout logs, please enter '" + VIEW_PAST_WORKOUTS_COMMAND + "'");
        System.out.println("To quit this program, please enter '" + QUIT_COMMAND + "'");

    }


    //EFFECTS: instantiates a new workout session where users can then change view, start exercises, or begin workout
    private void doWorkoutSession() {
        this.session = new WorkoutSession();
        boolean stillAddingExercises = true;
        printSelectionScreenInstructions();
        while (stillAddingExercises) {
            String c = input.nextLine().toLowerCase();
            if (c.equals(BEGIN_WORKOUT_COMMAND)) {
                if (session.getQueue().size() != 0) {
                    proceedAfterAddingExercise();
                } else {
                    System.out.println("There were no workouts added to queue. Returning to main menu.");
                }
                stillAddingExercises = false;
            } else if (c.equals(GO_BACK_COMMAND)) {
                stillAddingExercises = false;
            } else {
                handleOtherUserInputs(c);
            }
        }

    }

    //EFFECTS: handles user input on selection screen
    private void handleOtherUserInputs(String c) {
        if (isEqualToViewSelection(c)) {
            changeView(c);
        } else if (isEqualToWorkoutSelection(c)) {
            session.addWorkout(whichWorkoutToAdd(c));
            printCurrentSelections();
        } else if (c.equals(DELETE_COMMAND)) {
            deleteWorkout();
        } else if (c.equals(CLEAR_COMMAND)) {
            clearAllWorkouts();
        } else if (isEqualToPresetListSelection(c)) {
            session.choosePresetList(c);
            printCurrentSelections();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //EFFECTS: methods to run after exercise-adding has been completed
    private void proceedAfterAddingExercise() {
        if (!(session.getQueue().isEmpty())) {
            beginWorkout(session);
            printWorkoutSummary(session);
            pastLog.addSession(this.session);
            overwritePastLogs();
            clearCurrentSession();
        }
    }


    //EFFECTS: begins the workout
    private void beginWorkout(WorkoutSession ws) {
        for (Workout w : ws.getQueue()) {
            List<Double> infoList = new ArrayList<>();
            askForUserInput(w, infoList);
            w.goThroughWorkout(infoList);
            ws.addToFinalList(w);
            ws.removeFirstOfQueue();
            saveCurrentWorkoutSession();
        }
    }

    private void beginWorkoutGUI(WorkoutSession ws) {
        for (Workout w : ws.getQueue()) {
            List<Double> infoList = new ArrayList<>();
            askForUserInputGUI(w, infoList);
            w.goThroughWorkout(infoList);
            ws.addToFinalList(w);
            ws.removeFirstOfQueue();
            saveCurrentWorkoutSession();
        }
    }

    private void askForUserInputGUI(Workout w, List<Double> infoList) {
        if (w instanceof MuscleExercise) {
            double sets = askForSetsGUI(w, infoList);


            for (int i = 0; i < sets; i++) {
                askForRepsGUI(infoList, i);
                askForWeightGUI(infoList, i);
            }
        } else {
            askForTimeGUI(infoList, w);
        }
    }


    //EFFECTS: asks for user input on workout details
    private void askForUserInput(Workout w, List<Double> infoList) {
        if (w instanceof MuscleExercise) {

            double sets = askForSets(w, infoList);


            for (int i = 0; i < sets; i++) {
                System.out.println("\nPlease enter number of reps for set " + (i + 1));
                askForRepsOrWeightOrTime(infoList);


                System.out.println("\nPlease enter the weight done for set " + (i + 1));
                askForRepsOrWeightOrTime(infoList);
            }
        } else {

            System.out.println("Please enter number of minutes done for " + w.getWorkoutName());
            askForRepsOrWeightOrTime(infoList);
        }
    }

    private void askForRepsGUI(List<Double> infoList, int i) {
        while (true) {
            try {
                double info = abs(Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Please enter the number of reps done for set " + (i + 1),
                        "Input Reps",
                        JOptionPane.PLAIN_MESSAGE)));
                infoList.add(info);
                break;
            } catch (NumberFormatException e) {
                //do nothing
            } catch (NullPointerException e) {
                //do nothing
            }
        }
    }

    private void askForWeightGUI(List<Double> infoList, int i) {
        while (true) {
            try {
                double info = abs(Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Please enter the weight done for set " + (i + 1),
                        "Input Weight",
                        JOptionPane.PLAIN_MESSAGE)));
                infoList.add(info);
                break;
            } catch (NumberFormatException e) {
                //do nothing
            } catch (NullPointerException e) {
                //do nothing
            }
        }
    }

    private void askForTimeGUI(List<Double> infoList, Workout w) {
        while (true) {
            try {
                double info = abs(Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Please enter number of minutes done for " + w.getWorkoutName(),
                        "Input Time",
                        JOptionPane.PLAIN_MESSAGE)));
                infoList.add(info);
                break;
            } catch (NumberFormatException e) {
                //do nothing
            } catch (NullPointerException e) {
                //do nothing
            }
        }
    }


    private void askForRepsOrWeightOrTime(List<Double> infoList) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                double info = abs(Double.parseDouble(sc.next()));
                infoList.add(info);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (NullPointerException e) {
                //do nothing
            }
        }
    }

    private double askForSetsGUI(Workout w, List<Double> infoList) {
        double sets = 0;
        while (true) {
            try {
                sets = abs(Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Please enter the number of sets done for " + w.getWorkoutName(),
                        "Input Sets",
                        JOptionPane.PLAIN_MESSAGE)));
                infoList.add(sets);
                break;
            } catch (NumberFormatException e) {
                //Do nothing
            } catch (NullPointerException e) {
                //do nothing
            }
        }
        return sets;
    }

    private double askForSets(Workout w, List<Double> infoList) {
        Scanner sc = new Scanner(System.in);
        double sets = 0;
        System.out.println("Please enter the number of sets done for " + w.getWorkoutName());
        while (true) {
            try {
                sets = abs(Double.parseDouble(sc.next()));
                infoList.add(sets);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (NullPointerException e) {
                //do nothing
            }
        }
        return sets;
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
    private void deleteWorkout() {
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

    //EFFECTS: prints the workout summary of this session
    private void printWorkoutSummary(WorkoutSession workoutSession) {
        System.out.println("Workout Summary:");
        for (Workout w : workoutSession.getFinishedList()) {
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

    //EFFECTS: saves the current workout session state
    private void saveCurrentWorkoutSession() {
        try {
            jsonWriterCurrent.open();
            jsonWriterCurrent.write(session);
            jsonWriterCurrent.close();
        } catch (FileNotFoundException e) {
            System.out.println("could not find file");
        }
    }

    //EFFECTS: clears current workout session state
    private void clearCurrentSession() {
        try {
            jsonWriterCurrent.open();
            jsonWriterCurrent.write(new WorkoutSession());
            jsonWriterCurrent.close();
        } catch (FileNotFoundException e) {
            System.out.println("could not find file");
        }
    }

    //EFFECTS: loads workout session from memory
    private void loadWorkoutSession() {
        try {
            WorkoutSession loadable = jsonReaderCurrent.read();
            if (loadable.getQueue().size() != 0) {
                this.session = loadable;
                System.out.println("Loaded session from " + session.getSessionName());
            } else {
                System.out.println("No sessions currently in progress");
            }
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + SESSION_STORE);
        }
    }


    //EFFECTS: loads past logs from memory
    private void loadPastLogs() {
        try {
            this.pastLog = jsonReaderPast.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + LOGS_STORE);
        } finally {
            showAllSessionNames();
        }
    }

    //EFFECTS: overwrites the current past logs on memory
    private void overwritePastLogs() {
        try {
            jsonWriterPast.open();
            jsonWriterPast.write(pastLog);
            jsonWriterPast.close();
        } catch (FileNotFoundException e) {
            System.out.println("failed");
        }
    }


    //EFFECTS: shows names of all past workout sessions
    private void showAllSessionNames() {
        if (pastLog.getPastSessionNames().size() != 0) {
            for (WorkoutSession ws : pastLog.getPastWorkoutSessions()) {
                System.out.println(ws.getSessionName());
            }
        } else {
            System.out.println("\nNo past workout sessions");
        }
    }


    //EFFECTS: prints instructions as well as all workouts
    private void printSelectionScreenInstructions() {
        System.out.println("Type in the name of the exercise or one of '" + LEG_DAY_COMMAND + "' or '"
                + CHEST_DAY_COMMAND + "' or '" + ARM_DAY_COMMAND + "' or '" + SHOULDER_DAY_COMMAND + "' or '"
                + ABS_DAY_COMMAND + "' or '" + BACK_DAY_COMMAND + "' to add it to your workout session");
        System.out.println("Once you are satisfied with your list, enter '" + BEGIN_WORKOUT_COMMAND + "' to being your "
                + "workout");
        System.out.println("To delete an exercise from your list, please enter '" + DELETE_COMMAND + "'");
        System.out.println("To view exercises, please enter one of the following muscle groups:");
        displayMuscleGroups();
    }

    //EFFECTS: displays all muscle groups
    private void displayMuscleGroups() {
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
