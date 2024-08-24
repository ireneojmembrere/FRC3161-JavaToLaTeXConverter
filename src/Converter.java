/*
 * Author: Ireneo James Membrere (Software Mentor & Alumnus at FRC Team 3161 Tronic Titans)
 * Date Created: August 22, 2024
 * 
 * Description: This program was created to help expedite the documentation process for the Software Subteam.
 * The main method takes a .java file as input and produces a .tex file as output where comments are
 * written as raw text and executable code is formatted in the lstlisting environment. The .tex file can
 * be compiled into a neatly formatted PDF.
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Converter {

    // this program takes a .java file and converts it into a .tex file, which can be compiled into a neatly formatted PDF for documentation purposes
    public static void main(String[] args) throws Exception {
        // objects for reading a file (input)
        File inFile = new File("src/QuadraticEquation.java");      
        Scanner scanner = new Scanner(inFile);

        // objects for writing to a file (output)
        File outFile = new File("src/main.tex");
        FileWriter writer = new FileWriter(outFile);

        // .tex file preamble
        preamble(inFile, writer);

        // variables to keep track of the lstlisting environment
        boolean previousComment = true, previousCode = false;

        // read lines of input .java file, format for LaTeX, and write to a .tex file
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // skip lines that we want to omit
            if (omitLine(line)){
                continue;
            }

            // comments will not be formatted in the .tex file (raw text)
            if (isComment(line)){
                if (previousCode){
                    writer.write("\\end{lstlisting}\n\n");
                }
                writer.write(getTrimmedComment(line) + "\n");
                previousCode = false;
                previousComment = true;
            }
            // executable code will be formatted using the lstlisting environment
            else {
                if (previousComment){
                    writer.write("\n\\begin{lstlisting}[language=Java]\n");
                }
                writer.write(line + "\n");
                previousCode = true;
                previousComment = false;
            }
        }

        // end the last lstlisting environment (if it exists)
        if (previousCode){
            writer.write("\\end{lstlisting}\n\n");
        }

        // close the files and end the .tex document
        scanner.close();
        writer.write("\\end{document}");
        writer.close();
    }

    // method that writes the preamble of the .tex file
    public static void preamble(File inFile, FileWriter writer) throws IOException{
        writer.write("\\documentclass{article}\n");
        writer.write("\\usepackage[margin=2.54cm]{geometry}\n");
        writer.write("\\usepackage{listings}\n");
        writer.write("\\usepackage{xcolor}\n\n");
        writer.write("\\definecolor{codegray}{rgb}{0.5,0.5,0.5}\n");
        writer.write("\\definecolor{codegreen}{rgb}{0,0.6,0}\n");
        writer.write("\\definecolor{backcolour}{rgb}{0.95,0.95,0.92}\n");
        writer.write("\\lstdefinestyle{vscStyle}{\n");
        writer.write("    backgroundcolor=\\color{backcolour},\n");
        writer.write("    commentstyle=\\color{codegreen},\n");
        writer.write("    keywordstyle=\\color{blue},\n");
        writer.write("    numberstyle=\\tiny\\color{codegray},\n");
        writer.write("    stringstyle=\\color{orange},\n");
        writer.write("    basicstyle=\\ttfamily\\footnotesize,\n");
        writer.write("    breakatwhitespace=false,\n");
        writer.write("    breaklines=true,\n");
        writer.write("    captionpos=b,\n");
        writer.write("    keepspaces=true,\n");
        writer.write("    numbers=left,\n");
        writer.write("    numbersep=5pt,\n");
        writer.write("    showspaces=false,\n");
        writer.write("    showstringspaces=false,\n");
        writer.write("    showtabs=false,\n");
        writer.write("    tabsize=2\n");
        writer.write("}\n");
        writer.write("\\lstset{style=vscStyle}\n\n");
        writer.write("\n\\title{" + inFile.getName() + " Documentation}\n");
        writer.write("\\author{FRC Team 3161 Tronic Titans}\n\n");
        writer.write("\\begin{document}\n\n");
        writer.write("\\maketitle\n\n");
    }

    // method that returns true if we want to omit this line of code from the documentation, and false otherwise
    public static boolean omitLine(String line){
        // check if its an empty line
        if (line.length() < 1){
            return false;
        }
        // omit all import statements
        else if (line.startsWith("import")){
            return true;
        } 

        // ** add your other conditions here **

        else {
            return false;
        }
    }

    // method that returns true if the line of code is a comment, and false otherwise
    public static boolean isComment(String line){
        // check if its an empty line
        if (line.length() < 1){
            return false;
        }

        // find when the whitespace on the line ends
        int index = 0;
        while(Character.isWhitespace(line.charAt(index)) && index < line.length()) {
            index++;
        }

        // a line full of whitespace cannot be a comment
        if (line.length() - index < 2) {
            return false;
        }
        // all comments start with "//"
        else if (line.substring(index,index + 2).equals("//")){
            return true;
        } 
        // otherwise we must have a line of executable code
        else {
            return false;
        }
    }

    // method that takes a comment line as input and outputs the text raw text
    public static String getTrimmedComment(String line){
        // find when the whitespace on the line ends
        int index = 0;
        while(Character.isWhitespace(line.charAt(index)) && index < line.length()) {
            index++;
        }

        // trim the whitespace and the "//"
        return line.substring(index+2);
    }
}
