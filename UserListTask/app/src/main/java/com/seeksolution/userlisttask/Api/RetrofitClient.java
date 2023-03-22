package com.seeksolution.userlisttask.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final  String BASE_URL ="https://reqres.in/api/";
    private static RetrofitClient instance ;
    private Retrofit retrofit;

    // private constructor initialize retrofit
    private RetrofitClient() {
        Gson gson=new GsonBuilder().setLenient().create();


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);

        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build()).build();

    }
    public static  synchronized RetrofitClient getInstance(){
        if (instance==null){
            instance =new RetrofitClient();
        }
        return  instance;
    }
    public Api getAPI(){
        return   retrofit.create(Api.class);
    }
}

