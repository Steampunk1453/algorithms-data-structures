package matrix;

public class Agenda {

    protected int[][] createAgenda() {
        int[][] months = new int[12][];
        int[] days = new int[0];

        for (int i = 0; i < 12; i++) {
            switch (i) {
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case 9:
                case 11:
                    days = new int[31];
                    break;
                case 3:
                case 5:
                case 8:
                case 10:
                    days = new int[30];
                    break;
                case 1:
                    days = new int[28];
                    break;
            }
            months[i] = days;
        }
        return months;
    }

}
