# People Server

### Project Details

The people server simulates a repository of people using a **Person JSON** as a boundary for its clients.
The server stores a people repository in memory.
The RESTful API of the server enables creating people, identified by their emails, and manipulating their data.

* [Open API documentation ](http://localhost:8080/swagger-ui/index.html)

### API Boundaries Overview

A **Person JSON** represents user data that is managed by the server. The following example describes a person:
<pre>
{
  "email":"janesmith@s.afeka.ac.il",
  "name":{
    "first":"Jane", "last":"Smith"
  },
  "birthdate":"1999-01-31",
  "hobbies":["painting", "hiking", "singing"],
  "address":"44th Mivtza Kadesh st., Afeka, Tel-Aviv, IL",
  "avatar":"https://live.staticflickr.com/1047/926925086_59ba97c0e6_q_d.jpg",
  "currentLocation:"{
    "type":"Point", 
    "coordinates":[32.113119, 34.820213]
  },
  "details":{
    "professionalStatus":"student",
    "class":2022,
    "degree":"B.Sc.",
    "institution":"Afeka Academic College of Engineering, Tel-Aviv",
    "currentCurriculum":["Cellular Applications", "Integrative Software Engineering", "User Interface For Cellular Applications"],
    "finalProject":{
      "subject":"College Social Network",
      "due":"01/06/2025",
      "partners":["jackjones@s.afeka.ac.il"]
    }
  }
}
</pre>

### Core API Operations

* POST /people
    * Create a new person
        * Consumes a **Person JSON** with user details
        * Produces a **Person JSON** stored in the server


* GET /people?size={size}&page={page}
    * Get people from the server using pagination
        * Produces a **Person JSON Array** from the database
        * **size** defines the maximum size of the result
        * **page** enables pagination, when "0" indicates the first page, "1" indicates the second page, etc'


* GET /people/{email}
    * Get a specific person identified by their email
        * Produces a **Person JSON** from the database
        * If no such person exists, the server responds with **404** error status code


* DELETE /people/{email}
    * Deletes a specific person, identified by their email, from the server
        * If no such person exists, the server responds with **404** error status code


* DELETE /people
    * Deletes all people stored by the server


* PUT /people/{email}
    * Updates a person details
        * Consumes a **Person JSON** containing the updated details
        * Produces a **Person JSON** stored in the server
            * If no such person exists, the server responds with **404** error status code
            * Note that the email of the user can't be modified

