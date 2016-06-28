1. mvn clean jetty:run -Dspring.profiles.active=h2

2. http://localhost:8080/rest/getxml?id=1&name=tony

3. http://localhost:8080/rest/getjson?id=1&name=tony

4. http://localhost:8080/rest/parseJson
   Content-Type:application/json
   body:
   {
       "id": 5,
       "name": "tonyyy"
   }

5. http://localhost:8080/rest/parseJsonList
   Content-Type:application/json
   body:
    [
        {
            "id": 5,
            "name": "tonyyy"
        }
    ]
    