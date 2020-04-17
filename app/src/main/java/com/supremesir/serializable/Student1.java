package com.supremesir.serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author HaoFan Fang
 * @date 2020/4/17 17:17
 */

public class Student1 implements Parcelable {
    private String name;
    private int age;
    private Score1 score1;

    public Student1(String name, int age, Score1 score1) {
        this.name = name;
        this.age = age;
        this.score1 = score1;
    }

    protected Student1(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student1> CREATOR = new Creator<Student1>() {
        @Override
        public Student1 createFromParcel(Parcel in) {
            return new Student1(in);
        }

        @Override
        public Student1[] newArray(int size) {
            return new Student1[size];
        }
    };

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

    public Score1 getScore1() {
        return score1;
    }

    public void setScore1(Score1 score1) {
        this.score1 = score1;
    }
}

class Score1 implements Parcelable {
    private static final long serialVersionUID = 3317679076025674757L;
    private int mathScore;
    private int englishScore;
    private int chineseScore;
    private String grade;

    public Score1(int mathScore, int englishScore, int chineseScore) {
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

    protected Score1(Parcel in) {
        mathScore = in.readInt();
        englishScore = in.readInt();
        chineseScore = in.readInt();
        grade = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mathScore);
        dest.writeInt(englishScore);
        dest.writeInt(chineseScore);
        dest.writeString(grade);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Score1> CREATOR = new Creator<Score1>() {
        @Override
        public Score1 createFromParcel(Parcel in) {
            return new Score1(in);
        }

        @Override
        public Score1[] newArray(int size) {
            return new Score1[size];
        }
    };

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
