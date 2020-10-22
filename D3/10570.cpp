#include <iostream>
#include <cmath>
#include <string>

using namespace std;

bool checkPalin(int num);
void initPalin(bool* arr);

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	bool *palin = new bool[1001];

	initPalin(palin);

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int a, b;
		int count = 0;

		cin >> a >> b;

		for (int i = a; i <= b; i++) {
			if (sqrt(i) == (int)sqrt(i)) {
				int square = (int)sqrt(i);

				if (palin[square] && palin[i])
					count++;
			}
		}

		printf("#%d %d\n", test_case, count);
	}
	return 0;
}

bool checkPalin(int num) {
	string temp = to_string(num);

	for (int i = 0; i < temp.length() / 2; i++) {
		if (temp[i] != temp[temp.length() - i - 1])
			return false;
	}

	return true;
}

void initPalin(bool* arr) {
	for (int i = 1; i <= 1000; ++i) {
		arr[i] = checkPalin(i);
	}
}