package koutachan.kojogame.runTask

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.playerdata
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot



object ScoreBoard {


    fun ScoreBoardTimer(){
        Bukkit.getScheduler().runTaskTimer(plugin, {
            for (player in Bukkit.getOnlinePlayers()) {
                ScoreBoard(player)
            }
        },0,10)
    }

    fun ScoreBoard(player: Player) {
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        scoreboard.getObjective(player.name)?.unregister()
        val p = scoreboard.registerNewObjective(player.name, "dummy")
        p.displaySlot = DisplaySlot.SIDEBAR
        p.getScore("").score = 10
        p.getScore(" §cステータス: ${GameState.toString().replace("LOBBY", "ゲーム待機中").replace("STARTING", "ゲーム開始中").replace("PLAYING", "ゲームプレイ中").replace("ENDING", "ゲーム終了")}").score = 9
        //p.getScore("${player.health}").score = 10

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


        for (addteam in Bukkit.getOnlinePlayers()) {
            if (playerdata[addteam.uniqueId]?.team == "Red") {
                red.addEntry(addteam.name)
            }
            if (playerdata[addteam.uniqueId]?.team == "Blue") {
                blue.addEntry(addteam.name)
            }
            if (playerdata[addteam.uniqueId]?.team == "Default") {
                red?.removeEntry(addteam.name)
                blue?.removeEntry(addteam.name)
            }
        }
        player.scoreboard = scoreboard
    }
}