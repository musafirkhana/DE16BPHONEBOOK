package com.de16b.vaiuu.myapplication.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.de16b.vaiuu.myapplication.R;
import com.de16b.vaiuu.myapplication.model.CollectionListModel;

import de.hdodenhof.circleimageview.CircleImageView;


public class CollectionAdapter extends ArrayAdapter<CollectionListModel> implements
		Filterable {
	private List<CollectionListModel> planetList;

	private Context context;
	private Filter planetFilter;
	private List<CollectionListModel> origPlanetList;

	public CollectionAdapter(List<CollectionListModel> planetList, Context ctx) {
		super(ctx, R.layout.row_main, planetList);
		this.planetList = planetList;
		this.context = ctx;
		this.origPlanetList = planetList;
	}

	public int getCount() {
		return planetList.size();
	}

	public CollectionListModel getItem(int position) {
		return planetList.get(position);
	}

	public long getItemId(int position) {
		return planetList.get(position).hashCode();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		PlanetHolder holder = new PlanetHolder();

		// First let's verify the convertView is not null
		if (convertView == null) {
			// This a new view we inflate the new layout
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.row_main, null);
			// Now we can fill the layout with the right values
			CircleImageView profile_image = (CircleImageView) v.findViewById(R.id.profile_image);;
			TextView tv = (TextView) v.findViewById(R.id.textview_1);
			TextView distView = (TextView) v.findViewById(R.id.textview_2);

			holder.planetNameView = tv;
			holder.distView = distView;

			v.setTag(holder);
		} else
			holder = (PlanetHolder) v.getTag();
		CollectionListModel p = planetList.get(position);
		holder.planetNameView.setText(p.getName());
		holder.distView.setText("" + p.getMobile());

		return v;
	}

	public void resetData() {
		planetList = origPlanetList;
	}

	/* *********************************
	 * We use the holder pattern It makes the view faster and avoid finding the
	 * component *********************************
	 */

	private static class PlanetHolder {
		public TextView planetNameView;
		public TextView distView;
	}

	/*
	 * We create our filter
	 */

	@Override
	public Filter getFilter() {
		if (planetFilter == null)
			planetFilter = new PlanetFilter();

		return planetFilter;
	}

	private class PlanetFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults results = new FilterResults();
			// We implement here the filter logic
			if (constraint == null || constraint.length() == 0) {
				// No filter implemented we return all the list
				results.values = origPlanetList;
				results.count = origPlanetList.size();
			} else {
				// We perform filtering operation
				List<CollectionListModel> nPlanetList = new ArrayList<CollectionListModel>();
				for (CollectionListModel p : planetList) {

					if (p.getName().toUpperCase()
							.startsWith(constraint.toString().toUpperCase())||
							p.getMobile().toUpperCase()
							.contains(constraint.toString().toUpperCase())) {
						nPlanetList.add(p);
					}

					// else if (p.getAbbr().toUpperCase()
					// .matches(constraint.toString().toUpperCase())) {
					// nPlanetList.add(p);
					// }
					// else if (p.getAbbr().toUpperCase()
					// .contains(constraint.toString().toUpperCase())) {
					// nPlanetList.add(p);
					// }

				}

				Collections.sort(nPlanetList, new Comparator<CollectionListModel>() {
					@Override
					public int compare(CollectionListModel fruite1,
									   CollectionListModel fruite2) {

						return fruite1
								.getName()
								.toString()
								.toUpperCase()
								.trim().replaceAll(" ", "")
								.compareTo(
										fruite2.getName().toString()
												.toUpperCase().trim().replaceAll(" ", ""));
					}
				});

				results.values = nPlanetList;
				results.count = nPlanetList.size();

			}
			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {

			// Now we have to inform the adapter about the new list filtered
			if (results.count == 0)
				notifyDataSetInvalidated();
			else {
				planetList = (List<CollectionListModel>) results.values;
				notifyDataSetChanged();
			}

		}

	}
}