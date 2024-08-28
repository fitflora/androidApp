package com.example.fitflora_proto_one.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitflora_proto_one.R;
import com.example.fitflora_proto_one.data.model.Tree;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    private List<Tree> Treelst;
    private int layoutID;

    public HomeAdapter(List<Tree> Treelst, int layoutID) {
        this.Treelst = Treelst;
        this.layoutID = layoutID;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.layoutID, parent, false);
        return new ViewHolder(view, Treelst);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(Treelst.size() > 0){
            Tree tree = Treelst.get(position);
            holder.textViewLocationName.setText(tree.getName());
            holder.textViewLocationAdd.setText(tree.getLocation());

            if(holder.textViewDistance != null) {
                holder.textViewDistance.setText(String.valueOf(tree.getDistance()));
                Log.d("DEBUGGING"," resLandmark " + holder.textViewDistance.getText() );
            }

        }

    }
    @Override
    public int getItemCount() {
        return Treelst != null ? Treelst.size() : 0;
    }

    public void updateData(List<Tree> newtrees) {
        Treelst.clear();  // Clear existing data
        Treelst.addAll(newtrees);  // Add new data
        notifyDataSetChanged();  // Notify the RecyclerView of data change
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewLocationName;
        TextView textViewLocationAdd;
        TextView textViewDistance;



        ViewHolder(View view, List<Tree> treeList) {
            super(view);
            textViewLocationName = view.findViewById(R.id.locationname);
            textViewLocationAdd = view.findViewById(R.id.locationadd);
            textViewDistance = view.findViewById(R.id.timedistance);

            //attach onClickListener to restaurantItemView
/*            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    int pos = getBindingAdapterPosition();
                    Tree tree = treeList.get(pos);
                    bundle.putParcelable("restaurant", tree); // replace "key" and "value" with your actual key and value
                    if (pos != RecyclerView.NO_POSITION){
                        Navigation.findNavController(v).navigate(R.id.____, bundle);
                    }


                }
            });*/
        }
    }
}
