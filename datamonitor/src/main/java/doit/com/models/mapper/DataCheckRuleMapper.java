package doit.com.models.mapper;

import doit.com.models.domain.DataCheckRule;

import java.util.ArrayList;

public interface DataCheckRuleMapper {
    public ArrayList<DataCheckRule> select(String flag);
}
