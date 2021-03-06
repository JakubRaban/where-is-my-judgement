package pl.jakubraban.whereismyjudgement.data.judge;

public enum JudgeRole {

    PRESIDING_JUDGE, REPORTING_JUDGE,
    REASONS_FOR_JUDGMENT_AUTHOR,
    NONE;

    public String toString() {
        switch (this) {
            case PRESIDING_JUDGE:
                return "Przewodniczący składu";
            case REPORTING_JUDGE:
                return "Sędzia sprawozdawca";
            case REASONS_FOR_JUDGMENT_AUTHOR:
                return "Autor uzasadnienia";
            default:
                return "Brak";
        }
    }

}
