package koutachan.kojogame


import koutachan.kojogame.commands.giveStick
import org.bukkit.plugin.java.JavaPlugin
import koutachan.kojogame.game.GameState.*
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
        // Register Command //
        getCommand("givestick").executor = giveStick
        // Add config.yml/
        saveDefaultConfig()
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}