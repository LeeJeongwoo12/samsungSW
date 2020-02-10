#include <iostream>

using namespace std;

int power(int n, int m) {
	if (m <= 1)
		return n;

	return n * power(n, m - 1);
}

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int caseNum;
		int n, m;
		cin >> caseNum;
		scanf("%d %d", &n, &m);

		printf("#%d %d\n", test_case, power(n, m));
	}
	return 0;
}