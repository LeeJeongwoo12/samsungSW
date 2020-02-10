#include <iostream>
#include <string>
#include <algorithm>

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

		int count[3] = { 0, };

		if (str.length() == 1) { // 문자열의 길이가 1이면 무조건 가능
			printf("#%d YES\n", test_case);
			continue;
		}

		for (int i = 0; i < str.length(); i++) {
			if (str[i] == 'a')
				count[0]++;
			if (str[i] == 'b')
				count[1]++;
			if (str[i] == 'c')
				count[2]++;
		}

		sort(count, count + 3);

		if (count[0] == 0) { // 0번 쓰이는 알파벳이 1개 이상
			if (count[1] == count[2] && count[1] == 1)
				printf("#%d YES\n", test_case);
			else
				printf("#%d NO\n", test_case);
		}
		else if (count[0] == count[1] && count[1] == count[2]) { // 빈도가 모두 같을 때
			printf("#%d YES\n", test_case);

		}
		else if(count[2] - count[0] >= 2){ // max와 min의 차이가 2개 이상일 때
			printf("#%d NO\n", test_case);
		}
		else // 빈도가 모두 다를 때
			printf("#%d YES\n", test_case);
	}
	return 0;
}