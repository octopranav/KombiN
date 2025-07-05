
import unittest
from src.kombin_algo_pranavpatel_ca import Table


class TableTest(unittest.TestCase):
    """
    Unit tests for the Table class, verifying the bijective mapping
    between indices and ordered pairs for various set sizes and indexing modes.
    """
    
    def test_all_30_false(self):
        """
        Tests Table for all combinations of set sizes from 1 to 30 using one-based indexing (zeroBasedIndex=False).
        For each possible index, retrieves the pair, maps it back to the index, and asserts consistency.
        """
        result = True
        for X in range(1, 31):
            for Y in range(1, 31):
                _X_Y = Table(X, Y, False)
                for i in range(1, (X * Y) + 1):
                    ai, bi = _X_Y.GetElementsAtIndex(i)
                    index = _X_Y.GetIndexOfElements(ai, bi)
                    if(i != index):
                        result = False
        self.assertEqual(result, True)

    def test_all_30_true(self):
        """
        Tests Table for all combinations of set sizes from 1 to 30 using zero-based indexing (zeroBasedIndex=True).
        For each possible index, retrieves the pair, maps it back to the index, and asserts consistency.
        """
        result = True
        for X in range(1, 31):
            for Y in range(1, 31):
                _X_Y = Table(X, Y, True)
                for i in range(0, (X * Y)):
                    ai, bi = _X_Y.GetElementsAtIndex(i)
                    index = _X_Y.GetIndexOfElements(ai, bi)
                    if(i != index):
                        result = False
        self.assertEqual(result, True)
