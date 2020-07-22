package net.thumbtack.school.colors;

public enum Color {
    RED,
    GREEN,
    BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        if (colorString == null || colorString.equals("")) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        return Color.valueOf(colorString);
    }
}
