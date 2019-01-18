package dataStruture.avlTree;

/**
 * @ClassName AvlTree
 * @Author dianXiao2
 * @Date 2018/12/10 20:21
 **/
public class AvlTree {

    private int height(AvlNode t){
        if( t == null){
            return -1;
        }else{
            return t.height;
        }
    }

    //左左插入  -》 右旋
    private AvlNode rotateWithLeftChild(AvlNode k2){
        AvlNode k1 = k2.left;

        k2.left = k1.right;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right))+ 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }
    //右右插入 -》 左旋
    private AvlNode roateWithRightChild(AvlNode k2){
        AvlNode k1 = k2.right;

        k2.right = k1.left;
        k1.right = k2;

        k2.height = Math.max(height(k2.left), height(k2.right))+ 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    // 左右插入 =》 先左旋然后右旋
    private AvlNode roateLeftRight(AvlNode k3){
        k3.left = roateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    //右左插入 => 先右旋 然后左旋
    private AvlNode roateRightLeft(AvlNode k3){
        //先右旋
        k3.right = rotateWithLeftChild(k3.right);
        //然后左旋
        return roateWithRightChild(k3);
    }

    public AvlNode insert(Long data, AvlNode t){
        if (t == null){
            return new AvlNode(data, null, null);
        }

        int res = data.compareTo(t.data);
        if (res < 0){
            t.left = insert(data, t.left);
        }else if (res > 0){
            t.right = insert(data, t.right);
        }else{
            //duplicate; do nothing;
        }
        return balance(t);
    }

    //平衡
    private AvlNode balance(AvlNode t){
        if( t == null){
            return null;
        }

        if(height(t.left) - height(t.right) > 1){
            if(height(t.left.left) >= height(t.left.right)){
                t = roateLeftRight(t);
            }else {
                t = roateLeftRight(t);
            }
        }else {
            if(height(t.right.right) >= height(t.right.left)){
                t = roateLeftRight(t);
            }else{
                t = roateRightLeft(t);
            }
        }

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }
}
