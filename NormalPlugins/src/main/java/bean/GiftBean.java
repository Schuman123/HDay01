package bean;

import java.util.List;

/**
 * Created by Schuman on 2016/6/2.
 */
public class GiftBean {
    /**
     * info : [{"id":"5040","name":"《航海归来》72G独家大礼包",
     * "gamename":"航海归来",
     * "icon":"http://i3.72g.com/upload/201601/201601201042253982.png",
     * "remain":96,"gifttype":"1","consume":"0","content":"金币*150w； 礼金*300； 海贼王的秘宝*3； 天使像*1； 西班牙大帆船图纸（珍品）*1"},{"id":"3542","name":"《不良人》72G普通礼包","gamename":"不良人","icon":"http://i3.72g.com/upload/201506/201506041344181170.jpg","remain":"0","gifttype":"1","consume":"0","content":"铜币*2000，女儿红*2，侠客精魄礼盒*1，水判官精魄*1"},{"id":"4873","name":"《王者荣耀》新版本上线礼包","gamename":"王者荣耀","icon":"http://i4.72g.com/upload/201511/201511181059572674.jpg","remain":0,"gifttype":"1","consume":"0","content":"双倍经验卡1天； 2级符文：震击； 2级符文：痛苦； 钻石28 "},{"id":"5681","name":"《梦幻仙境》端午节礼包","gamename":"梦幻仙境","icon":"http://i5.72g.com/upload/201511/201511110934493818.jpg","remain":"500","gifttype":"1","consume":"0","content":"200绑元、黄金钱箱、大型法力结晶、大型生命结晶、高级升星石*10"},{"id":"5680","name":"《火影忍者手游》公测礼包","gamename":"火影忍者手游","icon":"http://i4.72g.com/upload/201605/201605171637326248.jpg","remain":"72","gifttype":"1","consume":"0","content":"鸣人碎片*2+2级绿勾玉+8888铜币+10金币"},{"id":"5678","name":"《最后一个三国志》特权礼包","gamename":"最后一个三国志","icon":"http://i4.72g.com/upload/201605/201605241500221789.jpg","remain":"45","gifttype":"1","consume":"0","content":"元宝x288,武将碎片x15，装备箱子x1,游戏币x100w"},{"id":"5677","name":"《问道》六一礼包","gamename":"问道","icon":"http://i4.72g.com/upload/201510/201510231612451354.png","remain":"52","gifttype":"1","consume":"0","content":"宠物经验丹*5、20级首饰*1、超级晶石*1、血池*1"},{"id":"5676","name":"《倩女幽魂手游》六一礼包","gamename":"倩女幽魂手游","icon":"http://i3.72g.com/upload/201601/201601050957561535.jpg","remain":"25","gifttype":"1","consume":"0","content":"一品豆腐*20、一品锅*20、5年人参果*5 "},{"id":"5675","name":"《我欲封天》六一礼包","gamename":"我欲封天","icon":"http://i4.72g.com/upload/201604/201604211019037214.jpg","remain":"188","gifttype":"1","consume":"0","content":"金币 x 200000 羽翼之心 x 10 神羽宝箱 x 5 苍穹一念丹 x 10 高级培养丹 x 10"},{"id":"5673","name":"《黑夜传说》儿童欢乐多礼包","gamename":"黑夜传说","icon":"http://i3.72g.com/upload/201602/201602040944029732.jpg","remain":"97","gifttype":"1","consume":"0","content":"羽灵之心*2016\t体力*60\t金币*16W"}]
     * page : {"total":389,"pagesize":10,"page":1,"page_total":39}
     * state : success
     */

    private String state;
    /**
     * id : 5040
     * name : 《航海归来》72G独家大礼包
     * gamename : 航海归来
     * icon : http://i3.72g.com/upload/201601/201601201042253982.png
     * remain : 96
     * gifttype : 1
     * consume : 0
     * content : 金币*150w； 礼金*300； 海贼王的秘宝*3； 天使像*1； 西班牙大帆船图纸（珍品）*1
     */

    private List<InfoBean> info;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        private String id;
        private String name;
        private String gamename;
        private String icon;
        private int remain;
        private String gifttype;
        private String consume;
        private String content;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGamename() {
            return gamename;
        }

        public void setGamename(String gamename) {
            this.gamename = gamename;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getRemain() {
            return remain;
        }

        public void setRemain(int remain) {
            this.remain = remain;
        }

        public String getGifttype() {
            return gifttype;
        }

        public void setGifttype(String gifttype) {
            this.gifttype = gifttype;
        }

        public String getConsume() {
            return consume;
        }

        public void setConsume(String consume) {
            this.consume = consume;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "InfoBean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", gamename='" + gamename + '\'' +
                    ", icon='" + icon + '\'' +
                    ", remain=" + remain +
                    ", gifttype='" + gifttype + '\'' +
                    ", consume='" + consume + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }


}
