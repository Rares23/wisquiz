package com.crxapplications.wisquiz.flows.quiz.domain.model

import com.crxapplications.wisquiz.R
import com.crxapplications.wisquiz.core.helper.UiText

data class Category(
    val id: Int,
    val type: CategoryType,
    val title: UiText,
    val description: UiText,
)

fun Category.getIconResource(): Int {
    return when (type) {
        CategoryType.GENERAL_KNOWLEDGE -> R.drawable.ic_globe
        CategoryType.GEOGRAPHY -> R.drawable.ic_landscape
        CategoryType.HISTORY -> R.drawable.ic_swords
        CategoryType.SCIENCE -> R.drawable.ic_science
        CategoryType.COMPUTERS_TECH -> R.drawable.ic_devices
        CategoryType.MOVIES -> R.drawable.ic_movie
        CategoryType.ART -> R.drawable.ic_art
        CategoryType.MYTHOLOGY -> R.drawable.ic_myth
    }
}

enum class CategoryType {
    GENERAL_KNOWLEDGE,
    GEOGRAPHY,
    HISTORY,
    SCIENCE,
    COMPUTERS_TECH,
    MOVIES,
    ART,
    MYTHOLOGY;

    companion object {
        fun fromSlug(slug: String): CategoryType =
            when (slug) {
                "geography" -> GEOGRAPHY
                "history" -> HISTORY
                "science" -> SCIENCE
                "computers-tech" -> COMPUTERS_TECH
                "movies" -> MOVIES
                "art" -> ART
                "mythology" -> MYTHOLOGY
                else -> GENERAL_KNOWLEDGE
            }
    }
}
