package koutachan.kojogame.game

import koutachan.kojogame.*
import koutachan.kojogame.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.Location

object GameEnd {
    fun GameEnd(){
        playerdata.clear()
        for(player in Bukkit.getOnlinePlayers()){
            playerdata[player.uniqueId] = PlayerData()
            player.teleport(Location(Bukkit.getWorld("${plugin.config.get("lobby.world")}"), plugin.config.getDouble("lobby.x"), plugin.config.getDouble("lobby.y"), plugin.config.getDouble("lobby.z"), plugin.config.getDouble("lobby.yaw").toFloat(), plugin.config.getDouble("lobby.pitch").toFloat()))
            SpongeIron = true
            SpongeGold = true
            SpongeDiamond = true
        }
    }
}