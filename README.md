# GOT_Characters_DemandFarm
Challenge for demand farm Full Stack application for GOT_Characters family tree

1. GOT_Backend Folder : It contains Java Springboot code for all the API's responsible for various operations , running on localhost:8081 with database postgresql and its configurations in application.properties file , APIs are below:
   (i) http://localhost:8081/api/characters/houses : to get all unique house names from database
   (ii) http://localhost:8081/api/characters/familytree/{houseName}: to get a list of all characters belonging to a given house , it is     
        used to build family tree in UI
   (iii)  http://localhost:8081/api/characters/{id}/favourite: to mark a character as favorite
   
2.  GOT_frontend Folder : It contains React Js code which is having various components to showcase on UI which are
   (i) HouseDropdown
   (ii) FamilyTree
   (iii) CharacterCard

and page as below
(i) CharacterPage.js

Combining these both will create our application to run smoothly
