package teia.corporation.com;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryViewHolder extends RecyclerView.ViewHolder {
    private ImageView icon;
    private TextView name;
    private TextView percentage;

    public CountryViewHolder (@NonNull View container) {
        super(container);
        icon = container.findViewById(R.id.country_image);
        name = container.findViewById(R.id.name);
        percentage = container.findViewById(R.id.match);
    }

    public void bind(CountryModel model) {
        name.setText(model.languageName);
        percentage.setText(model.percentage.substring(0, Math.min(model.percentage.length(), 5)) + "%");

        if (model.languageCode.equals("ro")) {
            icon.setImageResource(R.drawable.ro);
        }else
        if (model.languageCode.equals("fr")) {
            icon.setImageResource(R.drawable.fr);
        }else
        if (model.languageCode.equals("it")) {
            icon.setImageResource(R.drawable.it);
        }else
        if (model.languageCode.equals("es")) {
            icon.setImageResource(R.drawable.es);
        }else
        if (model.languageCode.equals("us")) {
            icon.setImageResource(R.drawable.us);
        }else
        if (model.languageCode.equals("ru")) {
            icon.setImageResource(R.drawable.ru);
        }else
        if (model.languageCode.equals("en")) {
            icon.setImageResource(R.drawable.gb);
        }else{
            icon.setImageResource(R.drawable.question);
        }
    }
}
