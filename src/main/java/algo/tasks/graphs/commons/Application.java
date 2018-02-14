package algo.tasks.graphs.commons;

import algo.tasks.graphs.commons.ArgParser.CMDInstance;
import algo.tasks.graphs.commons.ArgParser.OptionsInstance;
import algo.tasks.graphs.commons.IO.IOInstance;
import org.apache.commons.cli.ParseException;

import java.io.IOException;

public class Application {
    private final TaskSolver solver;

    public Application(TaskSolver solver){
        this.solver = solver;
    }

    public void run(String[] args){
        OptionsInstance options = new OptionsInstance();
        try {
            CMDInstance cmd = new CMDInstance(options.getOptions(), args);
            IOInstance io = new IOInstance(cmd.getInputStream(), cmd.getOutputStream());
            String[] result = solver.solve(io.readLines());
            io.writeLines(result);
            io.close();
        } catch (ParseException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
