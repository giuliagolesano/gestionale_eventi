plugins {
    // Apply the java plugin to add support for Java
    id("java")

    // Apply the application plugin to add support for building a CLI application
    id("application")

    // Adds tasks to export a runnable jar
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("org.danilopianini.gradle-java-qa") version "1.36.0"
}

repositories {
    mavenCentral()
}

val javaFXModules = listOf(
    "base",
    "controls",
    "fxml",
    "swing",
    "graphics"
)

val supportedPlatforms = listOf("linux", "mac", "win")

dependencies {
    implementation("mysql:mysql-connector-java:8.0.32")
    implementation("org.hibernate:hibernate-core:5.6.10.Final")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.hibernate.common:hibernate-commons-annotations:5.1.2.Final")
    implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.0.Final")
    
    testImplementation("junit:junit:4.13.2")

    val javaFxVersion = 15
    for (platform in supportedPlatforms) {
        for (module in javaFXModules) {
            implementation("org.openjfx:javafx-$module:$javaFxVersion:$platform")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    // Define the main class for the application
    mainClass.set("it.unibo.db.Start")
}
