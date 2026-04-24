# Flipkart Automation Framework 🚀

## Hybrid E-Commerce Test Automation Framework using Selenium, Java and TestNG

A scalable, modular and reusable automation framework built for testing critical e-commerce workflows inspired by Flipkart.

This project was developed as a **Final Year Major Project** to demonstrate real-world automation framework development using modern software testing practices.

---

# Project Overview

Manual testing of modern e-commerce applications is repetitive, time-consuming and difficult to scale.

This project automates critical user journeys and regression scenarios by implementing a hybrid automation framework covering:

* Authentication validations
* Product search and filtering
* Cart management
* Wishlist automation
* Checkout simulation
* Cross-browser testing
* Data-driven testing
* Database validations
* Reporting and logging
* Utility-driven reusable framework design

The project focuses not only on test scripts but also on **framework engineering**, maintainability and scalability.

---

# Objectives

* Reduce manual regression effort
* Increase test coverage
* Detect defects earlier
* Build reusable automation architecture
* Simulate real-world e-commerce validations
* Apply industry-level testing concepts

---

# Tech Stack

## Language

* Java

## Automation

* Selenium WebDriver
* TestNG

## Build Tool

* Maven

## Utilities

* Apache POI
* Log4j
* JDBC
* Extent Reports
* WebDriverManager

## IDE

* Visual Studio Code

## Version Control

* Git
* GitHub

---

# Framework Architecture

This project follows a Hybrid Framework Architecture combining:

## Page Object Model (POM)

Separates locators and actions from test logic.

## Data Driven Testing

Supports execution with multiple datasets.

## Utility Driven Framework

Reusable utilities for:

* waits
* screenshots
* configuration
* drivers
* database checks

## TestNG Framework

Supports:

* Assertions
* Suites
* Parallel execution
* Retry logic
* Listeners

---

# Project Structure

```bash
FlipkartAutomationFramework/
│
├── pom.xml
├── testng.xml
├── README.md
├── .gitignore
│
├── src
│   └── test
│       ├── java
│       │   ├── base
│       │   │    └── BaseTest.java
│       │   │
│       │   ├── pages
│       │   │    ├── HomePage.java
│       │   │    ├── LoginPopup.java
│       │   │    ├── SearchPage.java
│       │   │    ├── ProductPage.java
│       │   │    ├── CartPage.java
│       │   │    ├── CheckoutPage.java
│       │   │    └── WishlistPage.java
│       │   │
│       │   ├── tests
│       │   │    ├── LoginTest.java
│       │   │    ├── SearchTest.java
│       │   │    ├── FilterTest.java
│       │   │    ├── CartTest.java
│       │   │    ├── WishlistTest.java
│       │   │    ├── CheckoutTest.java
│       │   │    ├── CrossBrowserTest.java
│       │   │    ├── BrokenLinkTest.java
│       │   │    ├── DBValidationTest.java
│       │   │    └── PriceMonitorTest.java
│       │   │
│       │   ├── utilities
│       │   │    ├── DriverFactory.java
│       │   │    ├── ConfigReader.java
│       │   │    ├── WaitUtil.java
│       │   │    ├── ExcelUtil.java
│       │   │    ├── ScreenshotUtil.java
│       │   │    ├── DBUtil.java
│       │   │    └── ExtentReportManager.java
│       │   │
│       │   └── listeners
│       │        ├── TestListener.java
│       │        ├── RetryAnalyzer.java
│       │        └── AnnotationTransformer.java
│       │
│       └── resources
│            ├── config.properties
│            ├── log4j2.xml
│            └── testdata.xlsx
│
├── reports
│   └── extent-report.html
│
├── screenshots
│
├── logs
│
└── target

---

# Functional Modules Covered

## Authentication

* Login popup handling
* Session validations
* Authentication checks

## Search & Filters

* Product search
* Filters
* Sorting
* Search validations

## Product Validations

* Product listings
* Product details
* Dynamic element validations

## Cart Management

* Add to cart
* Remove item
* Cart validations

## Wishlist Automation

* Add to wishlist
* Wishlist flow validations

## Checkout Simulation

* Checkout mock flow coverage

## Additional Utilities

* Price monitoring
* Broken link checking
* Screenshot capture
* Multi-tab handling
* Reporting-ready framework

---

# Test Scenarios Covered

Examples:

* Search product and validate results
* Apply sorting filters
* Add products to cart
* Remove items from cart
* Wishlist validation
* Product price monitoring
* Broken link validation
* Cross-browser ready execution

---

# Framework Features

Implemented features include:

✔ Page Object Model

✔ Reusable Utility Framework

✔ Data Driven Testing

✔ TestNG Suite Execution

✔ Screenshot on Failure

✔ Retry Analyzer Support

✔ Listener Support

✔ Cross Browser Ready Structure

✔ Dynamic Wait Utilities

✔ Modular Scalable Design

---

# Sample Folder Modules

```bash
base/
pages/
tests/
utilities/
listeners/
reports/
screenshots/
logs/
```

---

# Installation

Clone repository:

```bash
git clone https://github.com/yourusername/FlipkartAutomationFramework.git
cd FlipkartAutomationFramework
```

Open in VS Code:

```bash
code .
```

Install dependencies:

```bash
mvn clean install
```

---

# Execute Tests

Run complete suite:

```bash
mvn clean test
```

Run TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# Example Automated Flow

Typical execution flow:

1 Launch Flipkart
2 Handle login popup
3 Search product
4 Apply filters
5 Open product
6 Add to cart
7 Validate actions
8 Generate results

---

# Reports

Reports generated inside:

```bash
reports/
```

Failure screenshots:

```bash
screenshots/
```

Execution logs:

```bash
logs/
```

---

# Why This Project

This project is more than simple Selenium scripts.

It demonstrates:

* Framework design
* Real-world test automation
* Reusable architecture
* Industry QA practices
* Scalable project structure

---

# Expected Outcomes

Using this framework:

* Faster regression execution
* Better coverage
* Reduced manual effort
* Improved maintainability
* Stronger defect detection support

---

# Future Enhancements

Planned extensions:

* API automation using Rest Assured
* Performance testing with JMeter
* Selenium Grid parallel execution
* Jenkins CI/CD integration
* Docker support
* Allure reports
* AI self-healing locators
* Mobile automation with Appium

---

# Learning Outcomes

This project helped strengthen understanding of:

* Selenium framework architecture
* Automation design patterns
* TestNG framework usage
* Dynamic locator strategies
* Reusable test framework development
* Real-world automation challenges

---

# Challenges Handled

Some practical automation challenges addressed:

* Dynamic locators
* Pop-up handling
* Synchronization issues
* Multi-tab switching
* Reusable utility creation

---

# Author

**Rohit Kumar**

B.Tech Computer Science Engineering

Specialization: Software Testing and Automation

---

# Academic Relevance

Suitable as:

* Final Year Major Project
* Software Testing Project
* Resume Project
* Placement Discussion Project
* Automation Framework Portfolio Project

---

# License

This project is intended for educational and learning purposes.

