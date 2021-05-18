package koutachan.kojogame.util

import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object ItemCreator {
    fun itemcreator(material: Material,amount: Int,displayName: String,vararg lore: String): ItemStack {
        val item = ItemStack(material,amount)
        val meta = item.itemMeta

        meta.displayName = displayName
        meta.lore = lore.toMutableList()

        item.itemMeta = meta

        return item
    }
}