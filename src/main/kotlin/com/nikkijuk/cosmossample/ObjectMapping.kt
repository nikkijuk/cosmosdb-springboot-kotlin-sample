package com.nikkijuk.cosmossample

// Type erasure removes here java typing and thus create method collision
@JvmName("UserListToApi")
fun List<com.nikkijuk.cosmossample.User>.toApi () =
        this.map { it.toApi() }

fun com.nikkijuk.cosmossample.User.toApi () =
        com.nikkijuk.model.User (
                this.id,
                this.firstName,
                this.lastName,
                this.addresses.toApi()
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

