package br.com.xoyz.testrestgps.rest;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import br.com.xoyz.testrestgps.entity.Check;
import br.com.xoyz.testrestgps.listview.ListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lelag on 01/08/2017.
 */

public class ChekInOutController implements Callback<Check> {

    private Check check;

    public void checkin(String latLng, String venueName, Check check){
        this.check = check;
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CheckApi.URL_CHECK).addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CheckApi checkApiInterface = retrofit.create(CheckApi.class);

        Call<Check> call = checkApiInterface.checkin(latLng, venueName,check.getId());
        call.enqueue(this);


    }

    public void checkout(Check check ){
        this.check = check;
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CheckApi.URL_CHECK).addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CheckApi checkApiInterface = retrofit.create(CheckApi.class);

        Call<Check> call = checkApiInterface.checkout(check.getId());
        call.enqueue(this);

    }


    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<Check> call, Response<Check> response) {
        if(!response.isSuccessful()) {
            check = response.body();
        }
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<Check> call, Throwable t) {
        Log.d("Erro na chamada REST", "Erro ao acessar a API da chamada remota", t);
    }
}
