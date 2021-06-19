package com.connectycube.flutter.connectycube_flutter_call_kit

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.connectycube.flutter.connectycube_flutter_call_kit.*


class CallForegroundService : Service(){
    override fun onBind(intent: Intent?): IBinder? {
        return null;
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)
        val extras = intent?.extras

        val callId = extras?.getString("call_id") as String
        val callType = extras.getInt("call_type") as Int
        val callInitiatorId = extras.getInt("caller_id") as Int
        val callInitiatorName = extras.getString("caller_name") as String
        val callOpponents = extras.getIntegerArrayList("call_opponents") as ArrayList<Int>
        val userInfo = extras.getString("user_info") as String

        showOngoingCallNotification(
            applicationContext!!,
            callId,
            callType,
            callInitiatorId,
            callInitiatorName,
            callOpponents,
            userInfo
        )

        return START_STICKY
    }
}