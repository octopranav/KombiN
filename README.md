# KombiN

[![Maven Central](https://img.shields.io/maven-central/v/ninja.pranav.algorithms/kombin.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/ca.pranavpatel.algo/kombin)
[![NuGet](https://img.shields.io/nuget/v/Ca.Pranavpatel.Algo.Kombin?label=NuGet)](https://www.nuget.org/packages/Ca.Pranavpatel.Algo.Kombin)
[![npm (scoped)](https://img.shields.io/npm/v/@pranavpatel.ca/algo-kombin)](https://www.npmjs.com/package/@pranavpatel.ca/algo-kombin)
[![PyPI](https://img.shields.io/pypi/v/kombin-algo-pranavpatel-ca)](https://pypi.org/project/kombin-algo-pranavpatel-ca/)

A library for bijectively mapping all ordered pairs $(a_i, b_j)$ from two finite sets **A** and **B** into a single linear index. KombiN orders pairs by ascending *weight* (sum of indices) using a three-region zig-zag algorithm, enabling **O(1)** bidirectional lookups.

---

## Table of Contents

1. [Mathematical Model](#mathematical-model)
2. [Forward Mapping (Pair → Index)](#forward-mapping-pair-→-index)
3. [Inverse Mapping (Index → Pair)](#inverse-mapping-index-→-pair)
4. [Installation](#installation)
5. [Quick Start](#quick-start)
6. [API Reference](#api-reference)
7. [Examples](#examples)
8. [Edge Cases & Error Handling](#edge-cases--error-handling)
9. [Contribution](#contribution)
10. [License](#license)

---

## Mathematical Model

Define:

* $N = |A|$, the size of set **A**
* $M = |B|$, the size of set **B**
* $L = \min(N, M)$
* $H = \max(N, M)$
* $P = N \times M$
* $S = N + M$

For any pair $(i, j)$ (with $1 \le i \le N$, $1 \le j \le M$), define its weight:

$$
  w = i + j,
$$

which ranges from $2$ to $S$. Partition $w$ into three regions:

1. **Region I (Ascending Triangle)**: $2 \le w \le L+1$
2. **Region II (Rectangle)**: $L+2 \le w \le H$ (only if $H-L\ge2$)
3. **Region III (Descending Triangle)**: $H+1 \le w \le S$

Define cumulative counts:

* $C_1 = \sum_{s=2}^{L+1}(s-1) = \frac{L(L+1)}{2}$
* $C_2 = C_1 + L\,(H-(L+1))$ if $H-L\ge2$, else $C_2=C_1$
* $C_3 = P$

These are the total indices up to each region boundary.

---

## Forward Mapping (Pair → Index)

Compute $k = f(i,j)$ for a given pair $(i,j)$:

### Region I ($2 \le w \le L+1$)

1. Base count:

   $$
     B(w) = \sum_{s=2}^{w-1}(s-1) = \frac{(w-2)(w-1)}{2}
   $$
2. Zig-zag offset:

   * If $(w-1)\bmod2=0$, offset = $i$.
   * Else, offset = $j$.
3. Index:

   $$
     k = B(w) + \text{offset}.
   $$

### Region II ($L+2 \le w \le H$)

1. Diagonal index: $d = w - (L+2)$.
2. Each diagonal has $L$ pairs.
3. Coordinate selector:

   $$
     \alpha = \begin{cases}
       i, & N<M,\\
       (M+1)-j, & N\ge M.
     \end{cases}
   $$
4. Index:

   $$
     k = C_1 + d\,L + \alpha.
   $$

### Region III ($H+1 \le w \le S$)

1. Mirror weight: $w' = S - w + 2$.
2. Compute $B(w')$ and offset as in Region I.
3. Index:

   $$
     k = C_3 - (B(w') + \text{offset}) + 1.
   $$

---

## Inverse Mapping (Index → Pair)

Given $k\in[1,P]$, identify the region:

* If $k\le C_1$, Region I
* Else if $k\le C_2$, Region II
* Else, Region III

Then:

### Region I & III

* Solve quadratic for weight:

  $$
    B(w) < k \le B(w+1)\;
    w = \left\lceil\frac{\sqrt{8k+1}+1}{2}\right\rceil.
  $$
* Compute offset: if $(w-1)\bmod2=0$, $i = k-B(w), j=w-i$; else $j=k-B(w), i=w-j$.
* For Region III, set $w'$ and invert mirror.

### Region II

* Diagonal index: $d = \lfloor(k-C_1-1)/L\rfloor$
* Weight: $w = L+2 + d$
* Selector: $\alpha = (k-C_1-dL)$
* Recover: if $N<M$, $i=\alpha, j=w-i$; else $j=(M+1)-\alpha, i=w-j$.

All formulas are closed-form integer ops ($+, -, \times, /, \lfloor\cdot\rfloor, \lceil\cdot\rceil, \sqrt{\cdot}$).

---

## Installation

**Python**:

```bash
pip install kombin
```

**C# (.NET)**:

```sh
dotnet add package Ca.Pranavpatel.Algo.Kombin
```

**Java (Maven)**:

```xml
<dependency>
  <groupId>ca.pranavpatel.algo</groupId>
  <artifactId>kombin</artifactId>
  <version>1.0.0</version>
</dependency>
```

**TypeScript/JavaScript**:

```bash
npm install kombin
```

---

## Quick Start

```python
from kombin import Table

t = Table(5,4,True)
idx = t.GetIndexOfElements(2,3)
ai,bi = t.GetElementsAtIndex(idx)
```

**C# (.NET)**:

```csharp
using Ca.Pranavpatel.Algo.Kombin;
var tbl = new Table(5,4,true);
var idx = tbl.GetIndexOfElements(2,3);
var (i,j) = tbl.GetElementsAtIndex(idx);
```

```java
Table tbl = new Table(5,4,true);
long idx = tbl.GetIndexOfElements(2,3);
Pair p = tbl.GetElementsAtIndex(idx);
```

```ts
import {Table} from 'kombin';
const tbl = new Table(5,4,true);
const idx = tbl.GetIndexOfElements(2,3);
const [i,j] = tbl.GetElementsAtIndex(idx);
```

---

## API Reference

**Constructor**: `Table(lengthOfA, lengthOfB, zeroBasedIndex)`

**Methods**:

* `GetIndexOfElements(ai, bi) -> number`
* `GetElementsAtIndex(index) -> [ai, bi]`

---

## Examples

```python
# Enumerate all pairs by weight
t = Table(3,3,False)
for k in range(1,10): print(k, t.GetElementsAtIndex(k))
```

```csharp
// Random access
long pos = tbl.GetIndexOfElements(4,2);
var pair = tbl.GetElementsAtIndex(7);
```

---

## Edge Cases & Error Handling

* Invalid indices throw errors.
* Sum > N+M invalid.
* Large N,M may overflow; implementations use checked arithmetic.

---

## Contribution

1. Fork
2. Branch
3. Commit
4. PR

---

## License

MIT License. See LICENSE.
