package by.epam.tc.project.entity;

public enum Role {
    ADMIN (1), USER(2);

    final int roleId;

    Role(int roleId){
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }
}
