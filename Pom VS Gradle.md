Creating both Maven and gradle uses default plugin - like <packaging>jar</packaging> in maven and id 'java' in build.gradle.

If we need any additional plugins in maven we will add them under <build><plugins></plugins></build> in build.gradle the are under plugins.

Dependencies section is similar. In maven there is a <scope></scope> element, while in gradle it is a function like testImplementation.

Repositories 
- in build.gradle
  - mavenCentral()
  - url="" - some local repository
- In maven we can use <url></url> tag for custom repository.
- Both know if a dependency depends on another dependency they automatically pull them.

Same project structure (src->main->java/test)

Maven is xml, Gradle is Groovy dsl.
