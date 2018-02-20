package com.example.willi.homeschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //Declare buttons
        Button Inboxbtn = (Button)findViewById(R.id.inboxButton);
        Button Attendancebtn = (Button) findViewById(R.id.attendanceButton);

        //Button to Admin Inbox
        Inboxbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, AdminInbox.class));
            }
        });

        //Button to Admin Attendance
        Attendancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminActivity.this, AdminAttendance.class));
            }
        });













    }
}
