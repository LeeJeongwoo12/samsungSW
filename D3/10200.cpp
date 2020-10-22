#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, a, b;

		cin >> n >> a >> b;

		int max_value, min_value;

		max_value = min(a, b);

		if (a + b < n) {
			min_value = 0;
		}
		else {
			min_value = a + b - n;
		}

		printf("#%d %d %d\n", test_case, max_value, min_value);
	}
	return 0;
}