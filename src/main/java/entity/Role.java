package entity;

public enum Role {
    Admin (1), Manager (2), Guest (3);

    final int roleId;

    Role(int roleId){
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
