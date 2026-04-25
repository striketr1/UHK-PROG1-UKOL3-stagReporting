package pro1.apiDataModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ExamsList {

    @SerializedName("termin")
    public List<Exams> items;
}
