package namtran.cleanarchitechturesample.application.adapter;


import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.application.mvp.core.AbsBaseAdapter;
import namtran.cleanarchitechturesample.application.mvp.core.AbsBaseViewHolder;
import namtran.cleanarchitechturesample.flatform.remote.response.team.Team;

public class TeamAdapter extends AbsBaseAdapter<Team, TeamAdapter.TeamHolder> {

    @Inject
    public TeamAdapter() {
        mListData = new ArrayList<>();
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_team;
    }

    @Override
    public TeamHolder getViewHolder(View view) {
        return new TeamHolder(view);
    }

    static class TeamHolder extends AbsBaseViewHolder<Team> {

        @BindView(R.id.tv_team)
        TextView mTvTeam;

        TeamHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(List<Team> data) {

        }

        @Override
        public void bind(Team data) {
            mTvTeam.setText(data.name);
        }
    }
}
