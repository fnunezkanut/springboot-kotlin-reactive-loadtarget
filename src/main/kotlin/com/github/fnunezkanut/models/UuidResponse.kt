package com.github.fnunezkanut.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class UuidResponse(
    @JsonProperty(value = "dt") val dt: String? = "",
    @JsonProperty(value = "uuid") val uuid: String? = ""
)