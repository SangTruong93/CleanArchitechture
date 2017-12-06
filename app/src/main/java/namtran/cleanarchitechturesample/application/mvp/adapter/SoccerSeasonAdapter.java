package namtran.cleanarchitechturesample.application.mvp.adapter;


import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvp.core.AbsBaseAdapter;
import namtran.cleanarchitechturesample.application.mvp.core.AbsBaseViewHolder;
import namtran.cleanarchitechturesample.flatform.remote.response.session.SoccerSeasons;

public class SoccerSeasonAdapter extends AbsBaseAdapter<SoccerSeasons, SoccerSeasonAdapter.SoccerSeasonHolder> {

    @Inject
    public SoccerSeasonAdapter() {
        mListData = new ArrayList<>();
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_soccer_season_mvp;
    }

    @Override
    public SoccerSeasonHolder getViewHolder(View view) {
        return new SoccerSeasonHolder(view);
    }

    static class SoccerSeasonHolder extends AbsBaseViewHolder<SoccerSeasons> {

        @BindView(R.id.tv_caption)
        TextView mTvCaption;
        @BindView(R.id.tv_league)
        TextView mTvLeague;
        @BindView(R.id.tv_number_team)
        TextView mTvNumberTeam;

        SoccerSeasonHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(List<SoccerSeasons> data) {

        }

        @Override
        public void bind(SoccerSeasons data) {
            mTvCaption.setText(data.caption);
            mTvLeague.setText(data.league);
            mTvNumberTeam.setText(String.format(Locale.getDefault(),"%s %s","Number team",String.valueOf(data.numberOfTeams)));
        }
    }
}
