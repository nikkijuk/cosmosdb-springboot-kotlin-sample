package com.nikkijuk.cosmossample

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "cosmos")
class CosmosProperties {
    lateinit var uri: String
    lateinit var key: String
    lateinit var secondaryKey: String
    var isQueryMetricsEnabled = false
}