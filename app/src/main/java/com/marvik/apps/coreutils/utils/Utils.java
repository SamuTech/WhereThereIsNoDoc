package com.marvik.apps.coreutils.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.marvik.apps.coreutils.accounts.UserAccountsManager;
import com.marvik.apps.wherethereisnodoc.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by victor on 9/27/2015.
 */

public class Utils {

    private UserAccountsManager userAccountsManager;

    public Utils(Context context) {

        initAll(context);
    }

    private void initAll(Context context) {

        this.context = context;

        this.userAccountsManager = new UserAccountsManager(getContext());

    }

    private Context getContext() {
        return context;
    }



    public UserAccountsManager getUserAccountsManager() { return userAccountsManager; }


    private Context context;


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////Start Activity////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void startActivity(Class<? extends Activity> cls) {
        startActivity(cls, new Bundle(), 0);
    }

    public void startActivity(String action, Class<? extends Activity> cls) {
        startActivity(action, cls, new Bundle(), 0);
    }

    public void startActivity(Class<? extends Activity> cls, @NonNull Bundle bundle) {
        startActivity(cls, bundle, 0);
    }

    public void startActivity(Class<? extends Activity> cls, int flags) {
        startActivity(cls, new Bundle(), flags);
    }


    public void startActivity(Class<? extends Activity> cls, @NonNull Bundle extras, int flags) {
        startActivity(Intent.ACTION_MAIN, cls, extras, flags);
    }

    public void startActivity(String action, Class<? extends Activity> cls, int flags) {
        startActivity(action, cls, new Bundle(), flags);
    }

    public void startActivity(String action, Class<? extends Activity> cls, @NonNull Bundle extras, int flags) {

        getContext().startActivity(new Intent(getContext(), cls).addFlags(flags).putExtras(extras).setAction(action));
    }


    public void startService(Class<? extends Service> cls) {
        startService(cls, new Bundle(), 0);
    }

    public void startService(Class<? extends Service> cls, @NonNull Bundle bundle) {
        startService(cls, bundle, 0);
    }

    public void startService(Class<? extends Service> cls, int flags) {
        startService(cls, new Bundle(), flags);
    }

    public void startService(Class<? extends Service> cls, @NonNull Bundle extras, int flags) {
        getContext().startService(new Intent(getContext(), cls).addFlags(flags).putExtras(extras));
    }

    public void stopService(Class<? extends Service> cls) {
        stopService(cls, new Bundle(), 0);
    }

    public void stopService(Class<? extends Service> cls, @NonNull Bundle bundle) {
        stopService(cls, bundle, 0);
    }

    public void stopService(Class<? extends Service> cls, int flags) {
        stopService(cls, new Bundle(), flags);
    }

    public void stopService(Class<? extends Service> cls, @NonNull Bundle extras, int flags) {
        getContext().stopService(new Intent(getContext(), cls).addFlags(flags).putExtras(extras));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////// SEND BROADCASTS //////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void sendBroadcast(Class<? extends Activity> cls) {
        getContext().sendBroadcast(new Intent(getContext(), cls).putExtra(Intent.ACTION_MAIN, Intent.ACTION_MAIN), new String(""));
    }

    public void sendBroadcast(String action) {
        sendBroadcast(action, new Bundle());

    }

    public void sendBroadcast(String action, @NonNull Bundle extras) {
        sendBroadcast(action, extras, null);
    }

    public void sendBroadcast(String action, int flags) {
        sendBroadcast(action, flags, null);
    }

    public void sendBroadcast(String action, @NonNull Bundle extras, int flags) {
        sendBroadcast(action, extras, flags, null);
    }


    public void sendBroadcast(String action, String permission) {
        sendBroadcast(action, 0, permission);
    }

    public void sendBroadcast(String action, @NonNull Bundle extras, String permission) {
        sendBroadcast(action, extras, 0, permission);
    }

    public void sendBroadcast(String action, int flags, String permission) {
        sendBroadcast(action, new Bundle(), flags, permission);
    }

    public void sendBroadcast(String action, @NonNull Bundle extras, int flags, String permission) {
        getContext().sendBroadcast(new Intent(action).addFlags(flags).putExtras(extras), permission);
    }

    public void sendBroadcast(Intent intent, String permission) {
        getContext().sendBroadcast(intent, permission);
    }

    public void sendBroadcast(Intent intent) {
        getContext().sendBroadcast(intent, null);
    }


    @NonNull
    public String getString(@NonNull TextView textView) {
        return textView.getText().toString();
    }

    public void toast(String text) {
        toast(text, Toast.LENGTH_SHORT);
    }

    public void toast(String text, int duration) {
        // TODO Auto-generated method stub
        Toast toast = new Toast(getContext());
        TextView view = new TextView(getContext());
        view.setPadding(10, 10, 10, 10);
        view.setBackgroundColor(Color.rgb(180, 180, 180));
        view.setTextColor(Color.BLACK);
        view.setText(text);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);
        toast.show();
    }

    public boolean isEmpty(@NonNull TextView[] textViews) {
        boolean isEmpty = false;
        for (TextView textView : textViews) {
            if (textView.getText().length() == 0) {
                textView.setError("Cannot be null");
                textView.setHintTextColor(Color.RED);
                isEmpty = true;
            } else {
                textView.setHintTextColor(Color.GRAY);
            }
        }
        return isEmpty;
    }

    @NonNull
    public ArrayList<String> formatToArray(@NonNull Set<String> set) {

        ArrayList<String> arrayList = new ArrayList<String>(set.size());
        for (int i = 0; i < set.size(); i++) {
            arrayList.add(set.iterator().next());
        }
        return arrayList;
    }

    public void hideViews(@NonNull View[] views) {
        for (View view : views) {
            view.setVisibility(View.GONE);
        }
    }

    public void showViews(@NonNull View[] views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    public <T extends TextView> void resetInputs(@NonNull T[] t) {
        for (T v : t) {
            v.setText("");
        }
    }



    public boolean isNetworkConnected(int notificationId,boolean alert) {
        return isNetworkConnected(notificationId,alert, "Network Error", "Action Failed! You are not connected to the Internet");
    }

    public boolean isNetworkConnected(int notificationId,boolean alert, String title, String message) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        boolean networkConnected = false;

        if (networkInfo != null) {
            networkConnected = networkInfo.isAvailable() && networkInfo.isConnected();
        }

        if (!networkConnected && alert) {
            sendNotification(notificationId,title, message);
        }
        return true/*networkConnected*/;
    }

    private void sendNotification(int notificationId,String title, String message) {
        NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(getContext());
        notificationCompat.build();
        notificationCompat.mContentTitle = title;
        notificationCompat.mContentText = message;
        notificationCompat.setSmallIcon(R.mipmap.ic_launcher);
        notificationCompat.setLargeIcon(BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.ic_launcher));
        notificationManager.notify(notificationId, notificationCompat.build());
    }

    public Drawable getUserAvatar( String profilePicUrl) throws FileNotFoundException {

        if (profilePicUrl == null) {
            return null;
        }
        return Drawable.createFromStream(new FileInputStream(new File(profilePicUrl)), profilePicUrl);
    }

    public void showInfoDialog(String title, String message, String positiveButtonText, Intent intent) {
        showInfoDialog(title, message, Color.RED, positiveButtonText, intent);
    }

    public void showInfoDialog(String title, String message, int textColor, String positiveButtonText, final Intent positiveIntent) {
        AlertDialog.Builder infoDialog = new AlertDialog.Builder(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        infoDialog.setTitle(title);
        TextView mTvMessage = new TextView(getContext());
        mTvMessage.setPadding(16, 16, 16, 16);
        mTvMessage.setTextColor(textColor);
        mTvMessage.setText(message);
        infoDialog.setView(mTvMessage);

        infoDialog.setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendBroadcast(positiveIntent);
            }
        });
        infoDialog.show();
        Log.i("DIALOG", "SHOWING");
    }



    public Bitmap getFileBitmap(String fileUri) {


        if (fileUri == null) {
            return null;
        }

        Bitmap bitmap = null;
        try {
            return bitmap = BitmapFactory.decodeStream(new FileInputStream(new File(fileUri)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap = BitmapFactory.decodeResource(getContext().getResources(),R.mipmap.error_icon);
    }

    public ProgressDialog showCustomProgressDialog(String title, String message, boolean cancelable) {
        ProgressDialog mDialog = new ProgressDialog(getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        mDialog.setTitle(title);
        mDialog.setMessage(message);
        mDialog.setCancelable(cancelable);
        mDialog.show();
        return mDialog;
    }

}
