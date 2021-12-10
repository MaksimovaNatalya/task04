package entity;

public enum Role {
    ADMIN (1), MANAGER (2), GUEST (3);

    final int roleId;

    Role(int roleId){
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
