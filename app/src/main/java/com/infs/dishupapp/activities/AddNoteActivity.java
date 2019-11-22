package com.infs.dishupapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.infs.dishupapp.R;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.infs.dishupapp.activities.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.infs.dishupapp.activities.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.infs.dishupapp.activities.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.infs.dishupapp.activities.EXTRA_PRIORITY";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText((intent.getStringExtra(EXTRA_DESCRIPTION)));
            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
        } else {
            setTitle("Add Note");
        }
    }

    private void saveNote() {
        // Extract values from the views
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();

        // If the title and description has just spaces or no text, show the toast message.
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please fill in the title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        // Accept the input to be saved into the notes
        // Put the values into the resulting intent
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        // Indicates if input was successful
        setResult(RESULT_OK, data);
        finish();
    }

    // Display the add_note_menu as the menu of the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    // Handle clicks in the menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
