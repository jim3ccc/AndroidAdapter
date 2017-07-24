package com.example.chiangj.androidadapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set our ContentView to a ListView
        ListView colorList = new ListView(this);
        setContentView(colorList);

        //our dataset
        final Color[] colors = {
                new Color("red", "the first color in the rainbow"),
                new Color("orange", "the second color in the rainbow"),
                new Color("yellow", "the third color in the rainbow"),
                new Color("green", "the fourth color in the rainbow"),
                new Color("blue", "the fifth color in the rainbow"),
                new Color("indigo", "the sixth color in the rainbow"),
                new Color("violet", "the last color in the rainbow"),
        };

        //our adapter that overrides getView - gets the view of each item in the list
        ArrayAdapter<Color> colorArrayAdapter = new ArrayAdapter<Color>(this, 0, colors){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                Color currentColor = colors[position];

                //convertView is the view of the list item
                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.view_custom_list_item, null, false);

                    //viewHolder stores the views of convertView so we don't have to call findViewById over and over
                    ViewHolder viewHolder = new ViewHolder();
                    viewHolder.colorName = (TextView)convertView.findViewById(R.id.color_name);
                    viewHolder.colorDescription = (TextView) convertView.findViewById(R.id.color_description);

                    //kinda like giving convertView a "property" or "field" that we can refer to
                    convertView.setTag(viewHolder);
                }
                TextView colorName = ((ViewHolder)convertView.getTag()).colorName;
                TextView colorDescription = ((ViewHolder)convertView.getTag()).colorDescription;

                colorName.setText(currentColor.colorName);
                colorDescription.setText(currentColor.description);

                return convertView;
            }
        };

        //set the adapter
        colorList.setAdapter(colorArrayAdapter);

        //define onClickListener on each item in the list
        colorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "clicked on item at position " + i + " and in row " + l, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
