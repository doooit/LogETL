package doit.com.parser;

import doit.com.models.domain.DataCheckRule;

public class CheckRuleParser {
    private DataCheckRule dcr = null;

    public CheckRuleParser(DataCheckRule dcr) {
        this.dcr = dcr;
    }

    public String getScheduleTiming() {
        return dcr.getScheduleTiming();
    }

    public String getCheckRule() {
        return dcr.getCheckRule();
    }

    public String getCheckEngine() {
        return dcr.getCheckEngine();
    }
}
