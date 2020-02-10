#include <iostream>

#define INF 9999999

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int p;
		cin >> p;

		int ans;
		int min = INF, max = -1;
		for (int i = 0; i < p; i++) {
			int input;
			cin >> input;

			if (max < input)
				max = input;

			if (min > input)
				min = input;
		}

		printf("#%d %d\n", test_case, min*max);
	}
	return 0;
}