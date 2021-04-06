# cosmosdb-springboot-kotlin-sample

Copy of Microsoft azure cosmosdb spring data example app converted to kotlin and spring boot http api added.

## Content

Small example how to use azure cosmosdb spring data SQL API (3.5.1) with spring boot (2.4.3).

Additionally presented how one open api 3.0.3 can be used to generate base API for spring boot rest controllers.

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

