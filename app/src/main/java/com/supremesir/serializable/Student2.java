package com.supremesir.serializable;


import com.google.gson.annotations.SerializedName;

/**
 * @author HaoFan Fang
 * @date 2020/4/19 16:11
 */

public class Student2 {

    // 使用 @SerializedName() 可以为每个属性自定义名称
    @SerializedName("student_name")
    private String name;
    private int age;
    private Score2 score2;

    public Student2(String name, int age, Score2 score2) {
        this.name = name;
        this.age = age;
        this.score2 = score2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score2 getScore() {
        return score2;
    }

    public void setScore(Score2 score2) {
        this.score2 = score2;
    }

}

class Score2 {
    private static final long serialVersionUID = 3317679076025674757L;
    private int mathScore;
    private int englishScore;
    private int chineseScore;
    private String grade;

    public Score2(int mathScore, int englishScore, int chineseScore) {
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.chineseScore = chineseScore;
        if (mathScore >= 90 && englishScore >= 90 && chineseScore >= 90) {
            this.grade = "A";
        } else if (mathScore >= 80 && englishScore >= 80 && chineseScore >= 80) {
            this.grade = "B";
        } else {
            this.grade = "C";
        }
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

