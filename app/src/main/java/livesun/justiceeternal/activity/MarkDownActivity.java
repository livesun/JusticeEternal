package livesun.justiceeternal.activity;

import android.view.View;

import br.tiagohm.markdownview.MarkdownView;
import br.tiagohm.markdownview.css.styles.Github;
import livesun.justiceeternal.R;
import livesun.justiceeternal.adapter.ItemsBean;
import livesun.justiceeternal.base.BaseActivity;
import livesun.justiceeternal.base.Contract;

/**
 * 类描述：
 * 创建人：livesun
 * 创建时间：2017/12/29.
 * 修改人：
 * 修改时间：
 * github：https://github.com/livesun
 */
public class MarkDownActivity extends BaseActivity {
    @Override
    public int getResourcesId() {
        return R.layout.activity_markdown;
    }

    @Override
    public void initView() {
        ItemsBean  itemsBean = (ItemsBean) getIntent().getSerializableExtra(Contract.ITEMBEAN);
        String   headBody = itemsBean.getBody();
        MarkdownView   mMarkdownView = (MarkdownView)findViewById(R.id.markdown_view);
        mMarkdownView.addStyleSheet(new Github());
        mMarkdownView.loadMarkdown(headBody);
      /*  mMarkdownView.loadMarkdownFromAsset("markdown1.md");
        mMarkdownView.loadMarkdownFromFile(new File());
        mMarkdownView.loadMarkdownFromUrl("url");*/
    }

    @Override
    public void initListener() {

    }

    @Override
    public void onClick(View v, int id) {

    }
}
