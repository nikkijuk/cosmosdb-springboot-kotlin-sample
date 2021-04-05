package com.nikkijuk.cosmossample

import com.nikkijuk.api.UsersApi
import com.nikkijuk.model.User
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

    companion object {
        private val LOGGER = LoggerFactory.getLogger(SampleAppController::class.java)
    }

    override fun createUser(@RequestBody user: User): ResponseEntity<User> {
        LOGGER.info("create")
        val user = userRepository.save(user.toEntity())
        LOGGER.info("saved user " + user.toString())
        return ResponseEntity(user.toApi(), HttpStatus.OK)
        return ResponseEntity(user.toApi(), HttpStatus.OK)
    }

    override fun findUsers(): ResponseEntity<List<User>> {
        LOGGER.info("find all")
        val users = userRepository.findAll()
        LOGGER.info("found users " + users.toString())
        return ResponseEntity(users.map { it.toApi() }, HttpStatus.OK)
    }

    override fun getUserById(@PathVariable("id") id: kotlin.String
    ): ResponseEntity<User> {
        LOGGER.info("find with id " + id)
        val user = userRepository.findById(id)
        LOGGER.info("found user " + user.toString())
        return user
                .map { ResponseEntity(it.toApi(), HttpStatus.OK) }
                .orElse(ResponseEntity(HttpStatus.NOT_FOUND))
    }
}
