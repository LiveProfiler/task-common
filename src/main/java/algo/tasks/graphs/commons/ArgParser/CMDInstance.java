package algo.tasks.graphs.commons.ArgParser;

import org.apache.commons.cli.*;

import java.io.*;

public class CMDInstance {
    private final InputStream inputStream;
    private final OutputStream outputStream;

    public CMDInstance(Options options, String[] args) throws ParseException, FileNotFoundException {
        CommandLineParser parser = new DefaultParser();
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("help")){
            help(options);
        }
        if (line.hasOption("input")){
            inputStream = new FileInputStream(line.getOptionValue("input"));
        } else {
            inputStream = System.in;
        }
        if (line.hasOption("output")){
            outputStream = new FileOutputStream(line.getOptionValue("output"));
        } else {
            outputStream = System.out;
        }
    }

    private void help(Options options){
        HelpFormatter formatter = new HelpFormatter();

        formatter.printHelp("Solver", options);
        System.exit(0);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
