package doit.com.fs.utils;

public class CommandFactory {

    public HDFSCommand getInstance(String item) {
        if (item.equals("-count")) {
            return new HDFSCount();
        }

        return null;
    }
}
