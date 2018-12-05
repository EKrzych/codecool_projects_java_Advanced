# Breadth-First Search on a Graph

This assignment is about putting your graph knowledge to practice by implementing a simple friends-of-friends finder algorithm.

You have the following data structures:

**User**
 id: The unique ID of the user
firstName
lastName
friends: A list or array of IDs that this user is friends with

Your task is to write three functions:

- One that lists the minimum distance between two users returning an integer (friends' distance should be 1 from each other).
- One that lists a given user's friends-of-friends at a given distance. The list should not contain duplicates.
- One that returns a list of shortest paths between two users. If their distance is dist then each path is a list that contains (dist + 1) users displaying how the "friend chain" goes. For example: if A and B are not friends but they have E and F as common friends, their distance is 2, and shortestPaths(A, B) should return [ [A, E, B], [A, F, B] ].