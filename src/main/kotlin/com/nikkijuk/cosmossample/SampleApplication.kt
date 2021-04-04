package com.nikkijuk.cosmossample

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import reactor.core.publisher.Flux

@SpringBootApplication
class SampleApplication : CommandLineRunner {
    private val logger: Logger = LoggerFactory.getLogger(SampleApplication::class.java)

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var reactiveUserRepository: ReactiveUserRepository

    override fun run(vararg var1: String?) {
        val testAdress1 = Address("Waldstrasse 1", "04105", "Leipzig")
        val testAdress2 = Address("Christianstrasse 2", "04105", "Leipzig")
        val testAdress3 = Address("Lindenauer Markt 21",         "04177", "Leipzig")

        val testUser1 = User("testId1", "testFirstName", "testLastName1",
                listOf(testAdress1, testAdress2))
        val testUser2 = User("testId2", "testFirstName", "testLastName2",
                listOf(testAdress2, testAdress3))
        logger.info("Using sync repository")

        // <Delete>
        userRepository.deleteAll()

        // </Delete>

        // <Create>
        logger.info("Saving user : {}", testUser1)
        userRepository.save(testUser1)

        // </Create>
        logger.info("Saving user : {}", testUser2)
        userRepository.save(testUser2)

        // to find by Id, please specify partition key value if collection is partitioned
        val result: User = userRepository.findByIdAndLastName(testUser1.id, testUser1.lastName)
        logger.info("Found user : {}", result)

        val usersIterator = userRepository.findByFirstName("testFirstName").iterator()
        logger.info("Users by firstName : testFirstName")
        while (usersIterator.hasNext()) {
            logger.info("user is : {}", usersIterator.next())
        }

        // find with postalcode

        val postalcode = "04177"
        val usersByPostalcode = userRepository.getUsersByPostalcode(postalcode).iterator()
        logger.info("Users by postalcode : {}",postalcode)
        while (usersByPostalcode.hasNext()) {
            logger.info("user living at {} is : {}", postalcode, usersByPostalcode.next())
        }

        // reactive

        logger.info("Using reactive repository")

        // <Query>
        val users = reactiveUserRepository.findByFirstName("testFirstName")
        users?.map { u ->
            logger.info("user is : {}", u)
            u
        }?.subscribe()

        // </Query>
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SampleApplication::class.java, *args)
        }
    }

}
