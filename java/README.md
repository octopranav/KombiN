# KombiN - Java Library

KombiN is a library for bijectively mapping all ordered pairs $(a_i, b_j)$ from two finite sets **A** and **B** into a single linear index. KombiN orders pairs by ascending *weight* (sum of indices) using a three-region zig-zag algorithm, enabling **O(1)** bidirectional lookups.

---

## Installation

Available on [Maven Central](https://central.sonatype.com/artifact/ca.pranavpatel.algo/kombin)

Add to your `pom.xml`:

```xml
<dependency>
  <groupId>ca.pranavpatel.algo</groupId>
  <artifactId>kombin</artifactId>
  <version>1.0.3</version>
</dependency>
```

---

## Usage

Suppose set **A** has 100 elements and set **B** has 80 elements, both using zero-based indexing:

```java
import ca.pranavpatel.algo.kombin.*;

// Initialize Table for sets A (100 elements) and B (80 elements), zero-based indexing
Table myObj = new Table(100, 80, true);

// Get index for combination pair (ai: 46, bi: 72)
long index = myObj.GetIndexOfElements(46, 72);

// Get combination pair from index value
Pair myPair = myObj.GetElementsAtIndex(index);
```

---

## API Reference

### Table Class

**Constructor:**
```java
Table(long lengthOfA, long lengthOfB, boolean zeroBasedIndex)
```
- `lengthOfA`: Number of elements in set A.
- `lengthOfB`: Number of elements in set B.
- `zeroBasedIndex`: `true` for zero-based, `false` for one-based indexing.

**Methods:**
- `long GetIndexOfElements(long ai, long bi)`  
  Returns the unique index for the pair `(ai, bi)`.

- `Pair GetElementsAtIndex(long index)`  
  Returns the pair `(ai, bi)` for the given index as a `Pair` object.

---

## Example: Enumerate All Pairs by Weight

```java
Table table = new Table(3, 3, false);
for (long i = 1; i <= 9; i++) {
    Pair pair = table.GetElementsAtIndex(i);
    System.out.println(i + ": (" + pair.ai + ", " + pair.bi + ")");
}
```

---

## Edge Cases & Error Handling

- Throws `IllegalArgumentException` for invalid indices or set sizes.

---

## License

MIT License.