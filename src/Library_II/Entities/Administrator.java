package Library_II.Entities;

import Library_II.Repositories.Permissions;

import java.util.ArrayList;

public class Administrator extends User{

    private ArrayList<Permissions> permissions = new ArrayList<>();
    private static byte adminLevel;
    final private boolean isSuperAdmin;

    public Administrator(Profile profile, String username, String password, boolean isSuperAdmin) {
        super(profile, username, password);
        this.isSuperAdmin=isSuperAdmin;
    }

    ///////////////////////////GETTERS///////////////////////////
    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public ArrayList<Permissions> getPermissions() {
        return permissions;
    }

    //Imprimir los permisos solo usando Administrator.toString()
    @Override
    public String toString() {
        if (adminLevel==3) return "READ | WRITE | DELETE";
        if (adminLevel==2) return "READ | WRITE";
        if (adminLevel==1 )return "READ";
        else return "None...";
    }

    ////////////////////////////////////////////////////////////
    public void addPermission(Permissions Permission){
        permissions.add(Permission);
    }

    public void setAdminLevel(){
        if(permissions.contains(Permissions.DELETE))
            adminLevel=3;
        else if(!permissions.contains(Permissions.DELETE)&&permissions.contains(Permissions.WRITE))
            adminLevel=2;
        else if (!permissions.contains(Permissions.DELETE)&&!permissions.contains(Permissions.WRITE)&&permissions.contains(Permissions.READ))
            adminLevel=1;
        else adminLevel=0;
    }

    @Override
    public void print() {
        System.out.print("avr'nt");
    }

    @Override
    public byte getAdminLevel() {
        return adminLevel;
    }
}
