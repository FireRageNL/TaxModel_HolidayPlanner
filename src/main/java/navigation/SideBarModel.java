/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Violet
 */
public class SideBarModel {

    public String Name;
    public String Location;

    public SideBarModel(String Name, String Location) {
        this.Name = Name;
        this.Location = Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getLocation() {
        return Location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

}
