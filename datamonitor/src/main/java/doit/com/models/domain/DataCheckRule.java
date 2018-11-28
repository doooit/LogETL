package doit.com.models.domain;

public class DataCheckRule {
    private Integer id;
    private String scheduleTiming;
    private String scheduleType;
    private String checkEngine;
    private String checkCmd;
    private String checkRule;
    private String alarmTo;
    private String enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheduleTiming() {
        return scheduleTiming;
    }

    public void setScheduleTiming(String scheduleTiming) {
        this.scheduleTiming = scheduleTiming;
    }

    public String getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(String scheduleType) {
        this.scheduleType = scheduleType;
    }

    public String getCheckEngine() {
        return checkEngine;
    }

    public void setCheckEngine(String checkEngine) {
        this.checkEngine = checkEngine;
    }

    public String getCheckCmd() {
        return checkCmd;
    }

    public void setCheckCmd(String checkCmd) {
        this.checkCmd = checkCmd;
    }

    public String getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(String checkRule) {
        this.checkRule = checkRule;
    }

    public String getAlarmTo() {
        return alarmTo;
    }

    public void setAlarmTo(String alarmTo) {
        this.alarmTo = alarmTo;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }
}
