package koutachan.kojogame.runTask

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.langMessage.lang.config
import koutachan.kojogame.playerdata
import koutachan.kojogame.starttime
import koutachan.kojogame.time
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot

object ScoreBoard {

    fun ScoreBoard(player: Player) {
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        val p = scoreboard.registerNewObjective(lang.TITLE_SCOREBOARD.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"), "dummy")

        p.getScore("§9").score = 10
        p.getScore("§8").score = 9
        p.getScore("§7").score = 8
        p.getScore("§6").score = 7
        p.getScore("§5").score = 6
        p.getScore("§4").score = 5
        p.getScore("§3").score = 4
        p.getScore("§2").score = 3
        p.getScore("§1").score = 2
        p.getScore("§0").score = 1

        scoreboard?.registerNewTeam("line10")
        scoreboard.getTeam("line10").addEntry("§9")

        scoreboard?.registerNewTeam("line9")
        scoreboard.getTeam("line9").addEntry("§8")

        scoreboard?.registerNewTeam("line8")
        scoreboard.getTeam("line8").addEntry("§7")

        scoreboard?.registerNewTeam("line7")
        scoreboard.getTeam("line7").addEntry("§6")

        scoreboard?.registerNewTeam("line6")
        scoreboard.getTeam("line6").addEntry("§5")

        scoreboard?.registerNewTeam("line5")
        scoreboard.getTeam("line5").addEntry("§4")

        scoreboard?.registerNewTeam("line4")
        scoreboard.getTeam("line4").addEntry("§3")

        scoreboard?.registerNewTeam("line3")
        scoreboard.getTeam("line3").addEntry("§2")

        scoreboard?.registerNewTeam("line2")
        scoreboard.getTeam("line2").addEntry("§1")

        scoreboard?.registerNewTeam("line1")
        scoreboard.getTeam("line1").addEntry("§0")

        p.displaySlot = DisplaySlot.SIDEBAR

        var red = scoreboard.getTeam("Red")
        if (red == null) {
            red = scoreboard.registerNewTeam("Red")
        }
        red.prefix = "§c"
        red.setAllowFriendlyFire(false)

        var blue = scoreboard.getTeam("Blue")
        if (blue == null) {
            blue = scoreboard.registerNewTeam("Blue")
        }
        blue.prefix = "§9"
        blue.setAllowFriendlyFire(false)


        player.scoreboard = scoreboard

    }


    @Suppress("DEPRECATION")
    fun ScoreBoardUpdate(){
        Bukkit.getScheduler().runTaskTimer(plugin, {
            for (player in Bukkit.getOnlinePlayers()) {
                player.scoreboard.getTeam("line1").prefix = lang.SCOREBOARD_LINE1.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line2").prefix = lang.SCOREBOARD_LINE2.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line3").prefix = lang.SCOREBOARD_LINE3.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line4").prefix = lang.SCOREBOARD_LINE4.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line5").prefix = lang.SCOREBOARD_LINE5.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line6").prefix = lang.SCOREBOARD_LINE6.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line7").prefix = lang.SCOREBOARD_LINE7.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line8").prefix = lang.SCOREBOARD_LINE8.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line9").prefix = lang.SCOREBOARD_LINE9.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")
                player.scoreboard.getTeam("line10").prefix = lang.SCOREBOARD_LINE10.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time")

                for (addteam in Bukkit.getOnlinePlayers()) {
                    if (playerdata[addteam.uniqueId]?.team == "Red") {
                        player.scoreboard.getTeam("Red").addPlayer(addteam)
                    }
                    if (playerdata[addteam.uniqueId]?.team == "Blue") {
                        player.scoreboard.getTeam("Blue").addPlayer(addteam)
                    }
                    if (playerdata[addteam.uniqueId]?.team == "Default") {
                        player.scoreboard.getTeam("Red")?.removeEntry(addteam.name)
                        player.scoreboard.getTeam("Blue")?.removeEntry(addteam.name)
                    }
                }
            }
        },0,0)
    }
}