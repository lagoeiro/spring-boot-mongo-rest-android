package br.com.xoyz.testrestgps.rest;

import java.io.IOException;
import java.util.List;

import br.com.xoyz.testrestgps.entity.Check;
import br.com.xoyz.testrestgps.listview.ListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import android.app.AlertDialog;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by lelag on 01/08/2017.
 */

public class ListCheckController implements Callback<List<Check>> {


    private ListAdapter listAdapter;



    public void find(int page, int size, ListAdapter listAdapter){
        this.listAdapter = listAdapter;
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CheckApi.URL_CHECK).addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CheckApi checkApiInterface = retrofit.create(CheckApi.class);

        Call<List<Check>> call = checkApiInterface.find(page, size);
        call.enqueue(this);

    }




    @Override
    public void onResponse(Call<List<Check>> call, Response<List<Check>> response) {
        if(response.isSuccessful()) {
            listAdapter.getData().addAll(response.body());
            listAdapter.notifyDataSetChanged();
        } else {
            try {
                Log.d("Erro na chamada REST", response.errorBody().string());
                listAdapter.showError(response.errorBody().string());
            } catch (IOException e) {
                String msg = "Não foi possível obter os dados";
                Log.d("Exceção na chamada REST", msg );
                listAdapter.showError(msg);
            }

        }
    }

    @Override
    public void onFailure(Call<List<Check>> call, Throwable t) {
        String msg = "Erro ao acessar a API da chamada remota";
        Log.d("Erro na chamada REST", msg, t);
        listAdapter.showError(msg);
    }


}
