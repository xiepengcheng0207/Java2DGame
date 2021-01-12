README

Game: Stickman
Version: 1.1

*** How to run it ***
1. Download the src folder and build.gradle.
2. Install JDK 11 and Gradle 6.6
3. "Gradle init" in your download folder
4. "Gradle build" and "Gradle run"


*** AIM ***

The aim of the Stickman game is to make it to the right top side of the game space and touch the finish flag.
Picking up a mushroom will enable you to shoot bullets.
If you fall off the bottom of the screen or you are touched by an enemy slime, then you 
will die and the level will start again.

If you make it to the end, a "You Win" banner will come down from the top. At this
point, you can press ESC to restart the level. --- Play as much as you want!!! ---


*** Controls ***

Left: Left Arrow
Right: Right Arrow
Jump: Up arrow
		NOTE: You can only jump a maximum time of two jumps.
			After this the Stickman will fall back to the 
			ground, when you can now jump again.

Shoot: [Left Arrow | Right Arrow] + Spacebar.
		NOTE: Shoot will not work with just the spacebar or before a mushroom is gathered.


*** Features ***

Time: Each level has a limit time, if the time of completing the level is out of limitation. The total score will be deducted by 1 for per second. The time will be shown on the top left corner.

Score: Per second worths 1 score. The score will be shown on the top left corner.

Levels: The number of total levels is 4. The current level and number of total level will be shown on the top left corner.

Save/load: This game is able to save and load the game states;

*** Design patterns ***

Observer design pattern: path: src/main/java/stickman/Observe

Memento design pattern: path: src/main/java/stickman/model


*** Save & load ***
Save: This game can quickly save the game states by pressing the key "q".
Load: This game can quickly load the saved game states by pressing the key "s".

