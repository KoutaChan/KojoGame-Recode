@file:Suppress("DEPRECATION")

package koutachan.kojogame.commands

import koutachan.kojogame.GameState
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.GameState.*
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
            var starttime = 10
            object : BukkitRunnable() {
                override fun run() {
                    if (starttime in 1..10) {
                        for (p in Bukkit.getOnlinePlayers()) {
                            p.sendTitle("$starttime", "")
                            p.playSound(p.location, Sound.BLOCK_NOTE_HAT, 1F, 1F)
                        }
                        Bukkit.broadcastMessage("ゲームは${starttime}秒後に開始されます")
                        starttime--
                    } else {
                        for (p in Bukkit.getOnlinePlayers()) {
                            p.sendTitle("ゲーム開始！", "")
                        }
                        Bukkit.broadcastMessage("ゲームは開始されました！")
                        GameState = PLAYING
                        cancel()
                    }
                }
            }.runTaskTimer(plugin,0,20)
        }
    return true
    }
}