package com.qvqol.mtube.ui.FirstItem;

import android.view.View;

import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import com.qvqol.mtube.R;

public class FootViewHolder  extends RecyclerView.ViewHolder {

    private ContentLoadingProgressBar progressBar;
    public FootViewHolder(View itemView) {
        super(itemView);
        progressBar=itemView.findViewById(R.id.contentprog);
    }
}
