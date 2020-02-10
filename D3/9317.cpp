#include<iostream>
#include <string>

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
		string ans, input;

		cin >> ans >> input;
		int count = 0;
		for (int j = 0; j < n; j++) {
			if (ans[j] == input[j])
				count++;
		}

		printf("#%d %d\n", test_case, count);
	}
	return 0;
}