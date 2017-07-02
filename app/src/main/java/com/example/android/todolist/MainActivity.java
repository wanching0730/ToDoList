package com.example.android.todolist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private ListView listView;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.linear_layout);
        ll.setBackgroundColor(getResources().getColor(R.color.colorLightBlue));

        etInput = (EditText) findViewById(R.id.input);
        listView = (ListView) findViewById(R.id.list_view);

        final ArrayList<String> doList = new ArrayList<String>();
        //final ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.black_list, R.id.items, doList);

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, doList){

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =super.getView(position, convertView, parent);

                TextView textView=(TextView) view.findViewById(android.R.id.text1);

                textView.setTextColor(Color.BLUE);

                return view;
            }
        };


        listView.setAdapter(adapter);

        etInput.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //AUTO-GENERATED

                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_DOWN) || (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        doList.add(0, etInput.getText().toString());
                        adapter.notifyDataSetChanged();
                        etInput.setText("");
                        return true;
                    }
                }

                return false;
            }
        });
    }
}
