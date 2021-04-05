package com.nikkijuk.cosmossample


// to api

// Type erasure removes here java typing and thus create method collision
@JvmName("UserListToApi")
fun List<com.nikkijuk.cosmossample.User>.toApi () =
        this.map { it.toApi() }

fun com.nikkijuk.cosmossample.User.toApi () =
        com.nikkijuk.model.User (
                id = this.id,
                firstName = this.firstName,
                lastName = this.lastName,
                addresses = this.addresses.toApi()
        )

// Type erasure removes here java typing and thus create method collision
@JvmName("AddressListToApi")
fun List<com.nikkijuk.cosmossample.Address>.toApi () =
        this.map { it.toApi() }

fun com.nikkijuk.cosmossample.Address.toApi () =
                com.nikkijuk.model.Address (
                        street = this.street,
                        postalcode = this.postalcode,
                        city = this.city
                        )

// to entity

fun com.nikkijuk.model.User.toEntity () =
        com.nikkijuk.cosmossample.User (
                id = this.id,
                firstName = this.firstName,
                lastName = this.lastName,
                addresses = this.addresses.toEntity()
        )

// Type erasure removes here java typing and thus create method collision
@JvmName("AddressListToEntityNullable")
fun List<com.nikkijuk.model.Address>?.toEntity () =
        this?.map { it.toEntity() } ?: listOf() // return empty list in case of null

fun com.nikkijuk.model.Address.toEntity () =
        com.nikkijuk.cosmossample.Address (
                street = this.street,
                postalcode = this.postalcode,
                city = this.city
        )
