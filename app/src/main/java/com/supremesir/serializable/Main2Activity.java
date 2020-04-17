package com.supremesir.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.supremesir.serializable.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        Student1 student1 = bundle.getParcelable("student");
        binding.textViewName.setText(student1.getName());
        binding.textViewAge.setText(String.valueOf(student1.getAge()));
        binding.textViewMath.setText(String.valueOf(student1.getScore1().getMathScore()));
        binding.textViewEnglish.setText(String.valueOf(student1.getScore1().getEnglishScore()));
        binding.textViewChinese.setText(String.valueOf(student1.getScore1().getChineseScore()));
        binding.textViewGrade.setText(student1.getScore1().getGrade());
    }
}
