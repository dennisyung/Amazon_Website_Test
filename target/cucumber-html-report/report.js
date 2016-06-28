$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: girija.panda@nokia.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 19,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 21,
  "name": "Amazon_LoginPage",
  "description": "  This is the Login Page feature for amazon.",
  "id": "amazon-loginpage",
  "keyword": "Feature",
  "tags": [
    {
      "line": 20,
      "name": "@tag"
    }
  ]
});
formatter.before({
  "duration": 25045181440,
  "status": "passed"
});
formatter.scenario({
  "line": 55,
  "name": "Sign into the website from the login page with correct username but incorrect password",
  "description": "",
  "id": "amazon-loginpage;sign-into-the-website-from-the-login-page-with-correct-username-but-incorrect-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 54,
      "name": "@sanity"
    },
    {
      "line": 54,
      "name": "@experiment"
    }
  ]
});
formatter.step({
  "line": 56,
  "name": "I am currently on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 57,
  "name": "I attempt to sign in with correct username but incorrect password",
  "keyword": "When "
});
formatter.step({
  "line": 58,
  "name": "the sign in should fail with appropriate error message",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefs.i_am_currently_on_the_login_page()"
});
formatter.result({
  "duration": 4389049453,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefs.i_attempt_to_sign_in_with_correct_username_but_incorrect_password()"
});
formatter.result({
  "duration": 3531093545,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefs.the_sign_in_should_fail_with_appropriate_error_message()"
});
formatter.result({
  "duration": 598526730,
  "status": "passed"
});
formatter.after({
  "duration": 1034736299,
  "status": "passed"
});
formatter.before({
  "duration": 11938838176,
  "status": "passed"
});
formatter.scenario({
  "line": 61,
  "name": "Sign into the website from the login page with correct username and correct password",
  "description": "",
  "id": "amazon-loginpage;sign-into-the-website-from-the-login-page-with-correct-username-and-correct-password",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 60,
      "name": "@sanity"
    },
    {
      "line": 60,
      "name": "@experiment"
    }
  ]
});
formatter.step({
  "line": 62,
  "name": "I am currently on the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "I attempt to sign in with correct username and correct password",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "the sign in should be successful",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefs.i_am_currently_on_the_login_page()"
});
formatter.result({
  "duration": 2949661004,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefs.i_attempt_to_sign_in_with_correct_username_and_correct_password()"
});
formatter.result({
  "duration": 3406406268,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefs.the_sign_in_should_be_successful()"
});
formatter.result({
  "duration": 1637058268,
  "status": "passed"
});
formatter.after({
  "duration": 549406761,
  "status": "passed"
});
});