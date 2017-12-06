package namtran.cleanarchitechturesample.application.mvp.core;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;

public abstract class AbsBaseViewHolder<I> extends RecyclerView.ViewHolder {

    public AbsBaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bind(List<I> data);

    public abstract void bind(I data);

    protected Context getContext() {
        return itemView.getContext();
    }

}
