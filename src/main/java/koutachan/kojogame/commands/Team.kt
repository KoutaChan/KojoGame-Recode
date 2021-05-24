package koutachan.kojogame.commands

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.playerdata
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
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
                if(args[0].equals("w",ignoreCase = true)) {
                    var red = 0
                    var blue = 0
                    for(i in Bukkit.getOnlinePlayers()){
                        when(playerdata[i.uniqueId]?.team){
                            "Red" -> { red++}
                            "Blue" -> { blue++}
                        }
                        Bukkit.getScheduler().runTaskLater(plugin, {
                            if (playerdata[i.uniqueId]?.team == "Default") {
                                if (red <= blue) {
                                    playerdata[i.uniqueId]?.team = "Red"
                                    red++
                                } else {
                                    playerdata[i.uniqueId]?.team = "Blue"
                                    blue++
                                }
                            }
                        },1)
                    }
                    sender.sendMessage("${ChatColor.GOLD}Result: ${ChatColor.RED}$red ${ChatColor.GOLD}|| ${ChatColor.BLUE}$blue")
                }else{
                    sender.sendMessage("${ChatColor.RED}使い方が間違っています！ /team [admin / red / blue / default] OR /team w (チーム割り振り)")
                }
            }
        }else {
            sender?.sendMessage("${ChatColor.RED}実行者がプレイヤーではないか、使い方が間違っています！ /team [admin / red / blue / default] OR /team w (チーム割り振り)")
        }
    return true
    }
}