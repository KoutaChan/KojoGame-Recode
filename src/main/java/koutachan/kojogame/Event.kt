package koutachan.kojogame

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.runTask.ScoreBoard.ScoreBoard
import koutachan.kojogame.game.GameState.*
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent

object Event : Listener {
    @EventHandler
    fun PlayerJoinEvent(e: PlayerJoinEvent) {
        e.joinMessage = ""
        ScoreBoard(e.player)
        team[e.player.uniqueId] = "Red"
        /*TODO: Add Team*/
    }

    @EventHandler
    fun BreakEvent(e: BlockBreakEvent) {
        if (e.player.gameMode != GameMode.CREATIVE && e.block.type != Material.SPONGE) {
            e.isCancelled = true
        } else {
            if (e.player.gameMode != GameMode.CREATIVE) {
                /*TODO: Add SpongeCheck*/
            }
        }
    }

    @EventHandler
    fun PlaceEvent(e: BlockPlaceEvent) {
        if (e.player.gameMode != GameMode.CREATIVE) {
            e.isCancelled = true
        }
    }

    @EventHandler
    fun PlayerInteractEvent(e: PlayerInteractEvent) {
        if (GameState == LOBBY && e.player.isOp && e.action == Action.RIGHT_CLICK_BLOCK && e.player.inventory.itemInMainHand.type == Material.STICK) {
            when (e.player.inventory.itemInMainHand.itemMeta.displayName) {
                "§f§l鉄の棒" -> {
                    plugin.config.set("iron.world", e.clickedBlock.world.name)
                    plugin.config.set("iron.x", e.clickedBlock.x)
                    plugin.config.set("iron.y", e.clickedBlock.y)
                    plugin.config.set("iron.z", e.clickedBlock.z)
                    plugin.saveConfig()
                    e.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§n結果 world: ${e.clickedBlock.world.name} x: ${e.clickedBlock.x} y: ${e.clickedBlock.y} z: ${e.clickedBlock.z}"))
                }
                "§6§l金の棒" -> {
                    plugin.config.set("gold.world", e.clickedBlock.world.name)
                    plugin.config.set("gold.x", e.clickedBlock.x)
                    plugin.config.set("gold.y", e.clickedBlock.y)
                    plugin.config.set("gold.z", e.clickedBlock.z)
                    plugin.saveConfig()
                    e.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§6§n結果 world: ${e.clickedBlock.world.name} x: ${e.clickedBlock.x} y: ${e.clickedBlock.y} z: ${e.clickedBlock.z}"))
                }
                "§b§lダイヤの棒" -> {
                    plugin.config.set("diamond.world", e.clickedBlock.world.name)
                    plugin.config.set("diamond.x", e.clickedBlock.x)
                    plugin.config.set("diamond.y", e.clickedBlock.y)
                    plugin.config.set("diamond.z", e.clickedBlock.z)
                    plugin.saveConfig()
                    e.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§b§n結果 world: ${e.clickedBlock.world.name} x: ${e.clickedBlock.x} y: ${e.clickedBlock.y} z: ${e.clickedBlock.z}"))
                }
            }
        }
    }
}