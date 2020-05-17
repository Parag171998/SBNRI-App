package com.example.paragranesbnri.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.paragranesbnri.Models.User;
import com.example.paragranesbnri.R;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.UserViewHolder> {

    Context context;

    public UserAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(context).inflate(
                R.layout.custom_recycler_layout
                ,parent
                ,false);


        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = getItem(position);

        if(user != null )
        {
            if(user.getLicense() != null && user.getPermissions() != null) {
                if (user.getFullName() != null)
                    holder.userNname.setText("Name : " + user.getFullName());
                if (user.getPermissions().getAdmin() != null)
                    holder.permAdmin.setText("admin : " + user.getPermissions().getAdmin().toString());
                if (user.getPermissions().getPull() != null)
                    holder.permPull.setText("pull : " + user.getPermissions().getPull().toString());
                if (user.getPermissions().getPush() != null)
                    holder.permPush.setText("push : " + user.getPermissions().getPush().toString());
                if (user.getLicense().getName() != null)
                    holder.licName.setText("name : " + user.getLicense().getName());
                if (user.getLicense().getKey() != null)
                    holder.licKey.setText("key : " + user.getLicense().getKey());
                if (user.getLicense().getSpdxId() != null)
                    holder.licSpxId.setText("spx id : " + user.getLicense().getSpdxId());
                if (user.getOpenIssuesCount() != null)
                    holder.issueCount.setText(user.getOpenIssuesCount().toString());
            }

        }
    }

    private static DiffUtil.ItemCallback<User> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<User>() {
                @Override
                public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                    return oldItem.getId() == newItem.getId();
                }


                @Override
                public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                    return oldItem == newItem;
                }
            };

    public class UserViewHolder extends RecyclerView.ViewHolder{

        TextView userNname;
        TextView permAdmin;
        TextView permPush;
        TextView permPull;
        TextView licName;
        TextView licKey;
        TextView licSpxId;
        TextView issueCount;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            userNname = itemView.findViewById(R.id.userName);
            permAdmin = itemView.findViewById(R.id.permisssion_admin);
            permPush = itemView.findViewById(R.id.permisssion_push);
            permPull = itemView.findViewById(R.id.permisssion_pull);
            licName = itemView.findViewById(R.id.licens_name);
            licKey = itemView.findViewById(R.id.licens_key);
            licSpxId = itemView.findViewById(R.id.licens_spx_id);
            issueCount = itemView.findViewById(R.id.issue_count);
        }
    }
}
