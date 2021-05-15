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
                    Bukkit.broadcastMessage(lang.MESSAGE_TELEPORT_TO_LOBBY5.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"))
                    GameState = ENDING
                    cancel()
                    Bukkit.getScheduler().runTaskLater(KojoGame.plugin, {
                        GameState = LOBBY
                        Bukkit.broadcastMessage(lang.MESSAGE_TELEPORT_TO_LOBBY.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"))
                        GameEnd.GameEnd()
                    },20 * 5)
                }
            }
        }.runTaskTimer(KojoGame.plugin, 20, 20)
    }
}