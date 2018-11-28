package doit.com.handlers;

import doit.com.models.domain.DataCheckRule;
import doit.com.models.domain.DataEtlDetailInfo;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

public class DatabaseHandlerTest extends TestCase {

	public void testInsertDataEtlDetailInfo() {
		DataEtlDetailInfo info = new DataEtlDetailInfo();
		
        info.setDataDateTime(new Date(2018, 11, 28, 00, 00));
        info.setCheckRuleId(1);
        info.setResult(new Integer(11).toString());
        info.setAlarmRule("!=11");
		info.setAlarmed("N");

		DatabaseHandlerTest.assertTrue(new DatabaseHandler().insertDataEtlDetailInfo(info) > 0);
	}

	public void testSelectCheckRules() {
		ArrayList<DataCheckRule> res = new DatabaseHandler().selectCheckRules("Y");

		for (DataCheckRule re : res) {
			System.out.println(re.getCheckCmd() + re.getId() + re.getEnable());
		}

		DatabaseHandlerTest.assertEquals(res.getClass(), ArrayList.class);
	}
}
