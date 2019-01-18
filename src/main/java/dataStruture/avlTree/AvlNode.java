package dataStruture.avlTree;

/**
 * @ClassName AvlNode
 * @Author dianXiao2
 * @Date 2018/12/10 20:06
 **/
public class AvlNode {
    Long data;
    AvlNode left;
    AvlNode right;
    int height;

    public AvlNode(Long data) {
       this(data, null, null) ;
    }

    public AvlNode(Long data, AvlNode left, AvlNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
}
