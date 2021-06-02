package koutachan.kojogame.util

import koutachan.kojogame.langMessage.lang

object ReplaceTeamPrefix {
    fun replace(string: String) : String{
        return when (string) {
            "Red" -> {
                "${lang.config.get("RED_CHAT_PREFIX")}"
            }
            "Blue" -> {
                "${lang.config.get("BLUE_CHAT_PREFIX")}"
            }
            "Admin" -> {
                "${lang.config.get("ADMIN_CHAT_PREFIX")}"
            }
            else -> {
                ""
            }
        }

    }
}