package livesun.justiceeternal.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.yydcdut.rxmarkdown.RxMDConfiguration;
import com.yydcdut.rxmarkdown.RxMDEditText;
import com.yydcdut.rxmarkdown.RxMDTextView;
import com.yydcdut.rxmarkdown.RxMarkdown;
import com.yydcdut.rxmarkdown.callback.OnLinkClickCallback;
import com.yydcdut.rxmarkdown.loader.DefaultLoader;
import com.yydcdut.rxmarkdown.syntax.edit.EditFactory;
import com.yydcdut.rxmarkdown.syntax.text.TextFactory;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;
import com.zzhoujay.richtext.RichText;
import com.zzhoujay.richtext.callback.OnImageClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.ExternalStyleSheet;
import br.tiagohm.markdownview.css.InternalStyleSheet;
import br.tiagohm.markdownview.css.styles.Github;
import livesun.justiceeternal.R;
import livesun.justiceeternal.adapter.Comments;
import livesun.justiceeternal.adapter.ItemsBean;
import livesun.justiceeternal.adapter.ScoreAdapter;
import livesun.justiceeternal.adapter.ScoreBean;
import livesun.justiceeternal.adapter.ScoreInforAdapter;
import livesun.justiceeternal.base.Contract;
import livesun.justiceeternal.callbakc.NoDataCallback;
import livesun.justiceeternal.utils.FullyLinearLayoutManager;
import livesun.justiceeternal.utils.ImageUtils;
import livesun.justiceeternal.utils.MatcherUtils;
import livesun.justiceeternal.utils.ToastUtil;
import livesun.justiceeternal.view.BadgeView;
import okhttp3.Call;
import okhttp3.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 29028 on 2017/8/10.
 */

public class ScoreInforActivity extends AppCompatActivity implements View.OnClickListener,ScoreInforAdapter.OnItemClickListener{

    private TextView title;
    private LinearLayout labelRoot;
    private ItemsBean itemsBean;
    private String headBody;
    private String comentUrl;
    private ScoreInforAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private View titleHeard;
    private View markDownView;
    private View footView;
    private List<ScoreBean.LabelsBean> labels;
    private int comments=0;
    private String mUserAvatar;
    private String mUserName;
    private String scoreTitle;
    private LinearLayout linearLayout;
    private String mUserUrl;
    private Intent mIntent;
    private HeaderAndFooterWrapper mWrapper;
    private TextView commentSrc;
    private EditText commentEdit;
    private TextView commentCount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIntent = new Intent();

        itemsBean = (ItemsBean) getIntent().getSerializableExtra(Contract.ITEMBEAN);
        if(itemsBean!=null){
            labels = itemsBean.getLabels();
            //markdown的谱子
            headBody = itemsBean.getBody();
            //评论条数
            comments = itemsBean.getComments();
            //评论链接
            comentUrl=itemsBean.getComments_url();
            //用户头像
            ScoreBean.UserBean user = itemsBean.getUser();
            if(user!=null){
                //上传谱子的用户头像
                mUserAvatar = user.getAvatar_url();
                //上传谱子用户姓名
                mUserName = user.getLogin();
                //上传谱子用户的github地址
                mUserUrl = user.getHtml_url();
            }
            //标题
            scoreTitle = itemsBean.getTitle();
        }

        setContentView(R.layout.activity_recycler);
       /* headBody= MatcherUtils.deletComment(headBody);
        headBody=MatcherUtils.getInfor(headBody);*/


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //标题
        titleHeard = LayoutInflater.from(this).inflate(R.layout.heard_rwo, mRecyclerView, false);
        title = (TextView) titleHeard. findViewById(R.id.title);
        setText(title,scoreTitle);
        labelRoot = (LinearLayout) titleHeard. findViewById(R.id.largeLabel_root);
        addBadgeView(labelRoot);



        //谱子
        markDownView = LayoutInflater.from(this).inflate(R.layout.item_list, mRecyclerView, false);
        final RxMDEditText textView = (RxMDEditText) markDownView.findViewById(R.id.content_main);
        ImageView userImag= (ImageView) markDownView.findViewById(R.id.user_imag);
        TextView userName= (TextView) markDownView.findViewById(R.id.user_name);
        linearLayout = (LinearLayout) markDownView.findViewById(R.id.intent_to_github);
        linearLayout.setOnClickListener(this);
        setText(userName,mUserName);
        ImageUtils.setUesrIcon(mUserAvatar,userImag);
        RxMDConfiguration rxMDConfiguration = new RxMDConfiguration.Builder(this)
                .setDefaultImageSize(100, 100)//default image width & height
                .setBlockQuotesColor(Color.LTGRAY)//default color of block quotes
                .setHeader1RelativeSize(1.6f)//default relative size of header1
                .setHeader2RelativeSize(1.5f)//default relative size of header2
                .setHeader3RelativeSize(1.4f)//default relative size of header3
                .setHeader4RelativeSize(1.3f)//default relative size of header4
                .setHeader5RelativeSize(1.2f)//default relative size of header5
                .setHeader6RelativeSize(1.1f)//default relative size of header6
                .setHorizontalRulesColor(Color.LTGRAY)//default color of horizontal rules's background
                .setInlineCodeBgColor(Color.LTGRAY)//default color of inline code's background
                .setCodeBgColor(Color.LTGRAY)//default color of code's background
                .setTodoColor(Color.DKGRAY)//default color of todo
                .setTodoDoneColor(Color.DKGRAY)//default color of done
                .setUnOrderListColor(Color.BLACK)//default color of unorder list
                .setLinkColor(Color.RED)//default color of link text
                .setLinkUnderline(true)//default value of whether displays link underline
                .setRxMDImageLoader(new DefaultLoader(this))//default image loader
                .setDebug(true)//default value of debug
                .setOnLinkClickCallback(new OnLinkClickCallback() {//link click callback
                    @Override
                    public void onLinkClicked(View view, String link) {
                        Toast.makeText(view.getContext(), link, Toast.LENGTH_SHORT).show();
                    }
                })
                .build();

