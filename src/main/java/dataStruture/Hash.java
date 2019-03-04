package dataStruture;

import java.util.List;

/**
 * 散列
 */
public class Hash {

    public static void main(String[] args) {

    }

    /**
     * 分离连接法
     */
    static class SeparateChainingHashTable<T>{

        private int size;

        private static final int DEFAULT_SIZE = 10;
        private List<T> list;
        private int currentSize;


        public SeparateChainingHashTable() {
        }

        public void insert(T t){

        }

        public void remove(T t){

        }

        public boolean contains(T t){
            return true;
        }

        public void empty(){

        }
        private void rehash(){};
        private int myhash(){
            return 0;
        };
        private static int nextPrime(int n){
            return 0;
        };




    }
}
