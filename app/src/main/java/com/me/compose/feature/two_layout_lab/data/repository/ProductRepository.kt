package com.me.compose.feature.two_layout_lab.data.repository

import com.me.compose.feature.two_layout_lab.data.model.Category
import com.me.compose.feature.two_layout_lab.data.model.Product
import kotlinx.coroutines.delay

// ProductRepository.kt
class ProductRepository {
    suspend fun fetchCategories(): List<Category> {
        delay(2000) // simulate network
        return (1..8).map { i ->
            Category(
                id = i.toString(),
                title = "Category $i",
                products = (1..9).map { j ->
                    Product(
                        id = "$i-$j",
                        name = "Product $j",
                        imageUrl = "", // Add URLs if needed
                        icon = "🔥"
                    )
                }
            )
        }
    }
}
