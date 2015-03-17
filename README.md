Included inside this repository is a code test performed in according to specifications.

The webservice may be reached at:

http://ec2-52-11-142-4.us-west-2.compute.amazonaws.com/EmcRubiconWS/fibonacci?n=15

The EmcRubiconWS implements a RESTFUL Web Service which generates output in a Fibonacci sequence n times with n as a non-negative whole integer input. Supplied 5 for n times the following would be produced as output: 0 1 1 2 3. Given a negative number, a 400 Bad Request is produced. Given 0 or null data a friendly error message is displayed. Given a whole integer, a pattern in accordance to Fibonacci is produced the supplied number of times.

The EmcRubiconWS was developed as a JAX-RS Web Service using Jersey 1.19, Tomcat 7.0.47, and JDK 1.8. The project contains 2 x packages ( com.emc.rubicon.resources - comprised of key Jersey classes exposing servlet method / REST Operations and URIs) and (com.emc.rubicon.math  - comprised of the fibonacci program). A web descriptor file describes the application's deployment properties, providing the display name, the principal servlet name, the servlet class, and any Jersey v1.1X version resourcs otherwise known as init parameters, with finally the servlet name and URL pattern for the servlet.

To prepare, build, and deploy:

1) Download Apache Jersey 1.19 (jersey-bundle-1.19.jar, and Apache Tomcat 7.047 from apache.org
2) Prepare and download Eclipse Luna for Java or JEE developers from eclipse.org
3) Download and Install JDK1.8 from Oracle 
4) Set Java Home to Java JRE install location, and start Eclipse
5) Prepare Eclipse, setting up a Tomcat Server 
6) Create a new Dynamic Web Project
7) Copy the jersey-bundle-1.19.jar to the lib directory within WEB-INF, inside WebContent
8) Right click on the project and generate a new descriptor file if one does not exist.
9) Edit the web.xml to define the display name, servlet name, the full path of the servlet-class, and finally provide servlet mapping with servlet name and provide a URL pattern.
10. Right click on the project, and select Web Project Settings, and specify the preferred context path.
11. Now prepare a new package which defines the resources, that is , create a package which shall contain the classes for implementing and providing the REST operations. The package name "eg: com.emc.rubicon.resources" will be defined as the param-value for the param-name "com.sun.jersey.config.property.packages" inside the Web Descripter file, web.xml.  This is according to Jersey 1.x. In Jersey 2.x, Maven is leveraged,and instead a POM is used, and in place of resources one defines dependencies. 
12. After creating the necessary classes and methods to support both Root "/" web URI requests as well as any additional URI paths, save changes,  right click on the project, and choose Run As, and follow the prompts to run/deploy it on the target Tomcat server.  Once the code is validated, one may right click on the project, and choose Export, and select to WAR.

To Deploy:
1) Install Java 1.8 JDK
2) Install Apache 2.2x , 2 or more instances spanning separate server noes for HA, Linux HA-Proxy may be used to establish a cluster with HA 
3) Install Apache Tomcat, 2 or more instances 
4) On each Apache web server, prepare Apache Jserve Protocol proxied connections to the Tomcat JServe Port 8009m using Apache MoxProxy AJP which supports ProxyPass / ajp://IP-or-FQDN-ofTomcat:8009/ to reverse proxy requests to Tomcat.  There are a number of settings options, including the ability to load balance to one or many disparate Tomcat instance. In a production environment, one can run more than one Tomcat instance on the same machine, and more than one system for hosting Tomcat instances to distribute load across separate JRE instances.
5) Set the Java home to the install location of the JDK
6) Start Tomcat, and ensure port 8080, and 8009 are running , netstat -an | grep 80 
7) Start Apache, and verify that a request for / in turn responds with the default Tomcat page.
8) SFTP, or copy over the WAR file exported from the Eclipse IDE and copy into the Tomcat install location's webapps sub-director to automatically deploy the WAR file. Tail the logs directory 's catalina.out, in order to see the starting of deployment, and finish deploying statement.

API Specifications:

1) Methods Supported: HTTP GET 
2) Input Specification:  QueryString Parameter: n , where n must be a non-negative whole number, e.g ?n=1
3) Response Encoding: plain/text 
4) HTTP Response Codes Supported: 200 Successful GET, 400 Bad Request, and 404 Not Found as explained:
- 200 when a whole integer was supplied and there is successful and sufficient resource access
- 404 when the request is for a non-supported context path, URI, or the combination, and thus the resource cannot be found. This includes requests for unimplemented URIs
- 400  when the request is for a negative number
- A friendly message in plain text is returned if the value is 0.

To test API:

Valid Requests:
1) 
CURL -X GET http://ec2-52-11-142-4.us-west-2.compute.amazonaws.com/EmcRubiconWS/fibonacci?n=15

Should return HTTP 200 OK,  text/plain formatted text, with 15 total space separated numbers

2) 
CURL -X GET http://ec2-52-11-142-4.us.west-2.compute.amazonaws.com/EmcRubiconWS/fibonacci?n=0
Should return HTTP 200 OK, text/plain, and a friendly message to provide valid input.

3) CURL -X GET http://ec2-52-11-142-4.us.west-2.compute.amazonaws.com/EmcRubiconWS/
Should return HTTP 404 Not Found 

4) CURL -X GET http://ec2-52-11-142-4.us.west-2.compute.amazonaws.com/EmcRubiconWS/fibonacci?n=-1
Should return HTTP 400 BAD Request























