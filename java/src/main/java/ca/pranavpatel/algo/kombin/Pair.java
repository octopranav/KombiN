// MIT License
// 
// Copyright (c) 2020 Pranavkumar Patel
// 
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
// 
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package ca.pranavpatel.algo.kombin;

/**
 * Represents an ordered combination pair (ai, bi) from two finite sets.
 * This class is used to encapsulate the indices of a pair in the KombiN mapping.
 *
 * @author Pranavkumar Patel
 * @version 1.0.3
 */
public class Pair {
    public final long ai;
    public final long bi;
    /**
     * Constructs a Pair object representing the indices of a combination pair.
     *
     * @param ai the index from the first set (A)
     * @param bi the index from the second set (B)
     */
    public Pair(long ai, long bi) {
        this.ai = ai;
        this.bi = bi;
    }
}
