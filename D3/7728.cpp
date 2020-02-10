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
		string str;
		cin >> str;

		int num[10] = { 0, };

		for (int i = 0; i < str.length(); i++) {
			num[str[i] - '0']++;
		}

		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (num[i] != 0)
				count++;
		}

		printf("#%d %d\n", test_case, count);
	}
	return 0;
}