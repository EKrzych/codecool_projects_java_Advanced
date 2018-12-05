# FP exercises

It may be difficult to switch from imperative to functional style at first. Following exercises might be easier for you to solve them using imperative style, however that's not the point of this exercises. Try to force yourself to start thinking functionally. Quality over quantity applies here.

## PoKeMoN cAsE
Write a function which upper cases every second letter of a string. Use streams.

## Who can into
Implement a given class:

class Person{
    private String name;
    private String phone;
    private List<String> skills;
}
Then create a collection of Person objects. Then write a function that will return people who own a given skill. This function should return formatted string. Here's an example

peopleWhoCanInto("java", people)
// returns
Mark - 123 456 789
Jane - +48 098 987 876

## Censorship
Write a function that takes a string and replaces all the bad words with peeep. Do it using streams.

## Battleship generator
Create a class that has three fields: startX, startY, length. Then write a method that accepts an array of integers and returns a list of battleships. The input array is structured in a following way: [ [ship1_startX, ship1_startY, ship1_length], [ship2_startX, ship2_startY, ship2_length], ...]

## String Filter
Write a function with a following signature:

public List<String> filttr(List<Predicate<String>> rules, List<String> strings)
rules is a list of String predicates by which strings should be filtered. Returned list contains strings, which conform to all predicates from the list.

## String Filter with threshold
Write a function with a following signature:

public List<String> filttr(List<Predicate<String>> rules, List<String> strings, Double threshold)
rules is a list of String predicates by which strings should be filtered. Returned list contains strings, which conform to threshold percent of predicates from the list.


