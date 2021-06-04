package koutachan.kojogame.commands.`fun`

import koutachan.kojogame.util.ItemCreator.itemcreator
import net.md_5.bungee.api.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object Grapple : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if(sender is Player){
            sender.inventory.addItem(itemcreator(Material.FISHING_ROD,1,0,"${ChatColor.GOLD}Grapple"))
        }
    return true
    }
}