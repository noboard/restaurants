# restaurants
### Restaurants assessment

####Running the RestAPI
The easiest wau to run the RestAPI on your local machine, is to download the jar file and run it locally.  The jar file can be found here: [jar file](https://github.com/noboard/restaurants/blob/main/target/restaurants-0.0.1-SNAPSHOT.jar) Look for the download button on the right sidew of the page.

Once the jar file has downloaded, copy it to a directory you wish to keep the file in.  If you haven't already, open a comand line/prompt and navigate to the directory the jar file is stored in.  Once there start the application with the following command: `java -jar restaurants-0.0.1-SNAPSHOT.jar` Once it's running you should see something similar to the screenshot below.

![Spring boot startup]()

←[30m2022-08-16 22:12:22,252←[0;39m ←[34mINFO ←[0;39m [←[34mmain←[0;39m] ←[33morg.springframework.boot.web.embedded.tomcat.TomcatWebServer←[0;39m: Tomcat initialized with port(s): 8080 (http)


#### cURL commands
- **Get all restaurants**: `curl http://localhost:8080/api/get-all-restaurants`
- **Get A rated restauratns**: `curl http://localhost:8080/api/get-restaurants-by-grade/a`
- **Get B rated restaurants**: `curl http://localhost:8080/api/get-restaurants-by-grade/B`
- **Get default error page**: `curl http://localhost:8080/api/get-restaurants-by-grade/ldfg`

