#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m;
		cin >> n >> m;

		int bin = pow(2, n) - 1;

		if ((m & bin) == bin)
			printf("#%d ON\n", test_case);
		else
			printf("#%d OFF\n", test_case);
	}
	
	return 0;
}