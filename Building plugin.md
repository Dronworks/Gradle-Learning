## Building our Plugin
We can build plugins for gradle, and it is a simple Gradle class which ```implements Plugins<Project>``` and we implement the ```apply(Project project)``` function. The **project** variable passed during runtime(build).

This class should be created under **buildSrc** folder and then the package path.

Inside the function we will create tasks, with doLast block.
```
project.task("copyToS3") {
  doLast {
    println 'Copied to S3'
  }
}
```

**Hint** We can create the plugin class **inside** the build.gradle, and test it. Only after we move it to a separate class.

```
public class MyAWSPlugin implements Plugin<Project> {
	public void apply(Project project) {
		project.task("copyToS3") {
			doLast {
				println "Copied to S3"
			}
		}

		project.task("deployToEC2") {
			doLast {
				println "Application up and running"
			}
		}
	}
}

apply plugin: MyAWSPlugin
```

Once file is created: 
- we can import it into build.gradle like this ```import <package name>.<plugin name>```.
- we apply the plugin ```apply plugin: <plugin name>```
- we can run the tasks of this plugin.
- we can depend on this plugin tasks.

## Example:
Inside **buildSrc\src\main\groovy** inside **{project package name}** create class with the plugin

```
package com.dronworks.spring.gradle;

import org.gradle.api.Plugin
import org.gradle.api.Project

public class MyAWSPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.task("copyToS3") {
            doLast {
                println "Copied to S3"
            }
        }

        project.task("deployToEC2") {
            doLast {
                println "Application up and running"
            }
        }
    }
}
```

Inside build.gradle before plugin block import

```
import com.dronworks.spring.gradle.MyAWSPlugin
```

Inside build.gradle somewhere before the **dependsOn...** part apply the plugin

```
apply plugin: MyAWSPlugin
```

Run the tasks inside the plugin :)

## Note
Inside the buildSrc there will be also a build folder, with the compiled plugin code.

