package Objects;

import java.util.Comparator;

public class IP_Compare_TransP implements Comparator<TransferPatient> {

    @Override
    public int compare(TransferPatient o1, TransferPatient o2) {
        if (o1.getMaHS()>o2.getMaHS()){
            return 1;
        }else {
            return -1;
        }
    }
}
