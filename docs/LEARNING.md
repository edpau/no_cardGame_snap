# Learning

## enums
- [Attaching Values to Java Enum](https://www.baeldung.com/java-enum-values)
- Java enums have a natural order, which follows the order you declare them in the enum declaration.
-  sort a list of Suit values using Collections.sort() follow enums order

## Combining Symbol and Value into One Structure
Instead of looping through three separate lists for suits, symbols, and values — which can get messy and error-prone — I combined the symbol and its corresponding value into a single structure:
```java
String[][] symbolsAndValues = {
    {"2", "2"}, {"3", "3"}, ..., {"A", "14"}
};
```
This way, each card symbol is directly paired with its value, making it easier to loop through and reducing the chance of mismatched indexes.
Then I loop through all suits and for each suit, I loop through the symbol-value pairs:
```java
for (String suit : suits) {
    for (String[] pair : symbolsAndValues) {
        String symbol = pair[0];
        int value = Integer.parseInt(pair[1]);
        // create Card(suit, symbol, value)
    }
}
```
### -  **Do not use Object[][]**
- [How to declare an array of different data types ](https://stackoverflow.com/questions/16363547/how-to-declare-an-array-of-different-data-types)
- [An array with mixed data types?](https://www.reddit.com/r/learnjava/comments/e8yygq/an_array_with_mixed_data_types/)
  Other advise not to use Object[][]
```java
Object[][] symbolsAndValues = {
        {"2", 2}, {"3", 3},...{"A", "14"}
        };
```
- ❌ It's not type-safe — you're mixing types and losing compile-time checks.
- ❌ It makes code harder to read and maintain (Object casting is messy).
- ❌ Java has better ways to pair values cleanly (like custom classes or Map.Entry).

### Better to use record
```java
record SymbolValue(String symbol, int value) {}
```
```java
SymbolValue[] symbolsAndValues = {
    new SymbolValue("2", 2),
    new SymbolValue("3", 3),
    // ...
    new SymbolValue("A", 14)
};
```
- Type-safe (symbol is a String, value is an int)
- Self-documenting (no guesswork about pair[0] vs pair[1])
- Easier to extend later (e.g. add color or rank logic)

- [What are Java Records and How to Use them Alongside Constructors and Methods?](https://www.geeksforgeeks.org/what-are-java-records-and-how-to-use-them-alongside-constructors-and-methods/)
- [Use Records to Simplify Your Java Code](https://www.codementor.io/@noelkamphoa/use-records-to-simplify-your-java-code-2j9tv56b64)
### a normal class if records aren't allowed
```java
public class CardGame {

    static class SymbolValue {
        String symbol;
        int value;

        SymbolValue(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }
}
```
### Best to use enum
- use enum, use ordinal() to replace card int value.
```java
 public static List<Card> getDeckOfCards() {
        List<Card> deck = new ArrayList<>();

        // Create the cards for each of the four suits.
        for (Suit suit : Suit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value));
            }
        }

        Collections.shuffle(deck);

        return deck;
    }
```


## List Common Method
- [What is a Java list?](https://www.ionos.co.uk/digitalguide/websites/web-development/java-list/)

| Method | Description |
|--------|-------------|
| `int size()` | Determines the number of elements in a list |
| `void add(int index, E element)` | Adds an element at a specific position |
| `boolean isEmpty()` | Checks if a list is empty |
| `void clear()` | Removes all elements from a list |
| `boolean contains(Object o)` | Returns `true` if the object `o` is in the list |
| `boolean add(E e)` | Adds an element to the end of a list |
| `boolean remove(Object o)` | Removes the first occurrence of an element |
| `E get(int index)` | Retrieves the element at the specified index |
| `E set(int index, E element)` | Replaces or inserts an element at a specified index |
| `Object[] toArray()` | Returns an array containing the elements from a list |
| `List<E> subList(int fromIndex, int toIndex)` | Captures all elements within the specified interval |
| `default void replaceAll(UnaryOperator<E> operator)` | Applies a unary operator to each element and replaces each with the result (Java 8+) |

## Best Practice
- [Java Best Practices for Developers](https://www.tatvasoft.com/blog/java-best-practices/)
    - 2.2 For String Concatenation, Use StringBuilder or StringBuffer
    - 2.3 Use Enums Instead of Interface
    - 2.4 Avoid Using Loops with Indexes
- [the right way to organise your code(Youtube)](https://www.youtube.com/watch?v=DoK3-9V5HRE)

## Testing
- [JUnit 5 tutorial - Learn how to write unit tests](https://www.vogella.com/tutorials/JUnit/article.html)
- [JUnit Doc](https://junit.org/junit5/docs/current/user-guide/#overview)
- [JUnit - 3 ways to assert an object is of a specific type (instance of)](https://www.codejava.net/testing/junit-assert-instance-of)
```java
@Test
public void test() {
 
    Object obj = classUnderTest.foo();
     
    Assertions.assertInstanceOf(Student.class, obj);
}
```
- [Good vs bad test helpers](https://marcingryszko.medium.com/good-vs-bad-test-helpers-62d552004bc5)
    - If you need to create a test utility method, make sure that it emphasizes what is relevant and hides what is irrelevant to understand the production code. Don’t increment the complexity with the test helper.

### Testing Sorting
- [How do I write a unit test to verify that a function sorts its result?](https://stackoverflow.com/questions/17687349/how-do-i-write-a-unit-test-to-verify-that-a-function-sorts-its-result)
```java
@Test public void testGetPeopleSortsByPeopleName() {
    String COUNTRY = "Whatistan";

    // set up test (the 3 lines below are actually in a @Before setup method)
    PeopleStuff peopleStuff = new PeopleStuff();
    IData mockData = createNiceMock(IData.class);
    peopleStuff.data = mockData;

    // set up data
    List<PersonName> mockPeopleList = new ArrayList<PersonName>();
    mockPeopleList.add(new Person(COUNTRY, "A"));
    mockPeopleList.add(new Person(COUNTRY, "D"));
    mockPeopleList.add(new Person(COUNTRY, "B"));
    mockPeopleList.add(new Person(COUNTRY, "C"));

    when(mockData.getPeopleForCountry(COUNTRY)).thenReturn(mockPeopleList);

    // exercise
    List<String> result = peopleStuff.getSortedPeopleForCountry(COUNTRY);

    // assert
    assertEquals("A", result.get(0).name);
    assertEquals("B", result.get(1).name);
    assertEquals("C", result.get(2).name);
    assertEquals("D", result.get(3).name);
}
```

## Sorting
- [Checking If a List Is Sorted in Java](https://www.baeldung.com/java-check-if-list-sorted)
    - Iterative Approach
        - Using Comparable
        - Using Comparator
    - Recursive Approach
- [Java Advanced Sorting (Comparator and Comparable)](https://www.w3schools.com/java/java_advanced_sorting.asp)
    - The Comparator interface allows you to create a class with a compare() method that compares two objects to decide which one should go first in a list.
        - The compare() method should return a number which is:
            - Negative if the first object should go first in a list.
            - Positive if the second object should go first in a list.
            - Zero if the order does not matter.
    - Using a lambda expression to replace compare() method
  ```java
  Collections.sort(myCars, (obj1, obj2) -> {
  Car a = (Car) obj1;
  Car b = (Car) obj2;
  if (a.year < b.year) return -1;
  if (a.year > b.year) return 1;
  return 0;
  });
  ```

- [Guide to Java Comparator.comparing()](https://www.baeldung.com/java-8-comparator-comparing)
    - 3.1. Key Selector Variant
        - The Comparator.comparing static function accepts a sort key Function and returns a Comparator for the type that contains the sort key:
  ```java
  static <T,U extends Comparable<? super U>> Comparator<T> comparing(
  Function<? super T,? extends U> keyExtractor)
  ```
    - we’ll use the name field in Employee as the sort key, and pass its method reference as an argument of type Function. The Comparator returned from the same is used for sorting:

```java
@Test
public void whenComparing_thenSortedByName() {
Comparator<Employee> employeeNameComparator
= Comparator.comparing(Employee::getName);

Arrays.sort(employees, employeeNameComparator);
      
assertTrue(Arrays.equals(employees, sortedEmployeesByName));
}

```

- 3.3. Using Comparator.reversed
- 3.4. Using Comparator.comparingInt
    - When you use plain Comparator.comparing with int:
      Java auto-boxes int → Integer.
      Creates lots of little Integer objects.
      Slower and heavier in big lists.
    - comparingInt skips boxing and compares primitives directly → faster.
- 5.1. Considering Null First
- 6 Using Comparator.thenComparing



## Sorting Testing with JUnit
- [Different Ways of Array Sorting Techniques in Java with JUnit](https://www.geeksforgeeks.org/different-ways-of-array-sorting-techniques-in-java-with-junit/)

## assertEquals on objects
- [assertEquals on objects is a mistake](https://rightmove.blog/assertequals-on-objects-is-a-mistake/)

```java
@Test
void shouldConvert() {
    var input  = new Person("Kieran", "Rafferty", LocalDate.of(1970, 1, 30));
 
    Employee result = mapper.map(input);
 
    assertThat(result.firstName()).isEqualTo("Kieran");
    assertThat(result.lastName()).isEqualTo("Rafferty");
    assertThat(result.dateOfBirth()).isEqualTo("1970-01-30");
}
```
- should not write extra production code for testing.
- It forces you to think about each field individually.
- When you add a new field, you must add a new assertion → you see the test fail properly during TDD.
- If a test fails, the stack trace points exactly to the failing field (firstName, lastName, or dateOfBirth), making debugging very fast and clear.
- It keeps your production code clean (no hidden dependency on equals()).

## Return null or Throw Exception
[Return null or Throw Exception - Best Practice?](https://chrisshennan.com/blog/return-null-or-throw-exception-best-practice#:~:text=As%20returning%20null%20doesn%27t,a%20variety%20of%20different%20ways.)

## prompt
### promptEnterKey()
```java
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

   
     // Pause execution and allow the user to continue by pressing ENTER.
    public static void promptEnterKey() {
        System.out
                .println("An Event has occured! Press \"ENTER\" to continue...");
        scanner.nextLine();
    }
}
```
- we need .nextLine(); to clear the scanner

## Timer
[Java Thread sleep and interrupt methods.](https://samedesilva.medium.com/java-thread-sleep-and-interrupt-methods-3850e6201169)

### Problem
- nextLine() are what are called blocking calls.
- [how to interrupt a scanner.nextline() call](https://stackoverflow.com/questions/12803151/how-to-interrupt-a-scanner-nextline-)
- [Input using thread](https://stackoverflow.com/questions/37135654/input-using-thread)
    - idea on using two threads
- [How To Terminate Threads in Java](https://oliverbo.medium.com/how-to-terminate-threads-in-java-30882227947a)
    - good explanation on threads