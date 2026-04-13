package pro1.reports.report2.reportDataModel;

public class DepartmentStats
{
    public int maxActionStudentsCount;
    public int emptyActionsCount;
    public int maxTeacherScore;

    public DepartmentStats(int maxActionStudentsCount, int emptyActionsCount, int maxTeacherScore) {
        this.maxActionStudentsCount = maxActionStudentsCount;
        this.emptyActionsCount = emptyActionsCount;
        this.maxTeacherScore = maxTeacherScore;
    }
}
