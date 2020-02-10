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
		string ans="";

		for (int i = 0; i < 3; i++) {
			cin >> input;
			ans += toupper(input[0]);
		}

		printf("#%d %s\n", test_case, ans.c_str());
	}
	return 0;
}