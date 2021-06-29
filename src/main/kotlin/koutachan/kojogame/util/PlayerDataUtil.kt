package koutachan.kojogame.util

import koutachan.kojogame.PlayerData
import koutachan.kojogame.playerdata
import org.bukkit.entity.Player

object PlayerDataUtil {
    fun checkContainsKey(player: Player){
        if (!playerdata.containsKey(player.uniqueId)) playerdata[player.uniqueId] = PlayerData()
    }
}