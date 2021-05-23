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

    fun scoreboard(player: Player) {
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

        var default = scoreboard.getTeam("S_Default")
        if (default == null){
            default = scoreboard.registerNewTeam("S_Default")
        }
        default.prefix = "${config.get("DEFAULT_PREFIX")}"
        default.setAllowFriendlyFire(false)


        var red = scoreboard.getTeam("Red")
        if (red == null) {
            red = scoreboard.registerNewTeam("Red")
        }
        red.prefix = "${config.get("RED_PREFIX")}"
        red.setAllowFriendlyFire(false)

        var blue = scoreboard.getTeam("Blue")
        if (blue == null) {
            blue = scoreboard.registerNewTeam("Blue")
        }
        blue.prefix = "${config.get("BLUE_PREFIX")}"
        blue.setAllowFriendlyFire(false)

        var admin = scoreboard.getTeam("Admin")
        if (admin == null) {
            admin = scoreboard.registerNewTeam("Admin")
        }
        admin.prefix = "${config.get("ADMIN_PREFIX")}"
        admin.setAllowFriendlyFire(false)

        player.scoreboard = scoreboard

    }


    @Suppress("DEPRECATION")
    fun scoreboardupdate(){
        Bukkit.getScheduler().runTaskTimer(plugin, {
            val line1 = lang.lengthcheck(config.getString("SCOREBOARD_LINE1").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line2 = lang.lengthcheck(config.getString("SCOREBOARD_LINE2").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line3 = lang.lengthcheck(config.getString("SCOREBOARD_LINE3").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line4 = lang.lengthcheck(config.getString("SCOREBOARD_LINE4").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line5 = lang.lengthcheck(config.getString("SCOREBOARD_LINE5").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line6 = lang.lengthcheck(config.getString("SCOREBOARD_LINE6").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line7 = lang.lengthcheck(config.getString("SCOREBOARD_LINE7").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line8 = lang.lengthcheck(config.getString("SCOREBOARD_LINE8").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line9 = lang.lengthcheck(config.getString("SCOREBOARD_LINE9").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))
            val line10 = lang.lengthcheck(config.getString("SCOREBOARD_LINE10").replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}")))

            for (player in Bukkit.getOnlinePlayers()) {

                if (!playerdata.containsKey(player.uniqueId)) {
                    playerdata[player.uniqueId] = PlayerData()
                }

                player.scoreboard.getObjective("KojoGame").displayName = lang.TITLE_SCOREBOARD.replace("@state", GameState.toString().replace("LOBBY","${config.get("GAMESTATE_LOBBY")}").replace("STARTING","${config.get("GAMESTATE_STARTING")}").replace("PLAYING","${config.get("GAMESTATE_PLAYING")}").replace("ENDING","${config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time").replace("@randomint","${Random.nextInt(100000)}").replace("@playername",player.name).replace("@usedmem","${(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1048576}").replace("@maxmem", "$maxmem").replace("@irons","$SpongeIron".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_IRON_FALSE")}")).replace("@golds","$SpongeGold".replace("true","${config.get("SCOREBOARD_IRON_TRUE")}").replace("false","${config.get("SCOREBOARD_GOLD_FALSE")}")).replace("@diamonds","$SpongeDiamond".replace("true","${config.get("SCOREBOARD_DIAMOND_TRUE")}").replace("false","${config.get("SCOREBOARD_DIAMOND_FALSE")}"))

                player.scoreboard.getTeam("line1").prefix = line1[0]
                player.scoreboard.getTeam("line2").prefix = line2[0]
                player.scoreboard.getTeam("line3").prefix = line3[0]
                player.scoreboard.getTeam("line4").prefix = line4[0]
                player.scoreboard.getTeam("line5").prefix = line5[0]
                player.scoreboard.getTeam("line6").prefix = line6[0]
                player.scoreboard.getTeam("line7").prefix = line7[0]
                player.scoreboard.getTeam("line8").prefix = line8[0]
                player.scoreboard.getTeam("line9").prefix = line9[0]
                player.scoreboard.getTeam("line10").prefix = line10[0]


                player.scoreboard.getTeam("line1").suffix = line1[1]
                player.scoreboard.getTeam("line2").suffix = line2[1]
                player.scoreboard.getTeam("line3").suffix = line3[1]
                player.scoreboard.getTeam("line4").suffix = line4[1]
                player.scoreboard.getTeam("line5").suffix = line5[1]
                player.scoreboard.getTeam("line6").suffix = line6[1]
                player.scoreboard.getTeam("line7").suffix = line7[1]
                player.scoreboard.getTeam("line8").suffix = line8[1]
                player.scoreboard.getTeam("line9").suffix = line9[1]
                player.scoreboard.getTeam("line10").suffix = line10[1]

                for (addteam in Bukkit.getOnlinePlayers()) {
                    when(playerdata[addteam.uniqueId]?.team){
                        "Red" -> {player.scoreboard.getTeam("Red").addPlayer(addteam)}
                        "Blue" -> {player.scoreboard.getTeam("Blue").addPlayer(addteam)}
                        "Admin" -> {player.scoreboard.getTeam("Admin").addPlayer(addteam)}
                        "Default" -> {player.scoreboard.getTeam("S_Default").addPlayer(addteam)}
                    }
                }
            }
        },0,0)
    }
}