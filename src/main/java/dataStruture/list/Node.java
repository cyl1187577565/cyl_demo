package dataStruture.list;

import lombok.Data;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/10/25
 */
@Data
public class Node {
    public Node next;
    public Integer value;

    public Node(Integer value) {
        this.value = value;
    }
}
