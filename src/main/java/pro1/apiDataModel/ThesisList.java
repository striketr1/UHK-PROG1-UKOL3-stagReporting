package pro1.apiDataModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ThesisList {

    @SerializedName("kvalifikacniPrace")
    public List<Thesis> items;
}
