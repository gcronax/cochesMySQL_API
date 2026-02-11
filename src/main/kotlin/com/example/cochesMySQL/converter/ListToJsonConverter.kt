package com.example.cochesMySQL.converter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import tools.jackson.module.kotlin.jacksonObjectMapper
import tools.jackson.module.kotlin.readValue
import kotlin.collections.emptyList

@Converter
class ListToJsonConverter : AttributeConverter<MutableList<Int>, String> {
    private val mapper = jacksonObjectMapper()

    override fun convertToDatabaseColumn(attribute: MutableList<Int>?): String =
        mapper.writeValueAsString(attribute ?: mutableListOf<Int>())

    override fun convertToEntityAttribute(dbData: String?): MutableList<Int> =
        if (dbData.isNullOrEmpty()) mutableListOf() else mapper.readValue(dbData)
}
