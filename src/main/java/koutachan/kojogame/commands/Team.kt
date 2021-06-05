package koutachan.kojogame.commands

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
                    for(i in Bukkit.getOnlinePlayers()) {
                        if (playerdata[i.uniqueId]?.team == "Default") {
                            if (sender.scoreboard.getTeam("Red").size == sender.scoreboard.getTeam("Blue").size) {
                                when ((1..10).random()) {
                                    in 1..5 -> {
                                        sender.scoreboard.getTeam("Red").addEntry(i.name) //hashmapだと入るまでに時間がかかるから即座に入れる
                                        playerdata[i.uniqueId]?.team = "Red"
                                    }
                                    in 6..10 -> {
                                        sender.scoreboard.getTeam("Blue").addEntry(i.name)
                                        playerdata[i.uniqueId]?.team = "Blue"
                                    }
                                }
                            } else {
                                if (sender.scoreboard.getTeam("Blue").size < sender.scoreboard.getTeam("Red").size) {
                                    sender.scoreboard.getTeam("Blue").addEntry(i.name)
                                    playerdata[i.uniqueId]?.team = "Blue"
                                } else {
                                    sender.scoreboard.getTeam("Red").addEntry(i.name)
                                    playerdata[i.uniqueId]?.team = "Red"
                                }
                            }
                        }
                    }
                    sender.sendMessage("${ChatColor.GOLD}チームの割り振りが完了しました")
                }else{
                    if(args[0].equals("leave",ignoreCase = true) || args[0].equals("l",ignoreCase = true)){
                        for(i in Bukkit.getOnlinePlayers()){
                            if(playerdata[i.uniqueId]?.team != "Admin"){
                                playerdata[i.uniqueId]?.team = "Default"
                            }
                            sender.sendMessage("${ChatColor.GRAY}チームを解散させました")
                        }
                    }else {
                        sender.sendMessage("${ChatColor.RED}使い方が間違っています！ /team [admin / red / blue / default] OR /team [w (チーム割り振り) / leave (チーム解散)]")
                    }
                }
            }
        }else {
            sender?.sendMessage("${ChatColor.RED}実行者がプレイヤーではないか、使い方が間違っています！ /team [admin / red / blue / default] OR /team [w (チーム割り振り) / leave (チーム解散)]")
        }
    return true
    }
}