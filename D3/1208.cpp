#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int dump;
		cin >> dump;

		int *arr = new int[100];
		for (int i = 0; i < 100; i++) {
			cin >> arr[i];
		}
		sort(arr, arr + 100); // 처음 한번 sorting

		for (int i = 0; i < dump; i++) {
			if (arr[99] - arr[0] <= 1) // 평탄화 완료면 종료
				break;

			arr[99]--; // 제일 높은 거 --
			arr[0]++; // 제일 낮은거 ++

			sort(arr, arr + 100); // 다시 sorting
		}
		printf("#%d %d\n", test_case, arr[99] - arr[0]);
	}
	return 0;
}