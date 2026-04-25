package pro1.reports.report3;

import com.google.gson.Gson;

import pro1.DataSource;
import pro1.apiDataModel.ActionsList;
import pro1.reports.report3.reportDataModel.DepartmentStats;

public class DepartmentWeekdaysReporting {

    public static DepartmentStats[] GetReport(DataSource dataSource, String rok, String katedra, String[] days) {
        var actionsListJson = dataSource.getRozvrhByKatedra(rok, katedra);
        var actionsList = new Gson().fromJson(actionsListJson, ActionsList.class);
        return buildStats(actionsList, days);
    }

    private static DepartmentStats[] buildStats(ActionsList actionsList, String[] days) {
        DepartmentStats[] stats = new DepartmentStats[days.length];
        for (int i = 0; i < days.length; i++) {
            String day = days[i];
            int count = (int) actionsList.items
                    .stream()
                    .filter(a -> a.weekday != null && a.weekday.equals(day))
                    .count();
            stats[i] = new DepartmentStats(day, count);
        }
        return stats;
    }
}
