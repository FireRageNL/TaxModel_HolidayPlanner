/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation;

/**
 *
 * @author Violet
 */
public class SideBarModel {

    private String name;
    private String location;

    public SideBarModel(String Name, String Location) {
        this.name = Name;
        this.location = Location;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

}
