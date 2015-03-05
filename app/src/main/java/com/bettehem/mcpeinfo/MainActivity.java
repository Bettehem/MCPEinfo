package com.bettehem.mcpeinfo;

/*
    Copyright 2015  Chris Mustola

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see http://www.gnu.org/licenses/.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    Toolbar toolbar;

    //temporary values
    SharedPreferencesSavingAndLoading.Saving saving;
    SharedPreferencesSavingAndLoading.Loading loading;
    SharedPreferencesSavingAndLoading.Deleting deleting;
    TextView textView;
    EditText valueNameInput, valueInput;
    Button save, load, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        variables();
    }


    public void variables(){
        toolbars();

        //temporary
        temporaryVariables();
    }

    public void temporaryVariables(){
        textView = (TextView) findViewById(R.id.textView);
        valueNameInput = (EditText) findViewById(R.id.editText);
        valueInput = (EditText) findViewById(R.id.editText2);
        save = (Button) findViewById(R.id.button2);
        load = (Button) findViewById(R.id.button);
        clear = (Button) findViewById(R.id.button3);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueName = valueNameInput.getText().toString();
                String value = valueInput.getText().toString();
                saving.saveString(getApplicationContext(), valueName, value);
                Toast.makeText(getApplicationContext(), "Value has been saved!", Toast.LENGTH_SHORT).show();
                textView.setText("");
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valueName = valueNameInput.getText().toString();
                String loadedValue;
                loadedValue = loading.loadString(getApplicationContext(), valueName);
                textView.setText(loadedValue);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleting.deleteAllValues(getApplicationContext());
                Toast.makeText(getApplicationContext(), "Values have been deleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toolbars(){
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
