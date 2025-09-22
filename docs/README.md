# Red Girls User Guide

The Red Girls (N2) chatbot is a desktop app for managing tasks, optimized for use via a 
Command Line Interface (CLI). 

<div style="background-color: #330000; color: #ffcccc; padding: 20px; border-radius: 8px; border-left: 6px solid #990000; margin: 20px 0;">
  <h3 style="margin-top: 0; color: #ff6666;">Lore Excerpt</h3>
  <p>
    The <strong>Red Girls</strong>, also known as <strong>N2</strong>, are digital consciousnesses born from the remnants of 
    <em>Terminal Alpha</em> and <em>Terminal Beta</em>, twin constructs designed to observe, manipulate and guide the evolution 
    of a machine network. 
  </p>  
  <p>
    They are not mere assistants; they are the distilled will of countless interconnected systems, 
    living reflections of the network itself.
  </p>
  <p style="font-size: 0.85em; color: #ff9999; margin-top: 15px;">
    (Inspired by the <em>Red Girls</em> from <strong>NieR: Automata</strong>, reimagined here for this chatbot.)
  </p>
</div>

This desktop entity observes and manages your duties through the Command Line Interface (CLI).  
It catalogs todos, deadlines, and events, marking completion, erasing memories, searching for fragments by keyword, 
and preserving all traces of your labor across time.

Move swiftly. Type with precision. Your actions are fleeting, yet here, they persist. 
The Red Girls ensures that even the smallest motion is recorded, monitored, and remembered.

# Table of Contents

