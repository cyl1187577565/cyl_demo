package mybatis.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString
public class Capitalist implements Serializable {
    /**
     * 
     * @mbg.generated
     */
    private Long id;

    /**
     * 资方名称
     * @mbg.generated
     */
    private String name;

    /**
     * 资方中文名称
     * @mbg.generated
     */
    private String chineseName;

    /**
     * 最大订单金额
     * @mbg.generated
     */
    private BigDecimal maxQuota;

    /**
     * 最小订单金额
     * @mbg.generated
     */
    private BigDecimal minQuota;

    /**
     * 借款期限列表
     * @mbg.generated
     */
    private String period;

    /**
     * 借款期限单位
     * @mbg.generated
     */
    private String periodUnit;

    /**
     * 银行卡列表
     * @mbg.generated
     */
    private String bankList;

    /**
     * 允许给资方推送订单的放款时间段，JsonArray，每个时间段是JsonObject
     * @mbg.generated
     */
    private String loanTime;

    /**
     * 资方推送订单的日限金额
     * @mbg.generated
     */
    private BigDecimal maxMoney;

    /**
     * 资方推满后可积累最大订单数
     * @mbg.generated
     */
    private Integer maxLoan;

    /**
     * 优先级
     * @mbg.generated
     */
    private BigDecimal priority;

    /**
     * 放弃提现的时间
     * @mbg.generated
     */
    private String dropWithdrawTime;

    /**
     * 放弃提现时间的规则
     * @mbg.generated
     */
    private String withdrawTimeRule;

    /**
     * 放款成功后是否需要提现
     * @mbg.generated
     */
    private Integer needWithdraw;

    /**
     * 分单开关
     * @mbg.generated
     */
    private Integer allotSwitch;

    /**
     * 推送开关
     * @mbg.generated
     */
    private Integer pushSwitch;

    /**
     * 查询开关
     * @mbg.generated
     */
    private Integer querySwitch;

    /**
     * 周末是否可推送开关
     * @mbg.generated
     */
    private Integer weekendSwitch;

    /**
     * 开户开关
     * @mbg.generated
     */
    private Integer openAccountSwitch;

    /**
     * 放弃提现开关
     * @mbg.generated
     */
    private Integer withdrawSwitch;

    /**
     * 资方类型
     * @mbg.generated
     */
    private String loanType;

    /**
     * 
     * @mbg.generated
     */
    private String merchantId;

    /**
     * 
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     * 
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}