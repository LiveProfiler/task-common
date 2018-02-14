package algo.tasks.graphs.commons.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOInstance {
    private final BufferedReader reader;
    private final BufferedWriter writer;

    public IOInstance(InputStream inputStream, OutputStream outputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public String[] readLines() throws IOException {
        String currentLine;
        List<String> list = new ArrayList<>();
        while ((currentLine = reader.readLine()) != null){
            list.add(currentLine);
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    public void writeLines(String[] lines) throws IOException {
        for (String line: lines){
            writer.write(line);
            writer.newLine();
        }
    }

    public void close() throws IOException {
        this.reader.close();
        this.writer.close();
    }
}
