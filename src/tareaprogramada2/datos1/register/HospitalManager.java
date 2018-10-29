/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;
import java.util.ArrayList;
import java.util.List;
import tareaprograma2.datos1.collections.*;
import tareaprogramada2.datos1.register.Patient;
import tareaprogramada2.datos1.register.attendedPeople.AttentionCenter;

/**
 *
 * @author samoy
 */
public class HospitalManager {

    private PriorityAdapter urgencyGreen;
    private PriorityAdapter urgencyYellow;
    private PriorityAdapter emergency;
    private PriorityAdapter attended;

    List<AttentionCenter> attentionC = new SimpleLinkeList<>();
    List<HealthOffice> greenConsultory = new SimpleLinkeList<>();
    List<HealthOffice> yellowConsultory = new SimpleLinkeList<>();
    List<HealthOffice> redConsultory = new SimpleLinkeList<>();
    List<HealthOffice> attendedConsultory = new SimpleLinkeList<>();

    public List<HealthOffice> getGreenConsutory() {
        return greenConsultory;
    }

    public List<HealthOffice> getYellowConsutory() {
        return yellowConsultory;
    }

    public List<HealthOffice> getRedConsutory() {
        return redConsultory;
    }

    public List<HealthOffice> getAttendedConsutory() {
        return attendedConsultory;
    }

    public PriorityAdapter getUrgencyGreen() {
        return urgencyGreen;
    }

    public void setUrgencyGreen(PriorityAdapter urgencyGreen) {
        this.urgencyGreen = urgencyGreen;
    }

    public PriorityAdapter getUrgencyYellow() {
        return urgencyYellow;
    }

    public void setUrgencyYellow(PriorityAdapter urgencyYellow) {
        this.urgencyYellow = urgencyYellow;
    }


    

    public PriorityAdapter getEmergency() {
        return emergency;
    }

    public void setEmergency(PriorityAdapter emergency) {
        this.emergency = emergency;
    }

    public PriorityAdapter getAttended() {
        return attended;
    }

    public void setAttended(PriorityAdapter attended) {
        this.attended = attended;
    }

    private static final HospitalManager instance = new HospitalManager();

    public static HospitalManager getInstance() {
        return instance;
    }

    public void Initialize() {
    }

    public void Initialize(boolean urgencyHeap, boolean emergencyHeap, boolean attendedHeap) {
        this.urgencyGreen = urgencyHeap ? new HeapPriorityAdapter()
                : new QueuePriorityAdapter();
        this.urgencyYellow = urgencyHeap ? new HeapPriorityAdapter()
                : new QueuePriorityAdapter();
        this.emergency = emergencyHeap ? new HeapPriorityAdapter()
                : new QueuePriorityAdapter();
        this.attended = attendedHeap ? new HeapPriorityAdapter()
                : new QueuePriorityAdapter();
    }

    public void Initialize(int consultoryQGreen, int consultoryQYellow, int consultoryQRed) {
        for (int i = 0; i < consultoryQGreen; i++) {
            this.greenConsultory.add(new HealthOffice());
            this.yellowConsultory.add(new HealthOffice());
            this.redConsultory.add(new HealthOffice());
            this.attendedConsultory.add(new HealthOffice());
        }
    }

}
