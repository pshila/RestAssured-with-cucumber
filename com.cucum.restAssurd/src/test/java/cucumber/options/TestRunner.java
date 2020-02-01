package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = "json:target/jsonReports/cucumber-report.json", glue = {
		"stepdefinations" }, tags = { "@DeletePlace" })
public class TestRunner {

}
//to run that testrunner by cmd  open prompt
//then take project path like C:\Users\shila\eclipse-api\com.cucum.restAssurd
// then  cd C:\Users\shila\eclipse-api\com.cucum.restAssurd --Enter
//type: mvn test  --Enter , it will compile or run our code or script.
//mvn test -Dcucumber.options="--tags @AddPlace"   to runspecific test by cmd

//for html report cmd>mvn test verify --Enter
//in test runner file need to mention --plugin="json:target/jsonReports/cucumber-report.json"

//for jenkins: we need to download: jenkins.war file 
//then go to cmd and reach out location where jenkins.war file have present
//then cmd>java -jar jenkins.war -httpPort=8080   --Enter
//now go to crome and write: localhost:8080     --enter
//in configure block under Build:  test verify -Dcucumber.options="--tags @AddPlace"  ,then clicked on ok mvn not mention because it maven block only
//then clicked build now if we want to change some setting that time we can go configure block for setting .
//need to select-- This project is parameterized, then on build block instead of @Add Place  we will write  @"$tags" Than ok button
//then clicked on build with parameterize and choice parameter which u want.
//