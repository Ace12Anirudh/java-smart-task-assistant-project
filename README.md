# 🧠 Smart Task Assistant (Java + Maven)

## A DevOps-Optimized Task Management Solution

This project is not merely a Java application; it serves as a foundational example for **Industrializing the Java Build Process using Maven** and defining clear **Cloud Deployment Strategies**.

As a DevOps and Cloud Engineer, my focus here is on **reproducible builds, reliable artifact generation, and deployment automation** rather than the underlying Java implementation details. This project demonstrates how to take a typical Java source base and prepare it for a robust CI/CD pipeline, including deployment on environments like **AWS EC2**.

---

## 🚀 Key Architectural & Operational Features

The functionality is centered around pipeline readiness and infrastructure deployment:

*   **Standardized Build Process:** Utilizes Maven to ensure deterministic builds across all environments (local, CI server, cloud).
*   **Portable Artifact Generation:** Creates a single, lightweight, runnable executable JAR (`smart-task-manager-1.0.0.jar`) ideal for distribution and deployment.
*   **Automated Quality Gates:** Integrated JUnit 5 tests executed via the `mvn test` goal, providing mandatory quality checks before packaging or deployment.
*   **Infrastructure Ready:** Designed for seamless deployment and execution on Linux-based cloud virtual machines (e.g., AWS EC2 instances).
*   **State Management:** Demonstrates simple file-based data persistence (`tasks.txt`), a common pattern for managing state in single-instance CLI deployments.

---

## 🛠️ Technologies Used

| Technology | Role in DevOps Workflow |
| :--- | :--- |
| **Java 17 (JDK)** | Application runtime environment and build target. |
| **Apache Maven** | **Primary Build Automation Engine.** Manages dependencies, controls the build lifecycle, and executes pipeline stages (goals). |
| **JUnit 5** | Unit testing framework, providing the necessary quality gate for `mvn test`. |
| **AWS EC2** | Target environment for cloud deployment and runtime execution. |
| **File I/O** | Data persistence method, impacting deployment considerations. |

---

## 🏗️ DevOps Workflow: Integrating Maven

As a DevOps engineer, Maven is essential for standardizing how source code transitions into a deployable artifact. It dictates the structure and execution of the application's build lifecycle.

### Why Maven for Java Projects?

I integrated Maven to ensure that the build process is:
1.  **Predictable:** Every build, regardless of location (developer machine or CI runner), produces the identical result.
2.  **Declarative:** All dependencies and build configurations are managed centrally and transparently in the `pom.xml` file.
3.  **CI/CD Ready:** Maven goals map directly to stages in a modern CI/CD pipeline (e.g., `test` maps to the Testing stage, `package` maps to the Artifact Creation stage).

### The Essential Maven Goals

The following goals are crucial for defining the Java application pipeline and are executed sequentially in a typical CI/CD flow:

| Maven Goal | Lifecycle Phase | DevOps Pipeline Stage | Description |
| :--- | :--- | :--- | :--- |
| `mvn clean` | `clean` | Cleanup/Pre-Build | Ensures a clean slate by deleting the `target/` directory, preventing old artifacts from interfering with new builds. |
| `mvn compile` | `default` | Build Stage (Compilation) | Compiles the source code (`src/main/java`) into bytecode. |
| `mvn test` | `default` | **Quality Gate** | Executes all unit tests (`src/test/java`). Successful execution is mandatory to proceed to artifact packaging. |
| `mvn package` | `default` | **Artifact Creation** | Bundles the compiled code and resources into the distribution format (an executable JAR). This is the deployable artifact. |
| `mvn install` | `default` | Local Repository Management | Copies the packaged JAR artifact into the local Maven repository (`~/.m2/repository`). Used when other local projects depend on this build. |

## 📦 Build & Artifact Management

Navigate to the project root directory and execute the build automation steps:

```bash
# 1. Clean the environment
mvn clean

# 2. Compile the application
mvn compile

# 3. Execute quality gates (tests)
mvn test

# 4. Generate the final deployable artifact (JAR)
mvn package
```

## Running the Artifact:
Once packaged, the application is ready to run using the Java runtime:

```bash
java -jar target/smart-task-manager-1.0.0.jar
```

## ☁️ Cloud Deployment Strategy (AWS EC2)
This procedure outlines the steps required to deploy the Maven-built artifact onto a dedicated Linux-based EC2 instance, demonstrating a common deployment approach for self-contained Java applications.
Prerequisites on EC2 Instance
(Assuming a standard Linux distribution like Amazon Linux 2 or RHEL equivalent):
1. Install Java 17 (Runtime Environment)
```Bash
sudo yum install java-17-amazon-corretto -y
```
2. Install Maven (Necessary if building directly on the server)

```Bash
sudo yum install maven -y
```
Deployment Steps
1. Source Retrieval
```Bash
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```
2. Reproduce the Build (Final Artifact Generation)
We rebuild on the target server to verify dependency resolution and artifact integrity, a key DevOps practice.
```Bash
mvn clean package
```
3. Run the Application
The application is started, utilizing the generated artifact. Note that output will be visible on the console. For production use, this would typically run via a service manager like systemd or within a container environment.
```Bash
java -jar target/smart-task-manager-1.0.0.jar
```
## 📁 Project Structure
The structure adheres to Maven standards, simplifying navigation for automation scripts:
```Code
smart-task-manager/
├── pom.xml          # Configuration for the Maven Build Automation Engine
└── src/
    ├── main/
    │   └── java/...   # Application source code
    └── test/
        └── java/...   # Unit tests (Quality Gates)
```

## 👤 Author
Anirudh Ace | DevOps and Cloud Engineer
Star ⭐ the repository if you appreciate projects focused on robust build automation and deployment readiness!
GitHub: https://github.com/Ace12Anirudh
LinkedIn: https://www.linkedin.com/in/anirudh-trivedi-4414b9244/
