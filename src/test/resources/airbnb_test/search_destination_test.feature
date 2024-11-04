Feature: Search destinations

  Background:
    Given I enter website https://www.airbnb.com/

  Scenario: Search for a destination and validate the found properties
    Given I enter the destination Rome, Italy
    And Choose Check In date after 7 days from now
    And Choose Check Out date after 14 days from now
    And Open guests panel
    And Add 2 Adults for search
    And Add 1 Child for search
    And Click on Search button
    Then Validate results from search bar
    And Validate that properties have the required guests number

  Scenario: Search for a destination, apply filter and validate the found properties
    Given I enter the destination Rome, Italy
    And Choose Check In date after 7 days from now
    And Choose Check Out date after 14 days from now
    And Open guests panel
    And Add 2 Adults for search
    And Add 1 Child for search
    And Click on Search button
    And Open Filter Pop Up
    And Increase the number of bedrooms by 5
    And Add pool to the filter
    And Show filtered properties
    Then Validate that properties have the required bedrooms number
    And Open the first property
    And  Open amenities popup
    And Check if pool amenity is present

  Scenario: Check property's details on map
    Given I enter the destination Rome, Italy
    And Choose Check In date after 7 days from now
    And Choose Check Out date after 14 days from now
    And Open guests panel
    And Add 2 Adults for search
    And Add 1 Child for search
    And Click on Search button
    And Hover the first property from search results
    And Check that hovered property changes on map
    And Open hovered property from map
    Then Check if information from map for the first property is same as in the page
