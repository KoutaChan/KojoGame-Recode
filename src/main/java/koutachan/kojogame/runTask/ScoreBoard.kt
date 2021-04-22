package koutachan.kojogame.runTask

import koutachan.kojogame.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scoreboard.DisplaySlot


object ScoreBoard {
    fun ScoreBoard(player: Player) {
        object : BukkitRunnable() {
            override fun run() {
                if (!player.isOnline) {
                    cancel()
                }
                //PlayerBoard
                val scoreboard = Bukkit.getScoreboardManager().getNewScoreboard()
                val p = scoreboard.registerNewObjective(player.name, "dummy")
                p.setDisplaySlot(DisplaySlot.SIDEBAR)
                p.getScore("${player.getHealth()}").setScore(10)
                player.setScoreboard(scoreboard)
            }
        }.runTaskTimer(plugin, 0, 1)
    }
}