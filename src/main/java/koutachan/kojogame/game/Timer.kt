package koutachan.kojogame.game

import koutachan.kojogame.KojoGame
import koutachan.kojogame.SettingsFile
import koutachan.kojogame.time
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.scheduler.BukkitRunnable

object Timer {
    fun Timer() {
        object : BukkitRunnable() {
            override fun run() {
                if (time <= 0) {
                    time = YamlConfiguration.loadConfiguration(SettingsFile).getInt("GameTime")
                    cancel()
                }
                time--
            }
        }.runTaskTimer(KojoGame.plugin, 20, 20)
    }
}