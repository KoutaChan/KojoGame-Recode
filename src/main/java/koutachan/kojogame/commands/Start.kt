@file:Suppress("DEPRECATION")

package koutachan.kojogame.commands

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
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
            starttime = 10
            object : BukkitRunnable() {
                override fun run() {
                    if (starttime in 1..10) {
                        for (p in Bukkit.getOnlinePlayers()) {
                            p.sendTitle(lang.TITLE_STARTING_COUNT.replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString()), "")
                            p.playSound(p.location, Sound.BLOCK_NOTE_HAT, 1F, 1F)
                        }
                        Bukkit.broadcastMessage(lang.MESSAGE_STARTING_COUNT.replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString()))
                        starttime--
                    } else {
                        for (p in Bukkit.getOnlinePlayers()) {
                            p.sendTitle(lang.TITLE_START.replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString()), "")
                        }
                        Bukkit.broadcastMessage(lang.MESSAGE_START.replace("@start","$starttime").replace("@time","$time").replace("@state", GameState.toString()))
                        GameState = PLAYING
                        Timer()
                        cancel()
                    }
                }
            }.runTaskTimer(plugin,0,20)
        }
    return true
    }
}