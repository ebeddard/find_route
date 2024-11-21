Elliot Beddard 10884690

I developed using Java Version 8 Update 361 in Eclipse.

I am using Windows 10 Pro Version 22H2

The code is structured so that the main function is contained in find_route.
find_route then calls BuildGraph to make an adjacency list of the cities based on the input file.
This graph is then passed to Search which has a function to perform the uniform cost search.
This function returns the final node, which is then backtracked to produce a path using the parent nodes set during the search.
Finally, there is a test file containing tests for only the given input as the input file I created didn't seem to work despite the adjacency list looking correct.

I simply used the built in features in Eclipse to provide the necessary arguments when running the program normally, or just running the tests.
To be more specific, I went into the Run Configuration and supplied the arguments to the Program Arguments field in the following form: input.txt start end
Now when the program is run, the arguments are passed to the main function.