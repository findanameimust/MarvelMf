package com.example.marvelmf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder>{



    private Context context;
    private List<Hero> list;
    //private List<Hero> fliterlist;
   // private HeroAdapterListener listener;
    
  //  private final View.OnClickListener monClickListener;
  public HeroAdapter(Context context, List<Hero> list) {
      this.context = context;
      this.list = list;
//      this.listener = listener;
//      this.fliterlist = list;
  }





//    public HeroAdapter(MainActivity context, List<Hero> heroList, Observer<List<Hero>> listObserver) {
//    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Hero hero= list.get(position);
        holder.textTeam.setText(hero.getTeam());
        holder.textRealName.setText(hero.getRealname());
        holder.textName.setText(hero.getName());
        Glide.with(context)
                .load(hero.getImageurl())
                .into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                String query = charSequence.toString().toLowerCase();
//                if (query.isEmpty()){
//                    fliterlist=list;
//                }else {
//                    List flist;
//                    flist = new ArrayList<>();
//
//                    for (Hero item : list) {
//                        if (item.getName().toLowerCase().contains(query))
//                        {
//                            flist.add(item);
//                        }
//
//                    }
//                    fliterlist=flist;
//                }
//
//            FilterResults filterResults = new FilterResults();
//                filterResults.count=fliterlist.size();
//            filterResults.values = fliterlist;
//
//                return filterResults;
//
//        }
//
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
//
//                fliterlist = (ArrayList) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textRealName, textTeam;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textName = itemView.findViewById(R.id.main_name);
            textRealName = itemView.findViewById(R.id.main_realName);
            textTeam = itemView.findViewById(R.id.main_team);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  Hero heroes=list.get(getAdapterPosition());

                    Intent intent = new Intent(context, ItemDisplayActivity.class);

                    intent.putExtra("imageurl",heroes.getImageurl());
                    context.startActivity(intent);
                    Toast.makeText(context,
                            "click"+getAdapterPosition(),
                            Toast.LENGTH_LONG).show();
                    //listener.onheroselected(fliterlist.get(getAdapterPosition()));
                }
            });
        }
    }
//    public interface HeroAdapterListener{
//        void onheroselected(Hero heroes);
//    }
}
