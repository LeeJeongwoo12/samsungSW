#include <iostream>
#include <string>
#include <cmath>

using ll = long long;
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		cin >> n;

		char *ans = new char[n + 2];
		char *str = new char[n + 2];

		scanf("%s", ans);
		scanf("%s", str);

		printf("%s %s\n", ans, str);

		int count = 0;
		for (int i = 0; i < n; i++) {
			if (ans[i] == str[i])
				count++;
		}

		printf("#%d %d\n", test_case, count);
	}
	return 0;
}