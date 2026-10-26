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

As of this writing, the AI has not written any of the Java source code, the class design, or the test cases.

<!-- TODO: Keep this section up to date. If you use AI for anything else later (code review,
     debugging help, explanations, test ideas, documentation), add it here, and say which
     parts you wrote yourself. -->
