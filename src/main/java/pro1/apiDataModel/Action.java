package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action
{
    @SerializedName("obsazeni")
    public int studentCount;
    @SerializedName("ucitIdno")
    public int teacherID;
}
