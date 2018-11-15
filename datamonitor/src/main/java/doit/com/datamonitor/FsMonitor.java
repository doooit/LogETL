package doit.com.datamonitor;

import java.io.IOException;

public abstract class FsMonitor {
	/*
	 * 获取路径下文件数量
	 */
	public abstract Integer getCount(String path, String prefix, String suffix)
			throws IOException;
}
