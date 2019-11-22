package com.infs.dishupapp.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.infs.dishupapp.models.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    // With LiveData can observe the object, when there's changes in note_table, the List<Note>
    // will be automatically updated with room library.
    @Query("SELECT * FROM note_table ORDER BY priority ASC")
    LiveData<List<Note>> getAllNotes();
}
