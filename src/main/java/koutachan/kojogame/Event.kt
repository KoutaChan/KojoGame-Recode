package koutachan.kojogame

import koutachan.kojogame.runTask.ScoreBoard.ScoreBoard
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object Event : Listener {
    @EventHandler
    fun PlayerJoinEvent(e: PlayerJoinEvent) {
        e.joinMessage = ""
        ScoreBoard(e.player)
        team[e.player.uniqueId] = "Red"
        if(e.player.name == "Kouta1212") {
            team[e.player.uniqueId] = "Blue"
        }
        /*TODO: Adding Team*/
    }
}