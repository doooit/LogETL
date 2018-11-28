package doit.com.fs.utils;

import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

import java.io.IOException;

public class HDFSCount extends HDFSCommand{

    @Override
    public Integer run(String[] args) throws IOException {

        RemoteIterator<LocatedFileStatus> lfs = fs.listFiles(new Path(args[0]), false);

        Integer count = 0;
        while (lfs.hasNext()) {
            lfs.next();
            count += 1;
        }

        return count;
    }
}
