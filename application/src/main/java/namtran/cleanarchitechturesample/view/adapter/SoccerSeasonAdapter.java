package namtran.cleanarchitechturesample.view.adapter;


import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.view.mvp.core.AbsBaseAdapter;
import namtran.cleanarchitechturesample.view.mvp.core.AbsBaseViewHolder;
import namtran.cleanarchitechturesample.model.SoccerSeasonModel;

public class SoccerSeasonAdapter extends AbsBaseAdapter<SoccerSeasonModel, SoccerSeasonAdapter.SoccerSeasonHolder> {

    private OnSoccerSeasonItemClick onSoccerSeasonItemClick;

    @Inject
    public SoccerSeasonAdapter() {
        mListData = new ArrayList<>();
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_soccer_season;
    }

    @Override
    public SoccerSeasonHolder getViewHolder(View view) {
        return new SoccerSeasonHolder(view,onSoccerSeasonItemClick);
    }

    public void setOnSoccerSeasonItemClick(OnSoccerSeasonItemClick onSoccerSeasonItemClick) {
        this.onSoccerSeasonItemClick = onSoccerSeasonItemClick;
    }

    static class SoccerSeasonHolder extends AbsBaseViewHolder<SoccerSeasonModel> {

        @BindView(R.id.tv_caption)
        TextView mTvCaption;
        @BindView(R.id.tv_league)
        TextView mTvLeague;
        @BindView(R.id.tv_number_team)
        TextView mTvNumberTeam;

        private OnSoccerSeasonItemClick onSoccerSeasonItemClick;

        SoccerSeasonHolder(View itemView,OnSoccerSeasonItemClick onSoccerSeasonItemClick) {
            super(itemView);
            this.onSoccerSeasonItemClick = onSoccerSeasonItemClick;
        }

        @Override
        public void bind(List<SoccerSeasonModel> data) {

        }

        @Override
        public void bind(final SoccerSeasonModel data) {
            mTvCaption.setText(data.caption);
            mTvLeague.setText(data.league);
            mTvNumberTeam.setText(String.format(Locale.getDefault(),"%s %s","Number team",String.valueOf(data.numberOfTeams)));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onSoccerSeasonItemClick != null)
                        onSoccerSeasonItemClick.onSoccerSeasonItemClick(data);
                }
            });
        }
    }

    public interface OnSoccerSeasonItemClick{
        void onSoccerSeasonItemClick(SoccerSeasonModel data);
    }
}
