#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m;
		cin >> n >> m;

		int max = -1;

		int input;
		vector <int> cookie;

		for (int i = 0; i < n; i++) {
			cin >> input;
			cookie.push_back(input);
		}

		sort(cookie.begin(), cookie.end(), greater<int>()); // 내림차순으로 정렬

		for (int i = 0; i < cookie.size() - 1; i++) { // 완전 탐색
			for (int j = i + 1; j < cookie.size(); j++) {
				int sum = cookie.at(i) + cookie.at(j);

				if (j == i + 1 && sum < max) // Time complexity를 줄이기 위해
					break;

				if (sum <= m && sum > max) { // 새로운 max가 나타날 경우
					max = sum;
				}
			}
		}

		printf("#%d %d\n", test_case, max);
	}
	return 0;
}