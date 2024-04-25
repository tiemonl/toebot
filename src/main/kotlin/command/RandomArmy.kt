package command

import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.converters.impl.stringChoice
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.publicButton
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.Color
import dev.kord.common.entity.ButtonStyle
import dev.kord.common.entity.Permission
import dev.kord.rest.builder.message.embed
import kotlinx.datetime.Clock
import kotlinx.serialization.json.Json
import model.LocalTroop
import utils.getResourceAsText
import kotlin.random.Random

class RandomArmy : Extension() {
    override val name: String
        get() = "random"

    override suspend fun setup() {
        publicSlashCommand {
            name = "army"
            description = "creates a random army"

            publicSubCommand(::ArmyArgs) {
                name = "randomize"
                description = "Creates a random army for selected player"

                requireBotPermissions(
                    Permission.SendMessages
                )

                action {
                    val format = Json { prettyPrint = true }
                    val troopVariation = arguments.troopVariation
                    val spellVariation = arguments.spellVariation

                    val troops =
                        format.decodeFromString<List<LocalTroop>>(getResourceAsText("src/main/resources/troops.json"))
                    val validTroops =
                        troops.filter { it.village == "home" && it.category == "troop" && it.subCategory == "troop" && it.minLevel < 4 }

                    val validSpells =
                        troops.filter { it.village == "home" && it.category == "spell" }

                    //troops.shuffled().take(troopVariation)
                    val finalArmy = validTroops.shuffled().take(troopVariation)
                    val finalSpells = validSpells.shuffled().take(spellVariation)

                    val troopString =
                        finalArmy.joinToString("\n") { it.name }
                    val spellString =
                        finalSpells.joinToString("\n") { it.name }
                    respond {
                        embed {
                            title = "Randomized Army"
                            field {
                                name = "Troops"
                                value = troopString
                                inline = true
                            }
                            field {
                                name = "Spells"
                                value = spellString
                                inline = true
                            }
                            color = Color(
                                red = Random.nextInt(255),
                                green = Random.nextInt(255),
                                blue = Random.nextInt(255)
                            )
                            timestamp = Clock.System.now()
                        }
//                        components {
//                            publicButton {
//                                label = "Reroll"
//                                style = ButtonStyle.Primary
//                                action {
//                                    ma
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }

    inner class ArmyArgs : Arguments() {
//        val playerTag by string {
//            name = "player_tag"
//            description = "user's player tag"
//        }

        val troopVariation by int {
            name = "troop_limit"
            description = "different amount of troops allowed"
        }

        val spellVariation by int {
            name = "spell_limit"
            description = "different amount of spells allowed"
        }
    }

}