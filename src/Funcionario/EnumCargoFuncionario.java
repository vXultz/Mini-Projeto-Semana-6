package Funcionario;

import java.util.HashMap;
import java.util.Map;

public enum EnumCargoFuncionario {
    INICIANTE("Iniciante", 1),
    EXPERIENTE("Experiente", 2),
    AVANCADO("Avançado", 3);

    private final String formatedValue;
    private final int level;
    //Declares a map of level x cargo
    private static final Map<Integer, EnumCargoFuncionario> map = new HashMap<>(values().length, 1);

    static {
        //fills the map of cargo x level
        for (EnumCargoFuncionario c : values()) {
            map.put(c.level, c);
        }
    }
    EnumCargoFuncionario(String formatedValue, int level) {
        this.formatedValue = formatedValue;
        this.level = level;

    }

    public String getFormatedValue() {
        return this.formatedValue;
    }
    public int getLevel() {
        return this.level;
    }

    public static EnumCargoFuncionario getCargoByLevel(int level){
        EnumCargoFuncionario result = map.get(level);
        if (result == null) {
            throw new IllegalArgumentException("Nivel de cargo inválido: [" + level+ "]");
        }
        return result;

    }
}

