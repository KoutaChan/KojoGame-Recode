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

    var SCOREBOARD_LINE10 = config.get("SCOREBOARD_LINE10").toString()
    var SCOREBOARD_LINE9 = config.get("SCOREBOARD_LINE9").toString()
    var SCOREBOARD_LINE8 = config.get("SCOREBOARD_LINE8").toString()
    var SCOREBOARD_LINE7 = config.get("SCOREBOARD_LINE7").toString()
    var SCOREBOARD_LINE6 = config.get("SCOREBOARD_LINE6").toString()
    var SCOREBOARD_LINE5 = config.get("SCOREBOARD_LINE5").toString()
    var SCOREBOARD_LINE4 = config.get("SCOREBOARD_LINE4").toString()
    var SCOREBOARD_LINE3 = config.get("SCOREBOARD_LINE3").toString()
    var SCOREBOARD_LINE2 = config.get("SCOREBOARD_LINE2").toString()
    var SCOREBOARD_LINE1 = config.get("SCOREBOARD_LINE1").toString()

    var SCOREBOARD_LINE10_SUFFIX = ""
    var SCOREBOARD_LINE9_SUFFIX = ""
    var SCOREBOARD_LINE8_SUFFIX = ""
    var SCOREBOARD_LINE7_SUFFIX = ""
    var SCOREBOARD_LINE6_SUFFIX = ""
    var SCOREBOARD_LINE5_SUFFIX = ""
    var SCOREBOARD_LINE4_SUFFIX = ""
    var SCOREBOARD_LINE3_SUFFIX = ""
    var SCOREBOARD_LINE2_SUFFIX = ""
    var SCOREBOARD_LINE1_SUFFIX = ""

    fun LengthCheck(){
        if(SCOREBOARD_LINE10.length in 17..32){
            SCOREBOARD_LINE10_SUFFIX = SCOREBOARD_LINE10.substring(16)
            SCOREBOARD_LINE10 = SCOREBOARD_LINE10.substring(0,16)
        }
        if(SCOREBOARD_LINE9.length in 17..32){
            SCOREBOARD_LINE9_SUFFIX = SCOREBOARD_LINE9.substring(16)
            SCOREBOARD_LINE9 = SCOREBOARD_LINE9.substring(0,16)
        }
        if(SCOREBOARD_LINE8.length in 17..32){
            SCOREBOARD_LINE8_SUFFIX = SCOREBOARD_LINE8.substring(16)
            SCOREBOARD_LINE8 = SCOREBOARD_LINE8.substring(0,16)
        }
        if(SCOREBOARD_LINE7.length in 17..32){
            SCOREBOARD_LINE7_SUFFIX = SCOREBOARD_LINE7.substring(16)
            SCOREBOARD_LINE7 = SCOREBOARD_LINE7.substring(0,16)
        }
        if(SCOREBOARD_LINE6.length in 17..32){
            SCOREBOARD_LINE6_SUFFIX = SCOREBOARD_LINE6.substring(16)
            SCOREBOARD_LINE6 = SCOREBOARD_LINE6.substring(0,16)
        }
        if(SCOREBOARD_LINE5.length in 17..32){
            SCOREBOARD_LINE5_SUFFIX = SCOREBOARD_LINE5.substring(16)
            SCOREBOARD_LINE5 = SCOREBOARD_LINE5.substring(0,16)
        }
        if(SCOREBOARD_LINE4.length in 17..32){
            SCOREBOARD_LINE4_SUFFIX = SCOREBOARD_LINE4.substring(16)
            SCOREBOARD_LINE4 = SCOREBOARD_LINE4.substring(0,16)
        }
        if(SCOREBOARD_LINE3.length in 17..32){
            SCOREBOARD_LINE3_SUFFIX = SCOREBOARD_LINE3.substring(16)
            SCOREBOARD_LINE3 = SCOREBOARD_LINE3.substring(0,16)
        }
        if(SCOREBOARD_LINE2.length in 17..32){
            SCOREBOARD_LINE2_SUFFIX = SCOREBOARD_LINE2.substring(16)
            SCOREBOARD_LINE2 = SCOREBOARD_LINE2.substring(0,16)
        }
        if(SCOREBOARD_LINE1.length in 17..32){
            SCOREBOARD_LINE1_SUFFIX = SCOREBOARD_LINE1.substring(16)
            SCOREBOARD_LINE1 = SCOREBOARD_LINE1.substring(0,16)
        }
    }
}