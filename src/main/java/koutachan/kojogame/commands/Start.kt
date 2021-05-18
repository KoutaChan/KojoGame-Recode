@file:Suppress("DEPRECATION")

package koutachan.kojogame.commands

import koutachan.kojogame.*
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.GameState.*
import koutachan.kojogame.game.ResetSponge
import koutachan.kojogame.game.Timer.Timer
import koutachan.kojogame.langMessage.lang
import org.bukkit.Bukkit
import org.bukkit.Location
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
                            when(playerdata[p.uniqueId]?.team) {
                                "Red" -> {
                                    p.teleport(Location(Bukkit.getWorld("${plugin.config.get("red.world")}"),
                                    plugin.config.getDouble("red.x"),
                                    plugin.config.getDouble("red.y"),
                                    plugin.config.getDouble("red.z"),
                                    plugin.config.getDouble("red.yaw").toFloat(),
                                    plugin.config.getDouble("red.pitch").toFloat()))
                                }
                                "Blue" -> {
                                    p.teleport(Location(Bukkit.getWorld("${plugin.config.get("blue.world")}"),
                                    plugin.config.getDouble("blue.x"),
                                    plugin.config.getDouble("blue.y"),
                                    plugin.config.getDouble("blue.z"),
                                    plugin.config.getDouble("blue.yaw").toFloat(),
                                    plugin.config.getDouble("blue.pitch").toFloat()))
                                }
                            }
                        }
                        ResetSponge.ResetSponge()
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