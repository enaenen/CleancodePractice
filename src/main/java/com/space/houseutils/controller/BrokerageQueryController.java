package com.space.houseutils.controller;

import com.space.houseutils.constants.ActionType;
import com.space.houseutils.policy.BrokeragePolicy;
import com.space.houseutils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrokerageQueryController {
    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price){
        // 타입 정의 - 매매 / 임대차
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
