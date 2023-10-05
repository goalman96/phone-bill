package com.phonecompany.billing;

import com.phonecompany.billing.entity.CallRecord;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class NormalStrategy {

    // chybi implementace
    public static BigDecimal sum(Map<Integer, List<CallRecord>> callRecordMap) {

       return BigDecimal.ONE;
    }
}
