package edu.mbhs.blairtalks;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

/********************************
 * SoundPlayer.java				*
 * Shows a picture of a teacher	*
 * and plays their quote to go	*
 * along with it.				*
 ********************************/
public class SoundPlayer extends Activity {
	
	private ImageView play = null;		// Picture of teacher.
	// private boolean isPlaying = false;
	MediaPlayer mp = null; 		// Are these supposed to be private? - Robert
	MediaPlayer mp2 = null; 	// Are these supposed to be private? - Robert
	
	// Teacher asset files
	private int[] soundFilesTeachers = { R.raw.duval, R.raw.dvorsky, R.raw.fowler, R.raw.giles, R.raw.ostrander, R.raw.pham, 
			R.raw.piper, R.raw.rose, R.raw.schafer, R.raw.stein, R.raw.street };
	private int[] imageFilesHDTeachers = { R.drawable.duval, R.drawable.dvorsky, R.drawable.fowler, R.drawable.giles, R.drawable.ostrander, R.drawable.pham, 
			R.drawable.piper, R.drawable.rose, R.drawable.schafer, R.drawable.stein, R.drawable.street, R.drawable.rosestachecopy };
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sound_player);
		
		//I may be wrong about this, but I'm not sure if these need to be or should be in OnCreate vs instance variables.
		mp = MediaPlayer.create(SoundPlayer.this,  R.raw.duval);
		mp2 = MediaPlayer.create(SoundPlayer.this, R.raw.rose);
		play = (ImageView) (findViewById(R.id.playImage));
		
		mp.setLooping(false);
		mp2.setLooping(false);
		
		int itemPosition = this.getIntent().getIntExtra("POSITION_CLICKED", -1);
		if(itemPosition != 11)
			setImageAndMedia(itemPosition);
		else if(itemPosition == 11)
		{
			play.setImageResource(R.drawable.rosestachecopy);
			mp2 = MediaPlayer.create(SoundPlayer.this, R.raw.rose);
			mp2.start();
			mp2.setLooping(true);
			mp = MediaPlayer.create(SoundPlayer.this, R.raw.pham);
			mp.start();
			mp.setLooping(true);
		};
		
		/*mp.setOnCompletionListener(new OnCompletionListener() {	
			public void onCompletion(MediaPlayer mp) {
				isPlaying = false;
			}
		});*/
		
		play.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) 
			{
				//mp.setLooping(true);
				mp.seekTo(0);
				mp.start();	
				//isPlaying = true;
			}
		});	
	} // end protected void onCreate(Bundle savedInstanceState)

	private void setImageAndMedia(int n)
	{
		mp = MediaPlayer.create(SoundPlayer.this, soundFilesTeachers[n]);
		play.setImageResource(imageFilesHDTeachers[n]);
	} // end private void setImageAndMedia(int n)
	
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sound_player, menu);
		return true;
	} // end public boolean onCreateOptionsMenu(Menu menu)
} //end public class SoundPlayer