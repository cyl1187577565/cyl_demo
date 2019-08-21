package thread.threadPoolDemo;

import org.omg.PortableServer.ThreadPolicyOperations;

/**
 * 主要相当queue中的limit到达上限之后， 采用何种
 */
public interface DenyPolicy {

    void reject(Runnable runnable, ThreadPool threadPool);


    // 该拒绝策略直接丢弃
    public class DiscardDenyPolicy implements DenyPolicy{

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            System.out.println(">> 丢弃啦");
        }
    }

    // 该拒绝策略会向任务提交者抛出异常
    public class AbortDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnalbeDenyException("The Runable " + runnable + " will be abort");
        }
    }

    //该拒绝策略会使任务在提交者所在的线程中执行任务
    public class RunnerDenyPolicy implements DenyPolicy{
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }
}
