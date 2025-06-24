# Spring Boot Project Generator DSL (Xtext-based)

This project is a domain-specific language (DSL) built using Xtext to model and automate the configuration of Spring Boot applications. It provides a concise syntax to define Java packages, classes, and Maven (`pom.xml`) dependencies in a structured, readable way. The DSL is designed for educational use in agile development practices and model-driven engineering.

---

## 🧩 Features

- Define Spring Boot packages, classes, and controllers using a simple DSL syntax.
- Auto-generate boilerplate Java and Maven configuration files.
- Integrates with Eclipse and Gradle.
- DSL grammar written in Xtext, generating both parser and IDE support.

---

## 🛠️ Technologies Used

- **Xtext** for DSL development
- **Java 17**
- **Spring Boot**
- **Gradle** as the build tool
- **Eclipse IDE** with Xtext plugin

---

## 🗂️ Project Structure

```plaintext
springboot.automate.parent/
├── springboot.automate/         # Xtext grammar and language definition
├── springboot.automate.ide/     # Eclipse-specific features (e.g., content assist)
├── springboot.automate.tests/   # Unit tests for DSL parsing
└── generated-springboot/        # Output: Java + pom.xml generated from the DSL
```

---

## 🚀 Getting Started

### Prerequisites
- Eclipse IDE with Xtext plugin
- JDK 17
- Gradle

### Run Instructions

1. **Import into Eclipse**:
   - Import the project as a Gradle-based Eclipse project.
   - Run the Xtext workflow to generate the language infrastructure.

2. **Write DSL Code**:
   - Open or create a `.grabdsl` file.
   - Define Spring Boot components using the DSL syntax.

3. **Generate Output**:
   - The generator will output the equivalent Java classes and Maven configuration.

4. **Metamodel**:
   - The metamodel for this project is located at /springboot.automate.parent/springboot.automate/model/manual/ in the Metamodel.ecore & Metamodel.aird files.

---

## 📦 Example DSL Snippet

```dsl
package com.todo {
    pomXml {
        groupId = "com.todo"
        artifactId = "todo-app"
    }

    package dto {
        class TaskDto {
            private id: UUID
            private title: String
        }
    }

    package controller {
        class TaskController {
            public getTasks(): List<TaskDto>
        }
    }
}
```

---

## 🧪 Testing

```bash
./gradlew test
```

---

## 📚 License

This project is developed for academic and educational use.

---

## 👥 Contributors

- Bhavya Bhatt  
- Mengqi Liu  
- Pritesh Patel  
- Purnima Maheshwari  
- Shreeya Desai  
