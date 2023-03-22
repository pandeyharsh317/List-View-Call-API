
package com.seeksolution.userlisttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.seeksolution.userlisttask.Adapter.UserAdapter;
import com.seeksolution.userlisttask.Api.RetrofitClient;
import com.seeksolution.userlisttask.Model.User;
import com.seeksolution.userlisttask.Model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> user = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rc_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        Call<UserResponse> call = RetrofitClient.getInstance().getAPI().GetUser();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()){
                    UserResponse userResponse=response.body();
                    int arraylist = userResponse.getData().size();
                    for (int i = 0;  i<arraylist; i++){
                        user.add(new User(userResponse.getData().get(i).getId(),
                                userResponse.getData().get(i).getEmail(),
                                userResponse.getData().get(i).getFirst_name(),
                                userResponse.getData().get(i).getLast_name(),
                                userResponse.getData().get(i).getAvatar()
                                ));
                    }
                    UserAdapter userAdapter = new UserAdapter(getApplicationContext(),user);
                    recyclerView.setAdapter(userAdapter);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Internet Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}