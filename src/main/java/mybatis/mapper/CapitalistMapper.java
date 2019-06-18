package mybatis.mapper;

import mybatis.model.Capitalist;
import mybatis.model.CapitalistExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapitalistMapper {
    /**
     * @mbg.generated
     */
    long countByExample(CapitalistExample example);

    /**
     * @mbg.generated
     */
    int deleteByExample(CapitalistExample example);

    /**
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated
     */
    int insert(Capitalist record);

    /**
     * @mbg.generated
     */
    int insertSelective(Capitalist record);

    /**
     * @mbg.generated
     */
    List<Capitalist> selectByExample(CapitalistExample example);

    /**
     * @mbg.generated
     */
    Capitalist selectByPrimaryKey(Long id);

    /**
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Capitalist record, @Param("example") CapitalistExample example);

    /**
     * @mbg.generated
     */
    int updateByExample(@Param("record") Capitalist record, @Param("example") CapitalistExample example);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Capitalist record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(Capitalist record);
}