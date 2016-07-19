package pl.jwprogrammers;

import org.apache.commons.cli.*;
import pl.jwprogrammers.parser.BibleParser;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Options options = new Options();

        Option epubFileOption = Option.builder("f")
                .longOpt("file")
                .argName("file")
                .required(true)
                .hasArg(true)
                .numberOfArgs(1)
                .optionalArg(false)
                .type(Path.class)
                .desc("Path to bible in epub format")
                .build();
        Option outputFileOption = Option.builder("o")
                .longOpt("output")
                .argName("output")
                .required(true)
                .hasArg(true)
                .numberOfArgs(1)
                .optionalArg(false)
                .type(Path.class)
                .desc("Path to bible in epub format")
                .build();
        options.addOption(epubFileOption);
        options.addOption(outputFileOption);

        try {
            CommandLine cmd = new DefaultParser().parse(options, args);
            Path inputFile = Paths.get(cmd.getOptionValue("f"));
            Path outputFile = Paths.get(cmd.getOptionValue("o"));
            BibleParser parser = new BibleParser(inputFile);
            parser.parse();
            parser.save(outputFile);
        } catch (ParseException e) {
            new HelpFormatter().printHelp("bibleEpubToJSON", options);
        }


    }
}
