package com.crxapplications.wisquiz.flows.quiz.data.provider

import android.content.res.AssetManager
import com.crxapplications.wisquiz.flows.quiz.data.entity.CategoryDto
import com.crxapplications.wisquiz.flows.quiz.data.entity.toCategory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.reflect.Type

interface CategoryAssetDataProvider {
    suspend fun loadCategories(): Flow<List<CategoryDto>>
}

class CategoryAssetDataProviderImpl constructor(
    private val moshi: Moshi,
    private val assetManager: AssetManager,
) : CategoryAssetDataProvider {
    override suspend fun loadCategories(): Flow<List<CategoryDto>> = flow {
        assetManager.open("categories.json").bufferedReader().use { reader ->
            try {
                val type: Type = Types.newParameterizedType(
                    List::class.java,
                    CategoryDto::class.java
                )
                val categories =
                    moshi.adapter<List<CategoryDto>>(type).fromJson(reader.readText())
                        ?: emptyList()

                emit(categories)
            } catch (e: Exception) {
                e.printStackTrace()

                emit(emptyList())
            }

        }
    }

}