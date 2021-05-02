package koutachan.kojogame


import koutachan.kojogame.commands.Start
import koutachan.kojogame.commands.debug
import koutachan.kojogame.commands.giveStick
import org.bukkit.plugin.java.JavaPlugin
import koutachan.kojogame.game.GameState.*
import java.util.*
import kotlin.collections.HashMap


    var GameState = LOBBY
    var SpongeIron = true
    var SpongeGold = true
    var SpongeDiamond = true
    var playerdata = HashMap<UUID,PlayerData>()


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
        getCommand("debug").executor = debug
        getCommand("start").executor = Start
        // Add config.yml/
        saveDefaultConfig()
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}