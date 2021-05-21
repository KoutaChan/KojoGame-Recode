package koutachan.kojogame.commands

import koutachan.kojogame.playerdata
import net.md_5.bungee.api.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Team : CommandExecutor{
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if(sender is Player && args?.isNotEmpty()!!) {
            if (args[0].equals("admin",ignoreCase = true) || args[0].equals("red",ignoreCase = true) || args[0].equals("blue",ignoreCase = true) || args[0].equals("default",ignoreCase = true)){
                val team = args[0].substring(0,1).toUpperCase() + args[0].substring(1).toLowerCase()
                playerdata[sender.uniqueId]?.team = team
                sender.sendMessage("${ChatColor.AQUA}あなたのチームは $team に設定されました")
            }else {
                sender.sendMessage("${ChatColor.RED}使い方が間違っています！ /team [admin / red / blue / default]")
            }
        }else {
            sender?.sendMessage("${ChatColor.RED}実行者がプレイヤーではないか、使い方が間違っています！ /team [admin / red / blue / default]")
        }
    return true
    }
}