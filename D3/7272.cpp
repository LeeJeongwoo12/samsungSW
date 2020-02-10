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

	string zero = "CEFGHIJKLMNSTUVWXYZ";
	string one = "ADOPQR";

	for (test_case = 1; test_case <= T; ++test_case)
	{
		string str1, str2;

		cin >> str1 >> str2;

		if (str1.length() != str2.length()) { // 길이가 다른 경우는 무조건 다름
			printf("#%d DIFF\n", test_case);
			continue;
		}

		for (int i = 0; i < str1.length(); i++) {
			if (zero.find(str1[i]) != string::npos)
				str1[i] = '0';
			else if (one.find(str1[i]) != string::npos)
				str1[i] = '1';
			else
				str1[i] = '2';
		}

		for (int i = 0; i < str2.length(); i++) {
			if (zero.find(str2[i]) != string::npos)
				str2[i] = '0';
			else if (one.find(str2[i]) != string::npos)
				str2[i] = '1';
			else
				str2[i] = '2';
		}

		if (str1 == str2)
			printf("#%d SAME\n", test_case);
		else
			printf("#%d DIFF\n", test_case);
	}
	return 0;
}