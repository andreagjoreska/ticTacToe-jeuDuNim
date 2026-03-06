package games.players;

import gamestests.players.NegamaxPlayerTests;
import gamestests.players.NegamaxPlayerWithCacheTests;

public class TestNegamaxPlayerWithCache{

	public static void main(String[] args) {
		boolean ok = true;
		NegamaxPlayerWithCacheTests negamaxWithCacheTester = new NegamaxPlayerWithCacheTests();
		ok = ok && negamaxWithCacheTester.testNimEquals();
		ok = ok && negamaxWithCacheTester.testNimHashCode();
		ok = ok && negamaxWithCacheTester.testTicTacToeEquals();
		ok = ok && negamaxWithCacheTester.testTicTacToeHashCode();
		ok = ok && negamaxWithCacheTester.testEvaluate();
		ok = ok && negamaxWithCacheTester.testChooseMove();
		System.out.println(ok ? "All tests OK" : "At least one test KO");
	}
}
