package koutachan.kojogame.langMessage

import koutachan.kojogame.SettingsFile
import org.bukkit.ChatColor
import org.bukkit.configuration.file.YamlConfiguration

object lang {

    val config = YamlConfiguration.loadConfiguration(SettingsFile)!!

    //CURRENT REPLACE .replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString())

    val MESSAGE_STARTING_COUNT: String = config.getString("STARTING_COUNT")
    val TITLE_STARTING_COUNT: String = config.getString("STARTING_TITLE")

    val MESSAGE_START: String = config.getString("START_CHAT")
    val TITLE_START: String = config.getString("START_TITLE")

    val MESSAGE_TELEPORT_TO_LOBBY5: String = config.getString("TELEPORT_TO_LOBBY5")
    val MESSAGE_TELEPORT_TO_LOBBY: String = config.getString("TELEPORT_TO_LOBBY")

    val TITLE_SCOREBOARD: String = config.getString("SCOREBOARD_TITLE")

    val GLOBAL_CHAT_PREFIX: String = config.getString("GLOBAL_CHAT_PREFIX")


    fun lengthcheck(message: String): List<String> {
        return if(message.length in 17..32){
            listOf(message.substring(0, 16),ChatColor.getLastColors(message.substring(0, 16)) + message.substring(16))
        }else {
            listOf(message,ChatColor.getLastColors(message))
        }
    }
}