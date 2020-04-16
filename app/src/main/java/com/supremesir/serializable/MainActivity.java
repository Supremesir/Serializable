package com.supremesir.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.supremesir.serializable.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_main);

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int math = Integer.parseInt(binding.editTextMath.getText().toString());
                int english = Integer.parseInt(binding.editTextEnglish.getText().toString());
                int chinese = Integer.parseInt(binding.editTextChinese.getText().toString());
                Score score = new Score(math, english, chinese);
                String name = binding.editTextName.getText().toString();
                int age = Integer.parseInt(binding.editTextAge.getText().toString());
                Student student = new Student(name, age, score);

                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput(getResources().getString(R.string.FILE_NAME), MODE_PRIVATE));
                    objectOutputStream.writeObject(student);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                
            }
        });
    }
}
