# WCtool - Word Count Tool
Description: 
The WC-Tool program is a simple Java tool to display statistics about a file, including the number of lines, words, and file size (in bytes). It also supports optional flags to display only lines, words, or size.

Features: 
Display the total number of lines, words, and bytes in a file. 
Support for optional flags: 
-l for line count. 
-w for word count. 
-c for file size in bytes.

Prerequisites 
To run this program, you need the following: 
1, Java Development Kit (JDK) - Install JDK version 8 or above. 
2, Git - For version control (optional, only if you want to clone and contribute).

How to Run
Clone the repository:
git clone https://github.com/your-repository-url

Compile the program: Navigate to the directory where your source files are located and run:
javac wctool1.java

Run the program: To execute the program, use the following syntax:
java wctool1 <filename>

Flag Usage:
To get only the word count:
java wctool1 -w filename

To get only the line count:
java wctool1 -l filename

To get only the file size:
java wctool1 -c filename

Example
java wctool1 sample.txt
This will display:
[Size] [Line Count] [Word Count] sample.txt

Or, using a flag:

java wctool1 -w sample.txt
This will display the word count of sample.txt.

Error Handling
If the file is not found or cannot be read, the program will output:
Error reading file: <error message>

Feel free to fork the repository, make improvements, and submit a pull request! 
This project is licensed under the MIT License.
