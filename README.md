## General

Author: Ireneo James Membrere (Software Mentor & Alumnus at FRC Team 3161 Tronic Titans)
Date Created: August 22, 2024

Description: This package was created to help expedite the documentation process for the Software Subteam of FRC Team 3161 Tronic Titans. The main() method of the Converter class takes a .java file as input and produces a .tex file as output where comments are written as raw text and executable code is formatted in the lstlisting environment. The .tex file can be compiled into a neatly formatted PDF. 

As an example, this program currently implements the main() method in the Converter class to convert the QuadraticEquation.java file into the main.tex file. A TeX compiler was then used to generate the PDF main.pdf as shown. Please see the notes below for suggestions on modifying this code for your particular needs. If you have any questions about this code, please contact me at ireneojmembrere@gmail.com

## Instructions

1) on line 22 in Converter.java, set the argument of the inFile instance of the File class to be the pathname of the .java file you would like to convert
2) on line 26 in Converter.java, set the argument of the outFile instance of the File class to be the pathname of the .tex file you wish to write to
3) run the main() method in the Converter class to produce the output .tex file
4) compile the .tex file and generate a PDF using the LaTeX Workshop extension of VSC or some online TeX editor (I personally use Overleaf)


## Notes

- the .tex file preamble can be modified by modifying the preamble() method in the Converter class. Simply write your preamble lines to the .tex file using the writer instance of the FileWriter class
- to omit certain lines of the .java file in the .tex file, one must modify the omitLine() method in the Converter class. As an example, this code omits all lines starting with the keyword "import" by returning a value of true
- this code assumes that the .java file contains single line comments only, given by the symbol "//". In order to account for block comments, one can straightforwardly modify the isComment() and the main() methods in the Converter class