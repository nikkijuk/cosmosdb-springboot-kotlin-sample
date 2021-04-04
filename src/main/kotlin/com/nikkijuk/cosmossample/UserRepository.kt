package com.nikkijuk.cosmossample

import com.azure.spring.data.cosmos.repository.CosmosRepository
import com.azure.spring.data.cosmos.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CosmosRepository<User, String> {
    fun findByFirstName(firstName: String): Iterable<User>

    fun findByIdAndLastName(id: String, lastName: String): User

    @Query(value = "select * from c where c.firstName = @firstName and c.lastName = @lastName")
    fun getUsersByFirstNameAndLastName(@Param("firstName") firstName: String, @Param("lastName") lastName: String): List<User>

    @Query(value = "select * from c offset @offset limit @limit")
    fun getUsersWithOffsetLimit(@Param("offset") offset: Int, @Param("limit") limit: Int): List<User>

    @Query(value = "select c.id, c.firstName, c.lastName, c.addresses from c join a in c.addresses where a.postalcode = @plz")
    fun getUsersByPostalcode(@Param("plz") plz: String): List<User>

}