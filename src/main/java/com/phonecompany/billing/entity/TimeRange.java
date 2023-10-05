package com.phonecompany.billing.entity;

import java.time.LocalDate;

public record TimeRange(
    LocalDate start,
    LocalDate end
) {
}
