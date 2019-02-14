Feature: auto1 search functionality
This feature is to verify the search functionality in the autohero page

Scenario Outline: Verify that when I search the car from a certain registration year the car are correctly displayed
Given I am in the autohero web page
When I select a registration year as "<year>" a filter criteria as "<filter>"
Then all the cars displayed comes from the correct year

Examples:
|year|filter|
|2015|Höchster Preis|
|2014|Niedrigster Preis|

Scenario Outline: Verify that all of the cars are displayed with a descendent price order

Given I am in the autohero web page
When I select a registration year as "<year>" a filter criteria as "<filter>"
Then all the cars are displayed using a descendent price order

Examples:
|year|filter|
|2015|Höchster Preis|
|2014|Niedrigster Preis|