package me.adamoflynn.dynalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by Adam on 20/03/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Alarm!", Toast.LENGTH_SHORT).show();
		Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

		long[] vib = {600,600,600, 200, 200, 900, 200};

		Notification not = new Notification.Builder(context)
		  .setContentTitle("Alarm! Wake Up!")
			.setContentText("Click here to end Alarm.")
			.setSmallIcon(R.drawable.ic_alarm_white_48dp)
			.setAutoCancel(true)
			.setSound(alarmUri)
			.setVibrate(vib)
			.build();

		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.notify(0, not);

		Intent goToAccel = new Intent(context, AccelerometerService.class);
		context.stopService(goToAccel);
	}
}