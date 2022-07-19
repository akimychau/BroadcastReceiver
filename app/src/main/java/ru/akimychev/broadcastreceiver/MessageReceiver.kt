package ru.akimychev.broadcastreceiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

private const val NAME_MSG = "MSG";

class MessageReceiver : BroadcastReceiver() {
    private var messageID = 0

    // Сюда приходит широковещательное оповещение
    override fun onReceive(context: Context, intent: Intent) {
        // Получить параметр сообщения
        val message = intent.getStringExtra(NAME_MSG) ?: ""
        // создать нотификацию
        val builder = NotificationCompat.Builder(context, "2").setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Broadcast Receiver")
            .setContentText(message)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(messageID++, builder.build())

    }
}