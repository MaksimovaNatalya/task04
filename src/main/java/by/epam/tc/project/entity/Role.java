package by.epam.tc.project.entity;

public enum Role {
    ADMIN(1), USER(2);

    private final int roleId;

    Role(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public static Role getById(int roleId) {
        for (Role role : Role.values()) {
            if (role.roleId == roleId) {
                return role;
            }
        }
        throw new RuntimeException("Could not find roleID");
    }
}
