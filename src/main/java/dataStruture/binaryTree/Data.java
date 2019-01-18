package main.java.dataStruture.binaryTree;

/**
 * ${DESCRIPTION}
 *
 * @Author: DianXiao2
 * @Date: Created in  2018-12-04 下午10:28
 * @Modified by:
 **/
public class Data implements Comparable<Data>{
    private Long code;
    private String msg;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    @Override
    public int compareTo(Data o) {
        if(code == o.code){
            return 0;
        }else if(code < o.code){
            return  -1;
        }else{
            return 1;
        }
    }
}
