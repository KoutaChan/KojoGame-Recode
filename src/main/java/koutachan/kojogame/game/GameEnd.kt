package koutachan.kojogame.game

import koutachan.kojogame.*
import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.GameState.ENDING
import koutachan.kojogame.game.GameState.LOBBY
import koutachan.kojogame.langMessage.lang
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration

object GameEnd {
    fun GameEnd(){
        time = YamlConfiguration.loadConfiguration(SettingsFile).getInt("GameTime")
        Bukkit.broadcastMessage(lang.MESSAGE_TELEPORT_TO_LOBBY5.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"))
        GameState = ENDING
        Bukkit.getScheduler().runTaskLater(plugin, {
            GameState = LOBBY
            Bukkit.broadcastMessage(lang.MESSAGE_TELEPORT_TO_LOBBY.replace("@state", GameState.toString().replace("LOBBY","${lang.config.get("GAMESTATE_LOBBY")}").replace("STARTING","${lang.config.get("GAMESTATE_STARTING")}").replace("PLAYING","${lang.config.get("GAMESTATE_PLAYING")}").replace("ENDING","${lang.config.get("GAMESTATE_ENDING")}")).replace("@start","$starttime").replace("@time","$time"))
            playerdata.clear()
            for(player in Bukkit.getOnlinePlayers()) {
                player.teleport(Location(Bukkit.getWorld("${plugin.config.get("lobby.world")}"),
                    plugin.config.getDouble("lobby.x"),
                    plugin.config.getDouble("lobby.y"),
                    plugin.config.getDouble("lobby.z"),
                    plugin.config.getDouble("lobby.yaw").toFloat(),
                    plugin.config.getDouble("lobby.pitch").toFloat()))
                ResetSponge.ResetSponge()
                SpongeIron = true
                SpongeGold = true
                SpongeDiamond = true
            }
        },20 * 5)
    }
}