package com.example.bdstudent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentOperations {
    private SimpleBDWrapper dbHelper;
    private String[] STUDENT_TABLE_COLUMNS = {SimpleBDWrapper.STUDENT_ID, SimpleBDWrapper.STUDENT_NAME};
    private SQLiteDatabase db;

    public StudentOperations(Context context){
        dbHelper = new SimpleBDWrapper(context);
    }

    public void open() throws SQLException{
        db=dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public Student addStudent(String name){
        ContentValues values = new ContentValues();
        values.put(SimpleBDWrapper.STUDENT_NAME, name);
        long studentID = db.insert(SimpleBDWrapper.TABLE_NAME,null,values);

        Cursor cursor = db.query(SimpleBDWrapper.TABLE_NAME, STUDENT_TABLE_COLUMNS,
                SimpleBDWrapper.STUDENT_ID + "=" + studentID, null, null,
                null,null);
        cursor.moveToFirst();
        Student student = parseStudent(cursor);
        cursor.close();
        return student;
    }

    public void deleteStudent(Student student){
        long id = student.getId();
        db.delete(SimpleBDWrapper.TABLE_NAME, SimpleBDWrapper.STUDENT_ID + "=" + id,null);
    }

    public List getAllStudents(){
        List students = new ArrayList();
        Cursor cursor = db.query(SimpleBDWrapper.TABLE_NAME, STUDENT_TABLE_COLUMNS, null,
                null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Student student = parseStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return students;
    }

    private Student parseStudent(Cursor cursor){
        Student student = new Student();
        student.setId(cursor.getInt(cursor.getColumnIndex(SimpleBDWrapper.STUDENT_ID)));
        student.setName(cursor.getString(cursor.getColumnIndex(SimpleBDWrapper.STUDENT_NAME)));
        return student;
    }
}
