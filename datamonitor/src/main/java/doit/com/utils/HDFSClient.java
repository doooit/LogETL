package doit.com.utils;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import doit.com.datamonitor.FsMonitor;

public class HDFSClient extends FsMonitor {
	
	public static FileSystem fs = null;
	
	static {
		if (fs == null) {
			Configuration conf = new Configuration();
			try {
				fs = FileSystem.get(conf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		HDFSClient hdfsMonitor = new HDFSClient();
		Integer count = hdfsMonitor.getCount(args[0], "172", ".gz");
		System.out.println("file count under " + args[0] + " is " + count);
	}
	
	@Override
	public Integer getCount(String path, String prefix, String suffix)
			throws IOException {
		Integer count = 0;
		String fileName = null;
		boolean matchFlag = true;
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path(path), false);
		while (listFiles.hasNext()) {
			matchFlag = true;
			LocatedFileStatus fileStatus = listFiles.next();
			fileName = fileStatus.getPath().getName();
			if (prefix != null) {
				if (!fileName.startsWith(prefix)) {
					matchFlag = false;
				}
			}
			
			if (suffix != null) {
				if (!fileName.endsWith(suffix)) {
					matchFlag = false;
				}
			}
			
			if (matchFlag) {
				System.out.println(fileName);
				count += 1;
			}
			
		}
		
		return count;
	}
	
}
