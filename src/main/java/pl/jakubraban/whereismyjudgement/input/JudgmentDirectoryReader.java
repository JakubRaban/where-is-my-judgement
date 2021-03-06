package pl.jakubraban.whereismyjudgement.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JudgmentDirectoryReader {

    private Path pathToJudgments;
    private static boolean isPathSet = false;

    public JudgmentDirectoryReader(String path) {
        pathToJudgments = Paths.get(path);
        if(!Files.isDirectory(pathToJudgments))
            throw new InvalidPathException(pathToJudgments.toString(), "is not a directory");
        isPathSet = true;
    }

    public List<Path> getAllJSONs() throws IOException {
        return Files.walk(pathToJudgments)
                .filter(path -> path.toString().toLowerCase().endsWith(".json"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
    }

    public List<Path> getAllHTML() throws IOException {
        return Files.walk(pathToJudgments)
                .filter(path -> path.toString().endsWith(".html"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
    }

    public ArrayList<String> getFilesContents() throws IOException {
        return extractFromFiles(getAllJSONs());
    }

    public static boolean isPathSet() {
        return isPathSet;
    }

    private ArrayList<String> extractFromFiles(List<Path> paths) throws IOException {
        ArrayList<String> contents = new ArrayList<>();
        for(Path path : paths) {
            BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String line;
            StringBuilder allLines = new StringBuilder();
            while((line = reader.readLine()) != null) {
                allLines.append(line);
            }
            contents.add(allLines.toString());
            reader.close();
        }
        return contents;
    }

}
