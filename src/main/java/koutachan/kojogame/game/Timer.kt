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
                    time = YamlConfiguration.loadConfiguration(SettingsFile).getInt("GameTime")
                    Bukkit.broadcastMessage(lang.MESSAGE_TELEPORT_TO_LOBBY5.replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString()))
                    GameState = ENDING
                    cancel()
                    Bukkit.getScheduler().runTaskLater(KojoGame.plugin, {
                        GameState = LOBBY
                        Bukkit.broadcastMessage(lang.MESSAGE_TELEPORT_TO_LOBBY.replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString()))
                    },20 * 5)
                }
            }
        }.runTaskTimer(KojoGame.plugin, 20, 20)
    }
}