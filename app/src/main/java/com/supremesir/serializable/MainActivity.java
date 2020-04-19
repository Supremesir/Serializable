package com.supremesir.serializable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
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
                String name = binding.editTextName.getText().toString();
                int age = Integer.parseInt(binding.editTextAge.getText().toString());
                // Serializable 序列化
                Score score = new Score(math, english, chinese);
                Student student = new Student(name, age, score);
                // Parcelable 序列化
                Score1 score1 = new Score1(math, english, chinese);
                Student1 student1 = new Student1(name, age, score1);
                // JSON序列化
                Score2 score2 = new Score2(math, english, chinese);
                Student2 student2 = new Student2(name, age, score2);

                // 将 Serializable 序列化后的数据储存在文件系统里，便于其他 Activity 或者 Process 读取
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

                // 将 Parcelable 序列化后的数据放在 Bundle 里， 通过 Intent 给其他 Activity 或者 Process
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("student", student1);
                intent.putExtra("data", bundle);
                startActivity(intent);

                // 使用 Gson
                Gson gson = new Gson();
                String jsonStudent2 = gson.toJson(student2);
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
