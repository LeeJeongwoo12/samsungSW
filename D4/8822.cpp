#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	scanf("%d", &T);
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, x;
		scanf("%d %d", &n, &x);

		if (x >= 2 && x <= 2 * (n - 1))
			printf("#%d 1\n", test_case);
		else
			printf("#%d 0\n", test_case);
	}
	return 0;
}