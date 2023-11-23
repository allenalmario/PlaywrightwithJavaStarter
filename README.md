# PlaywrightwithJavaStarter

This is a starter framework that uses Playwright with Java and JUnit to run the tests and generate an HTML report for the results.

The Framework follows a Page Object Model design where the tests are seperated from the Pages and their locators/methods.

You can use this written documentation I wrote to build the framework yourself. https://docs.google.com/document/d/1mgZvuJeLvOEtuQxhjj1vizhpfqKryaM8BUeA3rgBt7k/edit?usp=sharing

If you need a more visual resource, follow this YouTube playlist I followed to create the framework: https://www.youtube.com/playlist?list=PLFGoYjJG_fqrEjt35Z1jxrYk5JXWQa_-D 

The framework has a gitlab.yml file which allows test excecution runs on Github actions by running a workflow and the surefire-report.html that JUnit produces after test execution completion is deployed to the repository's Github page.
