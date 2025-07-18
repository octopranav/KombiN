import { Table } from '../src/index';
import { expect } from 'chai';
import 'mocha';

/**
 * Unit tests for the Table class, verifying bijective mapping
 * between indices and ordered pairs for various set sizes and indexing modes.
 */

describe('Table class - one-based indexing', () => {
    it('should map indices and pairs consistently for all combinations of set sizes from 1 to 50', function() {
        this.timeout(60000); // 60 seconds
        for (let X = 1; X <= 50; X++) {
            for (let Y = 1; Y <= 50; Y++) {
                const table = new Table(X, Y, false);
                for (let i = 1; i <= X * Y; i++) {
                    const [ai, bi] = table.GetElementsAtIndex(i);
                    const index = table.GetIndexOfElements(ai, bi);
                    expect(index).to.equal(i, `Mismatch at X=${X}, Y=${Y}, i=${i}, ai=${ai}, bi=${bi}`);
                }
            }
        }
    });
});

describe('Table class - zero-based indexing', () => {
    it('should map indices and pairs consistently for all combinations of set sizes from 1 to 50', function() {
        this.timeout(60000); // 60 seconds
        for (let X = 1; X <= 50; X++) {
            for (let Y = 1; Y <= 50; Y++) {
                const table = new Table(X, Y, true);
                for (let i = 0; i < X * Y; i++) {
                    const [ai, bi] = table.GetElementsAtIndex(i);
                    const index = table.GetIndexOfElements(ai, bi);
                    expect(index).to.equal(i, `Mismatch at X=${X}, Y=${Y}, i=${i}, ai=${ai}, bi=${bi}`);
                }
            }
        }
    });
});
