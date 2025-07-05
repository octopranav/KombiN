# KombiN - Python 3 Library

KombiN is a Python library for bijectively mapping all ordered pairs $(a_i, b_j)$ from two finite sets **A** and **B** into a single linear index. Pairs are ordered by ascending weight (sum of indices) using a three-region zig-zag algorithm, enabling **O(1)** bidirectional lookups between pairs and indices.

---

## Installation

Install from [PyPI](https://pypi.org/project/kombin-algo-pranavpatel-ca/):

```sh
pip install kombin-algo-pranavpatel-ca
```

---

## Usage

Suppose set **A** has 100 elements and set **B** has 80 elements, both using zero-based indexing:

```python
from kombin import Table

# Initialize Table for sets A (100 elements) and B (80 elements), zero-based indexing
myObj = Table(100, 80, True)

# Get index for combination pair (ai: 46, bi: 72)
index = myObj.GetIndexOfElements(46, 72)

# Get combination pair from index value
ai, bi = myObj.GetElementsAtIndex(index)
```

---

## API Reference

### Table Class

**Constructor:**
```python
Table(lengthOfA: int, lengthOfB: int, zeroBasedIndex: bool)
```
- `lengthOfA`: Number of elements in set A.
- `lengthOfB`: Number of elements in set B.
- `zeroBasedIndex`: `True` for zero-based, `False` for one-based indexing.

**Methods:**
- `GetIndexOfElements(ai: int, bi: int) -> int`  
  Returns the unique index for the pair `(ai, bi)`.

- `GetElementsAtIndex(index: int) -> Tuple[int, int]`  
  Returns the pair `(ai, bi)` for the given index.

---

## Example: Enumerate All Pairs by Weight

```python
table = Table(3, 3, False)
for i in range(1, 10):
    ai, bi = table.GetElementsAtIndex(i)
    print(f"{i}: ({ai}, {bi})")
```

---

## Edge Cases & Error Handling

- Raises `ValueError` for invalid indices or set sizes.
- Large `lengthOfA` or `lengthOfB` may cause integer overflows in some environments.

---

## License

MIT License. See LICENSE