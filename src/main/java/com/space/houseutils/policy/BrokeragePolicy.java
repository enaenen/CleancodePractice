package com.space.houseutils.policy;

import com.space.houseutils.exception.ErrorCode;
import com.space.houseutils.exception.HouseUtilsException;

import java.util.List;

public interface BrokeragePolicy {
    List<BrokerageRule> getRules();
    default Long calculate(Long price) {
        BrokerageRule brokerageRule = getRules().stream()
                .filter(rule -> price < rule.getLessThen())
                .findFirst()
                .orElseThrow(()-> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }
}
