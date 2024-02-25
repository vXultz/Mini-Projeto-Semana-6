package SystemOutputs;

public enum EnumUserType {

    ALUNO("A"),
    DIRETOR("F"),
    PROFESSOR("F"),
    FUNCIONARIO("F"),
    ADMIN("X");

    private final String permissionGroup;
    EnumUserType(String permissionGroup) {
        this.permissionGroup = permissionGroup;

    }

    public String getPermissionGroup() {
        return this.permissionGroup;
    }
}
