# Retapped Design Sepcification

**User Profile Design:**
| Req. ID | Design |
| :------ | :---------- |
| D.1.11 |  |
| D.1.11.e |  |
| D.1.12 |  |
| D.1.12.e |  |
| D.1.2 |  |
| D.1.2.e |  |
| D.1.31 |  |
| D.1.31.e |  |
| D.1.32| When a user logs a beverage, they will be able to give it a rating. The rating will be on a scale from 1-10. 1 is the lowest rating (if the user disliked the beverage) and 10 is the highest rating (if the user liked the beverage). The user and the user's friends will be able to see the user's ratings. These ratings will contribute to the calculation of the user's flavor profile. |
| D.1.32.e| A user will be mocked for the testing. The user will log beverages, each with a different rating on the scale. The user's account will be inspected from the user's perspective as well as other accounts that are friends with the user to verify that the ratings of the logged beverages are visible and correct. |
| D.1.4| When a user drinks a beverage that is in the Retapped database, they will be able to "log" the beverage in the app. The log will be added to their history so that the user and the user's friends will be able to see what beverage they drank, the date that they drank the beverage, and what their rating of that beverage was. |
| D.1.4.e| A user will be mocked for the testing. The user will log several beverages from the Retapped database with ratings and on different days. The user's account will be inspected from the user's perspective as well as other accounts that are friends with the user to verify that the log data is accurate and visible. |
| D.1.5 | When a user creates an account, they will be able to add beverages from the database to a list of "preferences." This list of preferences will be visible to the user and the user's friends, and it will affect the user's calculated flavor profile. |
| D.1.5.e | A user will be mocked for the testing. The user will add several beverages to their preferences during account creation as well as after the account has been created. The user's preferences list will be inspected from the user's perspective as well as other accounts that are friends with the user to verify if the preferences list is accurate and visible. The preference list will also be used later in the testing for the flavor profile.  |
| D.1.6 | A user will be able to add beverages to a list of their preferences. They will also be able to log beverages that they have had to drink since creating the account and give it a rating on a scale from 1-10. These two actions by the user will be used to calculate a "flavor profile" that will display the types and flavors of beverages that the user enjoys. The flavor profile can also be used to suggest to the user what kind of beverages they should try in the future. If the user adds a beverage to their preferences or rates a logged beverage as a 7 or above, the flavor profile will suggest beverages that are similar to those. If the user rates a logged beverage as a 4 or below, the flavor profile will avoid suggesting beverages similar to the logged one. |
| D.1.6.e | A user will be mocked for the testing. Each beverage type will be set to a neutral rating for the user when the account is created. The software will be evaluated to verify if the flavor profile rating for multiple types of beverages is set to the neutral rating. The user will add several beverages to their preferences list and then log several similar beverages and give them a rating of 7 or above. The software will be evaluated to verify if the flavor profile rating for the specific beverage type that was added to the preferences list and logged with a high rating has been increased. The user will log several similar beverages and give them a rating of 4 or below. The software will be evaluated to verify if the flavor profile rating for the specific beverage type that was logged has been decreased. Visual inspection of the flavor profile's suggested beverages will also be used to verify that the suggestion feature of the application is accurate. |


**User Interface Design:**
| Req. ID | Design |
| :------ | :---------- |
| D.2.1 |  |
| D.2.1.e |  |
| D.2.2 |  |
| D.2.2.e |  |
| D.2.3 |  |
| D.2.3.e |  |
| D.2.4|  |
| D.2.4.e|  |
| D.2.5 |  |
| D.2.5.e |  |

**Frontend/Backend Compatability and Operations Design:**
| Req. ID | Design |
| :------ | :---------- |
| D.3.1 |  |
| D.3.1.e |  |
| D.3.21|  |
| D.3.21.e|  |
| D.3.22|  | 
| D.3.22.e|  |
| D.3.23|  |
| D.3.23.e|  |
| D.3.3 |  |
| D.3.3.e|  |
