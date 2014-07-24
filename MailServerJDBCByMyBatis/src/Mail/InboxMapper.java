package Mail;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface InboxMapper {

	
	@Select("select text from Inbox where address=#{addr}")
	List<Inbox> selectByAddress(String addr);
	@Insert("insert into Inbox (address,text) values (#{param1},#{param2})")
	void insertAddrAndText(String address,String text);
	
}
