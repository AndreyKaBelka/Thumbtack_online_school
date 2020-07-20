package net.thumbtack.school.colors;

public enum Color {
    RED,
    GREEN,
    BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        if (colorString == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        switch (colorString) {
            case "RED": {
                return RED;
            }
            case "GREEN": {
                return GREEN;
            }
            case "BLUE": {
                return BLUE;
            }
            case "": {
                throw new ColorException(ColorErrorCode.NULL_COLOR);
            }
            default: {
                throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
            }
        }
    }

    public static boolean isColorExist(Color color) {
        switch (color) {
            case BLUE:
            case RED:
            case GREEN:
                return true;
            default:
                return false;
        }
    }
}
