package koutachan.kojogame.commands

import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.playerdata
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Global : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (sender is Player && args?.isNotEmpty()!!) {
            var teamname = ""
            when (playerdata[sender.uniqueId]?.team) {
                "Red" -> {
                    teamname = "${lang.config.get("RED_CHAT_PREFIX")}"
                }
                "Blue" -> {
                    teamname = "${lang.config.get("BLUE_CHAT_PREFIX")}"
                }
                "Admin" -> {
                    teamname = "${lang.config.get("ADMIN_CHAT_PREFIX")}"
                }
            }
            Bukkit.broadcastMessage("§5[Global] $teamname${sender.name}: §r${args[0]}")
        }
    return true
    }
}