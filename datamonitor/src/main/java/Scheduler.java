import doit.com.fs.utils.CommandFactory;
import doit.com.fs.utils.HDFSCmdInterpreter;
import doit.com.handlers.DatabaseHandler;
import doit.com.models.domain.DataCheckRule;
import doit.com.models.domain.DataEtlDetailInfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Scheduler {

    public void run() throws IOException {
        ArrayList<DataCheckRule> checkRules = new DatabaseHandler().selectCheckRules("Y");
        for (DataCheckRule cr : checkRules) {
            Date curDate = new Date(System.currentTimeMillis() - (2 * 60 * 60 * 1000));
            if (cr.getScheduleType().equals("D")) {
                curDate.setHours(0);
                curDate.setSeconds(0);
                curDate.setMinutes(0);
            } else if (cr.getScheduleType().equals("H")) {
                curDate.setSeconds(0);
                curDate.setMinutes(0);
            } else {
                System.out.println("Invalid schedule type: " + cr.getScheduleType());
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String ymd = sdf.format(curDate);

            Object result = new HDFSCmdInterpreter(new CommandFactory()).getResult(
                    cr.getCheckCmd().replace("${ETLDT}", ymd).replace("${ETLHOUR}", String.valueOf(curDate.getHours())));

            DataEtlDetailInfo info = new DataEtlDetailInfo();
            info.setAlarmRule(cr.getCheckRule());
            info.setResult(result.toString());
            info.setCheckRuleId(cr.getId());
            info.setAlarmed("N");
            info.setDataDateTime(curDate);

            new DatabaseHandler().insertDataEtlDetailInfo(info);
        }
    }

    public static void main(String[] args) throws IOException {
        new Scheduler().run();
    }
}
