package koutachan.kojogame.runTask

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.playerdata
import koutachan.kojogame.time
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.DisplaySlot

object ScoreBoard {

    fun ScoreBoard(player: Player) {
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        val p = scoreboard.registerNewObjective(player.name, "dummy")

        p.getScore("§b").score = 10
        p.getScore("").score = 9
        var state = scoreboard.getTeam("State")
        if (state == null) {
            state = scoreboard.registerNewTeam("State")
        }
        state.addEntry("")

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
                player.scoreboard.getTeam("State").prefix = " §cステータス: $GameState".replace("LOBBY", "ゲーム待機中").replace("STARTING", "ゲーム開始中").replace("ステータス: PLAYING", "残り時間: $time 秒").replace("ENDING", "ゲーム終了")

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