package com.cmr.decoder.util;

import java.io.*;

/**
 * @author rajith
 */
public final class FileHandler {

    private FileHandler() {
    }

    public static String[] getMatchingFiles(String filePath, String fileNamePattern) {
        final String filePattern = fileNamePattern;
        File dir = new File(filePath);

        FilenameFilter filter = new FilenameFilter() {

            public boolean accept(File dir, String name) {
                return name.matches(filePattern);

            }
        };

        return dir.list(filter);
    }

    public static boolean moveDataFile(String filePath, String archiveDirectoryPath) {
        File file = new File(filePath);
        File dir = new File(archiveDirectoryPath);
        return file.renameTo(new File(dir, file.getName()));
    }


    private static final String NEW_LINE_CHARACTER = "\n";

    public static String getDataOfFile(String filePath) throws IOException {
        String data = "";
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            data = data + line + NEW_LINE_CHARACTER;
        }
        if (data.equalsIgnoreCase("")) {
            return null;
        }
        bufferedReader.close();
        return data;
    }

}
