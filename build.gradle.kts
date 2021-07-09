plugins {
    java
    idea
    eclipse
    application
}

repositories {
    mavenCentral()
}

dependencies {

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.1")
    // Use JUnit Jupiter Engine for testing
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")

    run { // JavaFX dependencies
        val group = "org.openjfx"
        val version = "15.0.1"
        val fxModules = arrayListOf("javafx-base", "javafx-graphics", "javafx-controls", "javafx-fxml")

        val osName = System.getProperty("os.name")
        val platform = when {
            osName.startsWith("Mac", ignoreCase = true) -> "mac"
            osName.startsWith("Windows", ignoreCase = true) -> "win"
            osName.startsWith("Linux", ignoreCase = true) -> "linux"
            else -> throw GradleException("Unknown platform $osName")
        }

        fxModules.forEach {
            implementation("$group:$it:$version:$platform")
        }
    }
}

group = "de.uni-passau.se.memory"
version = "0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_15
    targetCompatibility = JavaVersion.VERSION_15
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

idea.module {
    isDownloadJavadoc = true
    isDownloadSources = true
}

eclipse.classpath {
    isDownloadJavadoc = true
    isDownloadSources = true
}

application {
    mainClass.set("de.uni_passau.fim.se.memory.Main")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}