package livesun.justiceeternal.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.yydcdut.rxmarkdown.RxMDEditText;
import com.yydcdut.rxmarkdown.RxMDTextView;
import com.yydcdut.rxmarkdown.RxMarkdown;
import com.yydcdut.rxmarkdown.syntax.edit.EditFactory;
import com.yydcdut.rxmarkdown.syntax.text.TextFactory;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zzhoujay.richtext.RichText;

import java.util.List;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.styles.Github;
import livesun.justiceeternal.R;
import livesun.justiceeternal.utils.ImageUtils;
import livesun.justiceeternal.utils.MatcherUtils;
import livesun.justiceeternal.utils.UiUtils;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by 29028 on 2017/8/11.
 */

public class ScoreInforAdapter extends CommonAdapter<Comments> {


    private OnItemClickListener listener;
    private String headBody;

    public ScoreInforAdapter(Context context, List<Comments> datas) {
        super(context, R.layout.item_list, datas);
    }

    @Override
    protected void convert(final ViewHolder holder, Comments comments, final int position) {
        //评论内容
        headBody = comments.getBody();

        headBody = MatcherUtils.deletComment(headBody);
        headBody =MatcherUtils.getInfor(headBody);
//        MarkdownView textView= (MarkdownView) holder.getView(R.id.content_main);
////        textView.addStyleSheet(new Github());
//        textView.loadMarkdown(headBody);
        final RxMDEditText textView = (RxMDEditText) holder.getView(R.id.content_main);
//        RichText.fromMarkdown(headBody).singleLoad(true).into(textView);
        RxMarkdown.live(textView)
                .factory(EditFactory.create())
                .intoObservable()
                .subscribe();
       /* RxMarkdown.with(headBody, mContext)
                .factory(TextFactory.create())
                .intoObservable()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CharSequence>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(CharSequence charSequence) {
                        textView.setText(charSequence, TextView.BufferType.SPANNABLE);
                    }
                });*/



        final ScoreBean.UserBean user = comments.getUser();
        if(user!=null){
            //设置姓名
            setName(holder,user.getLogin());
            //设置头像
            ImageUtils.setUesrIcon(user.getAvatar_url(), (ImageView) holder.getView(R.id.user_imag));

            holder.getView(R.id.intent_to_github).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        listener.onItmeClick(user.getHtml_url());
                    }
                }
            });
        }

    }

    private void setName(ViewHolder holder, String text) {
        if(TextUtils.isEmpty(text)){
            holder.setText(R.id.user_name,"佚名");
        }else{
            holder.setText(R.id.user_name,text);
        }
    }

    private void setComment(ViewHolder holder,String text){
        if(TextUtils.isEmpty(text)){
            holder.setText(R.id.content_main,"哇！好赞！");
        }else{
            holder.setText(R.id.content_main,text);
        }
    }

    public interface OnItemClickListener{
        void onItmeClick(String result);
    }

    public void setOnItemClickListener(OnItemClickListener listener){

        this.listener = listener;
    }

    public boolean add(Comments object) {
        synchronized (this) {
            int lastIndex = getDatas().size();
            if (getDatas().add(object)) {
                notifyItemInserted(lastIndex);
                return true;
            } else {
                return false;
            }
        }
    }
}
