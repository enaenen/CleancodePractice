package com.space.houseutils.controller;

import com.space.houseutils.constants.ActionType;
import com.space.houseutils.policy.BrokeragePolicy;
import com.space.houseutils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Space
 * <p>
 * 중개수수료가 얼마인지 조회하는 컨트롤러
 */

@RestController
public class BrokerageQueryController {
    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }
}
