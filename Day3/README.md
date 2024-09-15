What is the purpose of the directory structure given on p. 30?

Answer: The directory structure on p. 30 represents a typical layout for a Java web application. It includes directories like WEB-INF for configuration files and security settings, classes for compiled Java classes, and lib for libraries. This structure is essential for the web server (such as Tomcat) to correctly locate and run the components of the web application.

What is the purpose of the directory structure given on p. 31?

Answer: The directory structure on p. 31 shows how the application should be organized within the deployment environment. It includes the webapps directory where the web application is deployed, and it indicates how the server will interact with the web application’s files, such as Servlets, JSPs, and other resources.
Why do you need to be in the project1 directory for step 5?

Answer: You need to be in the project1 directory for step 5 because this is where the web.xml file and the compiled classes are located. Being in this directory ensures that the jar command packages everything correctly into a WAR file, or that the server finds the correct paths when deploying the application.

Why is the copying of step 6 necessary?

Answer: The copying step is necessary because it places the WAR file (or the entire directory structure) into the server’s webapps directory. This directory is where the server looks for web applications to deploy. Without copying the files here, the server would not be able to deploy or run your application.

Where is the name of the web app defined? Try changing it.

Answer: The name of the web app is typically defined by the name of the WAR file or the name of the directory within the webapps folder. For example, if you deploy a WAR file named project1.war, the application will be accessible via http://localhost:8080/project1. Changing the name of the WAR file or the folder will change the context path of the application.

Why is step 9 necessary? Try changing display text in the servlet. What steps are necessary for your changes to appear in the browser?

Answer: Step 9 (restarting or refreshing the server) is necessary to ensure the server picks up any changes made to the Servlet or the deployment. When you change the display text in the Servlet, you need to recompile the Servlet, redeploy the WAR file or the directory structure, and restart the server. Alternatively, if your server supports hot deployment, you might only need to refresh the browser if the server automatically redeploys the updated class.


Describe an interesting problem you encountered (if any) and how you solved it.

Answer: An interesting problem might involve a 404 Not Found error after deploying the application. This could be caused by an incorrect directory structure, missing files, or a misconfigured web.xml. The solution could involve carefully reviewing the directory structure to ensure all files are correctly placed and the web.xml is correctly configured with the appropriate servlet mappings.