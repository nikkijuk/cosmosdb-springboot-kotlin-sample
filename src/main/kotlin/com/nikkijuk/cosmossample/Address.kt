package com.nikkijuk.cosmossample

import com.azure.spring.data.cosmos.core.mapping.Container
import com.azure.spring.data.cosmos.core.mapping.PartitionKey

class Address {
    lateinit var street: String
    lateinit var postalcode: String
    lateinit var city: String

    // no-arg constuctor is used by Jackson
    constructor() {}

    constructor(street: String, postalcode: String, city: String) {
        this.street = street
        this.postalcode = postalcode
        this.city = city
    }

    @Override
    override fun toString(): String {
        return String.format("Address: %s %s %s", street, postalcode, city)
    }
}