package com.alekseyld.chatbyinterest.ui.fake

import com.alekseyld.domain.model.Message

object FakeData {

    val initialMessages = listOf(
        Message(
            "me",
            "Держи!",
            "14:33"
        ),
        Message(
            "me",
            "Сейчас пришлю",
            "14:33",
            "",
//        R.drawable.sticker
        ),
        Message(
            "Taylor Brooks",
            "Отправь мне скриншот",
            "13:00"
        ),
    )

}


/**
 * Example colleague profile
 */
//val colleagueProfile = ProfileScreenState(
//    userId = "12345",
//    photo = R.drawable.someone_else,
//    name = "Taylor Brooks",
//    status = "Away",
//    displayName = "taylor",
//    position = "Senior Android Dev at Openlane",
//    twitter = "twitter.com/taylorbrookscodes",
//    timeZone = "12:25 AM local time (Eastern Daylight Time)",
//    commonChannels = "2"
//)

/**
 * Example "me" profile.
 */
//val meProfile = ProfileScreenState(
//    userId = "me",
//    photo = R.drawable.ali,
//    name = "Ali Conors",
//    status = "Online",
//    displayName = "aliconors",
//    position = "Senior Android Dev at Yearin\nGoogle Developer Expert",
//    twitter = "twitter.com/aliconors",
//    timeZone = "In your timezone",
//    commonChannels = null
//)
