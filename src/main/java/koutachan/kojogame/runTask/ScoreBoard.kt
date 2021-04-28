package koutachan.kojogame.runTask

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.team
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import org.bukkit.scoreboard.DisplaySlot




object ScoreBoard {
    fun ScoreBoard(player: Player) {
        val scoreboard = Bukkit.getScoreboardManager().newScoreboard
        object : BukkitRunnable() {
            override fun run() {
                //PlayerBoard
                if(!player.isOnline){
                    cancel()
                }
                scoreboard.getObjective(player.name)?.unregister()
                val p = scoreboard.registerNewObjective(player.name, "dummy")
                p.displaySlot = DisplaySlot.SIDEBAR
                p.getScore("${player.health}").score = 10

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
                    if (team[addteam.uniqueId] == "Red") {
                        red.addEntry(addteam.name)
                    }
                    if (team[addteam.uniqueId] == "Blue") {
                        blue.addEntry(addteam.name)
                    }
                }
                player.scoreboard = scoreboard
            }
        }.runTaskTimer(plugin, 0, 10)
    }
}