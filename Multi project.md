# Multi Project
Is an option to split project into modules so each module does her part and communicate with other modules.

## Basics
Multi project is a gradle project where we have
- root **settings.gradle**
- root **build.gradle** wehere we can set our repositories and dependencies that are common for all subprojects
- each sub project will have its src + test + build.gradle with his own dependencies
- each sub project gradle has its own tasks (with the according plugins) **gradle tasks --all**

## Commands of subproject
gradle :{project name}:{command}
```
gradle :web:clean
```

## New Tasks for all: root + sub project
We can create new tasks in build.gradle in the root. And then to run them in any of subproject. To do so create task in method **allprojects**
```
allprojects {
  task pringProjectName {
    doLast {
      println project.name
    }
  }
}
```

## New Tasks for only sub projects
Same as before but **subprojects**
```
subprojects {
  task pringProjectName {
    doLast {
      println project.name
    }
  }
}
```

## Running new Task (with subproject support)
Running such a Task will run the task in each subproject.

## Same build.gradle file in sub projects
Multiple subprojects can have same repositories, same plugins, and same dependencies (or at least some of them are common).
- We can extract (even have empty build.gradle files inside the sub projects) the configurations to the root build.gradle **under the subprojects { } block**
  - Note: plugins { id 'application' } need to be changed to apply plugin: 'application' (or any other plugin, same way)
- Version and Group also can go into the root build

```
subprojects {
  apply plugin: 'application'
  
  version = '1.0'
  group = 'com.dronworks'
  
  repositories {
    mavenCentral()
  }
  
  dependencies {
    ...
  }
}
```
