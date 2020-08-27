package Objects;

import java.util.Comparator;

public class ID_Compare_IP implements Comparator<Inpatient> {
    @Override
    public int compare(Inpatient o1, Inpatient o2) {
        if (o1.getMaHS()>o2.getMaHS()){
            return 1;
        }else {
            return -1;
        }
    }
}
