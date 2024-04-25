package model


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class Player(
    val achievements: List<Achievement>,
    val attackWins: Int,
    val bestBuilderBaseTrophies: Int,
    val bestTrophies: Int,
    val builderBaseLeague: BuilderBaseLeague,
    val builderBaseTrophies: Int,
    val builderHallLevel: Int,
    val clan: Clan,
    val clanCapitalContributions: Int,
    val defenseWins: Int,
    val donations: Int,
    val donationsReceived: Int,
    val expLevel: Int,
    val heroEquipment: List<HeroEquipment>,
    val heroes: List<Heroes>,
    val labels: List<Label>,
    val league: League,
    val legendStatistics: LegendStatistics,
    val name: String,
    val playerHouse: PlayerHouse,
    val role: String,
    val spells: List<Spell>,
    val tag: String,
    val townHallLevel: Int,
    val townHallWeaponLevel: Int,
    val troops: List<Troop>,
    val trophies: Int,
    val warPreference: String,
    val warStars: Int
) {
    @JsonClass(generateAdapter = true)
    internal data class Achievement(
        val completionInfo: String?,
        val info: String,
        val name: String,
        val stars: Int,
        val target: Int,
        val value: Int,
        val village: String
    )

    @JsonClass(generateAdapter = true)
    internal data class BuilderBaseLeague(
        val id: Int,
        val name: String
    )

    @JsonClass(generateAdapter = true)
    internal data class Clan(
        val badgeUrls: BadgeUrls,
        val clanLevel: Int,
        val name: String,
        val tag: String
    ) {
        @JsonClass(generateAdapter = true)
        internal data class BadgeUrls(
            val large: String,
            val medium: String,
            val small: String
        )
    }

    @JsonClass(generateAdapter = true)
    internal data class HeroEquipment(
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    )

    @JsonClass(generateAdapter = true)
    internal data class Heroes(
        val equipment: List<Equipment>?,
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    ) {
        @JsonClass(generateAdapter = true)
        internal data class Equipment(
            val level: Int,
            val maxLevel: Int,
            val name: String,
            val village: String
        )
    }

    @JsonClass(generateAdapter = true)
    internal data class Label(
        val iconUrls: IconUrls,
        val id: Int,
        val name: String
    ) {
        @JsonClass(generateAdapter = true)
        internal data class IconUrls(
            val medium: String,
            val small: String
        )
    }

    @JsonClass(generateAdapter = true)
    internal data class League(
        val iconUrls: IconUrls,
        val id: Int,
        val name: String
    ) {
        @JsonClass(generateAdapter = true)
        internal data class IconUrls(
            val medium: String,
            val small: String,
            val tiny: String
        )
    }

    @JsonClass(generateAdapter = true)
    internal data class LegendStatistics(
        val bestSeason: BestSeason,
        val currentSeason: CurrentSeason,
        val legendTrophies: Int,
        val previousSeason: PreviousSeason
    ) {
        @JsonClass(generateAdapter = true)
        internal data class BestSeason(
            val id: String,
            val rank: Int,
            val trophies: Int
        )

        @JsonClass(generateAdapter = true)
        internal data class CurrentSeason(
            val rank: Int,
            val trophies: Int
        )

        @JsonClass(generateAdapter = true)
        internal data class PreviousSeason(
            val id: String,
            val rank: Int,
            val trophies: Int
        )
    }

    @JsonClass(generateAdapter = true)
    internal data class PlayerHouse(
        val elements: List<Element>
    ) {
        @JsonClass(generateAdapter = true)
        internal data class Element(
            val id: Int,
            val type: String
        )
    }

    @JsonClass(generateAdapter = true)
    internal data class Spell(
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    )

    @JsonClass(generateAdapter = true)
    internal data class Troop(
        val level: Int,
        val maxLevel: Int,
        val name: String,
        val village: String
    )
}