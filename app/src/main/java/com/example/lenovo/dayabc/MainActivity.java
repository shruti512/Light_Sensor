package com.example.lenovo.dayabc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {//2 methods r der 1.accuracy change n value change..how to implement the method

    MediaPlayer mp;
    Sensor s;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp=MediaPlayer.create(this,R.raw.a);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);//this error is coming coz in this app sensor package is nt there .so we need to import sensor package

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
       if(event.values[0]>5)
       {
           mp.start();
       }
        else
       {
           mp.pause();
       }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
