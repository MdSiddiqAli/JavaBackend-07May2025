# Handson Use Case

This project has CRUD operations for storing/retrieving/updating/delete data into H2 DB. The Organization/Employee/Asset details are stored in DB.

JAVA Version: 1.8
Spring Boot Version: 2.5.3
Origin Developer: Syed Vali Ahamed S.
Project Type: Spring Boot Web

### Build and Deployment Steps

Step 1:
Build the application using maven clean install command.

Step 2:
In a terminal, navigate to where you created kube.yaml and deploy your application to Kubernetes.
kubectl apply -f kube.yaml.

you should see output that looks like the following, indicating your Kubernetes objects were created successfully:

deployment.apps/usecase-demo created
service/usecase-entrypoint created

Step 3:

Make sure everything worked by listing your deployments:

kubectl get deployments

Do the same check for your services.

kubectl get services


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.3/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-security)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Kubernetes Deployment] (https://docs.docker.com/get-started/kube-deploy/)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

