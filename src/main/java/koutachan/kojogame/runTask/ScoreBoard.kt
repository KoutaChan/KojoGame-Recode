package koutachan.kojogame.runTask

import koutachan.kojogame.*
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.langMessage.lang.config
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot
import kotlin.random.Random

object ScoreBoard {

    fun ScoreBoard(player: Player) {
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        val p = scoreboard.registerNewObjective("KojoGame", "dummy")

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

                player.scoreboard.getObjective(DisplaySlot.SIDEBAR).displayName = lang.TITLE_SCOREBOARD.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")

                lang.SCOREBOARD_LINE10 = config.get("SCOREBOARD_LINE10").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE9 = config.get("SCOREBOARD_LINE9").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE8 = config.get("SCOREBOARD_LINE8").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE7 = config.get("SCOREBOARD_LINE7").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE6 = config.get("SCOREBOARD_LINE6").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE5 = config.get("SCOREBOARD_LINE5").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE4 = config.get("SCOREBOARD_LINE4").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE3 = config.get("SCOREBOARD_LINE3").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE3 = config.get("SCOREBOARD_LINE3").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE2 = config.get("SCOREBOARD_LINE2").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")
                lang.SCOREBOARD_LINE1 = config.get("SCOREBOARD_LINE1").toString().replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem")

                lang.LengthCheck()

                player.scoreboard.getTeam("line1").prefix = lang.SCOREBOARD_LINE1
                player.scoreboard.getTeam("line2").prefix = lang.SCOREBOARD_LINE2
                player.scoreboard.getTeam("line3").prefix = lang.SCOREBOARD_LINE3
                player.scoreboard.getTeam("line4").prefix = lang.SCOREBOARD_LINE4
                player.scoreboard.getTeam("line5").prefix = lang.SCOREBOARD_LINE5
                player.scoreboard.getTeam("line6").prefix = lang.SCOREBOARD_LINE6
                player.scoreboard.getTeam("line7").prefix = lang.SCOREBOARD_LINE7
                player.scoreboard.getTeam("line8").prefix = lang.SCOREBOARD_LINE8
                player.scoreboard.getTeam("line9").prefix = lang.SCOREBOARD_LINE9
                player.scoreboard.getTeam("line10").prefix = lang.SCOREBOARD_LINE10


                player.scoreboard.getTeam("line1").suffix = lang.SCOREBOARD_LINE1_SUFFIX
                player.scoreboard.getTeam("line2").suffix = lang.SCOREBOARD_LINE2_SUFFIX
                player.scoreboard.getTeam("line3").suffix = lang.SCOREBOARD_LINE3_SUFFIX
                player.scoreboard.getTeam("line4").suffix = lang.SCOREBOARD_LINE4_SUFFIX
                player.scoreboard.getTeam("line5").suffix = lang.SCOREBOARD_LINE5_SUFFIX
                player.scoreboard.getTeam("line6").suffix = lang.SCOREBOARD_LINE6_SUFFIX
                player.scoreboard.getTeam("line7").suffix = lang.SCOREBOARD_LINE7_SUFFIX
                player.scoreboard.getTeam("line8").suffix = lang.SCOREBOARD_LINE8_SUFFIX
                player.scoreboard.getTeam("line9").suffix = lang.SCOREBOARD_LINE9_SUFFIX
                player.scoreboard.getTeam("line10").suffix = lang.SCOREBOARD_LINE10_SUFFIX

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