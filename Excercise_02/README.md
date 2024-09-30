# EI_study_Placement_tasks

# Astronaut Daily Schedule Organizer

A console-based Java application to help astronauts organize their daily schedules efficiently. The application allows users to add, remove, edit, and view daily tasks with features like conflict detection, priority levels, and task completion status.

## Table of Contents

- [Features](#features)
- [Design Patterns and Principles](#design-patterns-and-principles)
  - [Design Patterns Used](#design-patterns-used)
  - [SOLID Principles](#solid-principles)
- [Installation](#installation)
  - [Prerequisites](#prerequisites)
  - [Steps](#steps)
- [Usage](#usage)
  - [Menu Options](#menu-options)
- [Exception Handling and Logging](#exception-handling-and-logging)
  - [Exception Handling](#exception-handling)
  - [Logging](#logging)
- [Sample Interaction](#sample-interaction)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Add Tasks**: Create new tasks with a description, start time, end time, and priority level.
- **Remove Tasks**: Delete existing tasks from the schedule.
- **View Tasks**: Display all scheduled tasks sorted by start time.
- **Edit Tasks**: Modify existing tasks' details.
- **Conflict Detection**: Prevent overlapping tasks and notify users of conflicts.
- **Task Completion**: Mark tasks as completed.
- **Priority Filtering**: View tasks filtered by priority levels (High, Medium, Low).
- **Graceful Exception Handling**: Provides meaningful error messages without crashing.
- **Logging**: Logs application usage and errors to a file for tracking.

## Design Patterns and Principles

The application is built with a strong emphasis on clean code, maintainability, and best practices.

### Design Patterns Used

- **Singleton Pattern**: Ensures only one instance of the `ScheduleManager` exists throughout the application.
- **Factory Pattern**: The `TaskFactory` class encapsulates the creation logic of `Task` objects.
- **Observer Pattern**: Implements a notification system to alert users of task conflicts or updates.

### SOLID Principles

- **Single Responsibility Principle**: Each class has a single responsibility.
- **Open/Closed Principle**: Classes are open for extension but closed for modification.
- **Liskov Substitution Principle**: Subtypes can be substituted in place of their base types.
- **Interface Segregation Principle**: Uses specific interfaces rather than a general-purpose one.
- **Dependency Inversion Principle**: High-level modules do not depend on low-level modules but on abstractions.

## Installation

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**: Ensure that Java is installed and the `javac` and `java` commands are available in your system's PATH.



 


