package com.example.marvelmf;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HeroViewModel extends AndroidViewModel {

   // private MutableLiveData<List<Hero>> heroList;
    private HeroRepository heroRepository;

    public HeroViewModel(@NonNull Application application) {
        super(application);
        heroRepository=new HeroRepository(application);
    }
    public LiveData<List<Hero>> getHeroes(){
        return heroRepository.getMutableLiveData();
    }
    //    public void init(){
//        if (heroList != null){
//            return;
//        }
//        heroRepository=new HeroRepository();
//        heroList=heroRepository.loadHeroes();
//
//    }


}