# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

CMSC 335 Project 1: a graded course assignment (Java inheritance with a "Shape" theme). The full spec and grading rubric are in `docs/CMSC 335 Project 1.pdf` (the `docs/` directory is gitignored). This is the student's own graded work, so prefer explaining, reviewing, and guiding over writing large portions of the solution unless asked directly.

## Build & Run

Maven project, Java 17 (`maven.compiler.release`), JUnit 5 (Jupiter + params). There is no exec plugin or main-class manifest, so run the compiled classes directly.

```bash
mvn compile                                      # build
mvn test                                         # all tests
mvn test -Dtest=AppTest                          # one test class
mvn test -Dtest=AppTest#shouldAnswerWithTrue     # one test method
java -cp target/classes com.cooke.shapes.App     # run the program (after mvn compile)
```

The rubric requires **no compile warnings**, so check `mvn compile` output for warnings (for example, add `-Xlint:all` via compiler args if needed).

## Required design (from the spec)

All code lives in package `com.cooke.shapes`; each class goes in its own `.java` file. `App.java` is currently Maven archetype boilerplate and should become the menu driver.

- `Shape` (has a number of dimensions) → `TwoDimensionalShape` (has an area) and `ThreeDimensionalShape` (has a volume).
- 2D subclasses: `Circle`, `Square`, `Triangle`, `Rectangle`.
- 3D subclasses: `Sphere`, `Cube`, `Cone`, `Cylinder`, `Torus`.
- Assumptions about shapes (for example, which kind of triangle) must be documented in code comments.

Command-line menu behavior:
- Loops over options 1–9 (Circle, Rectangle, Square, Triangle, Sphere, Cube, Cone, Cylinder, Torus) and 10 = Exit.
- Prompts for each shape's dimensions, then prints its area (2D) or volume (3D).
- After each shape, asks "Would you like to continue? (Y or N)" and re-prompts on invalid input.
- Validates menu choices and numeric input, re-prompting on bad data.
- Exit prints a thank-you message with the current date and time (for example, "Today is Nov 11 at 1:40 PM.").

## Code conventions required by the rubric

Every source file needs a header comment block with the file name, date, author, and purpose. Use meaningful names and include comments inside the code.
