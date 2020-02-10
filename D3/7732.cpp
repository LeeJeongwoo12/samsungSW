#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int hour, min, sec;

		int now, pr;

		scanf("%d:%d:%d", &hour, &min, &sec);

		now = hour * 3600 + min * 60 + sec;

		scanf("%d:%d:%d", &hour, &min, &sec);

		pr = hour * 3600 + min * 60 + sec;

		int ans;

		if (now > pr) { // 다음날 약속
			pr += 24 * 3600;
		}
		
		ans = pr - now;

		printf("#%d %02d:%02d:%02d\n", test_case, ans / 3600, (ans / 60) %60, ans % 60);
	}
	return 0;
}