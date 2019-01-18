package dataStruture.binaryTree;

/**
 * ${DESCRIPTION}
 *
 * @Author: DianXiao2
 * @Date: Created in  2018-12-04 下午10:27
 * @Modified by:
 **/
public class BinaryNode<T>{

    private T data;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(T data) {
        this.data = data;
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}
