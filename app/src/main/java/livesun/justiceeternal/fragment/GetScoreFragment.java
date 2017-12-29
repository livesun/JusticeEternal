package livesun.justiceeternal.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import livesun.justiceeternal.R;
import livesun.justiceeternal.activity.MarkDownActivity;
import livesun.justiceeternal.activity.ScoreInforActivity;
import livesun.justiceeternal.adapter.ItemsBean;
import livesun.justiceeternal.adapter.ScoreAdapter;
import livesun.justiceeternal.adapter.ScoreBean;
import livesun.justiceeternal.base.BaseFragment;
import livesun.justiceeternal.base.Contract;
import livesun.justiceeternal.contract.IGetScoreContract;
import livesun.justiceeternal.persenter.GetScorePersenter;
import livesun.justiceeternal.utils.ToastUtil;
import zlc.season.practicalrecyclerview.PracticalRecyclerView;

/**
 * Created by 29028 on 2017/8/10.
 */

public class GetScoreFragment extends BaseFragment implements  PracticalRecyclerView.OnRefreshListener,
        PracticalRecyclerView.OnLoadMoreListener,IGetScoreContract.View,ScoreAdapter.OnItemClickListener{

    private PracticalRecyclerView recycleView;
    private SearchView searchView;
    private ScoreAdapter mAdapter;
    private boolean mHasLoadedOnce;
    private GetScorePersenter scorePersenter;
    private String keyWords="";
    private CharSequence query;
    private SearchView.SearchAutoComplete SearchTextView;
    private Intent mIntent;

    @Override
    public int getResourcesId() {
        mIntent = new Intent(getActivity(), ScoreInforActivity.class);
//        mIntent = new Intent(getActivity(), MarkDownActivity.class);
        return R.layout.score_fragment;
    }

    @Override
    public void initView() {
        scorePersenter = new GetScorePersenter(this,getActivity());
        searchView = findView(R.id.search_view);
        SearchTextView = ( SearchView.SearchAutoComplete) searchView.findViewById(R.id.search_src_text);
        SearchTextView.setTextSize(getResources().getDimension(R.dimen.text_small));

        ImageView  mGoButton = (ImageView) searchView.findViewById(android.support.v7.appcompat.R.id.search_go_btn);

            mGoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    query = SearchTextView.getText();
                    if(query ==null|| query.equals("")|| query.toString().trim().equals("")){
                        keyWords="";
                    }else{
                        keyWords=query.toString().trim();
                    }
                    closeKeyboard();
                    scorePersenter.start();
                }
            });


        searchView.setSubmitButtonEnabled(true);
        recycleView = findView(R.id.recycler);
        recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ScoreAdapter(getActivity());
        recycleView.setAdapterWithLoading(mAdapter);
        scorePersenter.start();

    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener(this);
        recycleView.setRefreshListener(this);
        recycleView.setLoadMoreListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            //查找本地数据库
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }

    /**
     * 关闭输入键盘
     */
    void closeKeyboard(){
        if (searchView != null) {
            // 得到输入管理对象
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
            }
            searchView.clearFocus(); // 不获取焦点
        }
    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void onLoadMore() {
        scorePersenter.loardMore();
    }

    @Override
    public void onRefresh() {
        scorePersenter.start();
    }


    @Override
    public void getDatasSucess(ScoreBean itemsBean) {
        mAdapter.clear();
        mAdapter.addAll(itemsBean.getItems());
    }

    @Override
    public void getDataError(String erro) {
        mAdapter.showError();
    }

    @Override
    public void loadMoreSucess(ScoreBean itemsBean) {
        mAdapter.addAll(itemsBean.getItems());
    }

    @Override
    public void loardMoreError(String erro) {
        mAdapter.loadMoreFailed();
    }

    @Override
    public String getKeyWords() {
        return keyWords;
    }

    @Override
    public void refreshSucess(ScoreBean itemsBean) {

    }

    @Override
    public void refreshError(String erro) {

    }

    @Override
    public void setPersenter(IGetScoreContract.Persenter persenter) {

        this.scorePersenter = (GetScorePersenter) persenter;
    }

    @Override
    public void itemClick(int position, ItemsBean scoreBean) {

        mIntent.putExtra(Contract.ITEMBEAN,scoreBean);
        startActivity(mIntent);
    }
}
