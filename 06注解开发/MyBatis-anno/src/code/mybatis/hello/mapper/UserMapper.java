package code.mybatis.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import code.mybatis.hello.domain.User;

public interface UserMapper {
	/*  <!-- ±£´æ²Ù×÷ -->
		<insert id="save" useGeneratedKeys="true" keyProperty="id">
			insert into t_user (name,salary) values(#{name},#{salary})
		</insert>*/
	@Insert("insert into t_user (name,salary) values(#{name},#{salary})")
	//@Insert({"insert into t_user (name,salary)","values(#{name},#{salary})"})
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(User u);
	
	@Update("update t_user set name=#{name},salary=#{salary} where id=#{id}")
	void update(User u);
	
	@Delete("delete from t_user where id=#{id}")
	void delete(Long id);
	
	@Select("select id as u_id,name as u_name,salary as u_salary from t_user where id = #{id}")
	@Results(id="BaseResultMap",value= {
			@Result(column="u_id",property="id"),
			@Result(column="u_name",property="name"),
			@Result(column="u_salary",property="salary")
	})
	User get(Long id);
	
	@Select("select id as u_id,name as u_name,salary as u_salary from t_user")
	@ResultMap("BaseResultMap")
	List<User> listAll();
}
