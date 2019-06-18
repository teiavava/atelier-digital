package teia.corporation.com;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("success")
    private boolean success;

    @SerializedName("results")
    private List<CountryModel> results;

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<CountryModel> getResults() {
        return results;
    }

    public void setResults(List<CountryModel> results) {
        this.results = results;
    }
}
