package net.thumbtack.school.introduction;

class FirstSteps {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return xLeft <= x && x <= xRight && yTop <= y && y <= yBottom;
    }

    public int sum(int[] array) {
        int r = 0;
        for (int value : array) r += value;
        return r;
    }

    public int mul(int[] array) {
        int r = 1;
        for (int value : array) r *= value;
        if (r == 1)
            r = 0;
        return r;
    }

    public int min(int[] array) {
        int smallest = Integer.MAX_VALUE;
        for (int value : array)
            if (value < smallest)
                smallest = value;
        return smallest;
    }

    public int max(int[] array) {
        int largest = Integer.MIN_VALUE;
        for (int value : array)
            if (value > largest)
                largest = value;
        return largest;
    }

    public double average(int[] array) {
        float s = 0;
        for (int value : array) s = s + value;
        return (array.length == 0) ? 0.0 : s / array.length;
    }

    public boolean isSortedDescendant(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i - 1])
                return false;
        }
        return true;
    }

    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++)
            array[i] = array[i] * array[i] * array[i];
    }

    public boolean find(int[] array, int value) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }
        return false;
    }

    public void reverse(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
    }

    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++)
            if (array[i] != array[array.length - i - 1])
                return false;
        return true;
    }

    public int sum(int[][] matrix) {
        int s = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) s = s + anInt;
        }
        return s;
    }

    public int max(int[][] matrix) {
        int largest = Integer.MIN_VALUE;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > largest)
                    largest = anInt;
            }
        }
        return largest;
    }

    public int diagonalMax(int[][] matrix) {
        int largest = Integer.MIN_VALUE;
        if (matrix.length == 1) return Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] > largest)
                largest = matrix[i][i];
        return largest;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        int lenght = 0;
        int counter = 0;
        for (int[] ints : matrix) {
            if (isSortedDescendant(ints))
                counter++;
            lenght++;
        }
        return lenght == counter;
    }
}