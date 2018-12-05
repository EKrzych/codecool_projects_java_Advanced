# SpellChecker

The program for this project will be a rudimentary spell checker. It will read a wordlist from a file, then spell-check an input file. For each misspelling found in the input file, your program will report it, along with a sorted list of suggestions (if any).

To keep this task relatively simple in the limited time we have remaining this quarter, I have provided a large portion of the spell checker as either .java files or (in most cases) compiled .class files. In fact, I will only be requiring you to implement two relatively small parts of it:
  - An implementation of a hash table that stores strings, using separate chaining (i.e. linked lists) to resolve collisions.
  - A class called WordChecker that checks the spelling of one word and makes an appropriate set of suggestions for a misspelled word.

Of course, it's required that you implement these classes according to the template provided, so that your code will work correctly with ours. Once you've completed the program, I'd like you to compare the performance of three provided hash functions (and you can implement your own and try them, as well) to get a feel for the dramatic influence that hash functions have on the performance of hash tables.
