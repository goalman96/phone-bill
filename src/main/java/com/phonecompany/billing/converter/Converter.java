package com.phonecompany.billing.converter;

import com.opencsv.CSVReaderBuilder;
import com.phonecompany.billing.entity.CallRecord;
import com.phonecompany.billing.entity.TimeRange;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Converter {
    private static final String TIME_PATTERN = "dd-MM-yyyy HH:mm:ss";

    public static Map<Integer, List<CallRecord>> convert(String csv) {
        try {
            final var csvReader = new CSVReaderBuilder(new StringReader(csv)).build();
            final var csvData = csvReader.readAll();
            final var callRecordList = new ArrayList<CallRecord>();

            for (String[] row : csvData) {
                callRecordList.add(convert(row));
            }

            return callRecordList
                    .stream()
                    .collect(Collectors.groupingBy(CallRecord::number));

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static CallRecord convert(String[] csvRow) {
        final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_PATTERN);
        LocalDate startTime = LocalDate.parse(csvRow[1], timeFormatter);
        LocalDate endTime = LocalDate.parse(csvRow[2], timeFormatter);

        return new CallRecord(Integer.valueOf(csvRow[0]), new TimeRange(startTime, endTime));
    }
}
