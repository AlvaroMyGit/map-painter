# map-painter

Map painter is a Java based application that enables users to create and edit pictures in a grid based system.

It uses this <a href="https://github.com/academia-de-codigo/simple-graphics"> library </a> for the graphics.

<h2>Features</h2>

Choose from 10 different colors to paint

Ability to hold down the paint/erase key and continue painting/erasing seamlessly

Save and load different files to preserve your work

<h2>Getting Started</h2>

Prerequisites

<a href="https://www.oracle.com/java/technologies/downloads"> Java Development Kit (JDK) </a> installed on your system

<a href="https://ant.apache.org"> Apache Ant </a> installed on your system

<h3>Installation</h3>

1. Clone this repository to your local machine:
```
git clone https://github.com/AlvaroMyGit/map-painter.git
```
2. Compile the source code to generate the JAR file:
Navigate to the project root directory which has the build.xml file
```
ant compile
```
I also included the creation of a .bat file for Windows users if they so desire, to do that just run
```
ant compile create-batch
```

<h3>Running</h3>

1. Navigate to the directory containing the JAR file (MapPainter.jar).

2. Run the application with the following command

Example:
```
java -jar MapPainter.jar
```
3. Windows users can double click the run.bat

<h3>Usage</h3>

Use the `ARROW KEYS` to move the cursor

Press `SPACE` to paint / erase if the square is already painted

Hold `Space` while moving the cursor to continuously paint / erase

Press `S` to save the current grid

Press `L` to load a previously saved grid

Press `Q` to quit the application
