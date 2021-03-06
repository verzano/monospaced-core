plugins {
    `java-library`
    `maven-publish`
}

group = "dev.verzano.monospaced"
version = "0.1.0"

repositories {
    mavenLocal()
    jcenter()
}

java {
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    // Test Dependencies
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-params", "5.7.1")
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-engine", "5.7.1")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = rootProject.name
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set("Monospaced Core")
                description.set("Core components of the Monospaced framework")
                url.set("https://github.com/verzano/monospaced-core")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("verzano")
                        name.set("Mitchell Verzano Berg")
                        email.set("mitchell.v.berg@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com:verzano/monospaced-core.git")
                    developerConnection.set("scm:git:ssh://github.com:verzano/monospaced-core.git")
                    url.set("https://github.com/verzano/monospaced-core")
                }
            }
        }
    }
    repositories {
        maven {
            // change URLs to point to your repos, e.g. http://my.org/repo
            val releasesRepoUrl = uri("$buildDir/repos/releases")
            val snapshotsRepoUrl = uri("$buildDir/repos/snapshots")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
