package koutachan.kojogame.commands

import koutachan.kojogame.KojoGame.Companion.plugin
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object SetSpawn : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (args?.isNotEmpty()!! && sender is Player) {
            if (args[0].equals("red", ignoreCase = true)) {
                plugin.config.set("red.world",sender.world.name)
                plugin.config.set("red.x",sender.location.x)
                plugin.config.set("red.y",sender.location.y)
                plugin.config.set("red.z",sender.location.z)
                plugin.config.set("red.yaw",sender.location.yaw)
                plugin.config.set("red.pitch",sender.location.pitch)
                plugin.saveConfig()
            } else {
                if (args[0].equals("blue", ignoreCase = true)) {
                    plugin.config.set("blue.world",sender.world.name)
                    plugin.config.set("blue.x",sender.location.x)
                    plugin.config.set("blue.y",sender.location.y)
                    plugin.config.set("blue.z",sender.location.z)
                    plugin.config.set("blue.yaw",sender.location.yaw)
                    plugin.config.set("blue.pitch",sender.location.pitch)
                    plugin.saveConfig()
                } else {
                    if (args[0].equals("lobby", ignoreCase = true)) {
                        plugin.config.set("lobby.world",sender.world.name)
                        plugin.config.set("lobby.x",sender.location.x)
                        plugin.config.set("lobby.y",sender.location.y)
                        plugin.config.set("lobby.z",sender.location.z)
                        plugin.config.set("lobby.yaw",sender.location.yaw)
                        plugin.config.set("lobby.pitch",sender.location.pitch)
                        plugin.saveConfig()
                    } else {
                        sender.sendMessage("§c使い方が間違っています！ /setspawn [red / blue / lobby]")
                    }
                }
            }
        }else {
            sender?.sendMessage("§c実行者がプレイヤーではないか、使い方が間違っています！ /setspawn [red / blue / lobby]")
        }
    return true
    }
}