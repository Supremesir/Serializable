package com.supremesir.serializable;

import java.io.Serializable;

/**
 * @author HaoFan Fang
 * @date 2020/4/16 07:45
 */

// transient 关键词表示 对某一个属性不做序列化
public class Student implements Serializable {
    // 对于不同的数据结构的标识
    // 如果不手动写，系统会自动生成，且不同数据结构生成不同的
    private static final long serialVersionUID = 5013468841441974555L;
    private String name;
    private int age;
    private Score score;

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

class Score implements Serializable{
    private static final long serialVersionUID = 3317679076025674757L;
    private int mathScore;
    private int englishScore;
    private int chineseScore;
    private String grade;

    public Score(int mathScore, int englishScore, int chineseScore) {
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
