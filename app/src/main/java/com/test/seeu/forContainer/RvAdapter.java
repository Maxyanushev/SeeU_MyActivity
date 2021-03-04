package com.test.seeu.forContainer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.test.seeu.R;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    // Запоним эти массивы из Json
    // А потом вместо массивов будем заполнять из Json базу данных SQLite
    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mAutors = new ArrayList<>();
    private ArrayList<String> mDetails = new ArrayList<>();

    public RvAdapter(Context Context, ArrayList<String> Image, ArrayList<String> Names, ArrayList<String> Autors, ArrayList<String> Details) {
        mImage = Image;
        mNames = Names;
        mAutors = Autors;
        mDetails = Details;
        mContext = Context;
    }

    private Context mContext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate используется для подстановке container.xml в holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.container, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImage.get(position))
                .into(holder.imgContainer);
        holder.txtName.setText(mNames.get(position));
        holder.txtAutor.setText(mAutors.get(position));
        holder.txtDetails.setText(mDetails.get(position));
    }

    @Override
    public int getItemCount() {
        return mImage.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgContainer;
        TextView txtName;
        TextView txtAutor;
        TextView txtDetails;

        ConstraintLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContainer = itemView.findViewById(R.id.imgContainer);
            txtAutor = itemView.findViewById(R.id.txtAvtor);
            txtName = itemView.findViewById(R.id.txtName);
            txtDetails = itemView.findViewById(R.id.txtDetails);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
