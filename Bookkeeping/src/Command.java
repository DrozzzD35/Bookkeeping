public enum Command {
    READ_MONTH_REPORTS,
    READ_YEAR_REPORTS,
    VERIFY_REPORTS,
    PRINT_MONTH_REPORTS,
    PRINT_YEAR_REPORTS,
    EXIT,
    UNKNOWN ;

    public static Command getCommand(int number){
        switch (number){
            case 1-> {
                return READ_MONTH_REPORTS;
            }
            case 2->{
                return READ_YEAR_REPORTS;
            }
            case 3->{
                return VERIFY_REPORTS;
            }
            case 4 ->{
                return PRINT_MONTH_REPORTS;
            }
            case  5->{
                return PRINT_YEAR_REPORTS;
            }
            case 6->{
                return EXIT;
            }
            default -> {
                return UNKNOWN;
            }
        }
    }


}
