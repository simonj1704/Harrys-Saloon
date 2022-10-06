import java.util.ArrayList;

public class DateList {
    public ArrayList<Date> dates = new ArrayList<Date>();
    public Date date = new Date();
    private int date1;

    public DateList(){
       addAllDates();
    }

    public void addDate(){
        dates.add(new Date());
    }

    public void addAllDates(){
        for (int i = 0; i < 2000; i++) {
            dates.add(new Date());
        }
    }

    public int checkDate(String requestedDate) {
        String[] vacationDate = requestedDate.split("/");
        int yearTwoThousand = 8030;
        int normalYearLength = 365;
        int year = Integer.parseInt(vacationDate[2]) * normalYearLength - yearTwoThousand;
        int month = Integer.parseInt(vacationDate[1]);
        int date1 = Integer.parseInt(vacationDate[0]);

        switch (month) {
            case 1:
                month = 0;
                break;
            case 2:
                month = 31;
                break;
            case 3:
                month = 59;
                break;
            case 4:
                month = 90;
                break;
            case 5:
                month = 120;
                break;
            case 6:
                month = 151;
                break;
            case 7:
                month = 181;
                break;
            case 8:
                month = 212;
                break;
            case 9:
                month = 243;
                break;
            case 10:
                month = 273;
                break;
            case 11:
                month = 304;
                break;
            case 12:
                month = 334;
                break;
        }
        if (Integer.parseInt(vacationDate[2]) % 4 == 0)
            month += 1;

        this.date1 = year + month + date1;
        System.out.println(this.date1);

        return this.date1;
    }
    //TODO do we need to change this?

    @Override
    public String toString() {
        return "DateList{" +
                "dates=" + dates +
                '}';
    }
}
