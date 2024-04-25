import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    application
    kotlin("plugin.serialization") version "1.9.23"
}

group = "dev.garlicbread"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "Sonatype Snapshots (Legacy)"
        url = uri("https://oss.sonatype.org/content/repositories/snapshots")
    }

    maven {
        name = "Sonatype Snapshots"
        url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")
//    implementation("dev.kord:kord-core:0.13.1")
    implementation("org.slf4j:slf4j-simple:2.0.5")
    implementation("com.squareup.moshi:moshi:1.15.1")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation(libs.kotlinx.serialization)
    implementation(libs.kord.extensions.core)
}

tasks {
    val fatJar = register<Jar>("fatJar") {
        archiveFileName.set("toebot.jar")
        dependsOn.addAll(listOf("compileJava", "compileKotlin", "processResources"))
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest { attributes(mapOf("Main-Class" to application.mainClass)) }
        val sourcesMain = sourceSets.main.get()
        val contents = configurations.runtimeClasspath.get()
            .map { if (it.isDirectory) it else zipTree(it) } +
                sourcesMain.output
        from(contents)
    }
    build {
        dependsOn(fatJar)
    }
}