package com.seeksolution.userlisttask.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seeksolution.userlisttask.Model.User;
import com.seeksolution.userlisttask.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    public UserAdapter(Context context, ArrayList<User> user) {
        this.context = context;
        this.user = user;
    }

    private Context context;
    ArrayList<User> user;

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.my_custom_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {


        Picasso.get().load(Uri.parse(user.get(position).getAvatar())).into(holder.user_img);
        holder.fname.setText(user.get(position).getFirst_name());
        holder.lname.setText(user.get(position).getLast_name());
        holder.email.setText(user.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView user_img;
        TextView fname, lname, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_img = itemView.findViewById(R.id.user_image);
            fname = itemView.findViewById(R.id.f_name);
            lname = itemView.findViewById(R.id.l_name);
            email= itemView.findViewById(R.id.email);
        }
    }
}
