plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit test framework.
    testImplementation(libs.junit)

    // This dependency is used by the application.
    implementation(libs.guava)

    // RabbitMQ client library
    implementation("com.rabbitmq:amqp-client:5.22.0")

    // SLF4J simple logger
    implementation("org.slf4j:slf4j-simple:1.7.32")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    // Define the default main class for the application.
    mainClass.set("org.example.App")
}

// Define task for MainClass1 (Send)
tasks.register<JavaExec>("runMainClass1") {
    mainClass.set("org.example.Send")  // Correct class name and package
    classpath = sourceSets["main"].runtimeClasspath
}

// Define task for MainClass2 (Recv)
tasks.register<JavaExec>("runMainClass2") {
    mainClass.set("org.example.Recv")  // Correct class name and package
    classpath = sourceSets["main"].runtimeClasspath
}

tasks.register<JavaExec>("runNewTask") {
    mainClass.set("org.example.NewTask")  // Correct class name and package
    classpath = sourceSets["main"].runtimeClasspath
    args=listOf("First message.","Second message..","Third message...", "Fourth message....", "Fifth message.....")
}

tasks.register<JavaExec>("runWorker") {
    mainClass.set("org.example.Worker")  // Correct class name and package
    classpath = sourceSets["main"].runtimeClasspath
}

