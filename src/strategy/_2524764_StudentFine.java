package strategy;

import core._2524764_BorrowRecord;

import java.time.LocalDate;

public class _2524764_StudentFine implements _2524764_FineStrategy {
    @Override
    public double calculateFine(_2524764_BorrowRecord record) {
        if (record.getReturnDate() == null) return 0;
        long daysLate = java.time.temporal.ChronoUnit.DAYS.between(record.getDueDate(), record.getReturnDate());
        return daysLate > 0 ? daysLate * 5 : 0; // 5 LKR per day
    }
}
