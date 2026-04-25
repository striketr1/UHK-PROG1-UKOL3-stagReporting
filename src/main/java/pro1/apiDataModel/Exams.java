package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Exams {

    @SerializedName("obsazeni")
    public int occupancy;
    @SerializedName("ucitIdno")
    public int teacherId;
}
