package com.nikkijuk.cosmossample

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface ReactiveUserRepository : ReactiveCosmosRepository<User, String> {
    fun findByFirstName(firstName: String): Flux<User>?
}