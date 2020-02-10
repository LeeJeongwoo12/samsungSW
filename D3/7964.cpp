#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, d;

		cin >> n >> d;

		int ans = 0;
		int count = 0;

		for (int i = 0; i < n; i++) {
			int input;
			cin >> input;

			if (i == 0 || i == n - 1) {
				if (input == 0)
					ans++;
			}
			else {
				if (input == 0)
					count++;
				else
					count = 0;
			}

			if (count == d) {
				ans++;
				count = 0;
			}
		}
		printf("#%d %d\n", test_case, ans);
	}
	return 0;
}