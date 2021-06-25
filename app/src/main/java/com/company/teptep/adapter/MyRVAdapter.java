package com.company.teptep.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.company.teptep.R;
import com.company.teptep.entity.Game;
import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyRVAdapter extends BaseQuickAdapter<Game, BaseViewHolder> {
    private Context context;
    public MyRVAdapter(int layoutResId, @Nullable List<Game> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, Game game) {
        baseViewHolder.setText(R.id.rv_item_game_name, game.getName())
                .setText(R.id.rv_item_game_sort, game.getType())
                .setText(R.id.rv_item_game_rank, game.getRank())
                .setText(R.id.rv_item_game_score, game.getScore());

        MaterialButton rankBtn = baseViewHolder.getView(R.id.rv_item_game_rank);
        if (game.getRank() != null) {
            rankBtn.setVisibility(View.VISIBLE);
            rankBtn.setText(game.getRank());
        } else {
            rankBtn.setVisibility(View.GONE);
        }


        ImageView gameImg = baseViewHolder.getView(R.id.rv_item_game_img);
        Glide.with(getContext())
                .load(game.getUrl())
                .into(gameImg);
    }
}
