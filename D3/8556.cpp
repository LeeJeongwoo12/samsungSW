#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		string input;
		cin >> input;

		string temp;
		for (int i = input.length() - 1; i >= 0; i--) { // 뒤에서부터 W, N을 문자열에 삽입
			if (input[i] == 'n')
				temp.append("n");
			if (input[i] == 'w')
				temp.append("w");
		}

		float ans;
		if (temp[0] == 'w') // 초기 값 설정
			ans = 90;
		else
			ans = 0;

		for (int i = 1; i < temp.length(); i++) { // ans 값 구함
			if (temp[i] == 'w')
				ans += 90 / pow(2, i);
			else
				ans -= 90 / pow(2, i);
		}

		if (ans == (int)ans) // ans가 정수인 경우 그냥 print
			printf("#%d %d\n", test_case, (int)ans);
		else { // ans가 유리수인 경우
			float t = ans;
			int count = 0;

			while ((int)t != t) { // 분수로 나타내기 위하여 분모를 찾음
				t *= 2;
				count++;
			}

			count = pow(2, count); // count를 분모로 사용

			printf("#%d %d/%d\n", test_case, (int)(ans*count), count);
		}
	}
	return 0;
}