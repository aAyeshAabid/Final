package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RcAdapter rcAdapter;
    List<Model> userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userlist = new ArrayList<>();
        recyclerView = findViewById(R.id.rcView);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        rcAdapter = new RcAdapter(getApplicationContext(),userlist);
        recyclerView.setAdapter(rcAdapter);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Model>> call = apiService.getUser();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                Toast.makeText(MainActivity.this, "API CONNECTED", Toast.LENGTH_SHORT).show();
                userlist= response.body();
                Log.d("TAG","Response = "+ userlist);
                rcAdapter.setUserlist(userlist);
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());

            }
        });

    }
}


// https://github.com/velmurugan-murugesan/Android-Example/blob/master/RetrofitAndroidExample/app/src/main/java/com/example/velmurugan/retrofitandroidexample/RecyclerAdapter.java