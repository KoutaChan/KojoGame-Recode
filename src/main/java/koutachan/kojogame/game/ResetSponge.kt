package koutachan.kojogame.game

import koutachan.kojogame.KojoGame.Companion.plugin
import org.bukkit.Bukkit
import org.bukkit.Material

object ResetSponge {
    fun resetsponge(){
        Bukkit.getWorld(plugin.config.getString("iron.world")).getBlockAt(plugin.config.getInt("iron.x"),plugin.config.getInt("iron.y"),plugin.config.getInt("iron.z")).type = Material.SPONGE
        Bukkit.getWorld(plugin.config.getString("gold.world")).getBlockAt(plugin.config.getInt("gold.x"),plugin.config.getInt("gold.y"),plugin.config.getInt("gold.z")).type = Material.SPONGE
        Bukkit.getWorld(plugin.config.getString("diamond.world")).getBlockAt(plugin.config.getInt("diamond.x"),plugin.config.getInt("diamond.y"),plugin.config.getInt("diamond.z")).type = Material.SPONGE

    }
}