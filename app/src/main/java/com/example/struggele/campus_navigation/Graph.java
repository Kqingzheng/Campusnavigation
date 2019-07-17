package com.example.struggele.campus_navigation;
import com.amap.api.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private int VexsNum;       // 点的数量


    private Vertex[] Vexs;       // 顶点集合
    private int[][] Matrix;    // 邻接矩阵


    private static final int INF = Integer.MAX_VALUE;   // 最大值

    public Graph(){
        this.Vexs = new Vertex[0];
        this.Matrix = new int[0][0];
    }

    public void setVexNum(int VexsNum){
        this.VexsNum = VexsNum;
    }

    public void setEdg(int i,int j,int weight){
        this.Matrix[i][j] = weight;
        this.Matrix[j][i] = weight;
    }
    public void GraphBuild(){
        this.setVexNum(28);                       //定义顶点个数
        this.Vexs = new Vertex[this.VexsNum];
        this.Matrix = new int[this.VexsNum][this.VexsNum];

        Vexs[0] = new Vertex("大门");
        Vexs[1] = new Vertex("主楼");
        Vexs[2] = new Vertex("主楼k1");
        Vexs[3] = new Vertex("联通广场");
        Vexs[4] = new Vertex("图书馆");
        Vexs[5] = new Vertex("1号教学楼");
        Vexs[6] = new Vertex("医院");
        Vexs[7] = new Vertex("实验楼");
        Vexs[8] = new Vertex("体育场");
        Vexs[9] = new Vertex("体育场k2");
        Vexs[10] = new Vertex("体育场k3");
        Vexs[11] = new Vertex("汇文楼k4");
        Vexs[12] = new Vertex("汇文楼");
        Vexs[13] = new Vertex("汇文楼k5");
        Vexs[14] = new Vertex("综合楼k6");
        Vexs[15] = new Vertex("综合楼");
        Vexs[16] = new Vertex("地下通道C口");
        Vexs[17] = new Vertex("3号教学楼");
        Vexs[18] = new Vertex("4号教学楼");
        Vexs[19] = new Vertex("游泳馆");
        Vexs[20] = new Vertex("艺术楼");
        Vexs[21] = new Vertex("体育场k7");
        Vexs[22] = new Vertex("1号楼k8");
        Vexs[23] = new Vertex("1号楼k9");
        Vexs[24] = new Vertex("联通广场k10");
        Vexs[25] = new Vertex("实验楼k11");
        Vexs[26] = new Vertex("体育场k12");
        Vexs[27] = new Vertex("一号楼k13");

        Vexs[0].input(45.708027,126.613903);
        Vexs[1].input(45.708196,126.614702);
        Vexs[2].input(45.707297,126.614901);
        Vexs[3].input(45.707589,126.617492);
        Vexs[4].input(45.708421,126.618672);
        Vexs[5].input(45.707848,126.619026);
        Vexs[6].input(45.707683,126.619133);
        Vexs[7].input(45.707294,126.619456);
        Vexs[8].input(45.708342,126.619935);
        Vexs[9].input(45.708114,126.620485);
        Vexs[10].input(45.708376,126.621188);
        Vexs[11].input(45.708593,126.622706);
        Vexs[12].input(45.709361,126.622395);
        Vexs[13].input(45.708616,126.623202);
        Vexs[14].input(45.707318,126.623393);
        Vexs[15].input(45.706896,126.623291);
        Vexs[16].input(45.706986,126.624208);
        Vexs[17].input(45.707226,126.624578);
        Vexs[18].input(45.706784,126.624616);
        Vexs[19].input(45.707173,126.627234);
        Vexs[20].input(45.707387,126.628135);
        Vexs[21].input(45.708464,126.619558);
        Vexs[22].input(45.707853,126.619821);
        Vexs[23].input(45.707767,126.619069);
        Vexs[24].input(45.707695,126.618485);
        Vexs[25].input(45.707772,126.619316);
        Vexs[26].input(45.708223,126.619815);
        Vexs[27].input(45.708223,126.618404);


        for(int i=0 ; i<this.VexsNum ; i++){
            for(int j = 0 ; j<this.VexsNum ; j++){
                this.Matrix[i][j] = INF;
            }
        }

        this.setEdg(0, 1, 80);                                    //大门

        this.setEdg(1, 2, 90);                                    //主楼

        this.setEdg(2, 3, 210);                                   //主楼k1

        this.setEdg(3, 4, 120);                                   //联通广场
        this.setEdg(3, 23, 110);
        this.setEdg(3, 24, 45);

        this.setEdg(4, 21, 75);                                   //图书馆
        this.setEdg(4, 27, 40);

        this.setEdg(5, 23, 25);                                   //1号教学楼

        this.setEdg(6, 23, 15);                                   //医院

        this.setEdg(7, 25, 50);                                   //实验楼

        this.setEdg(8, 26, 10);                                   //体育场

        this.setEdg(9, 10, 50);                                   //体育场k2
        this.setEdg(9, 26, 60);

        this.setEdg(10, 11, 130);                                   //体育场k3

        this.setEdg(11,12, 90);                                   //汇文楼k4
        this.setEdg(11,13, 45);

        this.setEdg(13, 15, 180);                                   //汇文楼k5

        this.setEdg(14, 15, 40);                                   //综合楼k6

        this.setEdg(15, 16, 50);                                   //综合楼

        this.setEdg(16, 17, 50);                                   //地下通道C口
        this.setEdg(16, 18, 50);
        this.setEdg(16, 19, 220);
        this.setEdg(16, 20, 300);

        this.setEdg(17, 18, 60);                                   //3号教学楼
        this.setEdg(17, 19, 200);
        this.setEdg(17, 20, 290);

        this.setEdg(18, 19, 200);                                   //4号教学楼
        this.setEdg(18, 20, 290);

        this.setEdg(19, 20, 110);                                   //游泳馆

        this.setEdg(20, 19, 100);                                   //艺术楼

        this.setEdg(21, 26, 40);                                    //体育场k7

        this.setEdg(22, 23, 65);                                   //1号楼k8
        this.setEdg(22, 25, 40);
        this.setEdg(22, 26, 60);

        this.setEdg(23, 24, 50);                                   //1号楼k9
        this.setEdg(23, 25, 15);

        this.setEdg(24, 27, 55);                                   //一号楼k13

    }

    /*
     * Dijkstra最短路径。
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public List<LatLng> dijkstra(int vs, int end) {
        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
        boolean[] flag = new boolean[Vexs.length];
        int[] prev = new int[this.VexsNum];
        int[] dist = new int[this.VexsNum];
        List<LatLng> points = new ArrayList<LatLng>();

        // 初始化
        for (int i = 0; i < Vexs.length; i++) {
            flag[i] = false;          // 顶点i的最短路径还没获取到。
            prev[i] = 0;              // 顶点i的前驱顶点为0。
            dist[i] = Matrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
        }

        // 对"顶点vs"自身进行初始化
        flag[vs] = true;
        dist[vs] = 0;

        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
        int k=0;
        for (int i = 1; i < Vexs.length; i++) {
            // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
            int min = INF;
            for (int j = 0; j < Vexs.length; j++) {
                if (flag[j]==false && dist[j]<min) {
                    min = dist[j];
                    k = j;
                }
            }
            // 标记"顶点k"为已经获取到最短路径
            flag[k] = true;

            // 修正当前最短路径和前驱顶点
            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int j = 0; j < Vexs.length; j++) {
                int tmp = (Matrix[k][j]==INF ? INF : (min + Matrix[k][j]));
                if (flag[j]==false && (tmp<dist[j]) ) {
                    dist[j] = tmp;
                    prev[j] = k;
                }
            }
        }

        //输出最短路径结果
        int p=end;
        int[] path = new int[this.VexsNum];
        int i = 0;
        while(p!=vs){
            path[i] = p;
            p = prev[p];
            i++;
        }

        for(int j = i;j > 0;j--){
            System.out.print(path[j]+"-->");                                                       //显示序号
            //System.out.print(this.Vexs[path[j]].getName()+"-->");                                  //显示名字
            //System.out.print(this.Vexs[path[j]].getx()+","+this.Vexs[path[j]].gety()+"-->");         //显示坐标
            points.add(new LatLng(this.Vexs[path[j]].getx(), this.Vexs[path[j]].gety()));
        }
        System.out.println(path[0]);
        //System.out.println(this.Vexs[path[0]].getName());
        //System.out.println(this.Vexs[path[0]].getx()+","+this.Vexs[path[0]].gety());
        points.add(new LatLng(this.Vexs[path[0]].getx(), this.Vexs[path[0]].gety()));
        return points;

    }

    /*
     * floyd最短路径。
     * 即，统计图中各个顶点间的最短路径。
     *
     * 参数说明：
     *     note -- 路径。note[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
     *     dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
     */
    public List<LatLng> floyd(int start,int end) {

        int[][] note = new int[this.VexsNum][this.VexsNum];
        int[][] dist = new int[this.VexsNum][this.VexsNum];
        List<LatLng> points = new ArrayList<LatLng>();        // 初始化
        for (int i = 0; i < Vexs.length; i++) {
            for (int j = 0; j < Vexs.length; j++) {
                dist[i][j] = Matrix[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                note[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }

        // 计算最短路径
        for (int k = 0; k < Vexs.length; k++) {
            for (int i = 0; i < Vexs.length; i++) {
                for (int j = 0; j < Vexs.length; j++) {

                    // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF) ? INF : (dist[i][k] + dist[k][j]);
                    if (dist[i][j] > tmp) {
                        // "i到j最短路径"对应的值设，为更小的一个(即经过k)
                        dist[i][j] = tmp;
                        // "i到j最短路径"对应的路径，经过k
                        note[i][j] = note[i][k];
                    }
                }
            }
        }

        // 打印floyd最短路径的结果
        int p = start;
        int i=1,j;
        int[] path = new int[this.VexsNum];
        path[0] = start;
        while(p!=end){
            path[i] = note[p][end];
            p = note[p][end];
            i++;
        }

        for(j = 0;j < i-1;j++){
            System.out.print(path[j]+"-->");                                                       //显示序号
            //System.out.print(this.Vexs[path[j]].getName()+"-->");                                  //显示名字
            //System.out.print(this.Vexs[path[j]].getx()+","+this.Vexs[path[j]].gety()+"-->");         //显示坐标
            //list.add(String.valueOf(this.Vexs[path[j]].getx())+" "+String.valueOf(this.Vexs[path[j]].gety()));
            points.add(new LatLng(this.Vexs[path[j]].getx(), this.Vexs[path[j]].gety()));
        }
        System.out.println(path[j]);
        //System.out.println(this.Vexs[path[j]].getName());
        //System.out.println(this.Vexs[path[j]].getx()+","+this.Vexs[path[j]].gety());
        points.add(new LatLng(this.Vexs[path[j]].getx(), this.Vexs[path[j]].gety()));
        return points;
    }


    public List<LatLng> UDG(double x,double y,double x1,double y1){
        this.GraphBuild();
        List<LatLng> points = new ArrayList<LatLng>();
        List<String> list = new ArrayList<String>();
        points.add(new LatLng(x, y));
        int start=-1,end=-1;

        for(int i=0;i<this.VexsNum;i++){
            if(this.Vexs[i].getx()==x&&this.Vexs[i].gety()==y)
                start=i;
            else if(this.Vexs[i].getx()==x1&&this.Vexs[i].gety()==y1){
                end=i;
            }
        }
        System.out.println("start:"+start+" end:"+end);
        if(start==0){
            points = this.dijkstra(start, end);
        }
        else{
            points = this.floyd(start,end);
        }

        return points;
    }
    HashMap<String, String> hashMap = new HashMap<String, String>();
    public void hashadd()
    {
        hashMap.put("0", "https://baike.baidu.com/item/黑龙江大学/175307?fr=aladdin");//我的位置
        hashMap.put("1", "https://baike.baidu.com/item/黑龙江大学/175307?fr=aladdin"); //大门
        hashMap.put("2", "https://baike.baidu.com/item/黑龙江大学主楼/5797367?fr=aladdin"); //主楼
        hashMap.put("3", "http://www.hlju.edu.cn/info/1051/1078.htm");//联通广场
        hashMap.put("4", "https://baike.baidu.com/item/黑龙江大学图书馆"); //图书馆
        hashMap.put("5", "http://tieba.baidu.com/p/6158929578?pid=126037850669&cid=0#126037850669"); //1号教学楼
        hashMap.put("6", "http://tieba.baidu.com/p/6158902647?pid=126037410044&cid=0#126037410044"); //校医院
        hashMap.put("7", "https://baike.baidu.com/item/黑龙江大学物理科学与技术学院/7549945?fr=aladdin");//实验楼
        hashMap.put("8", "http://www.hlju.edu.cn/info/1051/1071.htm"); //体育场
        hashMap.put("9", "http://www.hlju.edu.cn/info/1051/1079.htm");//汇文楼
        hashMap.put("10", "https://baike.baidu.com/item/黑龙江大学/175307?fr=aladdin");//综合楼
        hashMap.put("11", "https://baike.baidu.com/item/黑龙江大学/175307?fr=aladdin");//3号教学楼
        hashMap.put("12", "https://baike.baidu.com/item/黑龙江大学/175307?fr=aladdin");//4号教学楼
        hashMap.put("13", "http://tieba.baidu.com/p/6158929915?pid=126037855968&cid=0#126037855968");//C区游泳馆
        hashMap.put("14", "http://tieba.baidu.com/p/6151985084?pid=125937520325&cid=0#125937520325"); //艺术楼

    }
    public String find(String x)
    {
        return hashMap.get(x);
    }

}

