#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int length;
		cin >> length;

		int *arr = new int[length + 1];

		for (int i = 1; i <= length; i++)
			cin >> arr[i];

		int sum = 0;

		for (int i = 3; i <= length - 2; i++) { // 좌우 2칸씩은 비워져있니까 계산 X
			int max = -1;

			if (arr[i] == 0)
				continue;

			for (int j = i - 2; j <= i + 2; j++) { // 좌우의 두칸씩에서 가장 높은 건물의 높이를 찾음
				if (j == i)
					continue;
				if (arr[j] > max)
					max = arr[j];
			}

			if (max < arr[i]) // 해당 건물보다 높은 건물이 없을 경우, 그 차이만큼이 조경권이 확보된 세대의 수
				sum += arr[i] - max;
		}

		printf("#%d %d\n", test_case, sum);
	}
	return 0;
}