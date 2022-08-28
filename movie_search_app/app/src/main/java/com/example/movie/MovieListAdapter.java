package com.example.movie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
   // 해당 어댑터의 ViewHolder를 상속받는다.
   private List<MovieDataItem> datas;
   private Context context;

   public MovieListAdapter(List<MovieDataItem> datas) {
      this.datas = datas;
   }

   @Override
   public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      // ViewHodler 객체를 생성 후 리턴한다.
      context = parent.getContext();
      return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_list, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
      // ViewHolder 가 재활용 될 때 사용되는 메소드
      MovieDataItem data = datas.get(position);

      holder.title.setText(data.getTitle());
      holder.pubDate.setText(data.getPubDate());
      holder.userRating.setText(data.getUserRating());
      Glide.with(context).load(data.getImage()).into(holder.imageView);

      holder.exTitle.setText("제목 : ");
      holder.exPubDate.setText("평점 : ");
      holder.exUserRating.setText("별점 : ");

      holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

            String link = data.getLink();

            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("link", link);
            context.startActivity(intent);

         }
      });

   }

   @Override
   public int getItemCount() {
      return datas.size(); // 전체 데이터의 개수 조회
   }

   // 아이템 뷰를 저장하는 클래스
   public class MovieViewHolder extends RecyclerView.ViewHolder {
      // ViewHolder 에 필요한 데이터들을 적음.
      private TextView title;
      private TextView pubDate;
      private TextView userRating;
      private ImageView imageView;

      private TextView exTitle;
      private TextView exPubDate;
      private TextView exUserRating;

      public MovieViewHolder(@NonNull View itemView) {
         super(itemView);
         // 아이템 뷰에 필요한 View
         title = itemView.findViewById(R.id.tv_title);
         pubDate = itemView.findViewById(R.id.tv_pubDate);
         userRating = itemView.findViewById(R.id.tv_userRating);
         imageView = itemView.findViewById(R.id.iv_movieImage);

         exTitle = itemView.findViewById(R.id.tv_exTitle);
         exPubDate = itemView.findViewById(R.id.tv_exPubDate);
         exUserRating = itemView.findViewById(R.id.tv_exUserRating);
      }
   }
}