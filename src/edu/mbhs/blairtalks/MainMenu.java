package edu.mbhs.blairtalks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainMenu extends Activity {

	int[] imageId = {
			R.drawable.duval, R.drawable.dvorsky,
			R.drawable.fowler, R.drawable.giles,
			R.drawable.ostrander, R.drawable.pham,
			R.drawable.piper, R.drawable.rose,
			R.drawable.schafer, R.drawable.stein,
			R.drawable.street, R.drawable.rosestache
	};
	
	GridView gv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		
		gv = (GridView) findViewById(R.id.gridView1);
		ImageGrid adapter = new ImageGrid(this, imageId);
		gv.setAdapter(adapter);
		gv.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Intent i = new Intent(MainMenu.this, SoundPlayer.class);
				i.putExtra("POSITION_CLICKED", position);
				startActivity(i);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
