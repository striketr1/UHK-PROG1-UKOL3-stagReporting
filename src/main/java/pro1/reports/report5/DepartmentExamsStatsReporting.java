package pro1.reports.report5;

import com.google.gson.Gson;

import pro1.DataSource;
import pro1.apiDataModel.ExamsList;
import pro1.reports.report5.reportDataModel.ExamsStats;

public class DepartmentExamsStatsReporting {

    public static Object GetReport(DataSource dataSource, String katedra) {
        var examsListJson = dataSource.getTerminyZkousek2(katedra);
        var examsList = new Gson().fromJson(examsListJson, ExamsList.class);
        return new ExamsStats(
                countRealizedExams(examsList),
                getTeachersIds(examsList));
    }

    private static int countRealizedExams(ExamsList examsList) {
        var result = (int) examsList.items
                .stream()
                .filter(e -> e.occupancy > 0)
                .count();
        return result;
    }

    private static int[] getTeachersIds(ExamsList examsList) {
        var result = examsList.items
                .stream()
                .filter(e -> e.occupancy > 0)
                .mapToInt(e -> e.teacherId)
                .distinct()
                .toArray();
        return result;
    }
}
