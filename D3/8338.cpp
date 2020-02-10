#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		scanf("%d", &n);

		int arr[10];

		for (int i = 1; i <= n; i++) {
			scanf("%d", &arr[i]);
		}

		if (n == 1) // 숫자가 하나인 경우 그냥 종료
			printf("#%d %d\n", test_case, arr[1]);

		else {
			int temp = arr[1];
			
			for (int i = 2; i <= n; i++) {
				if (temp + arr[i] > temp * arr[i]) // 합과 곱 중 큰 연산을 실행
					temp += arr[i];
				else
					temp *= arr[i];
			}

			printf("#%d %d\n", test_case, temp);
		}
	}
	return 0;
}