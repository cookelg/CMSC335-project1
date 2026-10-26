# CMSC 335 Project 1: Java Shapes Program

A command-line program that builds 2D and 3D shapes and reports their area or volume. It is organized as a Java inheritance hierarchy.

<!-- TODO: Add a sentence or two about what the program does from the user's point of view. -->

## Requirements

- **Java Development Kit (JDK) 17 or newer**. Check with `java -version` and `javac -version`.
- **Apache Maven 3.6 or newer** (optional, needed only for the Maven build). Check with `mvn -v`.

## Project Layout

```
src/main/java/com/cooke/shapes/   Program source files (package com.cooke.shapes)
src/test/java/com/cooke/shapes/   JUnit 5 unit tests
pom.xml                           Maven build configuration
```

<!-- TODO: List the main classes once the hierarchy is written (Shape, TwoDimensionalShape, ...). -->

## Compiling and Running

Run all commands from the project root, which is the folder that contains `pom.xml`.

### Option 1: Maven

```bash
mvn compile
java -cp target/classes com.cooke.shapes.App
```

### Option 2: Plain `javac` (no Maven)

```bash
javac --release 17 -d out src/main/java/com/cooke/shapes/*.java
java -cp out com.cooke.shapes.App
```

This puts the compiled `.class` files in an `out/` folder.

## Running the Tests

```bash
mvn test                          # run all tests
mvn test -Dtest=AppTest           # run a single test class
mvn test -Dtest=AppTest#methodName   # run a single test method
```

## Using the Program

<!-- TODO: Describe the menu options (1–9 construct a shape, 10 exits), what input each shape asks for,
     and what happens on invalid input. A short sample session works well here. -->

## Assumptions

<!-- TODO: Document the assumptions about each shape (for example, which kind of triangle is used
     and which dimensions it takes, and how the torus radii are defined). -->

## Author

Lawrence Cooke

## AI Use Disclosure

This project used Claude Code (Anthropic's AI coding assistant, model Claude Opus 5.5) in the limited ways listed below:

- **Created the README skeleton.** This includes the section layout and the compile, run, and test commands. The AI checked the commands against the starter code.
- **Created `CLAUDE.md`.** This is a configuration file that gives the AI assistant context about the project. It is not part of the program.
- **Answered Maven build questions.** The AI confirmed that `.gitignore` doesn't block a fresh clone from building, and explained when `pom.xml` needs a main class.
- **Reviewed `Circle.java` without changing it.** The AI confirmed that an `IllegalArgumentException` thrown from the constructor can be caught by the caller. It also pointed out edge cases: NaN radius values, `setRadius` changing the radius before validating it, and closing the `Scanner` on `System.in`.
- **Explained how `Scanner` handles input.** The AI explained how `nextDouble()` behaves when input isn't a number, why bad input has to be discarded, and the difference between Ctrl+C and Ctrl+D (end of input). It ran a small test program outside the project to show this.
- **Suggested a design for input validation.** The AI suggested one shared helper method for reading positive numbers instead of a loop in each shape class. It also suggested sharing a single `Scanner` and catching only `InputMismatchException` in the retry loop. I wrote the `readPositiveDouble` helper in `App.java` myself.
- **Helped debug a compiler error.** The AI explained the "variable might not have been initialized" error in `readPositiveDouble`. It suggested a three-line fix for the catch block (discard the bad input, then `continue`), and I applied the fix myself.

The AI has not edited any Java source files. I wrote the class design, the Java code, and the tests.

<!-- TODO: Keep this section up to date. If you use AI for anything else later (code review,
     debugging help, explanations, test ideas, documentation), add it here, and say which
     parts you wrote yourself. -->
