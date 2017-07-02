package com.example.android.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = (EditText) findViewById(R.id.input);
        listView = (ListView) findViewById(R.id.list_view);

        final ArrayList<String> doList = new ArrayList<String>();
        final ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, doList);

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
