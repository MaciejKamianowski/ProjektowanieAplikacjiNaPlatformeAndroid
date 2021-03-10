package com.mk.battery_info;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private ProgressBar batteryProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        batteryProgressBar = findViewById(R.id.batteryProgressBar);
        loadBatteryInfo();
    }

    private void loadBatteryInfo(){
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);

        registerReceiver(batteryInfoReceiver, intentFilter);
    }

    private void updateBatteryData(Intent intent){
        boolean present = intent.getBooleanExtra(BatteryManager.EXTRA_PRESENT, false);
        if (present){
            StringBuilder batteryInfo = new StringBuilder();
            int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, 0);
            batteryInfo.append("Health: " + health).append("\n");

            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            if (level != -1 && scale != -1) {
                int batteryPercentage = (int) ((level) / ((float)scale) + 100.0f);
                batteryInfo.append("Battery PCT : " + batteryPercentage).append("\n");
            }

            int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
            batteryInfo.append("Plugged : " + plugged).append("\n");

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            batteryInfo.append("Charging Status : " + status).append("\n");

            if (intent.getExtras() != null) {
                String technology = intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
                batteryInfo.append("Technology : " + technology).append("\n");
            }

            int temperature = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
            if (temperature > 0) {
                batteryInfo.append("Temperature : " + ((float) temperature / 10f)).append(" C\n");
            }

            int voltage = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
            batteryInfo.append("Voltage : " + voltage).append(" mV\n");

            long capacity = getBatteryCapacity();
            batteryInfo.append("Capacity : " + capacity).append(" mAh\n");

            result.setText(batteryInfo.toString());
            batteryProgressBar.setProgress(level);

        } else {
            Toast.makeText(MainActivity.this,
                    "No Battery Present", Toast.LENGTH_LONG).show();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private long getBatteryCapacity(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BatteryManager batteryManager = (BatteryManager) getSystemService(Context.BATTERY_SERVICE);
            Long chargeCounter = batteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
            Long capacity = batteryManager.getLongProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

            if (chargeCounter != null && capacity != null) {
                long value = (long) (((float) chargeCounter / (float) capacity) * 100.0f);
                return value;
            }
        }

        return 0;
    }

    private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateBatteryData(intent);
        }
    };


}