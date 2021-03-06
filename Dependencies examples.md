## Constraints
- Affecting only dependencies inside the consumer project. Producer project transitive dependencies versions not affected.
```
dependencies {
  constraints {
    implementation("org.slf4j:slf4j-api:1.7.26")
    implementation("org.apache:commons-lang3:3.3.0")
  }
  dependencies {
    implementation("org.slf4j:slf4j-api") // No version
  }
}
```

## Platform
- Lets you to define the version outside the dependencies declaration and used as a bom.

**Platform project**
```
plugins {
  'java-platform'
}

dependencies {
  constraints {
    api("org.slf4j:slf4j-api:1.7.26")
    runtime("org.slf4j:slf4j-simple:1.7.26")
  }
}
```

**Using project**
```
dependencies {
  api(platform(project(":platform")))
  implementation("org.slf4j:slf4j-api") // No version
}
```

## Because
Lets us to add a comment for "why the dependency is there"
```
dependencies("info.picocli:picocli") {
  because("Provides command-line argument parsing")
}
```

## Rich dependency versions
- Allows us to set dependency in a boundary, but if there is a 3.9.5 version it is preffered.
```
dependencies("info.picocli:picocli") {
  version {
    strictly ("[3.9, 4.0]")
    prefer("3.9.5")
  }
}
```
