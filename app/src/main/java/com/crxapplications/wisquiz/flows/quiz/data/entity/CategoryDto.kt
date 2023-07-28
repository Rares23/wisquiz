package com.crxapplications.wisquiz.flows.quiz.data.entity

import com.crxapplications.wisquiz.core.helper.UiText
import com.crxapplications.wisquiz.flows.quiz.domain.model.Category
import com.crxapplications.wisquiz.flows.quiz.domain.model.CategoryType
import com.squareup.moshi.Json

data class CategoryDto(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "slug") val slug: String,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "description") val description: String,
)

fun CategoryDto.toCategory(): Category = Category(
    id = id,
    title = UiText.DynamicText(title),
    type = CategoryType.fromSlug(slug),
    description = UiText.DynamicText(description)
)