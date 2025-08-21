# Selenium Test Automation Framework

This is a Maven-based Selenium automation framework built using **Java**, **TestNG**, and **Apache POI** (for Excel integration). It supports data-driven testing and logs test steps using **Log4j**.

---

## 📁 Project Structure

```
project-root/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/karthikbandi/trainingprogram/
│   │   │       └── App.java
│   │   └── resources/
│   │       └── log4j.properties
│   └── test/
│       ├── java/
│       │   └── com/karthikbandi/trainingprogram/
│       │       ├── LoginUsingExcelTest.java
│       │       ├── GroupsAndDataProviderTest.java
│       │       ├── LoggingStepsUsingLogFourJTest.java
│       │       ├── HandlingMultipleWindowsAndAlertsTest.java
│       │       └── utils/
│       │           └── ExcelUtils.java
│       └── resources/
│           └── testdata/
│               └── loginCreds.xlsx
└── target/
```

---

## ⚙️ Technologies Used

- Java 17  
- Maven  
- Selenium WebDriver  
- TestNG  
- Apache POI (Excel)  
- Log4j  
- Eclipse IDE  

---

## 🚀 How to Run the Tests

### 🧪 Option 1: From Eclipse

1. Right-click on any test class → `Run As` → `TestNG Test`  
2. Or, right-click `testng.xml` → `Run As` → `TestNG Suite`

### 🧪 Option 2: From Command Line

```bash
mvn clean test
```

> Make sure your terminal is at the project root (where `pom.xml` is).

---

## 📊 Test Reports

After test execution, reports are generated at:

```
target/surefire-reports/
```

---

## 📚 Data-Driven Testing

Excel file used for login tests is located at:

```
src/test/resources/testdata/loginCreds.xlsx
```

Test data is read using `ExcelUtils.java`.

---

## 🪵 Logging

Logs are configured using Log4j. Configuration file:

```
src/main/resources/log4j.properties
```

---

## 📦 Dependency Management

All dependencies are managed via `pom.xml` using Maven.

---

## 👨‍💻 Author

[Karthik Bandi](https://github.com/KarthikQQA080)  
✉️ karthik.bandi@qapitol.com

---

## 📜 License

This project is licensed under the MIT License - feel free to use or modify.
