# cosmosdb-springboot-kotlin-sample

Copy of Microsoft azure cosmosdb spring data example app converted to kotlin and spring boot http api added.

## Content

Small example how to use azure cosmosdb spring data SQL API (3.5.1) with spring boot (2.4.3).

Additionally presents how to use open api 3.0.3 to generate base API and model classes for spring boot rest controller.

## Original article

See original article for detailed cosmos db setup information

https://docs.microsoft.com/en-us/azure/cosmos-db/create-sql-api-spring-data

## Prerequisites

- Kotlin
- Maven
- An active Azure account.
    - If you don't have one, you can sign up for a [free account](https://azure.microsoft.com/free/).
- Cosmos db configured
    - Use sql api

## App

### Properties

Get keys from cosmos db accounts *keys* section and fill application.properties or set environment variables so that proper keys are used

#### application.properties

    cosmos.uri=${ACCOUNT_HOST}
    cosmos.key=${ACCOUNT_KEY}
    cosmos.secondaryKey=${SECONDARY_ACCOUNT_KEY}

### Role of application

- Application loads some test data to cosmosdb

### Role of controller

- Controller takes requests in
- Converst request parameters from api model to entities if needed  
- Executes database operations
- Converts responses from entities to api model if needed
- Returns response

### Code for controller

```
  @RestController
  class SampleAppController @Autowired constructor(
  val userRepository: UserRepository
  ) : UsersApi {

      private val logger: Logger = LoggerFactory.getLogger(SampleApplication::class.java)
  
      override fun createUser(@RequestBody user: User): ResponseEntity<User> {
          val user = userRepository.save(user.toEntity())
          logger.info("saved user: $user")
          return ResponseEntity(user.toApi(), HttpStatus.OK)
      }
  
      override fun findUsers(): ResponseEntity<List<User>> {
          val users = userRepository.findAll()
          logger.info("found users: $users")
          return ResponseEntity(users.map { it.toApi() }, HttpStatus.OK)
      }
  
      override fun getUserById(@PathVariable("id") id: kotlin.String
      ): ResponseEntity<User> {
          val user = userRepository.findById(id)
          logger.info("found with id '$id' user: $user")
          return user
                  .map { ResponseEntity(it.toApi(), HttpStatus.OK) }
                  .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
      }
  }
```

### Test it

Start app

- mvn clean install spring-boot:run

Get existing users as list

- http://127.0.0.1:8080/users/

Get single user

- http://127.0.0.1:8080/users/testId1

Add user

- get json returned by single user 
- change id
- post to http://127.0.0.1:8080/users/ with json body

Get added user

- get as single used with new id

## Resources

Tutorial about sping boot & kotlin

https://spring.io/guides/tutorials/spring-boot-kotlin/

Cosmos db sql api

https://docs.microsoft.com/en-us/azure/cosmos-db/sql-query-getting-started

Cosmos db spring boot starter

https://docs.microsoft.com/en-us/java/api/overview/azure/spring-boot-starter-cosmos-readme?view=azure-java-stable

documentation of latest spring data cosmos db version

https://docs.microsoft.com/en-us/java/api/overview/azure/spring-data-cosmos-readme?view=azure-java-stable

Guide to write cosmos db queries

https://cosmosdb.github.io/labs/dotnet/labs/03-querying_in_azure_cosmosdb.html

Full cosmos db lab

https://azurecosmosdb.github.io/labs/

azure cosmos db spring data documentation in github

https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/cosmos/azure-spring-data-cosmos/README.md

open api generator

https://github.com/OpenAPITools/openapi-generator

kotlin-spring open api generator

https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/kotlin-spring.md

