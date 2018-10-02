package models;

public enum Color {
    BLANCO('B'), NEGRO('N'), AMARILLO('A'), ROJO('R'), VERDE('V');

    char codigo;

    Color(char codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

    public char getCode() {
        return codigo;
    }
}
