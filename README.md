# Easy Fitness

## An app to plan your workouts, and log them

This application will be a fitness app where before a workout session, users will be able to **select** and **queue up**
different exercises, either by a preset list or a custom list. They will be able to view different workouts grouped
by muscle groups (e.g. biceps, triceps, pectorals, etc.) After selecting and queuing up exercises
, they can hit *start* on the queue and as they complete workouts, they will be able to **record** how many sets
, repetitions, weight of the exercise.  At the end of the workout, users can hit "*finished workout*" and the exercises in that **session will be logged and
stored**.
   
This application will be used by **gym-goers** or maybe people who just want a **casual workout**. This is a project of
interest to me because I used to be an active gym-goer before the pandemic and sometimes I would stray off task
from my workout, or I would forget what numbers I benched last week and would spend some more time trying to
find the perfect weight for my 10-rep max. A few reasons this app would be better than a workout log done on paper:
        
- Users don't have to bring around a piece of paper in the gym
- It is faster than having to write things down by handwriting
- Users don't have to additionally bring a pencil around (could be dangerous in a gym)
- Users can use it on their phones which most people bring to listen to music on.

#User Stories
- As a user, I want to be able to add and remove exercises to my workout queue.
- As a user, I want to be able to select a preset list
- As a user, I want to be able to view the different exercises available sorted by muscle groups.
- As a user, I want to be able to start the workout queue.
- As a user, I want to be able to record down details of the exercise (sets, reps ,etc).
- As a user, I want to be able to see a workout summary.
- As a user, I want to be able to close the app and pick up where I left off.
- As a user, I want to be able to save my workout summaries.
- As a user, I want to be able to load and view my past workout summaries.

#Phase 4: Task 2
- Made CardioExercise and MuscleExercise robust by dealing with negative input values from the user. Inputting
 negative values for time, sets, reps, or weight will throw a new NegativeValueException. Classes that throw this
  exception: CardioExercise, MuscleExercise, Workout. Methods involved: setTime() in CardioExercise, goThroughWorkout
  () in both CardioExercise and MuscleExercise, setReps(), setWeight(), and setNumberOfSets() in MuscleExercise.
- Class hierarchy of CardioExercise and MuscleExercise both extending abstract class Workout, and all cardio
 exercises in listofexercises package extend CardioExercise, and all muscle exercises in listofexercises package
  extend MuscleExercise. 
  
#Phase 4: Task 3
- If I had more time, I would have tried to figure out a better way to retrieve user input data when going through
 workouts because the current implementation uses a list of doubles for the time, sets, reps, and weights which does
 not seem like a very clean implementation.
- The classes in the persistence package could be abstracted as there contains a decent amount of duplicate code. One
 of them is used for PastLogs, and one of them is used for one temporary workout session.
- The FitnessApp class could also use a lot of abstraction because the console-based UI and the GUI both share many
 similar implementations. It was only a matter of how information was displayed that was different.
- I probably could have used an enum to represent the choices available for selectionList in FitnessApp.