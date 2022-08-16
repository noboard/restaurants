# restaurants
### Restaurants assessment

#### Running the RestAPI
The easiest way to run the RestAPI on your local machine, is to download the jar file and run it locally.  The jar file can be found here: [jar file](https://github.com/noboard/restaurants/blob/main/target/restaurants-0.0.1-SNAPSHOT.jar) Look for the download button on the right sidew of the page.

Once the jar file has downloaded, copy it to a directory you wish to keep the file in.  If you haven't already, open a comand line/prompt and navigate to the directory the jar file is stored in.  Once there start the application with the following command: `java -jar restaurants-0.0.1-SNAPSHOT.jar` Once it's running you should see something similar to the screenshot below.

![Spring boot startup](https://github.com/noboard/restaurants/blob/main/running_jar_file.PNG)

Once it has completed startup, look at the top lines, just below the "Spring" ascii art, for the port number the service is running on.  By default this will be port 8080, but if something is already on that port, it will use a different one.  The line you are looking for will probably be the third of fourth line and will look similar to the line below.

`←[30m2022-08-16 22:12:22,252←[0;39m ←[34mINFO ←[0;39m [←[34mmain←[0;39m] ←[33morg.springframework.boot.web.embedded.tomcat.TomcatWebServer←[0;39m: Tomcat initialized with port(s): 8080 (http)`

Once you know what port you are running on you can test the RestAPI with the following cURL commands.  
**NOTE**  The commands below assume the service is being run on port 8080.  If your service is running on a different port, simple replace 8080 with the actual port number.  So if the service was running on port 8088, instead of 'curl http://localhost:8080/api/get-all-restaurants', you would put `curl http://localhost:8088/api/get-all-restaurants`


#### cURL commands
- **Get all restaurants**: `curl http://localhost:8080/api/get-all-restaurants`
- **Get A rated restauratns**: `curl http://localhost:8080/api/get-restaurants-by-grade/a`
- **Get B rated restaurants**: `curl http://localhost:8080/api/get-restaurants-by-grade/B`
- **Get default error page**: `curl http://localhost:8080/api/get-restaurants-by-grade/ldfg`

### Compiling using an IDE for the first time
If you open the project in an IDE, before you can run it, jooq will need to generate the database classes used by the main application.  To do this you will need to create amaven build profile and run the following command: `clean install`.  Once the files have been generated, jooq will only run again if it checks changes to the database schema.
