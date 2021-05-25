package koutachan.kojogame

import koutachan.kojogame.KojoGame.Companion.plugin
import koutachan.kojogame.game.GameEnd.gameend
import koutachan.kojogame.game.GameState.LOBBY
import koutachan.kojogame.game.GameState.PLAYING
import koutachan.kojogame.langMessage.lang
import koutachan.kojogame.langMessage.lang.config
import koutachan.kojogame.runTask.ScoreBoard.scoreboard
import koutachan.kojogame.util.ItemCreator.itemcreator
import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.ChatMessageType
import net.md_5.bungee.api.chat.TextComponent
import net.minecraft.server.v1_12_R1.PacketPlayInClientCommand
import org.bukkit.*
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
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.player.*
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType

object Event : Listener {
    @EventHandler
    fun onPlayerJoinEvent(e: PlayerJoinEvent) {
        e.joinMessage = ""
        scoreboard(e.player)
    }

    @EventHandler
    fun onPlayerLeaveEvent(e: PlayerQuitEvent) {
        e.quitMessage = ""
        when(playerdata[e.player.uniqueId]?.team){
            "Red" -> {
                for(i in Bukkit.getOnlinePlayers()){
                    i.scoreboard.getTeam("Red").removeEntry(e.player.name)
                }
            }
            "Blue" -> {
                for(i in Bukkit.getOnlinePlayers()){
                    i.scoreboard.getTeam("Blue").removeEntry(e.player.name)
                }
            }
        }
    }

    //メモ(青) : 攻め
    //メモ(赤) : 守り

    @EventHandler
    fun onBlockBreakEvent(e: BlockBreakEvent) {
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
    fun onBlockPlaceEvent(e: BlockPlaceEvent) {
        if (e.player.gameMode != GameMode.CREATIVE) {
            e.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerInteractEvent(e: PlayerInteractEvent) {
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
    fun onPlayerDeathEvent(e: PlayerDeathEvent) {
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
    fun onAsyncPlayerChatEvent(e: AsyncPlayerChatEvent) {
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
                Bukkit.broadcastMessage("${lang.GLOBAL_CHAT_PREFIX} $teamname${e.player.name}: §r${e.message.replaceFirst("!", "")}")
            } else {
                e.player.sendMessage("${ChatColor.RED}何かを入力してください")
            }
        }
    }

    @EventHandler
    fun onEntityDamageEvent(e: EntityDamageEvent) {
        if(e.entity is Player){
            if(GameState != PLAYING || playerdata[e.entity.uniqueId]?.team == "Default"){
                e.isCancelled = true
            }
        }
    }

    @EventHandler
    fun onPlayerInteractEntityEvent(e: PlayerInteractEntityEvent){
        if(e.rightClicked is Villager) {
            e.isCancelled = true
            val inv = Bukkit.createInventory(null,27,"${ChatColor.GREEN}ショップ")
            for(i in 0..26){
                inv.setItem(i, itemcreator(Material.STAINED_GLASS_PANE,1,10,"${ChatColor.GREEN}"))
            }

            val potion = itemcreator(Material.POTION,1,0,"${ChatColor.AQUA}ポーション ${ChatColor.GOLD}(スポンジ 1個)")
            val potionMeta = (potion.itemMeta as PotionMeta)
            potionMeta.addCustomEffect(PotionEffect(PotionEffectType.SPEED,20 * 60,1),true)
            potionMeta.addCustomEffect(PotionEffect(PotionEffectType.INCREASE_DAMAGE,20 * 60 * 2,1),true)
            potionMeta.addCustomEffect(PotionEffect(PotionEffectType.REGENERATION,20 * 60 * 5,1),true)
            potionMeta.color = Color.AQUA
            potion.itemMeta = potionMeta

            inv.setItem(0, itemcreator(Material.STAINED_GLASS_PANE,1, 5,"${ChatColor.GREEN}ポーション類"))
            inv.setItem(1, potion)
            inv.setItem(9, itemcreator(Material.STAINED_GLASS_PANE,1,14,"${ChatColor.RED}剣/防御"))
            inv.setItem(18, itemcreator(Material.STAINED_GLASS_PANE,1,4,"${ChatColor.YELLOW}その他"))
            //inv.setItem(0, itemcreator(Material.POTION,1,"${ChatColor.AQUA}ポーション","${ChatColor.GREEN}ポーション効果:","${ChatColor.AQUA}スピード2(1分)","${ChatColor.RED}攻撃力上昇2(2分)","${ChatColor.LIGHT_PURPLE}再生2(5分)","","${ChatColor.GOLD}これを買うにはスポンジが1個必要"))
            //inv.setItem(2, itemcreator(Material.STICK,64,0,"今日はいい天気だ！","lore1","lore2"))
            e.player.openInventory(inv)
            e.player.inventory.addItem(itemcreator(Material.ICE,1,1,"ああ","1","2","3"))
            Bukkit.broadcastMessage("h")
        }
    }

    @EventHandler
    fun onPlayerDropItemEvent(e: PlayerDropItemEvent){
        if(playerdata[e.player.uniqueId]?.team != "Admin" || e.player.gameMode != GameMode.CREATIVE){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun onInventoryClickEvent(e: InventoryClickEvent){
        if(e.inventory.name == "${ChatColor.GREEN}ショップ") {
            e.isCancelled = true

            if (e.currentItem != null && e.currentItem.type != Material.AIR && e.currentItem.itemMeta.displayName != null) {
                if (e.currentItem.itemMeta.displayName.contains("スポンジ 1個")) {
                    for (inv in e.whoClicked.inventory.contents) {
                        if (inv != null && inv.type == Material.SPONGE) {
                            inv.amount = inv.amount - 1
                            e.whoClicked.inventory.addItem(e.currentItem)
                            e.whoClicked.sendMessage("${ChatColor.GREEN}${e.currentItem.itemMeta.displayName}${ChatColor.GREEN}を買った")
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    fun onInventoryDragEvent(e: InventoryDragEvent){
        if(e.inventory.name == "${ChatColor.GREEN}ショップ"){
            e.isCancelled = true
        }
    }

    @EventHandler
    fun onPlayerItemConsumeEvent(e: PlayerItemConsumeEvent){
        if(e.item.type == Material.POTION){
            Bukkit.getScheduler().runTaskLater(plugin, {
                e.player.inventory.remove(Material.GLASS_BOTTLE)
            },1)
        }
    }
}