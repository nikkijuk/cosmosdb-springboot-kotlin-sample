package com.nikkijuk.cosmossample

fun com.nikkijuk.cosmossample.User.toApi () =
        com.nikkijuk.model.User (
                this.id,
                this.firstName,
                this.lastName,
                this.addresses.toApi()
        )

fun List<com.nikkijuk.cosmossample.Address>.toApi () =
        this.map {
                com.nikkijuk.model.Address (
                        street = it.street,
                        postalcode = it.postalcode,
                        city = it.city
                        )
        }

