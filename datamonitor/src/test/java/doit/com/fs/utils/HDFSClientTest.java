package doit.com.fs.utils;

import junit.framework.TestCase;

import java.io.IOException;

public class HDFSClientTest extends TestCase {
	
	public void testGetCount() throws IOException {
		HDFSClientTest.assertEquals(11, new HDFSCmdInterpreter(new CommandFactory()).getResult("-count /ods/safe_realtime_click/20181125/00"));
	}
}
