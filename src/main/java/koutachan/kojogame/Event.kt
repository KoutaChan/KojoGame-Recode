package koutachan.kojogame

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.GameState.*
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.scheduler.BukkitRunnable

object Event : Listener {
    @EventHandler
    fun PlayerJoinEvent(e: PlayerJoinEvent) {
        e.joinMessage = ""
        if (!playerdata.containsKey(e.player.uniqueId)) {
            playerdata[e.player.uniqueId] = PlayerData()
        }
        //val inta = 0
        //val intb = 0
        //if(inta < intb) {
        //    Bukkit.broadcastMessage("testA")
        //}else {
        //    Bukkit.broadcastMessage("testB")
        //}
        /*TODO: Add Team*/
    }

    //メモ(青) : 攻め
    //メモ(赤) : 守り

    @EventHandler
    fun BreakEvent(e: BlockBreakEvent) {
        if (e.player.gameMode != GameMode.CREATIVE) {
            if (e.block.type != Material.SPONGE) {
                e.isCancelled = true
            } else {
                e.isCancelled = true
                if (GameState == PLAYING && playerdata[e.player.uniqueId]?.team == "Blue") {
                    if (e.block.world.name == plugin.config.getString("iron.world")
                        && e.block.x == plugin.config.getInt("iron.x")
                        && e.block.y == plugin.config.getInt("iron.y")
                        && e.block.z == plugin.config.getInt("iron.z")) {
                        Bukkit.broadcastMessage("鉄のスポンジが破壊されました")
                        SpongeIron = false
                        e.isCancelled = false
                    }
                    if (e.block.world.name == plugin.config.getString("gold.world")
                        && e.block.x == plugin.config.getInt("gold.x")
                        && e.block.y == plugin.config.getInt("gold.y")
                        && e.block.z == plugin.config.getInt("gold.z")) {
                        Bukkit.broadcastMessage("金のスポンジが破壊されました")
                        SpongeGold = false
                        e.isCancelled = false
                    }
                    if (e.block.world.name == plugin.config.getString("diamond.world")
                        && e.block.x == plugin.config.getInt("diamond.x")
                        && e.block.y == plugin.config.getInt("diamond.y")
                        && e.block.z == plugin.config.getInt("diamond.z")) {
                        Bukkit.broadcastMessage("ダイヤのスポンジが破壊されました")
                        SpongeDiamond = false
                        e.isCancelled = false
                    }
                    if (!e.isCancelled && !SpongeIron && !SpongeGold && !SpongeDiamond) {
                        Bukkit.broadcastMessage("テストーｗ")
                        /*TODO: Add End*/
                    }
                }
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

    @EventHandler
    fun EntityDamageEvent(e: EntityDamageEvent) {
        if (e.entity is Player){
            if(GameState == PLAYING && playerdata[e.entity.uniqueId]?.team != "Default") {
            if ((e.entity as Player).health - e.damage < 0) {
                e.isCancelled = true
                e.entity.sendMessage("§cあなたは死亡しました！ 5秒後に復活します")
                (e.entity as Player).gameMode = GameMode.SPECTATOR
                object : BukkitRunnable() {
                    var RespawnTimer = 5
                    override fun run() {
                        if (RespawnTimer > 0) {
                            (e.entity as Player).sendTitle("§cリスポーンまで: $RespawnTimer", "")

                        }
                        if (RespawnTimer == 0){
                            //Teleport TO Team Spawn??????
                            (e.entity as Player).gameMode = GameMode.SURVIVAL
                            (e.entity as Player).sendTitle("§aリスポーンしました！","")
                            cancel()
                        }
                        RespawnTimer--
                    }
                }.runTaskTimer(plugin,0,20)
            }
        } else {
            e.isCancelled = true
            }
        }
    }
}
