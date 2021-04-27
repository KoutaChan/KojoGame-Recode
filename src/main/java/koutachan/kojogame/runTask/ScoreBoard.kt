package koutachan.kojogame.runTask

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.Team
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
                    if (!player.isOnline) {
                        cancel()
                    }
                    //PlayerBoard
                    scoreboard.getObjective(player.name)?.unregister()
                    val p = scoreboard.registerNewObjective(player.name, "dummy")
                    p.displaySlot = DisplaySlot.SIDEBAR
                    p.getScore("${player.health}").score = 10

                    scoreboard.getTeam(player.name)?.unregister() //DESTROY
                    var team = scoreboard.getTeam(player.name)
                    if (team == null) {
                        team = scoreboard.registerNewTeam(player.name)
                    }
                    team.prefix = "§c"
                    team.setAllowFriendlyFire(false)
                    team.addEntry(player.name)
                    for (addteam in Bukkit.getOnlinePlayers()) {
                        team.addEntry(addteam.name)
                    }
                    player.scoreboard = scoreboard
                }
            }.runTaskTimer(plugin, 0, 10)
        }
    //}
}


//                    var red = scoreboard.getTeam("Red")
//                    if(red == null) {
//                        red = scoreboard.registerNewTeam("Red")
//                    }
//                    //team.put(player.uniqueId,red.toString())
//                    red.addEntry(player.name)
//                    red.prefix = "§c"