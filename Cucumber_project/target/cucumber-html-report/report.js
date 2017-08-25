$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login Features",
  "description": "",
  "id": "login-features",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 38,
  "name": "All the hyperlinked text should be accessible in the Gmail sign in page.",
  "description": "",
  "id": "login-features;all-the-hyperlinked-text-should-be-accessible-in-the-gmail-sign-in-page.",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 37,
      "name": "@Case-4"
    },
    {
      "line": 37,
      "name": "@regression"
    }
  ]
});
formatter.step({
  "line": 39,
  "name": "I am on login page for signIn using \"\u003curl\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "I get all the links on the page",
  "keyword": "When "
});
formatter.examples({
  "line": 42,
  "name": "",
  "description": "",
  "id": "login-features;all-the-hyperlinked-text-should-be-accessible-in-the-gmail-sign-in-page.;",
  "rows": [
    {
      "cells": [
        "url"
      ],
      "line": 43,
      "id": "login-features;all-the-hyperlinked-text-should-be-accessible-in-the-gmail-sign-in-page.;;1"
    },
    {
      "cells": [
        "Url"
      ],
      "line": 44,
      "id": "login-features;all-the-hyperlinked-text-should-be-accessible-in-the-gmail-sign-in-page.;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 44,
  "name": "All the hyperlinked text should be accessible in the Gmail sign in page.",
  "description": "",
  "id": "login-features;all-the-hyperlinked-text-should-be-accessible-in-the-gmail-sign-in-page.;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 37,
      "name": "@regression"
    },
    {
      "line": 37,
      "name": "@Case-4"
    }
  ]
});
formatter.step({
  "line": 39,
  "name": "I am on login page for signIn using \"Url\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 40,
  "name": "I get all the links on the page",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "Url",
      "offset": 37
    }
  ],
  "location": "Login_StepDefinitions.i_am_on_login_page_for_signIn(String)"
});
formatter.result({
  "duration": 18257312854,
  "status": "passed"
});
formatter.match({
  "location": "Login_StepDefinitions.i_get_all_the_links_on_the_page()"
});
formatter.result({
  "duration": 346616913738,
  "status": "passed"
});
});