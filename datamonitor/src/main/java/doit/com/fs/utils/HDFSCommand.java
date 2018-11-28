package doit.com.fs.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;

public abstract class HDFSCommand {
    public static FileSystem fs = null;

    static {
        if (fs == null) {
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://master1:8020");
            try {
                fs = FileSystem.get(conf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract Integer run(String[] args) throws IOException;
}
