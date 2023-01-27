/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details take a look at the 'Building Java & JVM projects' chapter in the Gradle
 * User Manual available at https://docs.gradle.org/7.6/userguide/building_java_projects.html
 */

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
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.eclipse.jetty:jetty-slf4j-impl:11.0.13")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.eclipse.jetty:jetty-server:11.0.13")
    implementation("org.eclipse.jetty:jetty-servlet:11.0.13")
    implementation("org.glassfish.jersey.containers:jersey-container-servlet-core:3.1.0")
    implementation("org.glassfish.jersey.inject:jersey-hk2:3.1.0")
    implementation("org.eclipse.jetty:jetty-servlets:11.0.13")
}

application {
    // Define the main class for the application.
    mainClass.set("jersey.App")
}
