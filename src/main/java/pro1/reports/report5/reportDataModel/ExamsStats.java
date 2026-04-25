package pro1.reports.report5.reportDataModel;

public class ExamsStats {

    public int realizedExamsCount;
    public int[] teacherIds;

    public ExamsStats(int realizedExamsCount, int[] teacherIds) {
        this.realizedExamsCount = realizedExamsCount;
        this.teacherIds = teacherIds;
    }
}
