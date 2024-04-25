package model


import kotlinx.serialization.Serializable


@Serializable
data class LocalTroop(
    val category: String,
    val dps: List<Int>,
    val housingSpace: Int,
    val id: Int,
    val levels: List<Int>,
    val minLevel: Int,
    val name: String,
    val regenerationTimes: List<Int>,
    val resourceType: String? = null,
    val seasonal: Boolean,
    val subCategory: String,
    val trainingTime: Int,
    val unlock: Unlock,
    val upgrade: Upgrade,
    val village: String
) {
    @Serializable
    data class Unlock(
        val building: String,
        val buildingLevel: Int,
        val cost: Int,
        val hall: Int,
        val resource: String,
        val time: Int
    )

    @Serializable
    data class Upgrade(
        val cost: List<Int>,
        val costAndResources: List<List<CostAndResource>>? = null,
        val resource: String,
        val time: List<Int>
    ) {
        @Serializable
        data class CostAndResource(
            val cost: Int,
            val resource: String
        )
    }
}
