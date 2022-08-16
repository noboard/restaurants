# restaurants
### Restaurants assessment

####Running the RestAPI
The easiest wau to run the RestAPI on your local machine, is to download the jar file and run it locally.  The jar file can be found here: [jar file](https://github.com/noboard/restaurants/blob/main/target/restaurants-0.0.1-SNAPSHOT.jar)


#### cURL commands
- **Get all restaurants**: `curl http://localhost:8080/api/get-all-restaurants`
- **Get A rated restauratns**: `curl http://localhost:8080/api/get-restaurants-by-grade/a`
- **Get B rated restaurants**: `curl http://localhost:8080/api/get-restaurants-by-grade/B`
- **Get default error page**: `curl http://localhost:8080/api/get-restaurants-by-grade/ldfg`

