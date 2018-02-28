# Spring Social Foursquare

To check out the project and build from source, do the following:

    git clone git://github.com/pablomxnl/spring-social-foursquare.git
    cd spring-social-foursquare
    mvn clean install
    
To use as a maven dependency add the following to your maven project

1. Add this repository to your `repositories` section  
    ```xml
    <repository>
        <id>spring-foursquare</id>
        <name>Spring Snapshot Repository</name>
        <url>https://raw.githubusercontent.com/pablomxnl/spring-social-foursquare/repository</url>
    </repository>
    ```

1. Add the dependency
    ```xml      
    <dependency>
        <groupId>org.springframework.social</groupId>
        <artifactId>spring-social-foursquare</artifactId>
        <version>1.0.9</version>
    </dependency>
    ```
