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
		char arr[8][9]; // 입력받을 배열
		int len; // 회문의 길이

		cin >> len;
		getchar(); // enter key
		char *str = new char[len + 1]; // 회문인지 보기 위하여 len만큼씩 자름

		for (int i = 0; i < 8; i++) {
			scanf("%s", arr[i]);
		}

		int count = 0;

		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				char *temp;

				if (j <= 8 - len) { // 가로로 비교
					strcpy(str, "");
					for (int k = 0; k < len; k++) {
						temp = &arr[i][j + k];
						strncat(str, temp, 1); // 한글자씩 str에 추가
					}
					if (checkPalin(str, len))
						count++;
				}

				if (i <= 8 - len) { // 세로로 비교
					strcpy(str, "");
					for (int k = 0; k < len; k++) {
						temp = &arr[i + k][j];
						strncat(str, temp, 1);
					}
					if (checkPalin(str, len))
						count++;
				}
			}
		}
		printf("#%d %d\n", test_case, count);
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