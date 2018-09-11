/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.itcr.perez_moya.datos1.library;

import ac.itcr.perez_moya.datos1.collections.SimpleLinkeList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 */
public class LibrarySchedule {
    List <Collection <Openhours>> openHours;

    public LibrarySchedule() {
        openHours = new SimpleLinkeList<>();
        for (int i=1; i <= 7; i++ ){
            this.openHours.add(new SimpleLinkeList<>());
        }
    
        }
    
    
    public Collection <Openhours> getSchedule(int dayOfWeek){
        return this.openHours.get(dayOfWeek-Calendar.SUNDAY);
    }
    
    
    
}
