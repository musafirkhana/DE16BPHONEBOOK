package com.de16b.vaiuu.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.de16b.vaiuu.myapplication.adapter.CollectionAdapter;
import com.de16b.vaiuu.myapplication.holder.AllCollectionList;
import com.de16b.vaiuu.myapplication.model.CollectionListModel;

import java.util.ArrayList;

public class MainActivity extends Activity {
    String text;
    String respones_results;
    Context context;
    ListView abbr_list;
    public EditText edit_seach;
    private TextView abbr_scroll;
    int textlength = 0;
    ArrayList<CollectionListModel> planetsList = new ArrayList<CollectionListModel>();
    private CollectionAdapter abbreviationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        edit_seach = (EditText) findViewById(R.id.edit_seach);
        abbr_list = (ListView) findViewById(R.id.abbr_list);
        abbr_scroll=(TextView)findViewById(R.id.abbr_scroll);
        abbr_scroll.setSelected(true);
        abbr_scroll.setText("Musafir Ali");
        abbreviationAdapter = new CollectionAdapter(
                AllCollectionList.getAllArabicList(), this);
        abbr_list.setAdapter(abbreviationAdapter);

        // TextFilter
        abbr_list.setTextFilterEnabled(true);

        edit_seach.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (count < before) {
                    // We're deleting char so we need to reset the adapter data
                    abbreviationAdapter.resetData();
                }

                abbreviationAdapter.getFilter().filter(s.toString());

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // React to user clicks on item
//		abbr_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			public void onItemClick(AdapterView<?> parentAdapter, View view,
//					int position, long id) {
//				AbbriListModel query = AllAbbriviationList.getAllArabicList()
//						.elementAt(position);
//
//				AlertMessage.showMessage(context, "Abbreviation ", query.getAbbr()
//						.toUpperCase() + " : " + query.getAbbreviate());
//
//			}
//		});

    }
}
