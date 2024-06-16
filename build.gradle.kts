import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.6"
	id("io.spring.dependency-management") version "1.1.5"
	// KotlinコードをJVMバイトコードへコンパイルするために必要
	kotlin("jvm") version "1.9.24"
	// Springの機能をKotlinに統合するために必要
	kotlin("plugin.spring") version "1.9.24"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.3")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Swagger SpringFoxはSpring3系には未対応
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
	// Okio
	implementation("com.squareup.okio:okio:3.4.0")
	// Coroutines
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	// Arrow
	implementation("io.arrow-kt:arrow-core")

	// KotlinクラスをJSONにシリアライズ/デシリアライズするためのサポート機能
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	// KotsetのJUnit5ランナー
	testImplementation("io.kotest:kotest-runner-junit5:5.4.2")
	testImplementation("io.kotest:kotest-assertions-core:5.4.2")
	testImplementation("io.kotest:kotest-property:5.4.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
