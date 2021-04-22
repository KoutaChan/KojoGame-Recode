package koutachan.kojogame


import org.bukkit.plugin.java.JavaPlugin

class KojoGame : JavaPlugin() {
    companion object {
        lateinit var plugin: JavaPlugin
    }
    override fun onEnable() {
        plugin = this
        // Register Event //
        server.pluginManager.registerEvents(Event,this)
        // ScoreBoard //
        //forPlayer()
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}