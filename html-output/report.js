$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/featureFiles/LoginApp.feature");
formatter.feature({
  "name": "Fill a simple form with excel data",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Data driven with excel and data sets",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "I open automationpractice website",
  "keyword": "When "
});
formatter.step({
  "name": "click contact us",
  "keyword": "And "
});
formatter.step({
  "name": "I contact the customer service with excel row \"\u003crow_index\u003e\" dataset",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "row_index"
      ]
    },
    {
      "cells": [
        "2"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Data driven with excel and data sets",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open automationpractice website",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.DataDrivenFramework.i_open_automationpractice_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click contact us",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinations.DataDrivenFramework.click_contact_us()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I contact the customer service with excel row \"2\" dataset",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.DataDrivenFramework.i_contact_the_customer_service_with_excel_row_dataset(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});