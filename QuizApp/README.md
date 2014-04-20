Quiz
====

PiJ 2014 - Coursework Part 3


The structure of this system is a server and two different clients.

The 'controller' on each system hold the main program. With the 'launcher' file containing the main.

To run the program, launcher the server first by running 'QuizServerLauncherImpl'.

The  Setup Client can be used to set up games by running 'SetupClientLauncherImpl'.

Player client can be launched running the 'PlayerClientLauncher'.

Due to the way the system works, the Setup Client and the Player Client don't interact with each other at all.
Therefore, both can be run at the same time without issue.


The only tool I didn't have time to implement was the ability to edit a quiz after it has been finalised and uploaded.
However, there are tools throughout the quiz building process to 'edit as you go'.
Further implementation would allow editing quizzes after upload, taking them 'offline' whilst somebody works on it.

I didn't take the TDD approach. I built this project testing usability as I created it due to the use of RMI. Hence the lack of tests.
I used the RAPID APPLICATION DEVELOPMENT approach, as this will be the system I will be implementing my final project with, prioritising usability.