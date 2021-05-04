package koutachan.kojogame.commands

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object giveStick : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        if (sender is Player) {

            val iron = ItemStack(Material.STICK, 1)
            val ironMeta = iron.itemMeta
            ironMeta.displayName = "§f§l鉄の棒"
            iron.itemMeta = ironMeta

            val gold = ItemStack(Material.STICK, 1)
            val goldMeta = gold.itemMeta
            goldMeta.displayName = "§6§l金の棒"
            gold.itemMeta = goldMeta

            val diamond = ItemStack(Material.STICK, 1)
            val diamondMeta = diamond.itemMeta
            diamondMeta.displayName = "§b§lダイヤの棒"
            diamond.itemMeta = diamondMeta

            sender.inventory.addItem(iron,gold,diamond)
        }else {
            sender?.sendMessage("§cこのコマンドはプレイヤーからのみのコマンドです！")
        }
    return true
    }
}