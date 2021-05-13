package koutachan.kojogame.runTask

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.langMessage.lang.config
import koutachan.kojogame.playerdata
import koutachan.kojogame.starttime
import koutachan.kojogame.time
import koutachan.kojogame.game.GameState.*
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot
import kotlin.random.Random

object ScoreBoard {

    fun ScoreBoard(player: Player) {
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        val p = scoreboard.registerNewObjective(lang.TITLE_SCOREBOARD.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"), "dummy")

        p.getScore("§９").score = 10
        p.getScore("§８").score = 9
        p.getScore("§７").score = 8
        p.getScore("§６").score = 7
        p.getScore("§５").score = 6
        p.getScore("§４").score = 5
        p.getScore("§３").score = 4
        p.getScore("§２").score = 3
        p.getScore("§１").score = 2
        p.getScore("§０").score = 1

        scoreboard?.registerNewTeam("line10")
        scoreboard.getTeam("line10").addEntry("§９")

        scoreboard?.registerNewTeam("line9")
        scoreboard.getTeam("line9").addEntry("§８")

        scoreboard?.registerNewTeam("line8")
        scoreboard.getTeam("line8").addEntry("§７")

        scoreboard?.registerNewTeam("line7")
        scoreboard.getTeam("line7").addEntry("§６")

        scoreboard?.registerNewTeam("line6")
        scoreboard.getTeam("line6").addEntry("§５")

        scoreboard?.registerNewTeam("line5")
        scoreboard.getTeam("line5").addEntry("§４")

        scoreboard?.registerNewTeam("line4")
        scoreboard.getTeam("line4").addEntry("§３")

        scoreboard?.registerNewTeam("line3")
        scoreboard.getTeam("line3").addEntry("§２")

        scoreboard?.registerNewTeam("line2")
        scoreboard.getTeam("line2").addEntry("§１")

        scoreboard?.registerNewTeam("line1")
        scoreboard.getTeam("line1").addEntry("§０")

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
                player.scoreboard.getTeam("line1").prefix = lang.SCOREBOARD_LINE1.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line2").prefix = lang.SCOREBOARD_LINE2.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line3").prefix = lang.SCOREBOARD_LINE3.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line4").prefix = lang.SCOREBOARD_LINE4.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line5").prefix = lang.SCOREBOARD_LINE5.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line6").prefix = lang.SCOREBOARD_LINE6.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line7").prefix = lang.SCOREBOARD_LINE7.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line8").prefix = lang.SCOREBOARD_LINE8.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line9").prefix = lang.SCOREBOARD_LINE9.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line10").prefix = lang.SCOREBOARD_LINE10.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)

                player.scoreboard.getTeam("line1").suffix = lang.SCOREBOARD_LINE1_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line2").suffix = lang.SCOREBOARD_LINE2_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line3").suffix = lang.SCOREBOARD_LINE3_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line4").suffix = lang.SCOREBOARD_LINE4_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line5").suffix = lang.SCOREBOARD_LINE5_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line6").suffix = lang.SCOREBOARD_LINE6_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line7").suffix = lang.SCOREBOARD_LINE7_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line8").suffix = lang.SCOREBOARD_LINE8_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line9").suffix = lang.SCOREBOARD_LINE9_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)
                player.scoreboard.getTeam("line10").suffix = lang.SCOREBOARD_LINE10_SUFFIX.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name)

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