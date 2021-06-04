package koutachan.kojogame.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.util.StringUtil

object TabComplete : TabCompleter {
    override fun onTabComplete(
        sender: CommandSender?,
        command: Command?,
        alias: String?,
        args: Array<out String>?
    ): MutableList<String>? {
        if (args?.size == 1) {
            when(command?.name){
                "setspawn" -> { return StringUtil.copyPartialMatches(args[0], listOf("lobby","red","blue"), ArrayList()) }
                "team" -> { return StringUtil.copyPartialMatches(args[0], listOf("admin","red","blue","w","leave","l"), ArrayList())}
            }
        }
    return null
    }
}
