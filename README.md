Description
This project is a fake REST API implemented using JSON Server, containing profiles of players from different sports such as cricket, basketball, football, etc.

Prerequisites
Before running the project, ensure that you have the following installed:

Node.js - JavaScript runtime (which includes npm)
JSON Server - Fake REST API server
Setup
Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/your-repository.git
cd your-repository
Install Dependencies:

bash
Copy code
npm install
Run JSON Server:

bash
Copy code
npm run json-server
This will start the JSON Server using the configuration in db.json.

Usage
The fake REST API will be available at http://localhost:3000.
Use this API to perform CRUD operations on player profiles.
Sample Endpoints
Get all players: http://localhost:3000/players
Get player by ID: http://localhost:3000/players/:id
Add a new player: POST http://localhost:3000/players
Update player by ID: PUT http://localhost:3000/players/:id
Delete player by ID: DELETE http://localhost:3000/players/:id
JSON Server Configuration
The configuration for the fake REST API is stored in db.json.
Customize this file to add, modify, or remove data as needed.
