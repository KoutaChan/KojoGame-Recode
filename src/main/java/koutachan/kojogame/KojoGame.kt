package koutachan.kojogame


import org.bukkit.plugin.java.JavaPlugin
import koutachan.kojogame.game.GameState.*
import koutachan.kojogame.runTask.TeamColor.TeamColor
import org.bukkit.Bukkit
import java.util.*
import kotlin.collections.HashMap


    var GameState = LOBBY
    var team = HashMap<UUID,String>()

class KojoGame : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    override fun onEnable() {
        plugin = this
        // Register Event //
        server.pluginManager.registerEvents(Event,this)
        TeamColor()
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}