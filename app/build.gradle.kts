plugins {
    application
}

val junitVersion by extra { "4.13.2" }
val jettyVersion by extra { "11.0.13" }
val jerseyVersion by extra { "3.1.0" }

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:$junitVersion")

    implementation("org.eclipse.jetty:jetty-server:$jettyVersion")
    implementation("org.eclipse.jetty:jetty-servlet:$jettyVersion")
    implementation("org.eclipse.jetty:jetty-servlets:$jettyVersion")
    implementation("org.glassfish.jersey.containers:jersey-container-servlet-core:$jerseyVersion")
    implementation("org.glassfish.jersey.inject:jersey-hk2:$jerseyVersion")
}

application {
    mainClass.set("jersey.App")
}
