#include <iostream>
#include <cstring>

using namespace std;

bool checkPalin(char *str, int len);

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		char arr[100][101]; // 입력받을 배열
		int num; // test_case
		int max = -1; // 최대 길이

		cin >> num;
		getchar(); // enter key


		for (int i = 0; i < 100; i++) {
			scanf("%s", arr[i]);
		}

		for (int len = 100; len > 0; len--) { // max 값을 찾는 것이 문제이니까 100에서부터 시작
			char *str = new char[len + 1]; // 회문인지 보기 위하여 len만큼씩 자름

			if (max != -1) // 100부터 시작했으므로 회문을 찾는 순간 그 값이 max length
				break;

			for (int i = 0; i <= 100; i++) {
				for (int j = 0; j <= 100; j++) {
					char *temp;

					if (j <= 100 - len) { // 가로로 비교
						strcpy(str, "");
						for (int k = 0; k < len; k++) {
							temp = &arr[i][j + k];
							strncat(str, temp, 1); // 한글자씩 str에 추가
						}
						if (checkPalin(str, len))
							max = len;
					}

					if (i <= 100 - len) { // 세로로 비교
						strcpy(str, "");
						for (int k = 0; k < len; k++) {
							temp = &arr[i + k][j];
							strncat(str, temp, 1);
						}
						if (checkPalin(str, len))
							max = len;
					}
				}
			}
		}
		printf("#%d %d\n", test_case, max);
	}
	return 0;
}

bool checkPalin(char *str, int len) { // 회문인지 확인, 맞다면 true 아니면 false return
	for (int i = 0; i < len / 2; i++) {
		if (str[i] != str[len - i - 1])
			return false;
	}
	return true;
}