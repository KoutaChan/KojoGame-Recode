package koutachan.kojogame


import koutachan.kojogame.commands.*
import koutachan.kojogame.commands.`fun`.Grapple
import koutachan.kojogame.debug.AreaSystem
import koutachan.kojogame.game.GameState.LOBBY
import koutachan.kojogame.game.ResetSponge.resetsponge
import koutachan.kojogame.runTask.ScoreBoard.scoreboardupdate
import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
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
        getCommand("grapple").executor = Grapple
        // Add config.yml
        saveDefaultConfig()
        // ???
        scoreboardupdate()
        resetsponge()
        // Custom Config
        if(!SettingsFile.exists()) {
            saveResource("settings.yml", false)
        }
        AreaSystem.tick(60)

        if(YamlConfiguration.loadConfiguration(SettingsFile).getDouble("ConfigVersion") != SettingsVersion) {
            Bukkit.getConsoleSender().sendMessage("${ChatColor.RED}settings.ymlのバージョンが一致していないため、再生成します。${ChatColor.RESET}")
            kotlin.runCatching {
                saveResource("settings.yml", true)
            }.fold(
                onSuccess = {
                    Bukkit.getConsoleSender().sendMessage("${ChatColor.GREEN}settings.ymlの再生成に成功しました。${ChatColor.RESET}") },
                onFailure = {
                    it.printStackTrace()
                    Bukkit.getConsoleSender().sendMessage("${ChatColor.RED}エラーが発生しました | 問題があると思う場合は、作成者に連絡してください${ChatColor.RESET}")
                }
            )
            time = YamlConfiguration.loadConfiguration(SettingsFile).getInt("GameTime")
            // Plugin startup logic
        }
        Bukkit.getWorld(plugin.config.getString("iron.world")).getBlockAt(plugin.config.getInt("iron.x"),plugin.config.getInt("iron.y"),plugin.config.getInt("iron.z"))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}