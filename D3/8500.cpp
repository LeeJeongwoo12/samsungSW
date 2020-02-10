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
		int k;
		cin >> k;
		int *num = new int[k];

		for (int i = 0; i < k; i++) {
			cin >> num[i];
		}
		sort(num, num + k);

		int sum = 0;
		for (int i = 0; i < k - 1; i++) { // 생각해보면 쉽게 구할 수 있음
			sum += num[i] + 1;
		}
		sum += num[k - 1] * 2 + 1;

		printf("#%d %d\n", test_case, sum);
	}

	return 0;
}