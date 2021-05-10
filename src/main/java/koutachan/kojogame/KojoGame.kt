package koutachan.kojogame


import koutachan.kojogame.commands.Ping
import koutachan.kojogame.commands.Start
import koutachan.kojogame.commands.debug
import koutachan.kojogame.commands.giveStick
import org.bukkit.plugin.java.JavaPlugin
import koutachan.kojogame.game.GameState.*
import koutachan.kojogame.runTask.ScoreBoard
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.util.*
import kotlin.collections.HashMap


    val SettingsFile = File("plugins/KojoGame/settings.yml")

    var GameState = LOBBY
    var SpongeIron = true
    var SpongeGold = true
    var SpongeDiamond = true
    var playerdata = HashMap<UUID, PlayerData>()
    var starttime = 10
    var time = YamlConfiguration.loadConfiguration(SettingsFile).getInt("GameTime")


class KojoGame : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    override fun onEnable() {
        plugin = this
        // Register Event
        server.pluginManager.registerEvents(Event,this)
        // Register Command
        getCommand("givestick").executor = giveStick
        getCommand("debug").executor = debug
        getCommand("start").executor = Start
        getCommand("ping").executor = Ping
        // Add config.yml
        saveDefaultConfig()
        //???
        ScoreBoard.ScoreBoardUpdate()
        //Custom Config
        saveResource("settings.yml",false)
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}