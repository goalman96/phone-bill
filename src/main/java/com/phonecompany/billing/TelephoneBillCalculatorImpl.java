package com.phonecompany.billing;

import com.phonecompany.billing.converter.Converter;

import java.math.BigDecimal;

public class TelephoneBillCalculatorImpl implements TelephoneBillCalculator {
    private static boolean PROMO = true;

    public BigDecimal calculate (String phoneLog) {
        final var phoneRecordMap = Converter.convert(phoneLog);
        if (PROMO) {
            return PromoStrategy.sum(phoneRecordMap);
        }
        return NormalStrategy.sum(phoneRecordMap);
    }
}
