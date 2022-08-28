package com.example.movie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchHistoryListAdapter extends RecyclerView.Adapter<SearchHistoryListAdapter.MovieViewHolder> {
   // 해당 어댑터의 ViewHolder를 상속받는다.
   private List<String> datas;
   private Context context;

   public SearchHistoryListAdapter(List<String> datas) {
      this.datas = datas;
   }

   @Override
   public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      // ViewHodler 객체를 생성 후 리턴한다.
      context = parent.getContext();
      return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keyword_list, parent, false));
   }

   @Override
   public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
      // ViewHolder 가 재활용 될 때 사용되는 메소드

      holder.keyword.setText(datas.get(position));
      holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String strKeyword = holder.keyword.getText().toString();
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("keyword", strKeyword);
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
      private TextView keyword;


      public MovieViewHolder(@NonNull View itemView) {
         super(itemView);
         // 아이템 뷰에 필요한 View
         keyword = itemView.findViewById(R.id.tv_keyword);

      }
   }
}