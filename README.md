# KombiN

[![Maven Central](https://img.shields.io/maven-central/v/ninja.pranav.algorithms/kombin.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/ca.pranavpatel.algo/kombin)
[![NuGet](https://img.shields.io/nuget/v/Ca.Pranavpatel.Algo.Kombin?label=NuGet)](https://www.nuget.org/packages/Ca.Pranavpatel.Algo.Kombin)
[![npm (scoped)](https://img.shields.io/npm/v/@pranavpatel.ca/algo-kombin)](https://www.npmjs.com/package/@pranavpatel.ca/algo-kombin)
[![PyPI](https://img.shields.io/pypi/v/kombin-algo-pranavpatel-ca)](https://pypi.org/project/kombin-algo-pranavpatel-ca/)

KombiN is an algorithm that gives Index # of weighted combination and back, works with combinations of two finite sets ordered by sum and then by difference of combination, without generating and enumerating through possible combinations.
## When to use KombiN?
Let's say we have two sets:
> Set A = { Apple = 0, Banana = 1, Cucumber = 2 }

> Set B = { CEO = 0, CFO = 1, CSO = 2 }

Now get all possible unique combinations for both sets and sort first by sum of combination and after by difference of combination and in the end give Index # to all combinations.

In above example, both sets have zero-based index so KombiN will have output as shown in left side Table below. For example, both sets are in DataTable with Non-zero index, In that case KombiN will have output as shown in right side Table below.

In short, It provides zero and non-zero index based on type of index used in both sets.

| Index # | ai | bi |  | | Index # | ai | bi |
| -- | -- | -- | -- | -- | -- | -- | -- |
|0|0|0|                      | |1|1|1|
|1|0|1|                     | |2|1|2|
|2|1|0|                      | |3|2|1|
|3|0|2|                     | |4|1|3|
|4|1|1|                      | |5|2|2|
|5|2|0|                      | |6|3|1|
|6|1|2|                     | |7|2|3|
|7|2|1|                      | |8|3|2|
|8|2|2|                      | |9|3|3|

You can use KombiN for
1. Finding the Index # of particular combination
2. Finding the Combination of particular Index #.
