package com.lars_albrecht.android.smsplan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.lars_albrecht.android.smsplan.activities.CreateEventActivity;
import com.lars_albrecht.android.smsplan.activities.HistoryActivity;
import com.lars_albrecht.android.smsplan.activities.UpcomingActivity;
import com.lars_albrecht.android.smsplan.database.EventsDataSource;

public class IntroActivity extends Activity implements OnClickListener {

	public static Context appContext;
	private Button openCreateActivityButton = null;
	private Button openHistoryActivityButton = null;
	private Button openUpcomingActivityButton = null;

	@Override
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_intro);

		this.openCreateActivityButton = (Button) this.findViewById(R.id.btnOpenCreateActivity);
		this.openCreateActivityButton.setOnClickListener(this);

		this.openHistoryActivityButton = (Button) this.findViewById(R.id.btnOpenHistoryActivity);
		this.openHistoryActivityButton.setOnClickListener(this);

		this.openUpcomingActivityButton = (Button) this.findViewById(R.id.btnOpenUpcomingActivity);
		this.openUpcomingActivityButton.setOnClickListener(this);

		EventsDataSource.getInstance(this.getApplicationContext());
	}

	@Override
	public void onClick(final View v){
		if (v == this.openCreateActivityButton) {
			this.startActivity(new Intent(IntroActivity.this, CreateEventActivity.class));
		} else if (v == this.openHistoryActivityButton) {
			this.startActivity(new Intent(IntroActivity.this, HistoryActivity.class));
		} else if (v == this.openUpcomingActivityButton) {
			this.startActivity(new Intent(IntroActivity.this, UpcomingActivity.class));
		}
	}

	@Override
	protected void onDestroy(){
		EventsDataSource.getInstance(this.getApplicationContext()).close();
		super.onDestroy();
	}
}
