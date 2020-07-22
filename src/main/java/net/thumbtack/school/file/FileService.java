package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.Color;
import net.thumbtack.school.colors.ColorException;
import net.thumbtack.school.figures.v3.Point2D;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            bufferedOutputStream.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(array);
        array = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array);
        byte[] ret = new byte[array.length / 2];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (byte) byteArrayInputStream.read();
            byteArrayInputStream.skip(1);
        }
        return ret;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream byteArrayInputStream = new BufferedOutputStream(new FileOutputStream(file))) {
            byteArrayInputStream.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        byte[] ret = null;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            ret = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(ret, 0, ret.length);
        }
        return ret;
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rectangle) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeInt(rectangle.getTopLeft().getX());
            dataOutputStream.writeInt(rectangle.getTopLeft().getY());
            dataOutputStream.writeInt(rectangle.getBottomRight().getX());
            dataOutputStream.writeInt(rectangle.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException, ColorException {
        Rectangle ret;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            ret = new Rectangle(new Point2D(dataInputStream.readInt(), dataInputStream.readInt()), new Point2D(dataInputStream.readInt(), dataInputStream.readInt()), "RED");
        }
        return ret;
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (Rectangle rectangle : rects) {
                dos.writeInt(rectangle.getTopLeft().getX());
                dos.writeInt(rectangle.getTopLeft().getY());
                dos.writeInt(rectangle.getBottomRight().getX());
                dos.writeInt(rectangle.getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException, ColorException {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            while (dataInputStream.available() > 0) {
                rectangles.add(new Rectangle(new Point2D(dataInputStream.readInt(), dataInputStream.readInt()), new Point2D(dataInputStream.readInt(), dataInputStream.readInt()), "RED"));
            }
        }
        Collections.reverse(rectangles);
        return rectangles.toArray(new Rectangle[0]);
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rectangle) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.format("%d %d %d %d %s", rectangle.getTopLeft().getX(), rectangle.getTopLeft().getY(),
                    rectangle.getBottomRight().getX(), rectangle.getBottomRight().getY(), rectangle.getColor().name());
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException, ColorException {
        Rectangle rectangle = null;
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            scanner.useDelimiter(" ");
            if (scanner.hasNext()) {
                rectangle = new Rectangle(new Point2D(scanner.nextInt(), scanner.nextInt()),
                        new Point2D(scanner.nextInt(), scanner.nextInt()), Color.valueOf(scanner.next()));
            }
        }
        return rectangle;
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rectangle) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.append(String.valueOf(rectangle.getTopLeft().getX()));
            bufferedWriter.newLine();
            bufferedWriter.append(String.valueOf(rectangle.getTopLeft().getY()));
            bufferedWriter.newLine();
            bufferedWriter.append(String.valueOf(rectangle.getBottomRight().getX()));
            bufferedWriter.newLine();
            bufferedWriter.append(String.valueOf(rectangle.getBottomRight().getY()));
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException, ColorException {
        Rectangle rectangle;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            rectangle = new Rectangle(new Point2D(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())),
                    new Point2D(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine())), "RED");
        }
        return rectangle;
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write(String.format("%s %d", trainee.getFullName(), trainee.getRating()));
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        Trainee ret = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String[] str = reader.readLine().split(" ");
            ret = new Trainee(str[0], str[1], Integer.parseInt(str[2]));
        }
        return ret;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            bufferedWriter.write(trainee.getFirstName());
            bufferedWriter.newLine();
            bufferedWriter.write(trainee.getLastName());
            bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(trainee.getRating()));
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        Trainee ret = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            ret = new Trainee(reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()));
        }
        return ret;
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        Trainee ret = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            ret = (Trainee) objectInputStream.readObject();
        }
        return ret;
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        Gson gson = new Gson();
        return gson.toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeUTF(serializeTraineeToJsonString(trainee));
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Trainee ret = null;
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            ret = deserializeTraineeFromJsonString(dis.readUTF());
        }
        return ret;
    }
}