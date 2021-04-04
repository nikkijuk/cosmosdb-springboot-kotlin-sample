# cosmosdb-springboot-kotlin-sample

Copy of Microsofts azure cosmosdb example app with needed fixes and some small modifications

## Content

Small example how to use `azure-spring-data-cosmos` Java SQL API with spring boot.

## Original article

See original article for detailed setup information

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

mvn clean install spring-boot:run

## Resources

Cosmos db sql api

https://docs.microsoft.com/en-us/azure/cosmos-db/sql-query-getting-started

Cosmos db spring boot starter

https://docs.microsoft.com/en-us/java/api/overview/azure/spring-boot-starter-cosmos-readme?view=azure-java-stable

documentation of latest spring data cosmos db version

https://docs.microsoft.com/en-us/java/api/overview/azure/spring-data-cosmos-readme?view=azure-java-stable

Guide to write cosmos db queries

https://cosmosdb.github.io/labs/dotnet/labs/03-querying_in_azure_cosmosdb.html