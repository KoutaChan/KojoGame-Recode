package koutachan.kojogame.commands

import koutachan.kojogame.util.ItemCreator.itemcreator
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object GiveStick : CommandExecutor {
    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>?
    ): Boolean {
        if (sender is Player) {
            sender.inventory.addItem(itemcreator(Material.STICK, 1,0, "§f§l鉄の棒"), itemcreator(Material.STICK, 1, 0,"§6§l金の棒"), itemcreator(Material.STICK, 1,0, "§b§lダイヤの棒"))
        } else {
            sender?.sendMessage("§cこのコマンドはプレイヤーからのみのコマンドです！")
        }
        return true
    }
}