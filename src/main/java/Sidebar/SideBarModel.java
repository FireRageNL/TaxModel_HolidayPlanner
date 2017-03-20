/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sidebar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Violet
 */
public class SideBarModel {
    public String Name;

        private ArrayList<SideBarActionGroup> _groups;

        public ArrayList<SideBarActionGroup> getGroups() {
            return _groups = new ArrayList<SideBarActionGroup>();
        }

        public void setGroups(ArrayList<SideBarActionGroup> _groups) {
            this._groups = _groups;
        }
    
    

    public class SideBarActionGroup
    {
        public String Name;

        private ArrayList<SideBarAction> _actions;

        public ArrayList<SideBarAction> getActions() {
            return _actions = new ArrayList<SideBarAction>(); 
        }

        public void setActions(ArrayList<SideBarAction> _actions) {
            this._actions = _actions;
        }
    }

    public class SideBarAction
    {
        public String Name;
        public String Controller;
        public String Action;
        public String IconName;

        public String getName() {
            return Name;
        }

        public String getIconName() {
            return IconName;
        }

        public String getAction() {
            return Action;
        }

        public String getController() {
            return Controller;
        }

        public void setAction(String Action) {
            this.Action = Action;
        }

        public void setController(String Controller) {
            this.Controller = Controller;
        }

        public void setIconName(String IconName) {
            this.IconName = IconName;
        }

        public void setName(String Name) {
            this.Name = Name;
        }       
                 
    }
}
