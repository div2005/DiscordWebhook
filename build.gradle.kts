plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("java-library")
    id("maven-publish")
}

group = "ua.vn.div"
version = "1.0.4"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
    implementation("io.ktor:ktor-client-core:3.0.0")
    implementation("io.ktor:ktor-client-okhttp:3.0.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}


publishing {
    publications {
        create<MavenPublication>("local") {
            from(components["java"])
        }
    }
}