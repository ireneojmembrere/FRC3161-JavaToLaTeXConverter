## General

Author: Ireneo James Membrere (Software Mentor & Alumnus at FRC Team 3161 Tronic Titans)
Date Created: August 22, 2024

Description: This package was created to help expedite the documentation process for the Software Subteam. The Converter.main() method takes a .java file as input and produces a .tex file as output where comments are written as raw text and executable code is formatted in the lstlisting environment. The .tex file can be compiled into a neatly formatted PDF. 

As an example, this program currently implements the Converter.main() method to convert the QuadraticEquation.java file into the main.tex file. Please see the notes below for suggestions on modifying this code for your particular needs. If you have any questions about this code, please contact me at ireneojmembrere@gmail.com

## Notes

- the .tex file preamble can be modified by modifying the preamble() method
- this code ignores all import statements. To change this or add more options, one must modify the omitLine() method
- this code assumes that the .java file contains single line comments only, given by the symbol "//". In order to account for block comments, one must modify the isComment() method