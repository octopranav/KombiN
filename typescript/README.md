# KombiN - JavaScript/TypeScript Library

KombiN is a library for bijectively mapping all ordered pairs $(a_i, b_j)$ from two finite sets **A** and **B** into a single linear index. KombiN orders pairs by ascending *weight* (sum of indices) using a three-region zig-zag algorithm, enabling **O(1)** bidirectional lookups.

---

## Installation

Available on [npm](https://www.npmjs.com/package/@pranavpatel.ca/algo-kombin):

```sh
npm i @pranavpatel.ca/algo-kombin
```

---

## Usage

Suppose set **A** has 100 elements and set **B** has 80 elements, both using zero-based indexing:

```js
import { Table } from '@pranavpatel.ca/algo-kombin';

// Initialize Table for sets A (100 elements) and B (80 elements), zero-based indexing
const myObj = new Table(100, 80, true);

// Get index for combination pair (ai: 46, bi: 72)
const index = myObj.GetIndexOfElements(46, 72);

// Get combination pair from index value
const [ai, bi] = myObj.GetElementsAtIndex(index);
```

---

## API Reference

### Table Class

**Constructor:**
```typescript
new Table(lengthOfA: number, lengthOfB: number, zeroBasedIndex: boolean)
```
- `lengthOfA`: Number of elements in set A.
- `lengthOfB`: Number of elements in set B.
- `zeroBasedIndex`: `true` for zero-based, `false` for one-based indexing.

**Methods:**
- `GetIndexOfElements(ai: number, bi: number): number`  
  Returns the unique index for the pair `(ai, bi)`.

- `GetElementsAtIndex(index: number): [number, number]`  
  Returns the pair `(ai, bi)` for the given index as a tuple.

---

## Example: Enumerate All Pairs by Weight

```js
const table = new Table(3, 3, false);
for (let i = 1; i <= 9; i++) {
    const [ai, bi] = table.GetElementsAtIndex(i);
    console.log(`${i}: (${ai}, ${bi})`);
}
```

---

## Edge Cases & Error Handling

- Throws `Error` for invalid indices or set sizes.

---

## License

MIT License.