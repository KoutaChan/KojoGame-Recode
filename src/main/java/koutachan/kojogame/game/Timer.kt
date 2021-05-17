package koutachan.kojogame.game

import koutachan.kojogame.*
import koutachan.kojogame.game.GameState.*
import koutachan.kojogame.langMessage.lang
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.scheduler.BukkitRunnable

object Timer {
    fun Timer() {
        object : BukkitRunnable() {
            override fun run() {
                time--
                if (time <= 0) {
                    GameEnd.GameEnd()
                    cancel()
                }
            }
        }.runTaskTimer(KojoGame.plugin, 20, 20)
    }
}