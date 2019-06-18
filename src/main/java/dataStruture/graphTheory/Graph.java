package dataStruture.graphTheory;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    // 用于广度优先遍历
    private Queue<Integer> queue = new ArrayDeque<>();
    // 用于深度优先遍历
    private  LinkedList<Integer> stack = new LinkedList<>();
    /*
    最大节点数量
     */
    private final int MAX_VERTS = 100;
    /**
     * 节点列表
     */
    private Vertex[] vertexList;
    /**
     * 邻接矩阵 用来表示边
     */
    private int[][] adjMat;
    /**
     * 当前节点个数
     */
    private int nVerts;

    /**
     * 构造方法
     */
    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        //初始化临街矩阵的所有值为0

        for(int i = 0 ; i < MAX_VERTS; i++){
            for(int j = 0; j < MAX_VERTS; j++){
                adjMat[i][j] = 0;
            }
        }
    }

    /**
     * 增加一个节点
     * @param label
     */
    public void addVertex(String label){
        vertexList[nVerts++] = new Vertex(label);
    }

    /**
     * 增加一条边
     * @param start
     * @param end
     */
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * 展示节点
     * @param v
     */
    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    /**
     * 深度优先搜索
     *  规则一：如果可能，访问一个邻接的未访问的顶点，标记它，并把它放入栈中
     *  规则二：当不能执行规则1时， 如果栈不空，就从栈中弹出一个顶点
     *  规则三：如果不能执行规则1和规则2，就完成了整个搜索过程
     */
    public void dfs(){
        //从vertex 0开始
        //标记
        vertexList[0].isVisited = true;
        //展示
        displayVertex(0);
        //加入栈
        stack.push(0);

        while (!stack.isEmpty()){
            //获取一个未被访问的vertex
            int v = getAdjUnvisitedVertex(stack.peek());
            if ( v == -1){
                stack.pop();
            }else{
                //标记为访问
                vertexList[v].isVisited = true;
                //展示
                displayVertex(v);
                //push
                stack.push(v);
            }
        }
        //重置访问状态
        for(int j = 0; j < nVerts; j++){
            vertexList[j].isVisited = false;
        }
        stack.clear();
    }

    /**
     * 广度优先搜索
     *  规则一：访问一个未来访问的邻接点（如果存在），在这个顶点必须是当前顶点的邻接点，标记它，并把它放入队列中
     *  规则二：如果因为已经没有未访问顶点而不能执行规则1 ，那么从队列头取出一个顶点（如果存在），并使其成为当前顶点
     *  规则三：如果因为队列为空而不能执行规则2，则搜索结束
     */
    public void bfs(){
        vertexList[0].isVisited = true;
        displayVertex(0);
        queue.add(0);

        while(!queue.isEmpty()){
            Integer v1 = queue.poll();
            int v2 = -1;
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].isVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }

        //清空queue重置数据
        for(int i = 0; i < nVerts; i++){
            vertexList[i].isVisited = false;
        }
        queue.clear();

    }

    /**
     * 最小生成树
     */
    public void mst(){
        vertexList[0].isVisited = true;
        stack.push(0);

        while (!stack.isEmpty()){
            int currentVertex = stack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);
            if(v == -1){
                stack.pop();
            }else{
                vertexList[v].isVisited = true;
                stack.push(v);
                displayVertex(currentVertex);
                displayVertex(v);
                System.out.println(" ");

            }
        }

        //清空队列
        stack.clear();
        for(int i = 0; i < nVerts; i++){
            vertexList[i].isVisited = false;
        }
    }


    /**
     * 获取未被反问的邻接顶点
     * @param v
     * @return
     */
    public int getAdjUnvisitedVertex(int v){
        for(int j = 0; j < nVerts; j++){
            if(adjMat[v][j] == 1 && !vertexList[j].isVisited){
                return j;
            }
        }
        return -1;
    }
}
