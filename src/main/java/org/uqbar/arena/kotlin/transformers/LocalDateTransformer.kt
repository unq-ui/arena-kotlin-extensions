package org.uqbar.arena.kotlin.transformers

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import org.uqbar.arena.bindings.ValueTransformer

class LocalDateTransformer(private val pattern: String = "dd/MM/yyyy")
    : ValueTransformer<LocalDate, String> {

    override fun getModelType() = LocalDate::class.java
    override fun getViewType() = String::class.java

    override fun modelToView(valueFromModel: LocalDate): String {
        return valueFromModel.format(DateTimeFormatter.ofPattern(pattern))
    }

    override fun viewToModel(valueFromView: String): LocalDate {
        return LocalDate.parse(valueFromView, DateTimeFormatter.ofPattern(pattern))
    }

}