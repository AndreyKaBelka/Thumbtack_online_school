package net.thumbtack.school.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        int min, i;
        ArrayList<Integer> rows = new ArrayList<>();
        for (int h = 0; h < matrixSetOfNumber.size(); h++) {
            rows.add(h);
        }
        ArrayList<Integer> toRemove = new ArrayList<>();
        HashSet<int[]> answer = new HashSet<>();
        do {
            i = 0;
            toRemove.add(i);
            min = rows.get(i);
            for (int j = i + 1; j < matrixSetOfNumber.size(); j++) {
                if (matrixSetOfNumber.get(i).equals(matrixSetOfNumber.get(j))) {
                    toRemove.add(j);
                }
            }
            for (int j = 0; j < toRemove.size(); j++) {
                matrixSetOfNumber.remove(((int) toRemove.get(j)));
                rows.remove((int) toRemove.get(j));
                for (int l = j + 1; l < toRemove.size(); l++) {
                    toRemove.set(l, toRemove.get(l) - 1);
                }
            }
            toRemove.clear();
            answer.add(matrix[min]);
        } while (!matrixSetOfNumber.isEmpty());
        return answer;
    }
}
