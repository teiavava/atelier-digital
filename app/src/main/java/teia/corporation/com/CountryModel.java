package teia.corporation.com;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

    @SerializedName("language_code")
    public String languageCode;

    @SerializedName("language_name")
    public String languageName;

    @SerializedName("percentage")
    public String percentage;

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

}
