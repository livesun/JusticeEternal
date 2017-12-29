package livesun.justiceeternal.adapter;

import java.io.Serializable;
import java.util.List;


/**
 * Created by 29028 on 2017/8/10.
 */

public class ScoreBean {
    /**
     * total_count : 1
     * incomplete_results : false
     * items : [{"url":"https://api.github.com/repos/zytx121/justice_eternal/issues/6","repository_url":"https://api.github.com/repos/zytx121/justice_eternal","labels_url":"https://api.github.com/repos/zytx121/justice_eternal/issues/6/labels{/name}","comments_url":"https://api.github.com/repos/zytx121/justice_eternal/issues/6/comments","events_url":"https://api.github.com/repos/zytx121/justice_eternal/issues/6/events","html_url":"https://github.com/zytx121/justice_eternal/issues/6","id":245628140,"number":6,"title":"Air","user":{"login":"zytx121","id":10410257,"avatar_url":"https://avatars0.githubusercontent.com/u/10410257?v=4","gravatar_id":"","url":"https://api.github.com/users/zytx121","html_url":"https://github.com/zytx121","followers_url":"https://api.github.com/users/zytx121/followers","following_url":"https://api.github.com/users/zytx121/following{/other_user}","gists_url":"https://api.github.com/users/zytx121/gists{/gist_id}","starred_url":"https://api.github.com/users/zytx121/starred{/owner}{/repo}","subscriptions_url":"https://api.github.com/users/zytx121/subscriptions","organizations_url":"https://api.github.com/users/zytx121/orgs","repos_url":"https://api.github.com/users/zytx121/repos","events_url":"https://api.github.com/users/zytx121/events{/privacy}","received_events_url":"https://api.github.com/users/zytx121/received_events","type":"User","site_admin":false},"labels":[{"id":651957271,"url":"https://api.github.com/repos/zytx121/justice_eternal/labels/A","name":"A","color":"ffcccc","default":false}],"state":"open","locked":false,"assignee":null,"assignees":[],"milestone":null,"comments":3,"created_at":"2017-07-26T07:17:46Z","updated_at":"2017-08-05T14:29:18Z","closed_at":null,"body":"<!-- \r\n上面的Title请务必填写谱子出自的作品名！\r\n上面的Title请务必填写谱子出自的作品名！\r\n上面的Title请务必填写谱子出自的作品名！\r\n\r\n只有当第一次提交一个新作品的谱子时，才需要新建一个new issue和填写Title！\r\n因为一个作品（issue）下面可以提交（commit）多次谱子，所以之后每次该作品的谱子只需要在相应issue下以相同格式commit即可。\r\n\r\n-->\r\n\r\n# 青空\r\n\r\n<!-- 歌曲配图  复制粘贴到该处即可 -->\r\n![image](https://user-images.githubusercontent.com/10410257/28609002-618b3fa4-7215-11e7-8341-10e3ef77e4e4.png)\r\n\r\n\r\n## 歌曲信息\r\n\r\n- ![](https://img.shields.io/badge/曲名-青空-brightgreen.svg)\r\n- ![](https://img.shields.io/badge/专辑-Air原声音轨-ff69b4.svg)\r\n- ![](https://img.shields.io/badge/作词-麻枝准-orange.svg)\r\n- ![](https://img.shields.io/badge/作曲-麻枝准-blue.svg)\r\n- ![](https://img.shields.io/badge/编曲-折户伸治-red.svg)\r\n- ![](https://img.shields.io/badge/歌手-Lia-d6504f.svg)\r\n\r\n\r\n## 谱\r\n\r\n```\r\n#C\r\n5667 7(1)776 67665 56567\r\n5667 7(1)776 67665 233225\r\n57(2)7535675 5675 5675\r\n357(2)7535675 !555545 5667(21)7655\r\n66 6575 55 5566 765 5(221)7655\r\n(2)66575 65!55 X2\r\n \r\n5565445 !346!74145 5565445\r\n56!7 6!7(1)45\r\n \r\n \r\n5667(21)7655\r\n66 6575 55 5566 765 5(221)7655\r\n(2)66575 65!55\r\n \r\n \r\n \r\n!为还原音，即吹回5 而不是#5 ~=~\r\n\r\n``` \r\n\r\n[![](https://img.shields.io/badge/扒谱-@风残烟消-ff69b4.svg)](http://tieba.baidu.com/home/main?un=%E9%A3%8E%E6%AE%8B%E7%83%9F%E6%B6%88&ie=utf-8&fr=pb)\r\n\r\n<!-- \r\n\r\n[^_^]:\r\n      请严格遵守上述格式提交曲谱，如果不符合规范，作者有权将其删除。\r\n\r\n      ps. 如果有什么想说的话可以写在最后，但不能影响上述格式。\r\n\r\n-->","score":34.47587}]
     */

