package com.example.chiangj.androidadapter;

import android.widget.TextView;

/**
 * ViewHolder will store widgets present in the layout which means we won't need to repeatedly call findViewById everytime we call getView
 */

public class ViewHolder {
    TextView colorName;
    TextView colorDescription;
}
