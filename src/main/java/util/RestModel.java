package util;

public class RestModel<T> {
    public static Integer CODE_SUCCESS = 1; // 成功
    public static Integer CODE_FAIL = 0; //失败
    public static Integer CODE_UNKNOWN = 2; // 未知

    public static String MESSAGE_SUCCESS = "SUCCESS";
    public static String MESSAGE_FAIL = "FAIL";

    private Integer code;
    private Boolean successFlag;
    private String message;
    private T data;
    private String directUrl;


    public static RestModel getError(){
        RestModel restModel = new RestModel();
        restModel.setCode(CODE_FAIL);
        restModel.setMessage(MESSAGE_FAIL);
        return restModel;
    }

    public static RestModel getError(String msg){
        RestModel restModel = new RestModel();
        restModel.setCode(CODE_FAIL);
        restModel.setMessage(msg);
        return restModel;
    }

    public static RestModel getSuccess(){
        RestModel restModel = new RestModel();
        restModel.setCode(CODE_SUCCESS);
        restModel.setMessage(MESSAGE_SUCCESS);
        return restModel;
    }

    public static RestModel getSuccess(String msg){
        RestModel restModel = new RestModel();
        restModel.setCode(CODE_SUCCESS);
        restModel.setMessage(msg);
        return restModel;
    }

    public static <T> RestModel getSuccess(T data){
        RestModel restModel = getSuccess();
        restModel.setData(data);
        return restModel;
    }

    public static <T> RestModel getSuccess(String msg,T data){
        RestModel restModel = new RestModel();
        restModel.setCode(CODE_SUCCESS);
        restModel.setMessage(msg);
        restModel.setData(data);
        return restModel;
    }
    
    public static <T> RestModel getError(String msg,T data){
        RestModel restModel = new RestModel();
        restModel.setCode(CODE_FAIL);
        restModel.setMessage(msg);
        restModel.setData(data);
        return restModel;
    }

    public RestModel() { }

    public RestModel(Integer code, String message, T data, String directUrl) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.directUrl = directUrl;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getDirectUrl() {
        return directUrl;
    }

    public void setDirectUrl(String directUrl) {
        this.directUrl = directUrl;
    }

	public Boolean getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(Boolean successFlag) {
		this.successFlag = successFlag;
	}

}