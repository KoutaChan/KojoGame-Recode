package koutachan.kojogame.util

import koutachan.kojogame.playerdata
import org.bukkit.entity.Player

object Skill {
    fun Player.setSkillCoolDown(Int: Int){
        PlayerDataUtil.checkContainsKey(player)
        playerdata[player.uniqueId]!!.cooldown = Int
    }
    fun Player.getSkillCoolDown(): Int{
        PlayerDataUtil.checkContainsKey(player)
        return playerdata[player.uniqueId]!!.cooldown
    }
}