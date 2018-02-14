package algo.tasks.graphs.commons.ArgParser;


import org.apache.commons.cli.Options;

public class OptionsInstance {
    private final Options options;

    public OptionsInstance() {
        options = new Options();
        options.addOption("i", "input", true, "Input file");
        options.addOption("o", "output", true, "Output file");
    }

    public Options getOptions(){
        return options;
    }
}
