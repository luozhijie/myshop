package lzj.DAO;

import lzj.entity.RememberMe;

public interface RememberMeDao {
	public int addRemeberMe(RememberMe rememberMe);

	public int delRemeberMe(RememberMe rememberMe);

	public int updateRemeberMe(RememberMe rememberMe);

	public RememberMe findRemeberMeByUid(int uid);

	public RememberMe findRemeberMeByMd5(String md5);

	public RememberMe findRememberMyByUidAndMd5(int uid, String md5);
}
