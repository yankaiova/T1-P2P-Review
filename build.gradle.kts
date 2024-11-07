import com.diffplug.spotless.LineEnding

plugins {
	java
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	id("io.freefair.lombok") version "8.6"
	id("com.diffplug.spotless") version "6.25.0"
	id("org.sonarqube") version "4.4.1.3373"
	id("jacoco")
}
group = "ru.akhramenko"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

val mapstructVersion = "1.5.5.Final"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
	// testImplementation ("org.testng:testng:6.10", "org.easytesting:fest-assert:1.4")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.jacocoTestReport {
	reports {
		xml.required = true
	}
	dependsOn(tasks.test)
}

spotless {
	java {
		importOrder()
		removeUnusedImports()
		toggleOffOn()
		lineEndings = LineEnding.GIT_ATTRIBUTES
	}

	sql {
		target(
				"src/*/.sql",
		)
		toggleOffOn()
	}

	kotlinGradle {
		target("*.gradle.kts")
		ktlint("1.2.1")
	}
}
