package com.phonecompany.billing;

import com.phonecompany.billing.entity.CallRecord;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class PromoStrategy {
    public static BigDecimal sum(Map<Integer, List<CallRecord>> callRecordMap) {
        final var maxEntry = Collections
                .max(callRecordMap.entrySet(), Comparator.comparingInt(entry -> entry.getValue().size()))
                .getKey();
        callRecordMap.remove(maxEntry);

        return NormalStrategy.sum(callRecordMap);
    }
}
