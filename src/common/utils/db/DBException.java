package common.utils.db;

// fizemos com RunTimeException para não ter que ficar tratando toda hora a SQLExpcetion (ela deriva de Exception, então fudeu...tem que tratar)
public class DBException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DBException(String msg) {
		super(msg);
	}

}
