package koutachan.kojogame.commands

import koutachan.kojogame.playerdata
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object debug : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (args?.isNotEmpty()!!) {
            val player = sender as Player
            if (args[0] == "0") {
                playerdata[player.uniqueId]?.team = "Red"
                player.sendMessage(":ok_hand:")
            } else {
                if (args[0] == "1") {
                    playerdata[player.uniqueId]?.team = "Blue"
                    player.sendMessage(":ok_hand:")
                } else {
                    if (args[0] == "2") {
                        playerdata[player.uniqueId]?.team = "Default"
                        player.sendMessage(":ok_hand:")
                    } else {
                        if (args[0] == "3") {
                            var int = 0
                            for (test in Bukkit.getOnlinePlayers()) {
                                int++
                            }
                            sender.sendMessage("$int")
                        } else {
                            if (args[0] == "4") {
                                playerdata[player.uniqueId]?.team = "Admin"
                                player.sendMessage(":ok_hand:")
                            }
                        }
                    }
                }
            }
        }
    return true}
}