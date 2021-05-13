package koutachan.kojogame.langMessage

import koutachan.kojogame.*
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

    val SCOREBOARD_LINE10 = config.get("SCOREBOARD_LINE10").toString()
    val SCOREBOARD_LINE9 = config.get("SCOREBOARD_LINE9").toString()
    val SCOREBOARD_LINE8 = config.get("SCOREBOARD_LINE8").toString()
    val SCOREBOARD_LINE7 = config.get("SCOREBOARD_LINE7").toString()
    val SCOREBOARD_LINE6 = config.get("SCOREBOARD_LINE6").toString()
    val SCOREBOARD_LINE5 = config.get("SCOREBOARD_LINE5").toString()
    val SCOREBOARD_LINE4 = config.get("SCOREBOARD_LINE4").toString()
    val SCOREBOARD_LINE3 = config.get("SCOREBOARD_LINE3").toString()
    val SCOREBOARD_LINE2 = config.get("SCOREBOARD_LINE2").toString()
    val SCOREBOARD_LINE1 = config.get("SCOREBOARD_LINE1").toString()

    val SCOREBOARD_LINE10_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE9_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE8_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE7_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE6_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE5_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE4_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE3_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE2_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
    val SCOREBOARD_LINE1_SUFFIX = config.get("SCOREBOARD_LINE10_SUFFIX").toString()
}