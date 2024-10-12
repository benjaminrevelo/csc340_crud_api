CRUD API
The REST API performs CRUD operations on Animal objects as described below.

Installation

Get the project
clone

git clone https://github.com/benjaminrevelo/csc340_crud_api.git

download zip.

Open the project in IntelliJ.
/src/main/resources/application.properties file is the configuration for the MySQL database on your localhost.
the database name is on the datasource.url property between the last / and the ?. In this case the database name is animal-db.
You MUST have the database up and running before running the project!
Open your XAMPP Control Panel.
Start the Apache server.
Start MySQL.
Click on MySQL "Admin" to open up the DBMS.
Ensure the database that you need is available.
Build and run the main class. You should see 2 new tables created in the aforementioned database.

API Endpoints
Use POSTMAN to try the following endpoints:

Get list of Animals

Request 
`GET /animals/all`

`http://localhost:8080/animals/all`

Response
`[
{"name": Blue Jay, "scientificname" Cyanocitta cristata: "species": bird, "habitat": decidious forests, "description": }
]`

Get a specific Animal

`GET /animals/{anaimald}`

`http://localhost:8080/animals/1`

Create a new Animal

`POST /animals/new`
`http://localhost:8080/animals/new` --data '{"name": Sparrow, "scientificname" Passeridae: "species": bird, "habitat": rain forests, "description": }'

Response 

`[
{"name": Blue Jay, "scientificname": Cyanocitta cristata, "species": bird, "habitat": decidious forests, "description": },
{"name": Sparrow, "scientificname": Passeridae, "species": bird, "habitat": rain forests, "description": }
]`

Get Animal by species

`GET /animals?species=reptile`

`http://localhost:8080/aniamls?species=reptile`

Response 

`[
{"name": Cobra, "scientificname": Naja, "species": reptile, "habitat": desert, "description": },
{"name": Komodo Dragon, "scientificname": Passeridae, "species": reptile, "habitat": desert, "description": }
]`

Update an existing Animal

Request

`PUT /animals/update/{animalId}`

`http://localhost:8080/animals/update/1` --data '{"name": Blue Jay, "scientificname": Cyanocitta cristata, "species": bird, "habitat": rain forests, "description": }'

Reponse 
`{
"name": Blue Jay, "scientificname": Cyanocitta cristata, "species": bird, "habitat": rain forests, "description": 
}`

Delete an existing Animal

`DELETE /animals/delete/{animalId}`

`http://localhost:8080/animals/delete/1`

Reponse 
`[
{"name": Cobra, "scientificname": Naja, "species": reptile, "habitat": desert, "description": },
{"name": Komodo Dragon, "scientificname": Passeridae, "species": reptile, "habitat": desert, "description": }
]`
