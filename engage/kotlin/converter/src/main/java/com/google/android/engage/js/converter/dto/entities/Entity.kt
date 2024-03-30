package com.google.android.engage.js.converter.dto.entities

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import com.google.android.engage.common.datamodel.Entity as EngageEntity

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("entityType")
abstract class Entity {
    abstract fun toEngageEntity(): EngageEntity
}
