package teia.corporation.com;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolveFragment extends Fragment {
    Button detectButton;
    EditText textBox;
    RecyclerView countryList;
    List<CountryModel> countryModels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.solver_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        detectButton = getView().findViewById(R.id.detect_button);
        textBox = getView().findViewById(R.id.text_box);
        countryList = getView().findViewById(R.id.contry_list);

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeDetection();
            }
        });

        countryList.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new CountryViewHolder(getLayoutInflater().inflate(R.layout.country_item,viewGroup,false));
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                ((CountryViewHolder)viewHolder).bind(countryModels.get(i));
            }

            @Override
            public int getItemCount() {
                return countryModels.size();
            }
        });

        countryList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void makeDetection(){
        RetrofitManager.getInstance()
                .detectLanguage("a56302af638ffb1cfb0d8d2900d4a66b",textBox.getText().toString())
                .enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if(countryList == null) return;

                        if(response.body().getResults() != null){
                            countryModels = response.body().getResults();
                        } else {
                            countryModels.clear();
                        }

                        countryList.getAdapter().notifyDataSetChanged();

                        if(response.body().getSuccess()){
                            Toast.makeText(getContext(),response.body().getResults().get(0).languageName, Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(),"Something is Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Toast.makeText(getContext(),"Failure", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}