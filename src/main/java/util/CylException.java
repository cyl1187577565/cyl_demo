package util;

public class CylException extends RuntimeException{

    private Integer code;
    private String msg;

    public CylException() {
    }

    public CylException(String msg) {
        this.msg = msg;
    }

    public CylException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
