package com.nikkijuk.cosmossample

import com.nikkijuk.api.UsersApi
import com.nikkijuk.model.User
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model
import org.springframework.web.bind.annotation.*

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
