package koutachan.kojogame.commands

import koutachan.kojogame.playerdata
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object KojoList : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        var All = 0
        var Red = 0
        var Blue = 0
        for (list in Bukkit.getOnlinePlayers()) {
            All++
            when(playerdata[list.uniqueId]?.team){
                "Red" -> {Red++}
                "Blue" -> {Blue++}
            }
        }
        sender?.sendMessage("§m---------------------------------------")
        sender?.sendMessage("現在のオンラインプレイヤー: $All")
        sender?.sendMessage("§c現在のオンラインプレイヤー(赤): $Red")
        sender?.sendMessage("§9現在のオンラインプレイヤー(青): $Blue")
        sender?.sendMessage("§m---------------------------------------")
    return true
    }
}