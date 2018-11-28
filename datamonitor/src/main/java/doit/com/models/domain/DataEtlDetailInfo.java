package doit.com.models.domain;

import java.util.Date;

public class DataEtlDetailInfo {
	private Integer id;
	private Integer checkRuleId;
	private Date dataDateTime;
	private String result;
	private String alarmRule;
	private String alarmed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCheckRuleId() {
		return checkRuleId;
	}

	public void setCheckRuleId(Integer checkRuleId) {
		this.checkRuleId = checkRuleId;
	}

	public Date getDataDateTime() {
		return dataDateTime;
	}

	public void setDataDateTime(Date dataDateTime) {
		this.dataDateTime = dataDateTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAlarmRule() {
		return alarmRule;
	}

	public void setAlarmRule(String alarmRule) {
		this.alarmRule = alarmRule;
	}

	public String getAlarmed() {
		return alarmed;
	}

	public void setAlarmed(String alarmed) {
		this.alarmed = alarmed;
	}
}
