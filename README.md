# Java Project - Snap Card Game

## Table of contents

- [Overview](#overview)
  - [The challenge](#the-challenge)
  - [How to play](#how-to-play)
  - [Links](#links)
  - [Run the Game Locally](#run-the-game-locally)
- [My process](#my-process)
  - [What I learned](#what-i-learned)
  - [Continued development](#continued-development)
  - [Useful resources](#useful-resources)
- [Author](#author)

## Overview

### The challenge

- Model Snap card game using Java
- Use Test-Driven Development (TDD)


### How to play
- 👥 The game is played by two players: Player One and Player Two.
- 🃏 A deck is shuffled and the top card is shown to start the game.
- 🔁 Players take turns drawing cards by pressing ENTER.
- 📣 If the symbol of the new card matches the previous one, a "Snap" opportunity is triggered.
- ⏱️ The current player has 2 seconds to type "snap" to win the game.
- ✅ If they type "snap" in time, they win.
- ❌ If they type it incorrectly or too late, they lose.
- 🏁 The game ends when a player successfully snaps, or when there are no cards left in the deck (draw).

### Links
- [Github URL](https://github.com/edpau/no_cardGame_snap/blob/main/src/main/java/org/example/card/Card.java)

### Run the Game Locally
1. Clone the repository
```
git clone https://github.com/edpau/no_cardGame_snap.git
```

2. Navigate into the project directory
```
cd no_cardGame_snap
```

3. Compile the project
```
javac -d out src/main/java/org/example/Main.java
```

4. Run the game
```
java -cp out org.example.Main
```


## My process

### What I learned
- Please read my [Learning Log](./docs/LEARNING.md) here

### Continued development
- Allow the player to choose to replay the game instead of exiting after one round
- Add a reusable command-line menu system to handle user input and actions in a structured way
- Allow the player to rename the player name


### Useful resources
- [Attaching Values to Java Enum](https://www.baeldung.com/java-enum-values)
- [How to declare an array of different data types ](https://stackoverflow.com/questions/16363547/how-to-declare-an-array-of-different-data-types)
- [An array with mixed data types?](https://www.reddit.com/r/learnjava/comments/e8yygq/an_array_with_mixed_data_types/)
- [What are Java Records and How to Use them Alongside Constructors and Methods?](https://www.geeksforgeeks.org/what-are-java-records-and-how-to-use-them-alongside-constructors-and-methods/)
- [Use Records to Simplify Your Java Code](https://www.codementor.io/@noelkamphoa/use-records-to-simplify-your-java-code-2j9tv56b64)
- [What is a Java list?](https://www.ionos.co.uk/digitalguide/websites/web-development/java-list/)
- [Java Best Practices for Developers](https://www.tatvasoft.com/blog/java-best-practices/)
- [the right way to organise your code(Youtube)](https://www.youtube.com/watch?v=DoK3-9V5HRE)
- [JUnit 5 tutorial - Learn how to write unit tests](https://www.vogella.com/tutorials/JUnit/article.html)
- [JUnit Doc](https://junit.org/junit5/docs/current/user-guide/#overview)
- [JUnit - 3 ways to assert an object is of a specific type (instance of)](https://www.codejava.net/testing/junit-assert-instance-of)
- [Good vs bad test helpers](https://marcingryszko.medium.com/good-vs-bad-test-helpers-62d552004bc5)
- [How do I write a unit test to verify that a function sorts its result?](https://stackoverflow.com/questions/17687349/how-do-i-write-a-unit-test-to-verify-that-a-function-sorts-its-result)
- [Checking If a List Is Sorted in Java](https://www.baeldung.com/java-check-if-list-sorted)
- [Java Advanced Sorting (Comparator and Comparable)](https://www.w3schools.com/java/java_advanced_sorting.asp)
- [Guide to Java Comparator.comparing()](https://www.baeldung.com/java-8-comparator-comparing)
- [Different Ways of Array Sorting Techniques in Java with JUnit](https://www.geeksforgeeks.org/different-ways-of-array-sorting-techniques-in-java-with-junit/)
- [assertEquals on objects is a mistake](https://rightmove.blog/assertequals-on-objects-is-a-mistake/)
- [Return null or Throw Exception - Best Practice?](https://chrisshennan.com/blog/return-null-or-throw-exception-best-practice#:~:text=As%20returning%20null%20doesn%27t,a%20variety%20of%20different%20ways.)
- [Java Thread sleep and interrupt methods.](https://samedesilva.medium.com/java-thread-sleep-and-interrupt-methods-3850e6201169)
- [how to interrupt a scanner.nextline() call](https://stackoverflow.com/questions/12803151/how-to-interrupt-a-scanner-nextline-)
- [Input using thread](https://stackoverflow.com/questions/37135654/input-using-thread)
- [How To Terminate Threads in Java](https://oliverbo.medium.com/how-to-terminate-threads-in-java-30882227947a)

## Author
- Website - [Edward Pau](https://www.edpau.me)
- Frontend Mentor - [@edpau](https://www.frontendmentor.io/profile/edpau)