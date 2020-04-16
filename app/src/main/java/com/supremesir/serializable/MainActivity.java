package com.supremesir.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.supremesir.serializable.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.ObjectInputStream;
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
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    // 保存数据完成后，清空editText
                    binding.editTextName.getText().clear();
                    binding.editTextAge.getText().clear();
                    binding.editTextMath.getText().clear();
                    binding.editTextEnglish.getText().clear();
                    binding.editTextChinese.getText().clear();
                    binding.textView.setText("-");
                    Toast.makeText(MainActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        binding.buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput(getResources().getString(R.string.FILE_NAME)));
                    Student student = (Student) objectInputStream.readObject();
                    binding.editTextName.setText(student.getName());
                    // Integer 变量必须用String.valueOf()
                    binding.editTextAge.setText(String.valueOf(student.getAge()));
                    binding.editTextMath.setText(String.valueOf(student.getScore().getMathScore()));
                    binding.editTextEnglish.setText(String.valueOf(student.getScore().getEnglishScore()));
                    binding.editTextChinese.setText(String.valueOf(student.getScore().getChineseScore()));
                    binding.textView.setText(student.getScore().getGrade());
                    Toast.makeText(MainActivity.this, "Data Loaded!", Toast.LENGTH_SHORT).show();
                    // binding.textView.setText(student.getScore().getClass());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
