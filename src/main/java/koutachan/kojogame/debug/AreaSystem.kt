package koutachan.kojogame.debug

import koutachan.kojogame.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable

object AreaSystem {
    fun tick(Long: Long){
        object : BukkitRunnable() {
            val worldBorderStart = Location(Bukkit.getWorld("world"),30.0,1.0,-40.0)
            val worldBorderStartZ = 30
            val worldBorderEndX = 600
            val worldBorderEndZ = -100
            override fun run() {
                for(player in Bukkit.getOnlinePlayers()) {
                    if(check(worldBorderStart,player))
                        Bukkit.broadcastMessage("border system enabled")
                    }
                }
        }.runTaskTimer(plugin,Long,0)
    }

    fun check(location: Location,player: Player): Boolean{
        //if((location.blockX <= player.location.blockX || location.blockX <= (-player.location.blockX)) || (location.blockZ <= player.location.blockX || location.blockZ <= (-player.location.blockZ))){
        //    return true
        //}

        if((location.blockX < 0 && location.blockX >= -player.location.blockX) || (location.blockX >= 0 && location.blockX <= player.location.blockX) || (location.blockZ < 0 && location.blockZ >= -player.location.blockZ) || (location.blockZ >= 0 && location.blockZ <= player.location.blockZ)){
            return true
        }
        if(location.blockX < 0){
            if(location.blockX >= -player.location.blockX){
                Bukkit.broadcastMessage("a")
                return true
            }
        }else{
            if(location.blockX <= player.location.blockX){
                Bukkit.broadcastMessage("b")
                return true
            }
        }
        if(location.blockZ < 0){
            if(location.blockZ >= -player.location.blockZ){
                Bukkit.broadcastMessage("c")
                return true
            }
        }else{
            if(location.blockX <= player.location.blockZ){
                Bukkit.broadcastMessage("d")
                return true
            }
        }
    return false
    }
}