package thread.threadPoolDemo;

/**
 * @Description 用于通知任务提交者，任务队列已无法在接受新的任务
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class RunnalbeDenyException extends  RuntimeException {
    public RunnalbeDenyException(String message) {
        super(message);
    }
}
