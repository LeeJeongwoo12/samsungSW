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
		int n, k;
		int dia[1001];

		cin >> n >> k;

		for (int i = 1; i <= n; i++)
			cin >> dia[i];

		sort(dia + 1, dia + n + 1);

		int max = -1;

		for (int i = 1; i <= n; i++) {
			int j = i + 1;
			int count = 1;

			while (j <= n) {
				if (dia[j] - dia[i] <= k) {
					count++;
				}
				j++;
			}

			if (count > max)
				max = count;
		}

		printf("#%d %d\n", test_case, max);
	}
	return 0;
}