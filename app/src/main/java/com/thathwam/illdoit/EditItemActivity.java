package com.thathwam.illdoit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        position = getIntent().getIntExtra("position", 0);
        String value = getIntent().getStringExtra("value");

        EditText edtValue = (EditText) findViewById(R.id.edtValue);
        edtValue.setText(value);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickSave(View view) {
        EditText etName = (EditText) findViewById(R.id.edtValue);

        Intent data = new Intent();
        data.putExtra("value", etName.getText().toString());
        data.putExtra("position", position);

        setResult(RESULT_OK, data);
        finish();
    }
}
