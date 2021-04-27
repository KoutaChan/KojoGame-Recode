package koutachan.kojogame.game

import koutachan.kojogame.team
import org.bukkit.entity.Player

object Team {
    fun AddTeam(p: Player,t: String) {
        team.put(p.uniqueId,t)
    }
    fun GetTeam(p: Player) {
        if(team.containsKey(p.uniqueId)) {
            team.get(p.uniqueId)
        }
    }
    fun DeleteTeam(p: Player) {
        if(team.containsKey(p.uniqueId)) {
            team.remove(p.uniqueId)
        }
    }
}