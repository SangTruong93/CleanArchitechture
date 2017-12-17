package namtran.cleanarchitechturesample.view.adapter;


import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import namtran.cleanarchitechturesample.R;
import namtran.cleanarchitechturesample.view.mvp.core.AbsBaseAdapter;
import namtran.cleanarchitechturesample.view.mvp.core.AbsBaseViewHolder;
import namtran.cleanarchitechturesample.model.TeamModel;

public class TeamAdapter extends AbsBaseAdapter<TeamModel, TeamAdapter.TeamHolder> {

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

    static class TeamHolder extends AbsBaseViewHolder<TeamModel> {

        @BindView(R.id.tv_team)
        TextView mTvTeam;

        TeamHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(List<TeamModel> data) {

        }

        @Override
        public void bind(TeamModel data) {
            mTvTeam.setText(data.name);
        }
    }
}