    private int total_count;
    private boolean incomplete_results;
    private List<ItemsBean> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }


        public  class UserBean implements Serializable{
            /**
             * login : zytx121
             * id : 10410257
             * avatar_url : https://avatars0.githubusercontent.com/u/10410257?v=4
             * gravatar_id :
             * url : https://api.github.com/users/zytx121
             * html_url : https://github.com/zytx121
             * followers_url : https://api.github.com/users/zytx121/followers
             * following_url : https://api.github.com/users/zytx121/following{/other_user}
             * gists_url : https://api.github.com/users/zytx121/gists{/gist_id}
             * starred_url : https://api.github.com/users/zytx121/starred{/owner}{/repo}
             * subscriptions_url : https://api.github.com/users/zytx121/subscriptions
             * organizations_url : https://api.github.com/users/zytx121/orgs
             * repos_url : https://api.github.com/users/zytx121/repos
             * events_url : https://api.github.com/users/zytx121/events{/privacy}
             * received_events_url : https://api.github.com/users/zytx121/received_events
             * type : User
             * site_admin : false
             */

            private String login;
            private int id;
            private String avatar_url;
            private String gravatar_id;
            private String url;
            private String html_url;
            private String followers_url;
            private String following_url;
            private String gists_url;
            private String starred_url;
            private String subscriptions_url;
            private String organizations_url;
            private String repos_url;
            private String events_url;
            private String received_events_url;
            private String type;
            private boolean site_admin;

            public UserBean() {

            }

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getGravatar_id() {
                return gravatar_id;
            }

            public void setGravatar_id(String gravatar_id) {
                this.gravatar_id = gravatar_id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getHtml_url() {
                return html_url;
            }

            public void setHtml_url(String html_url) {
                this.html_url = html_url;
            }

            public String getFollowers_url() {
                return followers_url;
            }

            public void setFollowers_url(String followers_url) {
                this.followers_url = followers_url;
            }

            public String getFollowing_url() {
                return following_url;
            }

            public void setFollowing_url(String following_url) {
                this.following_url = following_url;
            }

            public String getGists_url() {
                return gists_url;
            }

            public void setGists_url(String gists_url) {
                this.gists_url = gists_url;
            }

            public String getStarred_url() {
                return starred_url;
            }

            public void setStarred_url(String starred_url) {
                this.starred_url = starred_url;
            }

            public String getSubscriptions_url() {
                return subscriptions_url;
            }

            public void setSubscriptions_url(String subscriptions_url) {
                this.subscriptions_url = subscriptions_url;
            }

            public String getOrganizations_url() {
                return organizations_url;
            }

            public void setOrganizations_url(String organizations_url) {
                this.organizations_url = organizations_url;
            }

            public String getRepos_url() {
                return repos_url;
            }

            public void setRepos_url(String repos_url) {
                this.repos_url = repos_url;
            }

            public String getEvents_url() {
                return events_url;
            }

            public void setEvents_url(String events_url) {
                this.events_url = events_url;
            }

            public String getReceived_events_url() {
                return received_events_url;
            }

            public void setReceived_events_url(String received_events_url) {
                this.received_events_url = received_events_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public boolean isSite_admin() {
                return site_admin;
            }

            public void setSite_admin(boolean site_admin) {
                this.site_admin = site_admin;
            }
        }

        public  class LabelsBean implements Serializable {
            /**
             * id : 651957271
             * url : https://api.github.com/repos/zytx121/justice_eternal/labels/A
             * name : A
             * color : ffcccc
             * default : false
             */

            private int id;
            private String url;
            private String name;
            private String color;
            private boolean defaultX;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public boolean isDefaultX() {
                return defaultX;
            }

            public void setDefaultX(boolean defaultX) {
                this.defaultX = defaultX;
            }
        }
    }



