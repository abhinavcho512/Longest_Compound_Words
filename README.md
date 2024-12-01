Longest Compound Words

Impledge Technologies Interview Coding Test 2025

The problem statement for this challenge can be found in the [Exercise_Fresher_Word_Problem.pdf](https://github.com/abhinavcho512/Longest_Compound_Words/blob/main/Exercise_Fresher_Word_Problem.pdf) file.

Code Execution Procedure

This solution requires Java 8 or newer to run. To execute the program, follow these steps:
	1.	Clone or Download the repository to your local machine.
	2.	Open the Solution.java file.
	3.	In the file, locate the code segment where the input file path is specified. Modify the path to the location of the input file relative to the 
                solution file.
	

 
 4.	Compile the code using the following command:




   	     javac  Trie.java  Solution.java


5.	Run the Solution with:


           java Solution



   


7.	The program will output the longest and second-longest compound words from the provided input file.

Problem Understanding

	•	Compound words are formed by combining one or more valid words from the list provided in the input file.
	•	The words in the file are sorted alphabetically, and each word is on a new line. This makes it easier to check if a compound word can be made by joining smaller words that have already appeared.
	•	A compound word can be thought of as a combination of a prefix (already present word) and a suffix (remaining part of the word).
	•	If any character in the word does not belong to a valid word in the file, it cannot be considered a compound word.

Approach and Algorithm

This problem is best solved using a Trie (prefix tree) data structure, which allows efficient prefix searching. The following steps outline the approach used in this solution:
	1.	Building the Trie: Read each word from the input file and insert it into the trie.
	2.	Queue Construction: While inserting each word into the trie, maintain a deque that stores pairs of <word, suffix>. This helps in checking if the word can be split into smaller valid words from the trie.
	3.	Identify Longest Compound Words:
	•	Initialize variables to track the longest, second-longest, and the maximum length of valid compound words found.
	•	For each word, check if its suffix exists as a valid word in the trie. If so, and if the word is longer than the previously found longest word, update the longest and second-longest words accordingly.
	•	If no valid suffix is found, look for prefixes within the suffix and continue checking.
	4.	Return Results: Once all words are processed, return the longest and second-longest compound words.

Algorithm Overview:

	1.	Step 1: Build the trie by inserting words from the input file.
	2.	Step 2: For each word, find possible valid suffixes and store them in the deque for further processing.
	3.	Step 3: Check the queue until all compound words are processed.
	4.	Step 4: Update the longest and second-longest compound words by comparing their lengths.
	5.	Step 5: Output the longest and second-longest compound words.

Results:

Machine Specifications:

	•	Operating System: Windows 10
	•	CPU: Intel Core i3
	•	RAM: 16 GB DDR4

Sample Outputs:

	•	Output for File: Input_01.txt
	•	Output for File: Input_02.txt
