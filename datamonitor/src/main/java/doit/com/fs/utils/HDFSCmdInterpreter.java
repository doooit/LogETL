package doit.com.fs.utils;

import java.io.IOException;
import java.util.Arrays;

public class HDFSCmdInterpreter {
    private String[] args = null;
	private CommandFactory commandFactory = null;

	public HDFSCmdInterpreter(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
	}

	public Object getResult(String cmd) throws IOException {
	    this.args = cmd.split( " ");
		return this.commandFactory.getInstance(this.args[0]).run(Arrays.copyOfRange(this.args, 1, this.args.length));
	}
}
