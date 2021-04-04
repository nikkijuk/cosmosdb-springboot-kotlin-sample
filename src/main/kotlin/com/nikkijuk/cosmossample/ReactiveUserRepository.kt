package com.nikkijuk.cosmossample

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ReactiveUserRepository : ReactiveCosmosRepository<User, String> {

    /**
     * Get with firstname and return immendiately asycn result object
     */
    fun findByFirstName(firstName: String): Flux<User>?
}