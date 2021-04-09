package com.nikkijuk.cosmossample

// to api
fun com.nikkijuk.cosmossample.User.toApi () =
        com.nikkijuk.model.User (
                id = this.id,
                firstName = this.firstName,
                lastName = this.lastName,
                addresses = this.addresses.map { it.toApi() })

fun com.nikkijuk.cosmossample.Address.toApi () =
                com.nikkijuk.model.Address (
                        street = this.street,
                        postalcode = this.postalcode,
                        city = this.city)
// to entity
fun com.nikkijuk.model.User.toEntity () =
        com.nikkijuk.cosmossample.User (
                id = this.id,
                firstName = this.firstName,
                lastName = this.lastName,
                // return empty list in case of null
                addresses = this.addresses?.map { it.toEntity() } ?: listOf())

fun com.nikkijuk.model.Address.toEntity () =
        com.nikkijuk.cosmossample.Address (
                street = this.street,
                postalcode = this.postalcode,
                city = this.city)
