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

    private PriorityAdapter urgency;
    private PriorityAdapter emergency;
    private PriorityAdapter attended;


    List<AttentionCenter> attentionC = new SimpleLinkeList<>();
    List<HealthOffice> greenConsutory = new SimpleLinkeList<>();

    public List<HealthOffice> getGreenConsutory() {
        return greenConsutory;
    }
    

    public PriorityAdapter getUrgency() {
        return urgency;
    }

    public void setUrgency(PriorityAdapter urgency) {
        this.urgency = urgency;
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
        this.urgency = urgencyHeap ? new HeapPriorityAdapter()
                : new QueuePriorityAdapter();

    }

    public void Initialize(int consultoryQGreen, int consultoryQYellow, int consultoryQRed) {
        for (int i=0;i<consultoryQGreen;i++){
        this.greenConsutory.add(new HealthOffice());
        }//To change body of generated methods, choose Tools | Templates.
    }

}
