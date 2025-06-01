package enums;

public enum CARGO {
    ATENDENTE,
    TOSADOR,
    BANHISTA,
    VETERINARIO;

    public static CARGO fromString(String str) {
        for (CARGO c : CARGO.values()) {
            if (c.name().equalsIgnoreCase(str)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Cargo inválido: " + str);
    }
}

