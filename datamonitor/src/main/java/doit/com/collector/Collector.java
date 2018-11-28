package doit.com.collector;

import doit.com.handlers.DatabaseHandler;
import doit.com.models.domain.DataEtlDetailInfo;

import java.io.IOException;

public class Collector {

    private DataEtlDetailInfo result = null;

    private DatabaseHandler in = null;

    private DatabaseHandler out = null;

    public Collector(){
        out = new DatabaseHandler();
    }

    public Collector(DatabaseHandler out){
        this.out = out;
    }

    public boolean fetch() {
        return false;
    }

    public boolean save() throws IOException {

        out.insertDataEtlDetailInfo(result);

        return false;
    }
}
