package koutachan.kojogame

import koutachan.kojogame.runTask.ScoreBoard
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object Event : Listener {
    @EventHandler
    fun PlayerJoinEvent(e: PlayerJoinEvent) {
        e.setJoinMessage("")
        ScoreBoard.ScoreBoard(e.player)
        /*TODO: Adding Team*/
    }
}