## Tasks
- gradle tasks
- ./gradlew.bat tasks
- optional --all (shows also from what project task came)
- Inside custom task:
  - Anything will run during the **CONFIGURATION** phase.
  - doLast - will execute **LAST** during the **EXECUTION** phase.
  - doFirst - will execute **FIRST** during the **EXECUTION** phase.
- Any prints or functions inside the build.gradle - run during configuration phase.
- When we create new Task it looks something like this:
  ```
  project.addTask(task)
  Task task = new Compile
  ```
- We can set variables inside tasks: def someVariable = "abc"
- **NOTE** during the configuration phase ALL DEFINED in gradle.properties will run!


## Wrapper
- Gradle wrapper holds the version of gradle engine.
- It is pushed with the project.
- Instead of gradle commands we should use ./gradlew.bat 
  - this will use the wrapper for the gradle version.
  - this can be run at any machine without the need of installing gradle.

## Creating project
- To create gradle project we run gradle init.
- If we create application project, build.gradle will be at the application name folder.
- Application name is at settings.gradle.
- When creating a web project there is a need to manually add the **webapp** and the **index.html** to **src->main**. Aslo **response.jsp** can be good.

## Dependencies types
**Implementation** 
- Both for compilation time and run time.
- If we use dependency in project A, and then use A in project B, project B WILL NOT GET the dependencies of project A.

**API**
- Like Implementation, BUT project B WILL GET A's dependencies!

**Compile** 
- Same as Implementation, deprecaded.

**compileOnly**
– put the dependency on the compile classpath only

**runtimeOnly**
– put the dependency on the runtime classpath only

**testCompileOnly**
- Test files, only for compilation

**testRuntimeOnly**
- Test files, only for runtime

**testImplementation**
- Test files, both compilation and runtime.

## Gradle build Steps:
- **Initialization** - look at build.gradle and settings.gradle, configure what kind of project(single module/ multi module, project name...) is it and will create gradle object that represents the combination.
- **Configuration** - All the tasks reqired for the build create Direct Asideclick Ground. (If we create our own task in the build it will run during the configuration phase). 
  - **If we want to configure anything before task logic is executed we put it in a task.**
- **Execution** - Comilation, Test, jar/ war build.

## Build Daemon
- gradle build --daemon
- Does all the calculation for the build, build and launches a daemon that will make future builds faster because the daemon holds all the calculations.
- gradle build --no-daemon - recalculates everything and stop the daemon.

## Testing
- Running unit tests requres a block inside build.gradle
  ```
  test {
    useJunitPlatform()
  }
  ```
- For Junit5 next dependencies are required:
  ```
  dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.2'
  }
  ```
- To run unit tests in intellij:
  - File -> Settings -> Build,Execution,Deployment -> BildTools -> Gradle -> Run Tests Using -> Intellij  
