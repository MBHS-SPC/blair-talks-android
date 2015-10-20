package edu.mbhs.blairtalks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageGrid extends BaseAdapter {

	private Context mContext;
	private final int[] imageId;
	
	public ImageGrid(Context c, int[] imageId){
		mContext = c;
		this.imageId = imageId;
	}
	
	@Override
	public int getCount() {
		return imageId.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View grid;
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		if (convertView == null){
			grid = new View(mContext);
			grid = inflater.inflate(R.layout.grid_single, null);
		}
		else {
			grid = (View) convertView;
		}

		((ImageView) grid.findViewById(R.id.grid_image)).setImageResource(imageId[position]);
		
		return grid;
	}
	
}
