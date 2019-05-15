package code.mybatis.demo.mapper;

import code.mybatis.demo.domain.systemUser;
import java.util.List;

public interface systemUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(systemUser record);

    systemUser selectByPrimaryKey(Long id);

    List<systemUser> selectAll();

    int updateByPrimaryKey(systemUser record);
}