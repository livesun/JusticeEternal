package livesun.justiceeternal.contract;

import livesun.justiceeternal.adapter.ScoreBean;
import livesun.justiceeternal.base.BasePersenter;
import livesun.justiceeternal.base.BaseView;

/**
 * Created by 29028 on 2017/8/11.
 */

public class IGetScoreContract {

    public interface View extends BaseView<Persenter>{
        void getDatasSucess(ScoreBean itemsBean);
        void getDataError(String erro);

        void loadMoreSucess(ScoreBean itemsBean);
        void loardMoreError(String erro);

        String getKeyWords();

        void refreshSucess(ScoreBean itemsBean);
        void refreshError(String erro);

    }

    public interface Persenter extends BasePersenter{

        void loardMore();
        void refresh();
    }

}
