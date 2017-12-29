package livesun.justiceeternal.adapter;

import java.io.Serializable;
import java.util.List;

import zlc.season.practicalrecyclerview.ItemType;

/**
 * Created by 29028 on 2017/8/10.
 */

public class ItemsBean implements Serializable,ItemType {

    public ItemsBean(String title) {
        this.title = title;
    }

    /**
     * url : https://api.github.com/repos/zytx121/justice_eternal/issues/6
     * repository_url : https://api.github.com/repos/zytx121/justice_eternal
     * labels_url : https://api.github.com/repos/zytx121/justice_eternal/issues/6/labels{/name}
     * comments_url : https://api.github.com/repos/zytx121/justice_eternal/issues/6/comments
     * events_url : https://api.github.com/repos/zytx121/justice_eternal/issues/6/events
     * html_url : https://github.com/zytx121/justice_eternal/issues/6
     * id : 245628140
     * number : 6
     * title : Air
     * user : {"login":"zytx121","id":10410257,"avatar_url":"https://avatars0.githubusercontent.com/u/10410257?v=4","gravatar_id":"","url":"https://api.github.com/users/zytx121","html_url":"https://github.com/zytx121","followers_url":"https://api.github.com/users/zytx121/followers","following_url":"https://api.github.com/users/zytx121/following{/other_user}","gists_url":"https://api.github.com/users/zytx121/gists{/gist_id}","starred_url":"https://api.github.com/users/zytx121/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/zytx121/subscriptions","organizations_url":"https://api.github.com/users/zytx121/orgs","repos_url":"https://api.github.com/users/zytx121/repos","events_url":"https://api.github.com/users/zytx121/events{/privacy}","received_events_url":"https://api.github.com/users/zytx121/received_events","type":"User","site_admin":false}
     * labels : [{"id":651957271,"url":"https://api.github.com/repos/zytx121/justice_eternal/labels/A","name":"A","color":"ffcccc","default":false}]
     * state : open
     * locked : false
     * assignee : null
     * assignees : []
     * milestone : null
     * comments : 3
     * created_at : 2017-07-26T07:17:46Z
     * updated_at : 2017-08-05T14:29:18Z
     * closed_at : null
     * body :
     * 上面的Title请务必填写谱子出自的作品名！
     * 上面的Title请务必填写谱子出自的作品名！
     * 上面的Title请务必填写谱子出自的作品名！
     * <p>
     * 只有当第一次提交一个新作品的谱子时，才需要新建一个new issue和填写Title！
     * 因为一个作品（issue）下面可以提交（commit）多次谱子，所以之后每次该作品的谱子只需要在相应issue下以相同格式commit即可。
     * <p>
     * -->
     * <p>
     * # 青空
     * ![image](https://user-images.githubusercontent.com/10410257/28609002-618b3fa4-7215-11e7-8341-10e3ef77e4e4.png)
     * <p>
     * ## 歌曲信息
     * <p>
     * - ![](https://img.shields.io/badge/曲名-青空-brightgreen.svg)
     * - ![](https://img.shields.io/badge/专辑-Air原声音轨-ff69b4.svg)
     * - ![](https://img.shields.io/badge/作词-麻枝准-orange.svg)
     * - ![](https://img.shields.io/badge/作曲-麻枝准-blue.svg)
     * - ![](https://img.shields.io/badge/编曲-折户伸治-red.svg)
     * - ![](https://img.shields.io/badge/歌手-Lia-d6504f.svg)
     * <p>
     * ## 谱
     * <p>
     * ```
     * #C
     * 5667 7(1)776 67665 56567
     * 5667 7(1)776 67665 233225
     * 57(2)7535675 5675 5675
     * 357(2)7535675 !555545 5667(21)7655
     * 66 6575 55 5566 765 5(221)7655
     * (2)66575 65!55 X2
     * <p>
     * 5565445 !346!74145 5565445
     * 56!7 6!7(1)45
     * <p>
     * <p>
     * 5667(21)7655
     * 66 6575 55 5566 765 5(221)7655
     * (2)66575 65!55
     * <p>
     * <p>
     * <p>
     * !为还原音，即吹回5 而不是#5 ~=~
     * <p>
     * ```
     * <p>
     * [![](https://img.shields.io/badge/扒谱-@风残烟消-ff69b4.svg)](http://tieba.baidu.com/home/main?un=%E9%A3%8E%E6%AE%8B%E7%83%9F%E6%B6%88&ie=utf-8&fr=pb)
     * <p>
     * [^_^]:
     * 请严格遵守上述格式提交曲谱，如果不符合规范，作者有权将其删除。
     * <p>
     * ps. 如果有什么想说的话可以写在最后，但不能影响上述格式。
     * <p>
     * -->
     * score : 34.47587
     */

    private String url;
    private String repository_url;
    private String labels_url;
    private String comments_url;
    private String events_url;
    private String html_url;
    private int id;
    private int number;
    private String title;
    private ScoreBean.UserBean user;
    private String state;
    private boolean locked;
    private Object assignee;
    private Object milestone;
    private int comments;
    private String created_at;
    private String updated_at;
    private Object closed_at;
    private String body;
    private double score;
    private List<ScoreBean.LabelsBean> labels;
    private List<?> assignees;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepository_url() {
        return repository_url;
    }

    public void setRepository_url(String repository_url) {
        this.repository_url = repository_url;
    }

    public String getLabels_url() {
        return labels_url;
    }

    public void setLabels_url(String labels_url) {
        this.labels_url = labels_url;
    }

    public String getComments_url() {
        return comments_url;
    }

    public void setComments_url(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ScoreBean.UserBean getUser() {
        return user;
    }

    public void setUser(ScoreBean.UserBean user) {
        this.user = user;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Object getAssignee() {
        return assignee;
    }

    public void setAssignee(Object assignee) {
        this.assignee = assignee;
    }

    public Object getMilestone() {
        return milestone;
    }

    public void setMilestone(Object milestone) {
        this.milestone = milestone;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Object getClosed_at() {
        return closed_at;
    }

    public void setClosed_at(Object closed_at) {
        this.closed_at = closed_at;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<ScoreBean.LabelsBean> getLabels() {
        return labels;
    }

    public void setLabels(List<ScoreBean.LabelsBean> labels) {
        this.labels = labels;
    }

    public List<?> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<?> assignees) {
        this.assignees = assignees;
    }

    @Override
    public int itemType() {
        return 0;
    }
}

