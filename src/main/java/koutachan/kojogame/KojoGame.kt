package koutachan.kojogame


import koutachan.kojogame.commands.*
import koutachan.kojogame.game.GameState.LOBBY
import koutachan.kojogame.game.ResetSponge.resetsponge
import koutachan.kojogame.runTask.ScoreBoard.scoreboardupdate
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.fusesource.jansi.Ansi
import java.io.File
import java.util.*

    // val
    val SettingsFile = File("plugins/KojoGame/settings.yml")

    private const val SettingsVersion = 1.3

    val maxmem = Runtime.getRuntime().totalMemory() / 1048576


    // var
    var GameState = LOBBY
    var SpongeIron = true
    var SpongeGold = true
    var SpongeDiamond = true
    var playerdata = HashMap<UUID, PlayerData>()
    var starttime = 0
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
        getCommand("givestick").executor = GiveStick
        getCommand("debug").executor = debug
        getCommand("start").executor = Start
        getCommand("setspawn").executor = SetSpawn
        getCommand("ping").executor = Ping
        getCommand("kojolist").executor = KojoList
        getCommand("team").executor = Team
        getCommand("global").executor = Global
        getCommand("setspawn").tabCompleter = TabComplete
        getCommand("team").tabCompleter = TabComplete
        // Add config.yml
        saveDefaultConfig()
        // ???
        scoreboardupdate()
        resetsponge()
        // Custom Config
        if(!SettingsFile.exists()) {
            saveResource("settings.yml", false)
        }

        if(YamlConfiguration.loadConfiguration(SettingsFile).getDouble("ConfigVersion") != SettingsVersion) {
            logger.info("${Ansi.ansi().fg(Ansi.Color.RED)}settings.ymlのバージョンが一致していないため、再生成します。${Ansi.ansi().a(Ansi.Attribute.RESET)}")
            kotlin.runCatching {
                saveResource("settings.yml", true)
            }.fold(
                onSuccess = {
                    logger.info("${Ansi.ansi().fg(Ansi.Color.GREEN)}settings.ymlの再生成に成功しました。${Ansi.ansi().a(Ansi.Attribute.RESET)}") },
                onFailure = {
                    it.printStackTrace()
                    logger.info("${Ansi.ansi().fg(Ansi.Color.RED)}エラーが発生しました${Ansi.ansi().a(Ansi.Attribute.RESET)}")
                }
            )
            time = YamlConfiguration.loadConfiguration(SettingsFile).getInt("GameTime")
            // Plugin startup logic
        }
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}