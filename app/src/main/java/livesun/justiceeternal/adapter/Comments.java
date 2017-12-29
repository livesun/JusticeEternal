package livesun.justiceeternal.adapter;

/**
 * Created by 29028 on 2017/8/12.
 */

public class Comments {


    /**
     * body : 哇！超喜欢的一首曲子！
     * created_at : 2017-08-04T16:11:24Z
     * html_url : https://github.com/zytx121/justice_eternal/issues/65#issuecomment-320289175
     * id : 320289175
     * issue_url : https://api.github.com/repos/zytx121/justice_eternal/issues/65
     * updated_at : 2017-08-04T16:11:24Z
     * url : https://api.github.com/repos/zytx121/justice_eternal/issues/comments/320289175
     * user : {"avatar_url":"https://avatars0.githubusercontent.com/u/10410257?v=4","events_url":"https://api.github.com/users/zytx121/events{/privacy}","followers_url":"https://api.github.com/users/zytx121/followers","following_url":"https://api.github.com/users/zytx121/following{/other_user}","gists_url":"https://api.github.com/users/zytx121/gists{/gist_id}","gravatar_id":"","html_url":"https://github.com/zytx121","id":10410257,"login":"zytx121","organizations_url":"https://api.github.com/users/zytx121/orgs","received_events_url":"https://api.github.com/users/zytx121/received_events","repos_url":"https://api.github.com/users/zytx121/repos","site_admin":false,"starred_url":"https://api.github.com/users/zytx121/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/zytx121/subscriptions","type":"User","url":"https://api.github.com/users/zytx121"}
     */

    private String body;
    private String created_at;
    private String html_url;
    private int id;
    private String issue_url;
    private String updated_at;
    private String url;
    private ScoreBean.UserBean user;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue_url() {
        return issue_url;
    }

    public void setIssue_url(String issue_url) {
        this.issue_url = issue_url;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ScoreBean.UserBean getUser() {
        return user;
    }

    public void setUser(ScoreBean.UserBean user) {
        this.user = user;
    }


}