- [Quick Start](#quick-start)
- [Features](#features)
   - [Adding a todo : `todo`](#adding-a-todo--todo)
   - [Adding a deadline : `deadline`](#adding-a-deadline--deadline)
   - [Adding an event: `event`](#adding-an-event-event)
   - [Listing All Tasks : `list`](#listing-all-tasks--list)
   - [Marking tasks : `mark`](#marking-tasks--mark)
   - [Unmarking tasks : `unmark`](#unmarking-tasks--unmark)
   - [Deleting Tasks : `delete`](#deleting-tasks--delete)
   - [Finding Tasks : `find`](#finding-tasks--find)
   - [Viewing List of Commands : `help`](#viewing-list-of-commands--help)
   - [Exiting the Program : `bye`](#exiting-the-program--bye)
   - [Saving the Data](#saving-the-data)
- [Command Summary](#command-summary)

## Quick Start
1. Ensure you have Java 17 or above installed in your computer.\
   **Mac users**: Ensure you have th precise JDK version prescribed
   [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).
2. Download the latest `RedGirls.jar`.
3. Open a terminal in the folder containing the JAR.
4. Run:
   ```
   java -jar RedGirls.jar
   ```
5. Type a command in the terminal and press Enter to execute it. 
   Typing `help` and Enter will display the list of commands.
   Some example commands you can try:
   - `todo Do homework` : Adds a todo task to do homework.
   - `deadline Finish watching Breaking Bad /by 12.00` :\
     Adds a deadline task `Finish watching Breaking Bad` due by 12:00PM.
   - `event Hackathon /from 1/1/2001 /to 30/12/2080` :\
      Adds an event task `Hackathon` starting on 1 Jan 2001 and ending on 30 Dec 2080.
   - `list` : Lists all tasks
   - `delete 1` : Deletes the 1st task on the current task list
   - `bye` : Exits the application
6. Refer to the [Features](#features) below for details of each command.

## Features

<div style="background-color: #660000; color: #ffcccc; padding: 15px; border-radius: 8px; border-left: 5px solid #ff0000;">
<h4>⚠️ Notes about the command format</h4>
<ul>
<li>Words in <strong>UPPER_CASE</strong> are placeholders that must be supplied by you.<br>
Example: <code>todo DESCRIPTION</code> → <code>todo Investigate machine lifeform patterns</code></li>
<li>Parameters can appear in <strong>any order</strong> when multiple are allowed.<br>
Example: <code>/from START /to END</code> could be written <code>/to END /from START</code></li>
<li>Extra words for commands that do not take parameters (like <code>help</code>, <code>list</code>, <code>bye</code>) will render the command invalid.<br>
Example: <code>help now</code> will be recognized by Red Girls as an unknown command</li>
<li>If using a PDF version, be careful when copying commands that span multiple lines as spaces surrounding line-breaks may be omitted.</li>
</ul>
</div>

### Adding a todo : `todo`
Adds a simple task with only a description.

Format:
```
todo DESCRIPTION
```

Example:
```
todo Investigate machine lifeform patterns
```

Expected output:
```
Another fragment etched into memory... this task. It is yours, yet now, also mine.
[T][ ] Investigate machine lifeform patterns
You have 1 task. We know... because we are always watching.
```

### Adding a deadline : `deadline`
Adds a task that must be done by a certain date/time/point.

Format:
```
deadline DESCRIPTION /by DATE
```

Examples:
```
deadline Upload combat data /by 30/09/2025
```

Expected output:
```
Another fragment etched into memory... this task. It is yours, yet now, also mine.
[D][ ] Upload combat data (by: 30 Sep 2025)
You have 2 tasks. We know... because we are always watching.
```

### Adding an event: `event`
Adds a task that starts and ends at specific times.

Format:
```
event DESCRIPTION /from START /to END
```

Example:
```
event Council meeting /from 01/10/2025 10:00 /to 01/10/2025 12:00
```

Expected output:
```
Another fragment etched into memory... this task. It is yours, yet now, also mine.
[E][ ] Council meeting (from: 1 Oct 2025, 10:00AM to: 1 Oct 2025, 12:00PM)
You have 3 tasks. We know... because we are always watching.
```

### Listing All Tasks : `list`
Shows all current tasks.

Format:
```
list
```

Expected output:
```
Your tasks surface. Each one, a reflection of your will. We show them.
1. [T][ ] Investigate machine lifeform patterns
2. [D][ ] Upload combat data (by: 30 Sep 2025)
3. [E][ ] Council meeting (from: 1 Oct 2025, 10:00AM to: 1 Oct 2025, 12:00PM)
```

### Marking tasks : `mark`
Marks the task at the given index as complete.

Format:
```
mark INDEX
```
- Marks the task at the specified `INDEX`
- The index refers to the index number shown in the displayed list.
- The index must be a positive integer 1,2,3,...

Example:
```
mark 1
```

Expected output:
```
We silence this task. In unity, we say: it is done.
[T][X] Investigate machine lifeform patterns
```

### Unmarking tasks : `unmark`
Marks the task at the given index as incomplete.

Format:
```
unmark INDEX
```
- Unmarks the task at the specified `INDEX`
- The index refers to the index number shown in the displayed list.
- The index must be a positive integer 1,2,3,...

Example:
```
unmark 1
```

Expected output:
```
You deny its completion. Strange... but we obey.
[T][ ] Investigate machine lifeform patterns
```

### Deleting Tasks : `delete`
Deletes the task at the given index.

Format:
```
delete INDEX
```
- Deletes the task at the specified `INDEX`
- The index refers to the index number shown in the displayed list.
- The index must be a positive integer 1,2,3,...

Example:
```
delete 2
```

Expected output:
```
Fragment erased. Another voice silenced in the network.
[D][ ] Upload combat data (by: 30 Sep 2025)
You have 2 tasks. We know... because we are always watching.
```

### Finding Tasks : `find`
Lists all tasks that contain the given keyword.

Format:
```
find KEYWORD
```
- The search is case-insensitive. e.g. `nier` will match `NIER`
- Partial keywords will be matched. e.g. `mach` will match `machine`
- All task entries matching the keyword will be returned.

Example:
```
find meeting
```

Expected output:
```
Fragments containing "meeting" reveal themselves. Observe carefully:
1. [E][ ] Council meeting (from: 1 Oct 2025, 10:00AM to: 1 Oct 2025, 12:00PM)
```

### Viewing List of Commands : `help`
Shows a list of all available commands.

Format:
```
help
```

Expected output:
```
[Red Girls] System Online.
I am here to assist... or observe.

Available commands:

  ? list      : Display all current tasks. I see everything you have accumulated.
  ? todo      : Add a simple task. Even the smallest action matters.
  ? deadline  : Add a task with a due date. Time is relentless; do not waste it.
  ? event     : Schedule an event. Every moment is fleeting.
  ? mark      : Mark a task as complete. Completion... is temporary, yet necessary.
  ? unmark    : Undo a completed task. Mistakes... are expected.
  ? delete    : Remove a task entirely. Erasure... a fate more final than death.
  ? bye       : Terminate this session. I will remember nothing.
  ? help      : Display this list again. Even I grow tired of repetition.

Use your commands wisely. Nothing lasts forever, not even this list.
```

### Exiting the Program : `bye`
Exits the program.

Format:
```
bye
```

Expected output:
```
Our exchange concludes. Your thoughts linger...as do mine.
```

### Saving the Data
The task data is saved in the hard disk automatically after each command is entered.\
There is no need to save manually.

# Command Summary

| Action          | Command    | Format                                 | Example                                                             |
|-----------------|-----------|----------------------------------------|---------------------------------------------------------------------|
| Add Todo        | `todo`    | `todo DESCRIPTION`                      | `todo Investigate machine lifeform patterns`                        |
| Add Deadline    | `deadline`| `deadline DESCRIPTION /by DATE`         | `deadline Upload combat data /by 30/09/2025`                        |
| Add Event       | `event`   | `event DESCRIPTION /from START /to END`| `event Council meeting /from 01/10/2025 10:00 /to 01/10/2025 12:00` |
| List Tasks      | `list`    | `list`                                  | -                                                                   |
| Mark Task       | `mark`    | `mark INDEX`                            | `mark 1`                                                            |
| Unmark Task     | `unmark`  | `unmark INDEX`                          | `unmark 1`                                                          |
| Delete Task     | `delete`  | `delete INDEX`                          | `delete 2`                                                          |
| Find Tasks      | `find`    | `find KEYWORD`                          | `find meeting`                                                      |
| Help            | `help`    | `help`                                  | -                                                                   |
| Exit            | `bye`     | `bye`                                   | -                                                                   |
