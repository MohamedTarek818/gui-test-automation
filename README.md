# GUI Test Automation – the-internet.herokuapp.com

Selenium WebDriver + TestNG + Cucumber (BDD) + Maven, written in Java 17.

## Scenarios covered
| Feature | Flow |
|---|---|
| File Upload | Home → File Upload → choose image → Upload → verify "File Uploaded!" and file name |
| Dynamic Loading | Home → Dynamic Loading → Example 2 → Start → wait for loading → verify "Hello World!" |

## Tech & design
- **Page Object Model** – one class per page (`src/main/java/com/automation/pages`), shared waits/actions in `BasePage`.
- **Fluent API** – page methods return the next page (or `this`), e.g. `homePage.openFileUpload().selectFile(path).submit()`.
- **BDD** – Gherkin features in `src/test/resources/features`, step definitions in `src/test/java/.../steps`.
- **Dependency injection** – `TestContext` is shared between step classes through Cucumber PicoContainer.
- **No hard-coded values** – URL, browser, timeouts, test-data folder in `config.properties`; file names / expected messages in the feature `Examples` table; test files in `src/test/resources/testdata`.
- **Synchronization** – explicit waits only (`WebDriverWait` + `ExpectedConditions`), no `Thread.sleep`, no implicit wait.
- **Thread-safe driver** – `DriverManager` (ThreadLocal) + `DriverFactory` (Chrome / Firefox / Edge, headless option).
- **Reporting** – HTML + JSON Cucumber reports; screenshot attached to the report on failure.

## Project structure
```
src/main/java/com/automation
├── config/    ConfigReader
├── driver/    DriverFactory, DriverManager
├── pages/     BasePage, HomePage, FileUploadPage, UploadResultPage,
│              DynamicLoadingPage, DynamicLoadingExamplePage
└── utils/     ResourceUtils
src/test/java/com/automation
├── context/   TestContext
├── hooks/     Hooks
├── steps/     CommonSteps, FileUploadSteps, DynamicLoadingSteps
└── runners/   TestRunner
src/test/resources
├── features/  file_upload.feature, dynamic_loading.feature
├── testdata/  sample-image.png
└── config.properties
```

## Prerequisites
- JDK 17+
- Maven 3.8+
- Google Chrome (or Firefox / Edge) – the driver is downloaded automatically by Selenium Manager (internet access required)

## How to run
```bash
# all scenarios
mvn clean test

# headless
mvn clean test -Dheadless=true

# another browser
mvn clean test -Dbrowser=firefox

# only one feature (by tag)
mvn clean test -Dcucumber.filter.tags="@upload"
mvn clean test -Dcucumber.filter.tags="@dynamic"
```
Report: `target/cucumber-reports/cucumber.html`

## Notes
- The task text says "hello world"; the application actually renders **"Hello World!"**, which is what the assertion checks (configured in `dynamic_loading.feature`).
- To add more upload cases, drop a file in `testdata/` and add a row to the `Examples` table.

## Git
```bash
git init
git add .
git commit -m "Add GUI test automation project"
git remote add origin <your-repo-url>
git push -u origin main
```
