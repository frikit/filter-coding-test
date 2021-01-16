package uk.sky.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {

    public static final String EMPTY_FILE = "src/test/resources/empty-extract";
    public static final String HEADER_ONLY_FILE = "src/test/resources/header-only-extract";
    public static final String SINGLE_LINE_FILE = "src/test/resources/one-line-extract";
    public static final String MULTI_LINE_FILE = "src/test/resources/sample-extract";

    private static FileReader readFile(String filename) throws FileNotFoundException {
        return new FileReader(filename);
    }

    public static FileReader readEmptyFile() {
        try {
            return readFile(EMPTY_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static FileReader readHeaderOnlyFile() {
        try {
            return readFile(HEADER_ONLY_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static FileReader readOneLineFile() {
        try {
            return readFile(SINGLE_LINE_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static FileReader readMultiLineFile() {
        try {
            return readFile(MULTI_LINE_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
