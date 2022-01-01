package com.jay.local.model

import androidx.room.*

data class ShopAndGoodsEntity(
    @Embedded val shop: ShopEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "shopId"
    )
    val goodsList: List<GoodsEntity>
)

@DatabaseView
@Entity(tableName = "goods")
data class GoodsEntity(
    val shopId: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val imageUrl: String,
    val isPreOrder: Boolean,
    val isSoldOut: Boolean,
    val originalPrice: String,
    val salePrice: String
)