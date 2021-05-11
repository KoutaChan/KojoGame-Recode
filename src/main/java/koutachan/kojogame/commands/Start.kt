@file:Suppress("DEPRECATION")

package koutachan.kojogame.commands

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.SettingsFile
import koutachan.kojogame.game.GameState.*
import koutachan.kojogame.game.Timer.Timer
import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.starttime
import koutachan.kojogame.time
import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.scheduler.BukkitRunnable


object Start : CommandExecutor{
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if(GameState == LOBBY){
            GameState = STARTING
            starttime = YamlConfiguration.loadConfiguration(SettingsFile).getInt("StartTime") + 1
            object : BukkitRunnable() {
                override fun run() {
                    if (starttime >= 2) {
                        starttime--
                        for (p in Bukkit.getOnlinePlayers()) {
                            p.sendTitle(lang.TITLE_STARTING_COUNT.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"), "")
                            p.playSound(p.location, Sound.BLOCK_NOTE_HAT, 1F, 1F)
                        }
                        Bukkit.broadcastMessage(lang.MESSAGE_STARTING_COUNT.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"))
                    } else {
                        for (p in Bukkit.getOnlinePlayers()) {
                            p.sendTitle(lang.TITLE_START.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"), "")
                        }
                        Bukkit.broadcastMessage(lang.MESSAGE_START.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"))
                        GameState = PLAYING
                        starttime--
                        Timer()
                        cancel()
                    }
                }
            }.runTaskTimer(plugin,0,20)
        }
    return true
    }
}