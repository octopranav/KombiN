// Copyright (c) 2020 Pranavkumar Patel. All rights reserved. Licensed under the MIT license.

/**
 * KombiN is a library for bijectively mapping all ordered pairs from two finite sets into a single linear index.
 * It orders pairs by ascending weight (sum of indices) using a three-region zig-zag algorithm,
 * enabling O(1) bidirectional lookups between pairs and indices.
 */

export { Table } from './Table';
