package com.hfatih.reflow.Activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.hfatih.reflow.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // configure the SlidingMenu
        SlidingMenu leftMenu = new SlidingMenu(this);
        leftMenu.setMode(SlidingMenu.LEFT);
        leftMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        leftMenu.setShadowWidthRes(R.dimen.shadow_width);
        leftMenu.setShadowDrawable(R.drawable.shadow);
        leftMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        leftMenu.setFadeDegree(0.35f);
        leftMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        leftMenu.setMenu(R.layout.slidingmenu_main);

//		SlidingMenu rightMenu = new SlidingMenu(this);
//		rightMenu.setMode(SlidingMenu.RIGHT);
//		rightMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//		rightMenu.setShadowWidthRes(R.dimen.shadow_width);
//		rightMenu.setShadowDrawable(R.drawable.shadow);
//		rightMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//		rightMenu.setFadeDegree(0.35f);
//		rightMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
//		rightMenu.setMenu(R.layout.slidingmenu_main);



	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
//		if (id == R.id.action_settings) {
//			return true;
//		}

		return super.onOptionsItemSelected(item);
	}
}
