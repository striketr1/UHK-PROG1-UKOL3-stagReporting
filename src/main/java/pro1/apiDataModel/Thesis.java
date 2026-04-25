package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Thesis {

    @SerializedName("datumZadani")
    public Date assignedDate;
    @SerializedName("datumOdevzdani")
    public Date submittedDate;
}
