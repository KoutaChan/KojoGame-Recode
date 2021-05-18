package koutachan.kojogame.game

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame
import koutachan.kojogame.game.GameEnd.gameend
import koutachan.kojogame.game.GameState.PLAYING
import koutachan.kojogame.time
import org.bukkit.scheduler.BukkitRunnable

object Timer {
    fun Timer() {
        object : BukkitRunnable() {
            override fun run() {
                if (GameState != PLAYING){
                    cancel()
                }
                time--
                if (time <= 0) {
                    gameend()
                    cancel()
                }
            }
        }.runTaskTimer(KojoGame.plugin, 20, 20)
    }
}