package koutachan.kojogame.commands

import net.md_5.bungee.api.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player

object Ping : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if(sender is Player) {
            when(val ping = (sender as CraftPlayer).handle.ping){
                in 0..100 -> {sender.sendMessage("${ChatColor.GREEN}Your Ping: $ping ms")}
                in 101..250 -> {sender.sendMessage("${ChatColor.YELLOW}Your Ping: $ping ms")}
                else -> {sender.sendMessage("${ChatColor.RED}Your Ping: $ping ms")}
            }
        }else{
         sender?.sendMessage("${ChatColor.RED}プレイヤーからのみのコマンドです")
        }
    return true
    }
}