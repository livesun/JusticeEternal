package livesun.justiceeternal.persenter;

import android.content.Context;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;

import livesun.justiceeternal.adapter.ScoreBean;
import livesun.justiceeternal.base.Contract;
import livesun.justiceeternal.callbakc.NoDataCallback;
import livesun.justiceeternal.contract.IGetScoreContract;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by 29028 on 2017/8/11.
 */

public class GetScorePersenter implements IGetScoreContract.Persenter {

    private IGetScoreContract.View mView;
    private Context context;
    private int page;

    public GetScorePersenter(IGetScoreContract.View view, Context context){
        this.mView = view;
        this.context = context;
        mView.setPersenter(this);
    }

    @Override
    public void start() {
        page = 1;
        String url= Contract.BASE_URL+"/search/issues?q="+mView.getKeyWords()+"+state:open+repo:"+Contract.CONTEXT+"/sort=created&order=desc&page="+page+"&per_page=15!";
        OkGo.get(url)
                .tag(context)
                /*.cacheKey("ListItem")
                .cacheTime(-1)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST) //*/
                .execute(new NoDataCallback<ScoreBean>(context,"加载中") {
                    @Override
                    public void onSuccess(ScoreBean scoreBean, Call call, Response response) {
                        mView.getDatasSucess(scoreBean);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        mView.getDataError(e.getMessage());
                    }
                });
    }

    @Override
    public void loardMore() {
        int laodPage=++page;
        String url= Contract.BASE_URL+"/search/issues?q="+mView.getKeyWords()+"+state:open+repo:"+Contract.CONTEXT+"/sort=created&order=desc&page="+laodPage+"&per_page=15!";
        OkGo.get(url)
                .tag(context)
             /*   .cacheKey("ListItem"+laodPage)
                .cacheTime(-1)         //
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE) //REQUEST_FAILED_READ_CACHE REQUEST_FAILED_READ_CACHE*/
                .execute(new NoDataCallback<ScoreBean>(context,"加载中") {
                    @Override
                    public void onSuccess(ScoreBean scoreBean, Call call, Response response) {
                        mView.loadMoreSucess(scoreBean);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        mView.loardMoreError(e.getMessage());
                    }
                });
    }

    @Override
    public void refresh() {
        page = 1;
        String url= Contract.BASE_URL+"/search/issues?q="+mView.getKeyWords()+"+state:open+repo:"+Contract.CONTEXT+"/sort=created&order=desc&page="+page+"&per_page=15!";
        OkGo.get(url)
                .tag(context)
                .cacheKey("ListItem")
                .cacheTime(-1)
                .cacheMode(CacheMode.REQUEST_FAILED_READ_CACHE) //
                .execute(new NoDataCallback<ScoreBean>(context,"加载中") {
                    @Override
                    public void onSuccess(ScoreBean scoreBean, Call call, Response response) {
                        mView.getDatasSucess(scoreBean);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        mView.getDataError(e.getMessage());
                    }
                });
    }


}
