package  dataStruture.binaryTree;

import java.nio.BufferUnderflowException;

/**
 * ${DESCRIPTION}
 *
 * @Author: DianXiao2
 * @Date: Created in  2018-12-04 下午10:35
 * @Modified by:
 **/
public class BinaryTree<T extends Comparable> {

    private BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public void makeEmpty(){
        this.root = null;
    }

    public Boolean isEmpty(){
        return this.root == null;
    }

    public Boolean contains(T t){
        return contains(t, root);
    }

    public T findMin(){
        if(isEmpty()){
            throw  new BufferUnderflowException();
        }
        return findMin(root).getData();
    }

    public T findMax(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        return findMax(root).getData();
    }

    public void insert(T data){
        root = insert(data, root);
    }

    public void remove(T data){
        root = remove(data, root);
    }

    public void printTree(){

    }

    private Boolean contains(T data, BinaryNode<T> node){
        if(node == null){
            return false;
        }

        if(data.compareTo(node.getData() )< 0){
            return contains(data, node.getLeft());
        }else if(data.compareTo(node.getData()) > 0){
            return contains(data, node.getRight());
        }else{
            return true;
        }
    }

    /**
     * 查找最小值,递归实现
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode<T> node){

        if(node == null){
            return null;
        }

        if(node.getLeft() == null){
            return node;
        }

        return findMin(node.getLeft());
    }

    /**
     * 查找最大值,while实现
     * @param node
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode<T> node){

        if(node == null){
            return null;
        }

        BinaryNode<T> temp = node;

        while (temp.getRight() != null){
            temp = temp.getRight();
        }

        return temp;
    }

    /**
     * 插入值
     * @param data
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> node){
        // todo
        if (node == null){
            return new BinaryNode<T>(data,null,null);
        }

        T temp = node.getData();
        if(temp.compareTo(data) < 0){
            node.setLeft(insert(data, node.getLeft()));
        }else if(temp.compareTo(data) > 1){
           node.setRight(insert(data, node.getRight()));
        }else{
            //duplicated
        }
        return node;
    }

    /**
     * 删除节点
     * @param data
     * @param node
     * @return
     */
    private BinaryNode<T> remove(T data, BinaryNode<T> node){
        if(node == null){
            return node;
        }
        int i = node.getData().compareTo(data);
        if(i < 0){
            node.setLeft(remove(data, node.getLeft()));
        }else if(i > 0){
            node.setRight(remove(data, node.getRight()));
        }else if(node .getLeft() != null && node.getRight() != null){
            //two children
            node.setData(findMin(node.getRight()).getData());
            node.setRight(remove(node.getData(),node.getRight()));
        }else{
            // one children
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }
        return node;
    }
    private void printTree(BinaryNode<T> node){
        // todo

    }
}

