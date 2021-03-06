package pl.jakubraban.whereismyjudgement.data.judgment;

public enum CourtType {

    COMMON, SUPREME, SUPREME_ADMINISTRATIVE,
    REGIONAL_ADMINISTRATIVE,
    CONSTITUTIONAL_TRIBUNAL,
    NATIONAL_APPEAL_CHAMBER,
    NONE;

    public String toString() {
        switch(this) {
            case COMMON:
                return "Sąd powszechny";
            case SUPREME:
                return "Sąd Najwyższy";
            case SUPREME_ADMINISTRATIVE:
                return "Naczelny Sąd Administracyjny";
            case REGIONAL_ADMINISTRATIVE:
                return "Wojewódzki Sąd Administracyjny";
            case CONSTITUTIONAL_TRIBUNAL:
                return "Trybunał Konstytucyjny";
            case NATIONAL_APPEAL_CHAMBER:
                return "Krajowa Izba Odwoławcza";
            default:
                return "Żaden";
        }
    }

}
