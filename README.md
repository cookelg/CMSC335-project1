# CMSC 335 Project 1: Java Shapes Program

A command-line program that builds 2D and 3D shapes and reports their area or volume.

## Requirements

- **Java Development Kit (JDK) 17 or newer**. Check with `java -version` and `javac -version`.
- **Apache Maven 3.6 or newer** (optional, needed only for the Maven build). Check with `mvn -v`.

## Project Layout

```
src/main/java/com/cooke/shapes/   Program source files (package com.cooke.shapes)
src/test/java/com/cooke/shapes/   JUnit 5 unit tests
pom.xml                           Maven build configuration
```


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

When the app is started, the user will be prompted to input a number between 1 and 10
to the console to select a shape as such:


```
Select from the menu below:

    1. Construct a Circle
    2. Construct a Rectangle
    3. Construct a Square
    4. Construct a Triangle
    5. Construct a Sphere
    6. Construct a Cube
    7. Construct a Cone
    8. Construct a Cylinder
    9. Construct a Torus
    10. Exit the Program
```

The user will then be prompted to input the dimensions of the chosen shape. For example,
if a user selected circle, they will be prompted for the radius of the circle. Once 
the user inputs a valid radius, the shapes area (or volume if it is a 3D shape) will 
be displayed, and the user can decide to build another shape:


```
 >>1

You have selected a Circle
What is the Radius?
 >>1

The Circle has an area of 3.141592653589793
Would you like to continue? (Y or N)
 >>
```

If the user attempts to input an invalid character, or if one of the inputs cannot be 
used to make a valid shape, the menu will restart.

General Rules for inputs:
- no negative numbers
- The sum of the smallest two segments of a triangle must be greater than the longest segment
- The major radius of a torus must be greater than the minor radius

## Author

Lawrence Cooke

## Lessons learned
The concept that I wanted to really flex during this assignment was using constructors properly. One of the features that I wanted to implement was to have the program check for valid constructor arguments and throw an exception if one is supplied. I was able to overcome this by implementing a static method to calculate volume/area and throw an exception when an invalid argument is passed to it. I passed the output of that static method to the superclass constructor, enabling an exception to be thrown before an invalid shape can be constructed. I also used this project to learn about Java enum classes; I chose to use these as member variables for triangle types (right, obtuse, acute).  

## AI Use Disclosure

This project used two of Anthropic's AI tools in the limited ways listed below: Claude Code, the command-line coding assistant, and the Claude chatbot in a web browser.

### Claude Code (model Claude Opus 5.5)

- **Created the README skeleton.** This includes the section layout and the compile, run, and test commands. The AI checked the commands against the starter code.
- **Created `CLAUDE.md`.** This is a configuration file that gives the AI assistant context about the project. It is not part of the program.
- **Answered Maven build questions.** The AI confirmed that `.gitignore` doesn't block a fresh clone from building, and explained when `pom.xml` needs a main class.
- **Reviewed `Circle.java` without changing it.** The AI confirmed that an `IllegalArgumentException` thrown from the constructor can be caught by the caller. It also pointed out edge cases: NaN radius values, `setRadius` changing the radius before validating it, and closing the `Scanner` on `System.in`.
- **Explained how `Scanner` handles input.** The AI explained how `nextDouble()` behaves when input isn't a number, why bad input has to be discarded, and the difference between Ctrl+C and Ctrl+D (end of input). It ran a small test program outside the project to show this.
- **Suggested a design for input validation.** The AI suggested one shared helper method for reading positive numbers instead of a loop in each shape class. It also suggested sharing a single `Scanner` and catching only `InputMismatchException` in the retry loop. Lawrence implemented the `readPositiveDouble` helper in `App.java`.
- **Helped debug a compiler error.** The AI explained the "variable might not have been initialized" error in `readPositiveDouble`. It suggested a three-line fix for the catch block (discard the bad input, then `continue`), and Lawrence applied the fix. It also pointed out an extra `input.next()` call in the `number <= 0` branch that would make the program wait for more input.
- **Helped debug a failing triangle test.** The AI ran `TriangleTest` and found that `Triangle.getTriangleType()` was correct. The failure came from the test itself: one assertion checked the wrong triangle, and the `assertEquals` arguments were in the wrong order, which made the failure message misleading. The AI also pointed out two edge cases in `Triangle.java`: comparing doubles with exact `==` when checking for a right triangle, and allowing flat triangles (`a + b == c`). Any resulting fixes were made by Lawrence.
- **Added the Maven Javadoc plugin.** At Lawrence's request, the AI added `maven-javadoc-plugin` (version 3.11.2) to `pom.xml` and ran `mvn javadoc:javadoc` to test it. It pointed out three `@param` tags in `Cone.java` and `Square.java` that name parameters the methods don't have, which made the Javadoc build fail. It did not change those files.
- **Reformatted Javadoc comments.** At Lawrence's request, and after Lawrence reviewed and approved a preview of the changes, the AI edited all 13 Java source files in `src/main/java/com/cooke/shapes/`. It made only two kinds of formatting changes: it moved each file's header comment from above the `package` statement to just above the class declaration, and it removed the type annotations from the `@param` tags (for example, `@param radius:double` became `@param radius`), re-aligning the descriptions where they were lined up in columns. It did not change any code or the wording of any comment.

### Claude chatbot (web browser, model Claude Sonnet 5.5)

- **Calculated expected values for tests.** Lawrence used Claude to calculate known correct results, such as areas and volumes for specific dimensions. These values serve as the expected results in the project's unit tests.

### Summary

Apart from the Javadoc formatting changes described above, neither tool edited any Java source files. Lawrence wrote the class design, the Java code, the comments, and the tests. Some of the expected values in the tests were calculated with the Claude chatbot, as described above.

<!-- TODO: Keep this section up to date. If you use AI for anything else later (code review,
     debugging help, explanations, test ideas, documentation), add it here, and say which
     parts you wrote yourself. -->
