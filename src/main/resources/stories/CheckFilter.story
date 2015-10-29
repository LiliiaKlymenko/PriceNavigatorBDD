Narrative:
As a user
I want to filter search results
So that I had not to search long for the right product

Scenario: Check filter by price
Given I am on pn.com.ua
When Select category
When Select sub category
When Set min and max price
Then The results match the search parameters

Scenario: Check the filter on the name of the manufacturer
Given I am on pn.com.ua
When Select category
When Select sub category
When Select manufacturer
Then The amount of goods is equal to the number displayed next to the name
Then The names of the goods begin with the selected

Scenario: Check the product name search
Given I am on pn.com.ua
When Select category
When Select sub category
And Sort items by price
When Take the name of the cheapest good
When Enter the name into search box
Then The search result is equal to 1
Then The name of the product is equal to the specified name