        RxMarkdown.with(headBody, this)
                .config(rxMDConfiguration)
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
                });
       /* //设置单线程 顺序执行
        RichText.fromMarkdown(headBody).bind(this).
                singleLoad(true).
                imageClick(new OnImageClickListener() {
                    @Override
                    public void imageClicked(List<String> imageUrls, int position) {
                        Intent intent = new Intent();
                        intent.putStringArrayListExtra("IMGES", (ArrayList<String>) imageUrls);
                        intent.putExtra("position",position);
                        intent.setClass(ScoreInforActivity.this, PhotoActivity.class);
                        startActivity(intent);
                    }
                }).
                into(textView);*/



        //底部评论
        footView = LayoutInflater.from(this).inflate(R.layout.foot_view, mRecyclerView, false);
        commentCount = (TextView) footView.findViewById(R.id.comment_counts);
        commentEdit = (EditText) footView.findViewById(R.id.comment);
        Button gitButton= (Button) footView.findViewById(R.id.git_button);
        commentSrc = (TextView) footView.findViewById(R.id.comment_src);
        gitButton.setOnClickListener(this);
        commentCount.setText(comments+"条评论");
        if(comments==0){
            commentSrc.setText("来做留言第一人吧");
        }else{
            commentSrc.setText("快来发表你的留言~");
        }

        //获取数据
        getDatas();
    }

    private void addBadgeView(LinearLayout root) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(10,0,0,0);
        root.removeAllViews();
        if(labels!=null&&labels.size()>0){
            for(int i=0;i<labels.size();i++){
                BadgeView badgeView=new BadgeView(this);
                badgeView.setText(labels.get(i).getName());
                badgeView.setBadgeBackgroundColor(Color.parseColor("#"+labels.get(i).getColor()));
                badgeView.setLayoutParams(layoutParams);
                badgeView.setTextSize(13);
                badgeView.setTextColor(Color.parseColor("#6C5656"));
                root.addView(badgeView);
            }
        }
    }


    public void getDatas() {
        String url=comentUrl;
        if(url!=null){
            OkGo.get(url)
                    .tag(this)
                    .execute(new NoDataCallback<List<Comments>>(this,"加载中") {


                        @Override
                        public void onSuccess(List<Comments> commentses, Call call, Response response) {
                            mAdapter = new ScoreInforAdapter(ScoreInforActivity.this,commentses);
                            mAdapter.setOnItemClickListener(ScoreInforActivity.this);
                            mWrapper = new HeaderAndFooterWrapper(mAdapter);
                            mWrapper.addHeaderView(titleHeard);
                            mWrapper.addHeaderView(markDownView);
                            mWrapper.addFootView(footView);
                            mRecyclerView.setAdapter(mWrapper);
                        }

                        @Override
                        public void onError(Call call, Response response, Exception e) {
                            super.onError(call, response, e);
                        }
                    });
        }

    }

    public void setText(TextView view,String text){
        if(TextUtils.isEmpty(text)){
            view.setText("");
        }else {
            view.setText(text);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //跳转到github地址
            case R.id.intent_to_github:
                mIntent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(mUserUrl);
                mIntent.setData(content_url);
                startActivity(mIntent);
                break;

            case R.id.git_button:
                if(commentEdit.getText().toString().trim()!=null){
                    //上传网络，
                    //刷新本地
                    int i = comments + 1;
                    commentCount.setText(i+"条评论");
                    if(comments==0){
                        commentSrc.setText("快来发表你的留言~");
                        comments=i;
                    }
                    Comments comments=new Comments();
                    comments.setBody(commentEdit.getText().toString().trim());
                    ScoreBean.UserBean userBean=new ScoreBean().new UserBean();
                    userBean.setLogin("livesun");
                    comments.setUser(userBean);
                    mAdapter.add(comments);

                    commentEdit.setText("");
                }
                break;
        }
    }

    @Override
    public void onItmeClick(String result) {
        mIntent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(result);
        mIntent.setData(content_url);
        startActivity(mIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RichText.clear(this);
    }
}
