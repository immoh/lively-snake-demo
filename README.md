# Lively Snake Demo

This is a demo of live coding snake game in ClojureScript using [lively](http://github.com/immoh/lively).
It was part of a talk I gave in [clojuTre 2014](http://clojutre.org/2014/).

## Setup

1. Clone this repository and cd into it:

   ```
   git clone https://github.com/immoh/lively-snake-demo.git
   cd lively-snake-demo
   ```

2. In a terminal window, start lein-cljsbuid:

   ```
   lein cljsbuild auto
   ```

3. In another terminal window, start Ring server:

   ```
   lein ring server
   ```

   This should automatically open a web browser, if not, navigate to
   [http://localhost:3000/index.html](http://localhost:3000/index.html).
   Optionally, open JavaScript console to see when the reloads happen.


## Demo Steps

   Demo steps can be replayed by checkout out git tags in specific order. In order to do this, open (yet) another terminal
   and cd into lively-snake-demo dir.

1. Change start screen text

   ```
   git checkout 1-change-start-screen-text
   ```

   Title in the start screen changes from "Snake" to "Lively Snake".

   Click on the "Start Game" link. The snake appears but it doesn't move.


2. Make snake move

   ```
   git checkout 2-make-snake-move
   ```

   Snake starts moving to the left, and goes of the screen.


3. Make snake stay on the game area

   ```
   git checkout 3-stay-on-game-area
   ```

   Snake comes back to the game piece by piece, and doesn't run out of the game area anymore.


4. Enable snake controls

   ```
   git checkout 4-enable-snake-controls
   ```

   You are now able to change the direction of the snake by pressing arrow keys on the keyboard.


5. Add an apple

   ```
   git checkout 5-add-apple
   ```

   An apple appears on the game area but it is a difficult to catch since it moves constantly.


6. Make apple stay in its position

   ```
   git checkout 6-make-apple-stay
   ```

   The apple stops moving but the snake runs through it instead of eating it.


7. Make the snake eat apples

   ```
   git checkout 7-eat-apples
   ```

   You are now able to eat apples with the snake.
   When the snake runs into an apple, the apple disappears and snake grows.


8. Implement game over

   ```
   git checkout 8-add-game-over
   ```

   If you now make the snake cross itself, the game ends and start screen with "Game Over" text is shown.
