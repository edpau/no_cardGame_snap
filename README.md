
 

# Learning
- ## Combining Symbol and Value into One Structure
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
- [https://www.ionos.co.uk/digitalguide/websites/web-development/java-list/](https://www.ionos.co.uk/digitalguide/websites/web-development/java-list/)

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


## Things to look into 
- java project structure best practices
- 