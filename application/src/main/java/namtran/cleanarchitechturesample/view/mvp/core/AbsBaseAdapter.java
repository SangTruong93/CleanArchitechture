package namtran.cleanarchitechturesample.view.mvp.core;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import namtran.flatform.util.Checker;

public abstract class AbsBaseAdapter<I, VH extends AbsBaseViewHolder<I>> extends RecyclerView.Adapter<VH> {

    protected List<I> mListData;

    public abstract int getLayoutId();

    public abstract VH getViewHolder(View view);

    protected boolean isBindList(){
        return false;
    }

    public void updateData(List<I> mListData){
        this.mListData.addAll(mListData);
        notifyDataSetChanged();
    }

    public void updateData(List<I> mListData,boolean clear){
        if (!Checker.isEmpty(this.mListData) && clear)
            this.mListData.clear();

        this.mListData.addAll(mListData);
        notifyDataSetChanged();
    }

    public void updateData(I i){
        if (Checker.isEmpty(this.mListData))
            return;

        mListData.add(i);
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(), parent, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (!Checker.isEmpty(mListData)) {
            if (isBindList())
                holder.bind(mListData);
            else{
                I item = mListData.get(position);
                if (item != null) {
                    holder.bind(item);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return mListData != null ? mListData.size() : 0;
    }
}
