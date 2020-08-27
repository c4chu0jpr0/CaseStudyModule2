package Objects;

import java.util.Comparator;

public class ID_Compare_OP implements Comparator<Outpatient> {
    @Override
    public int compare(Outpatient o1, Outpatient o2) {
        if (o1.getMaHS() > o2.getMaHS()) return 1;
        else return -1;
    }
}
