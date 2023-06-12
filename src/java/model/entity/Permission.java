package model.entity;

public class Permission {
    private int id;
    private String permissionName;

    public Permission() {
    }

    public Permission(int id, String permissionName) {
        this.id = id;
        this.permissionName = permissionName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
