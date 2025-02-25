package com.bhumika.bookapp;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created on 31-12-2017.
 */

public class FBInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("FBToken:", "Refreshed token: " + refreshedToken);

        if(getApplicationContext().getSharedPreferences("MyPref", 0).getBoolean("recieveNotifications", Boolean.parseBoolean("")))
            FirebaseMessaging.getInstance().subscribeToTopic("newBooks");
        else
            FirebaseMessaging.getInstance().unsubscribeFromTopic("newBooks");
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {
        // TODO: Implement this method to send token to your app server.
    }
}
