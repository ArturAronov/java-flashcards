https://www.youtube.com/watch?v=31KTdfRH6nY&t=4145s  
1:33:21

`./mvn spring-boot:run`


![pic1.jpeg](resources/pic1.jpeg)

`bean` a instance of the class with some metadata around it

### Annotations
`@Component`  
`@Bean`  
`@RestController`  
`@GetMapping`  
`@PostConstruct`

### In memory DB
_application.properties_:
```
# by default the data source name is uuid
spring.datasource.generate-unique-name=false
spring.datasource.name=cards
```
_http://localhost:8080/h2-console_:
![pic2.jpeg](resources/pic2.jpeg)