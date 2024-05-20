plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
}

repositories {
	mavenCentral()
	maven {
		url = uri("")
		credentials {
			username = ""
			password = ""
		}
	}
}

configurations.all {
	resolutionStrategy.eachDependency {
		if (requested.group == "org.springframework.boot" && requested.name == "spring-boot-starter"
			&& requested.version == "3.1.2") {
			println("found version 3.1.2")
			useVersion("3.2.4")
			because("fixes critical bug in 1.2")
		}
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-dependencies:3.1.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.jobrunr:jobrunr-pro-spring-boot-3-starter:7.0.1")
	implementation("com.h2database:h2:2.1.212")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin" )
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web" )
	implementation("org.springframework.boot:spring-boot-starter-webflux" )
	implementation("org.springframework.boot:spring-boot-starter-websocket" )
	implementation("org.springframework.integration:spring-integration-amqp" )
	implementation("org.springframework.integration:spring-integration-jms" )
	implementation( "org.springframework.integration:spring-integration-redis" )
	implementation( "org.springframework.boot:spring-boot-starter-oauth2-client" )
	implementation( "org.springframework.boot:spring-boot-starter-oauth2-resource-server" )
	implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}
kotlin {
	jvmToolchain(17)
}