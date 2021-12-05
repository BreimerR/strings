val jvmTarget: String by project
val libraryGroup: String by project
val libraryVersion: String by project

plugins {
    kotlin("multiplatform")
    `maven-publish`
}

group = libraryGroup
version = libraryVersion


repositories {
    mavenCentral()
    mavenLocal()
}

kotlin {


    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = jvmTarget
        }

        compilations {
            tasks {

                named<Jar>("jvmJar") {
                    archiveBaseName.set("strings")
                }

                register<Jar>("buildFat") {
                    group = "build"
                    val target = kotlin.targets.getByName("jvm")
                    val main = target.compilations["main"]
                    from(main.output.classesDirs, main.compileDependencyFiles)
                   // {
                     //   exclude("META-INF/**")
                    //}
                    archiveBaseName.set("strings-jvm-all")
                }
            }
        }

        testRuns["test"].executionTask.configure {
            useTestNG()
        }
    }

    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }


    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }



    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}


val commonVariant by configurations.creating{
    isCanBeConsumed = true
}