# KombiN - .NET Library

KombiN is a library for bijectively mapping all ordered pairs $(a_i, b_j)$ from two finite sets **A** and **B** into a single linear index. KombiN orders pairs by ascending *weight* (sum of indices) using a three-region zig-zag algorithm, enabling **O(1)** bidirectional lookups.

---

## Installation

Install from [NuGet](https://www.nuget.org/packages/Ca.Pranavpatel.Algo.Kombin):

```sh
dotnet add package Ca.Pranavpatel.Algo.Kombin
```

---

## Usage

Suppose set **A** has 100 elements and set **B** has 80 elements, both using zero-based indexing:

```csharp
using Ca.Pranavpatel.Algo.Kombin;

// Initialize Table for sets A (100 elements) and B (80 elements), zero-based indexing
Table myObj = new Table(100, 80, true);

// Get index for combination pair (ai: 46, bi: 72)
long index = myObj.GetIndexOfElements(46, 72);

// Get combination pair from index value
long ai, bi;
(ai, bi) = myObj.GetElementsAtIndex(index);
```

---

## API Reference

### Table Class

**Constructor:**
```csharp
Table(long lengthOfA, long lengthOfB, bool zeroBasedIndex)
```
- `lengthOfA`: Number of elements in set A.
- `lengthOfB`: Number of elements in set B.
- `zeroBasedIndex`: `true` for zero-based, `false` for one-based indexing.

**Methods:**
- `long GetIndexOfElements(long ai, long bi)`  
  Returns the unique index for the pair `(ai, bi)`.

- `(long, long) GetElementsAtIndex(long index)`  
  Returns the pair `(ai, bi)` for the given index.

---

## Example: Enumerate All Pairs by Weight

```csharp
var table = new Table(3, 3, false);
for (long i = 1; i <= 9; i++)
{
    var (ai, bi) = table.GetElementsAtIndex(i);
    Console.WriteLine($"{i}: ({ai}, {bi})");
}
```

---

## Edge Cases & Error Handling

- Throws `ArgumentOutOfRangeException` for invalid indices or set sizes.
- Throws `OverflowException` if arithmetic overflows.

---

## License

MIT License.