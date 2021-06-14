package com.example.marvelmf;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroRepository {
    private ArrayList<Hero> heroes=new ArrayList<>();
    private MutableLiveData<List<Hero>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public HeroRepository(Application application) {
        this.application=application;
    }
    public MutableLiveData<List<Hero>> getMutableLiveData(){
        Call<List<Hero>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                mutableLiveData.setValue(response.body());
               // Log.d("shit", "onResponse: parse" + heroList);

//                dataadapter.notifyDataSetChanged();
//                dataadapter=new HeroAdapter(MainActivity.this, heroList,MainActivity.this);
//                hList.setAdapter(dataadapter);

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

                //Toast.makeText(Context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return mutableLiveData;

    }


    //    private Api api;
//
//    public HeroRepository() {
//        api=RetrofitClient.getInstance().getMyApi();
//    }
//    public MutableLiveData<List<Hero>> loadHeroes(){
//        MutableLiveData<List<Hero>> heroData = new MutableLiveData<>();
//        api.getHeroes().enqueue(new Callback<List<Hero>>() {
//            @Override
//            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
//                heroData.postValue(response.body());
//                Log.d("shit", "onResponse: parse" + heroData);
//
////                dataadapter.notifyDataSetChanged();
////                dataadapter=new HeroAdapter(MainActivity.this, heroList,MainActivity.this);
////                hList.setAdapter(dataadapter);
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Hero>> call, Throwable t) {
//
//                //Toast.makeText(Context, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//        return heroData;
//}
}
