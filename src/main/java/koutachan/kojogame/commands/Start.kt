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
                    for (p in Bukkit.getOnlinePlayers()) {
                        if (starttime < 1) {
                            Bukkit.broadcastMessage("ゲームは開始されました！")
                            p.sendTitle("ゲーム開始！", "")
                            GameState = PLAYING
                            cancel()
                        }
                        if (starttime in 1..10) {
                            p.sendTitle("$starttime", "")
                            Bukkit.broadcastMessage("ゲームは${starttime}秒後に開始されます")
                            p.playSound(p.location, Sound.BLOCK_NOTE_HAT, 1F, 1F)
                            starttime--
                        }
                    }
                }
            }.runTaskTimer(plugin,0,20)
        }
    return true
    }
}