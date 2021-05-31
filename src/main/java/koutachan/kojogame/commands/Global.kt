package koutachan.kojogame.commands

import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.langMessage.lang.config
import koutachan.kojogame.playerdata
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

private val Command = config.getBoolean("GlobalCommand")

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
                    teamname = "${config.get("RED_CHAT_PREFIX")}"
                }
                "Blue" -> {
                    teamname = "${config.get("BLUE_CHAT_PREFIX")}"
                }
                "Admin" -> {
                    teamname = "${config.get("ADMIN_CHAT_PREFIX")}"
                }
            }
            if(Command) {
                val message: StringBuilder = java.lang.StringBuilder()
                args.forEach{ i ->
                    message.append("$i ")
                }
                Bukkit.broadcastMessage("${lang.GLOBAL_CHAT_PREFIX} $teamname${sender.name}: §r$message")
            }else {
                Bukkit.broadcastMessage("${lang.GLOBAL_CHAT_PREFIX} $teamname${sender.name}: §r${args[0]}")
            }
        }
    return true
    }
}
