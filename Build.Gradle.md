## Concepts
- Each Block is a **method** on the gradle **object** of the project.
- 'plugin' is NOT a method. Once it was 'apply plugin', where 'apply' was a method.
- We can set project properties inside here, but after plugins block.
- We can create custom properties like this project.ext.some_property = "abc"
- Inside tasks there is an Actions block. (inclding methods doLast and doFirst)
