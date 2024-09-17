@RestAssured
Feature: Test feature for Rest Assured - Reqres

  @Reqres @Get
  Scenario Outline: Reqres Get Scenario
    Given I GET List of Users from "<URL>" Reqres

    Examples: 
      | URL                                   |
      | https://demoqa.com/BookStore/v1/Books |

  @Reqres @POST
  Scenario Outline: Reqres POST request
    Given I POST from "<URL>" Reqres using JSON "<file>"

    Examples: 
      | URL                         | file              |
      | https://reqres.in/api/users | data/payload.json |

      
  @Reqres @POST
  Scenario Outline: Reqres POST request
    Given I POST from "<URL>" Reqres using POJO

    Examples: 
      | URL                         | 
      | https://reqres.in/api/users | 
      
  @Reqres @JSON-Parse
  Scenario: Reqres POST request
    Given I Parse JSON