package koutachan.kojogame.langMessage

import koutachan.kojogame.SettingsFile
import org.bukkit.ChatColor
import org.bukkit.configuration.file.YamlConfiguration

object lang {

    val config = YamlConfiguration.loadConfiguration(SettingsFile)!!

    //CURRENT REPLACE .replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString())

    val MESSAGE_STARTING_COUNT = config.get("STARTING_COUNT").toString()
    val TITLE_STARTING_COUNT = config.get("STARTING_TITLE").toString()

    val MESSAGE_START = config.get("START_CHAT").toString()
    val TITLE_START = config.get("START_TITLE").toString()

    val MESSAGE_TELEPORT_TO_LOBBY5 = config.get("TELEPORT_TO_LOBBY5").toString()
    val MESSAGE_TELEPORT_TO_LOBBY = config.get("TELEPORT_TO_LOBBY").toString()

    val TITLE_SCOREBOARD = config.get("SCOREBOARD_TITLE").toString()

    fun LengthCheck(message: String): List<String> {
        return if(message.length in 17..32){
            listOf(message.substring(0, 16),ChatColor.getLastColors(message.substring(0, 16)) + message.substring(16))
        }else {
            listOf(message,"")
        }
    }
}