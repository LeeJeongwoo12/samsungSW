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
		int k;
		cin >> k;

		int size = pow(2, k) + 1;

		int *p = new int[size];
		for (int i = 1; i <= pow(2, k); i++)
			cin >> p[i];

		int sum = 0;

		for (int i = 1; i <= k; i++) { // k라운드만큼 진행
			for (int j = 1; j <= pow(2, k - i); j++) { // i번째 라운드는 2^(k-i)만큼 경기 진행
				sum += abs(p[j * 2 - 1] - p[j * 2]); // 두 플레이어의 실력 차이만큼 더함
				if (p[j * 2 - 1] > p[j * 2]) {
					p[j] = p[j * 2 - 1];
				}
				else
					p[j] = p[j * 2];
			}
		}

		printf("#%d %d\n", test_case, sum);
	}
	return 0;
}