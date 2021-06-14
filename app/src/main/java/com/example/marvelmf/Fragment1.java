package com.example.marvelmf;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Fragment1 extends Fragment {

    private HeroAdapter userAdapter;
    RecyclerView recyclerView;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.fragment1, container, false);

       recyclerView = rootview.findViewById(R.id.main_list);

         HeroViewModel mainViewModel= ViewModelProviders.of(this).get(HeroViewModel.class);

        mainViewModel.getHeroes().observe(getViewLifecycleOwner(), new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> userList) {
                setRecyclerView(userList);

            }
        });






    return rootview;
}
    private void setRecyclerView(List<Hero> userList) {
        userAdapter = new HeroAdapter(getContext(),userList);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();
    }

}
