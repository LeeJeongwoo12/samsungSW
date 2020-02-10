#include <iostream>
#include <string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		string input;
		cin >> input;

		int arr[10] = { 0, };

		for (int i = 0; i < input.length(); i++) { // 배열에 해당 숫자가 나온 횟수를 저장
			arr[input[i] - '0']++;
		}

		int sum = 0;

		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 1) // 횟수가 홀수라면 적혀있으므로 count
				sum++;
		}

		printf("#%d %d\n", test_case, sum);
	}
	return 0;
}