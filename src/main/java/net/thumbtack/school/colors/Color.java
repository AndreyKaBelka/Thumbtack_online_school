package net.thumbtack.school.colors;

public enum Color {
    RED,
    GREEN,
    BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        if (colorString == null || colorString.equals("")) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        try {
            return Color.valueOf(colorString);
        } catch (IllegalArgumentException ignored) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }
}
