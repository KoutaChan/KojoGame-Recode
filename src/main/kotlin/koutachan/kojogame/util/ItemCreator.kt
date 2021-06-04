package koutachan.kojogame.util

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemCreator {
    fun itemcreator(material: Material,amount: Int,damage: Short,displayName: String,vararg lore: String): ItemStack {
        val item = ItemStack(material,amount,damage)
        val meta = item.itemMeta

        meta.displayName = displayName
        meta.lore = lore.toMutableList()

        item.itemMeta = meta

        return item
    }
}