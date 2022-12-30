# Simple_Search_Engine
## Description
Search engine that processes some data and searches it for a word or a phrase according to different strategies  
## Features
- Inverted Index search
- Searching strategies: ALL, ANY, and NONE
## Running the project
The Source files for this project can be found by navigating to:  
Simple_Search_Engine/task/src/search/Main.java
## Strategies description
Lets consider these six sample lines:

```
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess
```
- If the strategy is ```ALL```, the program prints lines containing all the words from the query.

Query:

```
Harrington Erick
```

Result:

```
Erick Harrington harrington@gmail.com
```

- If the strategy is ```ANY```, the program prints the lines containing at least one word from the query.

Query:

```
Erick Dwight webb@gmail.com
```

Result:

```
Erick Harrington harrington@gmail.com
Erick Burgess
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
```

- If the strategy is ```NONE```, the program prints lines that do not contain words from the query at all:

Query:

```
djo@gmail.com ERICK
```

Result:

```
Katie Jacobs
Myrtle Medina
Rene Webb webb@gmail.com
```

## Usage
**Example 1**   

```
=== Menu ===
1. Find a person
2. Print all persons
0. Exit
> 1

Select a matching strategy: ALL, ANY, NONE
> ANY

Enter a name or email to search all suitable people.
> Katie Erick QQQ

3 persons found:
Katie Jacobs
Erick Harrington harrington@gmail.com
Erick Burgess
```
## Additional info
To find more about this project, please visit https://hyperskill.org/projects/66.
