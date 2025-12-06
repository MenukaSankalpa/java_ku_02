package strategy;

import core._2524764_BorrowRecord;

import java.time.temporal.ChronoUnit;

public class _2524764_FacultyFine implements _2524764_FineStrategy {
    @Override
    public double calculateFine(_2524764_BorrowRecord record) {
        if (record.getReturnDate() == null) return 0;
        long daysLate = ChronoUnit.DAYS.between(record.getDueDate(), record.getReturnDate());
        return daysLate > 0 ? daysLate * 2 : 0; // 2 LKR per day
    }
}
