buildscript {
    repositories {
        mavenLocal()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

plugins {
    id("com.google.cloud.tools.appengine").version("2.4.2")
    id("com.github.johnrengelman.shadow").version("7.0.0")
    kotlin("jvm").version("1.6.10")
    application
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
}

appengine {
    stage {
        setArtifact("build/libs/${project.name}-${project.version}-all.jar")
    }
    deploy {
        version = "GCLOUD_CONFIG"
        projectId = "GCLOUD_CONFIG"
    }
}

dependencies {
    implementation("com.google.cloud:google-cloud-logging-logback:+")
    implementation("io.ktor:ktor-server-core-jvm:2.0.0-eap-256")
    implementation("io.ktor:ktor-server-netty-jvm:2.0.0-eap-256")
    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-server-test-host-jvm:2.0.0-eap-256")
}
