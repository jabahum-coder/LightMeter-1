package com.webkist.android.lightmeter;

import android.os.Bundle;

public class TvActivity extends BaseSensorActivity {
	static int shutterSpeed = 0;
	static int apertureValue = 0;
	static int isoSpeed = 0;
	
	public static final NumberPicker.Formatter SHUTTER_FORMATTER =
		new NumberPicker.Formatter() {
            public String toString(int value) {
            	TvActivity.shutterSpeed = value;
                if(speeds[value] == 1) {
                	return "1";
                } else {
                	StringBuilder mBuilder = new StringBuilder();
                	return mBuilder.append("1/").append(speeds[value]).toString();
                }
            }
    };

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tv);
        NumberPicker shutter = (NumberPicker) findViewById(R.id.shutterPicker);
        shutter.setFormatter(SHUTTER_FORMATTER);
        shutter.setRange(0, speeds.length - 1);
        shutter.setSpeed(100);
        shutter.setIncBy(1);
        shutter.setEnabled(true);
    }
}