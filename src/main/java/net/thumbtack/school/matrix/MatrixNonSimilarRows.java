package net.thumbtack.school.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private ArrayList<HashSet<Integer>> matrixSetOfNumber;
    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        matrixSetOfNumber = new ArrayList<>();
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            matrixSetOfNumber.add(new HashSet<>());
            for (int j = 0; j < matrix[i].length; j++) {
                matrixSetOfNumber.get(i).add(matrix[i][j]);
            }
        }
    }

    public Set<int[]> getNonSimilarRows() {
        Map<Set<Integer>, int[]> matrixMap = new HashMap<>();

        for (int[] row : matrix) {
            Set<Integer> rowSet = new HashSet<>();
            for (int elem : row)
                rowSet.add(elem);
            matrixMap.putIfAbsent(rowSet, row);
        }

        return new HashSet<>(matrixMap.values());
    }
}
