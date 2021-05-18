package koutachan.kojogame

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.GameEnd.gameend
import koutachan.kojogame.game.GameState.LOBBY
import koutachan.kojogame.game.GameState.PLAYING
import koutachan.kojogame.langMessage.lang.config
import koutachan.kojogame.runTask.ScoreBoard.scoreboard
import koutachan.kojogame.util.ItemCreator.itemcreator
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import net.minecraft.server.v1_12_R1.PacketPlayInClientCommand
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer
import org.bukkit.entity.Player
import org.bukkit.entity.Villager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.AsyncPlayerChatEvent
import org.bukkit.event.player.PlayerInteractEntityEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerJoinEvent

object Event : Listener {
    @EventHandler
    fun PlayerJoinEvent(e: PlayerJoinEvent) {
        e.joinMessage = ""
        scoreboard(e.player)
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
                        gameend()
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
                    e.clickedBlock.type = Material.SPONGE
                    e.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§n結果 world: ${e.clickedBlock.world.name} x: ${e.clickedBlock.x} y: ${e.clickedBlock.y} z: ${e.clickedBlock.z}"))
                }
                "§6§l金の棒" -> {
                    plugin.config.set("gold.world", e.clickedBlock.world.name)
                    plugin.config.set("gold.x", e.clickedBlock.x)
                    plugin.config.set("gold.y", e.clickedBlock.y)
                    plugin.config.set("gold.z", e.clickedBlock.z)
                    plugin.saveConfig()
                    e.clickedBlock.type = Material.SPONGE
                    e.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§6§n結果 world: ${e.clickedBlock.world.name} x: ${e.clickedBlock.x} y: ${e.clickedBlock.y} z: ${e.clickedBlock.z}"))
                }
                "§b§lダイヤの棒" -> {
                    plugin.config.set("diamond.world", e.clickedBlock.world.name)
                    plugin.config.set("diamond.x", e.clickedBlock.x)
                    plugin.config.set("diamond.y", e.clickedBlock.y)
                    plugin.config.set("diamond.z", e.clickedBlock.z)
                    plugin.saveConfig()
                    e.clickedBlock.type = Material.SPONGE
                    e.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent("§b§n結果 world: ${e.clickedBlock.world.name} x: ${e.clickedBlock.x} y: ${e.clickedBlock.y} z: ${e.clickedBlock.z}"))
                }
            }
        }
    }

    @EventHandler
    fun PlayerDeathEvent(e: PlayerDeathEvent) {
        Bukkit.getScheduler().runTaskLater(plugin, {
            when (playerdata[e.entity.player.uniqueId]?.team) {
                "Red" -> {
                    e.entity.player.setBedSpawnLocation(Location(Bukkit.getWorld("${plugin.config.get("red.world")}"),
                        plugin.config.getDouble("red.x"),
                        plugin.config.getDouble("red.y"),
                        plugin.config.getDouble("red.z"),
                        plugin.config.getDouble("red.yaw").toFloat(),
                        plugin.config.getDouble("red.pitch").toFloat()), true)
                }
                "Blue" -> {
                    e.entity.player.setBedSpawnLocation(Location(Bukkit.getWorld("${plugin.config.get("blue.world")}"),
                        plugin.config.getDouble("blue.x"),
                        plugin.config.getDouble("blue.y"),
                        plugin.config.getDouble("blue.z"),
                        plugin.config.getDouble("blue.yaw").toFloat(),
                        plugin.config.getDouble("blue.pitch").toFloat()), true)
                }
                else -> {
                    e.entity.player.setBedSpawnLocation(Location(Bukkit.getWorld("${plugin.config.get("lobby.world")}"),
                        plugin.config.getDouble("lobby.x"),
                        plugin.config.getDouble("lobby.y"),
                        plugin.config.getDouble("lobby.z"),
                        plugin.config.getDouble("lobby.yaw").toFloat(),
                        plugin.config.getDouble("lobby.pitch").toFloat()), true)
                }
            }
            (e.entity.player as CraftPlayer).handle.playerConnection.a(PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN))
        },2)
    }

    @EventHandler
    fun AsyncPlayerChatEvent(e: AsyncPlayerChatEvent) {
        var teamname = ""
        when (playerdata[e.player.uniqueId]?.team) {
            "Red" -> {
                teamname = "${config.get("RED_CHAT_PREFIX")}"
            }
            "Blue" -> {
                teamname = "${config.get("BLUE_CHAT_PREFIX")}"
            }
            "Admin" -> {
                teamname = "${config.get("ADMIN_CHAT_PREFIX")}"
            }
        }
        e.isCancelled = true
        if (!e.message.startsWith("!") && playerdata[e.player.uniqueId]?.team != "Default") {
            for (team in Bukkit.getOnlinePlayers()) {
                if (playerdata[team.uniqueId]?.team == playerdata[e.player.uniqueId]?.team) {
                    team.sendMessage("$teamname${e.player.name}: §r${e.message}")
                }
            }
        } else {
            if (e.message.replaceFirst("!", "").isNotEmpty()) {
                Bukkit.broadcastMessage("§5[Global] $teamname${e.player.name}: §r${e.message.replaceFirst("!", "")}")
            } else {
                e.player.sendMessage("§c何かを入力してください")
            }
        }
    }

    @EventHandler
    fun EntityDamageEvent(e: EntityDamageEvent) {
        if(e.entity is Player){
            if(GameState != PLAYING || playerdata[e.entity.uniqueId]?.team == "Default"){
                e.isCancelled = true
            }
        }
    }

    @EventHandler
    fun PlayerInteractEntityEvent(e: PlayerInteractEntityEvent){
        if(e.rightClicked is Villager) {
            e.isCancelled = true
            val inv = Bukkit.createInventory(null,27,"gui")
            inv.setItem(2, itemcreator(Material.STICK,64,"今日はいい天気だ！","lore1","lore2"))
            e.player.openInventory(inv)
            e.player.inventory.addItem(itemcreator(Material.ICE,1,"ああ","1","2","3"))
            Bukkit.broadcastMessage("h")
        }
    }
}