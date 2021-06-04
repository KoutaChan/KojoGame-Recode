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
        var all = 0
        var red = 0
        var blue = 0
        for (list in Bukkit.getOnlinePlayers()) {
            all++
            when(playerdata[list.uniqueId]?.team){
                "Red" -> {red++}
                "Blue" -> {blue++}
            }
        }
        sender?.sendMessage("§m---------------------------------------")
        sender?.sendMessage("現在のオンラインプレイヤー: $all")
        sender?.sendMessage("§c現在のオンラインプレイヤー(赤): $red")
        sender?.sendMessage("§9現在のオンラインプレイヤー(青): $blue")
        sender?.sendMessage("§m---------------------------------------")
    return true
    }
}