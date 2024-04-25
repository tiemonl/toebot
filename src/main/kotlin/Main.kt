import com.kotlindiscord.kord.extensions.ExtensibleBot
import command.RandomArmy
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

@OptIn(PrivilegedIntent::class)
suspend fun main(args: Array<String>) {
    val token = args.first()
    val bot = ExtensibleBot(token) {
        intents {
            +Intent.GuildMembers
        }

        extensions {
            add(::RandomArmy)
        }
    }
    bot.start()
}

