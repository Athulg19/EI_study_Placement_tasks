# 🚀 EI_study_Placement_tasks

# 🧑‍🚀 Astronaut Daily Schedule Organizer

A console-based Java application to help astronauts organize their daily schedules efficiently. The application allows users to add, remove, edit, and view daily tasks with features like conflict detection, priority levels, and task completion status.

## 📋 Table of Contents

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


## ✨ Features

- **📝 Add Tasks**: Create new tasks with a description, start time, end time, and priority level.
- **❌ Remove Tasks**: Delete existing tasks from the schedule.
- **👀 View Tasks**: Display all scheduled tasks sorted by start time.
- **✏️ Edit Tasks**: Modify existing tasks' details.
- **⚠️ Conflict Detection**: Prevent overlapping tasks and notify users of conflicts.
- **✅ Task Completion**: Mark tasks as completed.
- **🔍 Priority Filtering**: View tasks filtered by priority levels (High, Medium, Low).
- **💡 Graceful Exception Handling**: Provides meaningful error messages without crashing.
- **📜 Logging**: Logs application usage and errors to a file for tracking.

## 🛠️ Design Patterns and Principles

The application is built with a strong emphasis on clean code, maintainability, and best practices.

### 📐 Design Patterns Used

- **🔁 Singleton Pattern**: Ensures only one instance of the `ScheduleManager` exists throughout the application.
- **🏭 Factory Pattern**: The `TaskFactory` class encapsulates the creation logic of `Task` objects.
- **👀 Observer Pattern**: Implements a notification system to alert users of task conflicts or updates.

### 🧱 SOLID Principles

- **📏 Single Responsibility Principle**: Each class has a single responsibility.
- **🔒 Open/Closed Principle**: Classes are open for extension but closed for modification.
- **⚖️ Liskov Substitution Principle**: Subtypes can be substituted in place of their base types.
- **🎛️ Interface Segregation Principle**: Uses specific interfaces rather than a general-purpose one.
- **⚙️ Dependency Inversion Principle**: High-level modules do not depend on low-level modules but on abstractions.

## ⚙️ Installation

### ⚠️ Prerequisites

- **Java Development Kit (JDK) 8 or higher**: Ensure that Java is installed and the `javac` and `java` commands are available in your system's PATH.


### 🔧 Steps

1. **📂 Clone the Repository**

   ```bash
   git clone https://github.com/Athulg19/EI_study_Placement_tasks.git

2. **📁 Navigate to the Project Directory**

   ```bash
   cd astronautscheduler

3. **🖥️ Compile the Source Files**

   ```bash
   javac *.java
 
4. **🚀 Run the Application**

   ```bash
   java AstronautScheduleApp

## 📱 Usage

**Upon running the application, you will be presented with a menu of options:**

Astronaut Daily Schedule Organizer
1. Add a new task
2. Remove an existing task
3. View all tasks
4. Mark task as completed
5. View tasks by priority
6. Edit an existing task
7. Exit
Enter your choice:

### 🧑‍💻 Menu Options

1. **📂 Add a New Task**
   ```plaintext
   - Enter the task description, start time (HH), end time (HH), and priority level (High, Medium, Low).
   - Example : <br>
     Enter task description: Morning Exercise <br>
     Enter start time (HH:mm): 07:00 <br>
     Enter end time (HH:mm): 08:00 <br>
     Enter priority level (High, Medium, Low): High <br>```

3. **❌ Remove an Existing Task**
   ```plaintext
   - Enter the exact task description to remove it from the schedule.```
    
5. **👀 View All Tasks**
   ```plaintext
   - Displays all scheduled tasks sorted by start time.```
    
7. **✅ Mark Task as Completed**
   ```plaintext
   - Enter the task description to mark it as completed.```

9. **🔍 View Tasks by Priority**
   ```plaintext
   - Enter a priority level to filter tasks (High, Medium, Low).```

2. **✏️ Edit an Existing Task**
   ```plaintext
   - Enter the description of the task you wish to edit and provide new details.```

2. **🚪 Exit**
   ```plaintext
   - Closes the application.```

## ⚠️ Exception Handling and Logging

### 🛡️ Exception Handling 

**The application gracefully handles exceptions with meaningful error messages:**

 - **`InvalidTimeException:`** Thrown when the time format is invalid.
 - **`InvalidPriorityException:`** Thrown when an invalid priority level is entered.
 - **`TaskConflictException:`** Thrown when a new task conflicts with an existing one.
 - **`TaskNotFoundException:`** Thrown when attempting to remove or edit a non-existent task.

### 📝 Logging

 - **`🖥️ Logging Mechanism:`** Uses Java's built-in logging API.
 - **`📄 Log File:`** application.log is created in the project directory.
 - **`🔍 Logged Information:`**
   - Task additions, removals, edits, and completions.
   - Warnings for attempted conflicting tasks.
   - Errors encountered during execution.  

## 💻 Sample Interaction

Astronaut Daily Schedule Organizer
1. Add a new task
2. Remove an existing task
3. View all tasks
4. Mark task as completed
5. View tasks by priority
6. Edit an existing task
7. Exit<br>

Enter your choice: 1 <br> 
Enter task description: Morning Exercise <br> 
Enter start time (HH:mm): 07:00 <br> 
Enter end time (HH:mm): 08:00 <br> 
Enter priority level (High, Medium, Low): High <br> 
Task added successfully. No conflicts. <br> 

Astronaut Daily Schedule Organizer <br> 
Enter your choice: 1 <br> 
Enter task description: Team Meeting <br> 
Enter start time (HH:mm): 09:00 <br> 
Enter end time (HH:mm): 10:00 <br> 
Enter priority level (High, Medium, Low): Medium <br> 
Task added successfully. No conflicts. <br> 

Astronaut Daily Schedule Organizer <br> 
Enter your choice: 3 <br> 
Scheduled Tasks: <br> 
07:00 - 08:00: Morning Exercise [HIGH] <br> 
09:00 - 10:00: Team Meeting [MEDIUM] <br> 

Astronaut Daily Schedule Organizer <br> 
Enter your choice: 1 <br> 
Enter task description: Training Session <br> 
Enter start time (HH:mm): 09:30 <br> 
Enter end time (HH:mm): 10:30 <br> 
Enter priority level (High, Medium, Low): High <br> 
Notification: Task conflicts with existing task "Team Meeting". <br> 
Error: Task conflicts with existing task "Team Meeting". <br> 

Astronaut Daily Schedule Organizer <br> 
Enter your choice: 4 <br> 
Enter task description to mark as completed: Morning Exercise <br> 
Task marked as completed. <br> 

Astronaut Daily Schedule Organizer <br> 
Enter your choice: 3 <br> 
Scheduled Tasks: <br> 
07:00 - 08:00: Morning Exercise [HIGH] (Completed) <br> 
09:00 - 10:00: Team Meeting [MEDIUM] <br> 

Astronaut Daily Schedule Organizer <br> 
Enter your choice: 7 <br> 
Exiting application.<br> 

















