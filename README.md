# ODS Full Stack Coding Assignment

## Tech Stack

#### Front End: 
Vue2.js, Vue Router, Vue ui (CLI), Element-UI, Axios, less (CSS), HTML, Javascript

#### Back End: 
Spring Web, Spring Data JPA, Hibernate, Java, MySQL

## RESTful API
Base URL: 'http://localhost:80/api/v1/'

**Feature 1: search** 

Request URL: 'http://localhost:80/api/v1/flights/{keyword}?type={type}&page={page}&pageSize={pageSize}'

Method: ```HTTP GET```

Path Variable: ```string {keyword} required```
Request Parameter: ```string {type} not required```
Request Parameter: ```int {page} not required```
Request Parameter: ```int {pageSize} not required```

Response Body:
```json
{
    "data": {
        "content": [
            {
                "id": 294314,
                "createAt": "2019-09-19 20:36:44",
                "updateAt": "2019-09-19 20:36:44",
                "flightUID": "bb919965-b673-470e-8d6f-4970a6ae8c64",
                "flightNum": 1114,
                "gateOrigin": "B4",
                "gateDestination": "F03",
                "out": "2019-02-09 22:56:05",
                "in": "2019-02-10 02:54:09",
                "off": "2019-02-09 23:08:18",
                "on": "2019-02-10 02:50:41",
                "destination": "SLC",
                "origin": "BNA",
                "fullDestination": "Salt Lake City Intl",
                "fullOrigin": "Nashville Intl"
            }
        ],
        "last": false,
        "totalElements": 19,
        "totalPages": 19,
        "number": 1,
        "size": 1,
        "sort": null,
        "first": false,
        "numberOfElements": 1
    },
    "payload": {
        "message": "OK",
        "status": 200
    }
}
```

**Feature 2: auto-suggest** 

Request URL: 'http://localhost:80/api/v1/station/lookup/{keyword}?limit={limit}'

Method: ```HTTP GET```

Path Variable: ```string {keyword} required```
Request Parameter: ```int {limit} not required```

Response Body:
```json
{
    "data": [
        "BNA",
        "Nashville Intl"
    ],
    "payload": {
        "message": "OK",
        "status": 200
    }
}
```

## Reproduce the project
If you want to run this project on a localhost, you will need npm installed on your enviornment, as well as Vue CLI too.

To run the front-end, open CMD and enter ```vue ui``` command, import the folder delta-front-end into the Vue CLI, and run it by ```vue ui``` interface via browser or you can manually install the dependencies via npm, and then do a ```npm run serve```.

To run the back-end, first import the file ```flights.csv``` into MySQL database, configure the JDBC connection via file ```application.properties``` under ```delta-back-end\src\main\resources``` folder. You can run this project in any IDE that supports Maven project, Eclipse would be a good one here since I develop this on Eclipse.

## Test
This assignment is tested manually by PostMan & manual operations.
A showcase video can be found at 'https://www.youtube.com/watch?v=tOtu0PCiMKw'

Feature 1 average response time is in 7ms;
Feature 2 average response time is in 10ms;
