
using System;
using Xunit;

[assembly: CLSCompliant(true)]
namespace Ca.Pranavpatel.Algo.Kombin.tests {

    /// <summary>
    /// Contains unit tests for the <see cref="Table"/> class,
    /// verifying the bijective mapping between indices and ordered pairs.
    /// </summary>
    public class TestTable {

        /// <summary>
        /// Tests the <see cref="Table"/> class for all combinations of set sizes from 1 to 100,
        /// using one-based indexing (zeroBasedIndex = false).
        /// For each possible index, retrieves the pair, then maps it back to the index,
        /// and asserts that the mapping is consistent.
        /// </summary>
        [Fact]
        public void TestAll100False() {
            bool result = true;
            for (int X = 1; X <= 100; X++) {
                for (int Y = 1; Y <= 100; Y++) {
                    Table myXY = new(X, Y, false);
                    for (long i = 1; i <= X * Y; i++) {
                        long ai, bi;
                        (ai, bi) = myXY.GetElementsAtIndex(i);
                        long index = myXY.GetIndexOfElements(ai, bi);
                        if (i != index) {
                            result = false;
                        }
                    }
                }
            }
            Assert.True(result);
        }

        /// <summary>
        /// Tests the <see cref="Table"/> class for all combinations of set sizes from 1 to 100,
        /// using zero-based indexing (zeroBasedIndex = true).
        /// For each possible index, retrieves the pair, then maps it back to the index,
        /// and asserts that the mapping is consistent.
        /// </summary>
        [Fact]
        public void TestAll100True() {
            bool result = true;
            for (int X = 1; X <= 100; X++) {
                for (int Y = 1; Y <= 100; Y++) {
                    Table myXY = new(X, Y, true);
                    for (long i = 0; i <= (X * Y) - 1; i++) {
                        long ai, bi;
                        (ai, bi) = myXY.GetElementsAtIndex(i);
                        long index = myXY.GetIndexOfElements(ai, bi);
                        if (i != index) {
                            result = false;
                        }
                    }
                }
            }
            Assert.True(result);
        }
    }
}
