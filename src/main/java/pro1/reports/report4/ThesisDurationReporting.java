package pro1.reports.report4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.google.gson.Gson;

import pro1.DataSource;
import pro1.apiDataModel.ThesisList;
import pro1.reports.report4.reportDataModel.DepartmentStats;

public class ThesisDurationReporting {

    public static Object[] GetReport(DataSource dataSource, String katedra, String[] years) {
        DepartmentStats[] stats = new DepartmentStats[years.length];
        for (int i = 0; i < years.length; i++) {
            var actionsListJson = dataSource.getKvalifikacniPrace(years[i], katedra);
            var actionsList = new Gson().fromJson(actionsListJson, ThesisList.class);
            stats[i] = new DepartmentStats(years[i], duration(actionsList));
        }
        return stats;
    }

    private static int duration(ThesisList thesisList) {
        var result = thesisList.items
                .stream()
                .filter(t -> t.assignedDate != null && t.submittedDate != null
                && t.assignedDate.value != null && t.submittedDate.value != null)
                .mapToInt(t -> daysBetween(t.assignedDate.value, t.submittedDate.value))
                .average()
                .orElse(0);
        return (int) Math.round(result);
    }

    private static int daysBetween(String start, String end) {
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate d1 = LocalDate.parse(start, frmt);
        LocalDate d2 = LocalDate.parse(end, frmt);
        return (int) ChronoUnit.DAYS.between(d1, d2);
    }

}
