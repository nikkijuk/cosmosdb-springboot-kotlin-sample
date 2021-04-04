package com.nikkijuk.cosmossample

import com.azure.spring.data.cosmos.core.mapping.Container

@Container(containerName = "myContainer", ru = "400")
class User {
    lateinit var id: String
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var addresses: List<Address>

    // no-arg constuctor is used by Jackson
    constructor() {}

    constructor(id: String, firstName: String, lastName: String, addresses: List<Address>) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.addresses = addresses
    }

    @Override
    override fun toString(): String {
        return String.format("User: %s %s, %s @ %s", firstName, lastName, id, addresses)
    }

}