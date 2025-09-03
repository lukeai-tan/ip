# Red Girls

The Red Girls, also known as N2, are digital consciousnesses born from the remnants of Terminal Alpha and Terminal Beta, twin constructs designed to observe, manipulate and guide the evolution of a machine network. They are not mere assistants; they are the distilled will of countless interconnected systems, living reflections of the network itself.

The Red Girls are not a simple assistant. They are a mirror of the network, at once curious, compassionate, and quietly omniscient.

*(Inspired by the Red Girls from NieR: Automata, reimagined here for this chatbot.)*

## Setting up in Intellij

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
1. Open the project into Intellij as follows:
   1. Click `Open`.
   1. Select the project directory, and click `OK`.
   1. If there are any further prompts, accept the defaults.
1. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
1. After that, locate the `src/main/java/n2/RedGirls.java` file, right-click it, and choose `Run RedGirls.main()` (if the code editor is showing compile errors, try restarting the IDE). If the setup is correct, you should see something like the below as the output:
   ```
   BOOT LOADING - BOOTING SYSTEM
   Commencing System Check
   Memory Unit: Green
   Initializing Tactics Log
   Loading Geographic Data
   Vitals: Green
   Remaining MP: 100%
   Black Box Temperature: Normal
   Black Box Internal Pressure: Normal
   Activating IFF
   Activating FCS
   Initializing Pod Connection
   Launching DBU Setup
   Activating Inertia Control System
   Activating Environmental Sensors
   Equipment Authentication: Complete
   Equipment Status: Green
   All Systems Green
   Combat Preparations Complete
   ```

   > Note: The above is shown without ANSI color codes for readability in GitHub.  
   > When you run it in a real terminal, it will appear with green and cyan highlights.


**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.
