package com.example.struggele.CampusNavigation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        TextView fruitImage;
        TextView fruitName;
        //ImageView fruitimm;

        public ViewHolder(View view){
            super(view);
            fruitView=view;
            fruitImage=(TextView)view.findViewById(R.id.fruit_name1);
            fruitName=(TextView)view.findViewById(R.id.fruit_name2);
           // fruitimm=(ImageView)view.findViewById(R.id.fruit_image);
        }

    }

    public FruitAdapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }

    public void setmFruitList(List<Fruit> mFruitList) {
        this.mFruitList = mFruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Fruit fruit=mFruitList.get(position);
                Toast.makeText(v.getContext(),"你点击了"+fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(v.getContext(), Main5Activity.class);
//                v.getContext().startActivity(intent);
//            }
//        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Fruit fruit=mFruitList.get(position);
        holder.fruitImage.setText(fruit.getName());
        holder.fruitName.setText(fruit.getName1());

    }
    @Override
    public int getItemCount()
    {
        return mFruitList.size();
    }

}
