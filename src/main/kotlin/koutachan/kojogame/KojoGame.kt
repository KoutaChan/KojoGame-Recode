package koutachan.kojogame


import koutachan.kojogame.game.GameState.LOBBY
import koutachan.kojogame.game.RoleType
import koutachan.kojogame.game.role.Knight
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

// var
    var GameState = LOBBY
    var playerdata = HashMap<UUID, PlayerData>()



class KojoGame : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    override fun onEnable() {
        plugin = this
        // Register Event
        //server.pluginManager.registerEvents(Event,this)
        // Register Command
        // Add config.yml
        saveDefaultConfig()
        // ???
        // Custom Config
        Bukkit.getOnlinePlayers().forEach() { b ->
            b.address

        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}