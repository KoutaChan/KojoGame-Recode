package koutachan.kojogame.util

import koutachan.kojogame.game.TeamType
import koutachan.kojogame.playerdata
import org.bukkit.entity.Player

object Team {
    fun Player.getTeam() : TeamType {
        PlayerDataUtil.checkContainsKey(player)
        return playerdata[player.uniqueId]!!.team
    }
    fun Player.setTeam(TeamType: TeamType){
        PlayerDataUtil.checkContainsKey(player)
        playerdata[player.uniqueId]!!.team = TeamType
    }
}