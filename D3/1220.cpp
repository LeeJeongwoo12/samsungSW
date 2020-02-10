#include <iostream>

#define RED 1
#define BLUE 2

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int size;
		cin >> size;

		int **arr = new int *[size];
		for (int i = 0; i < size; i++) {
			arr[i] = new int[size];
			for (int j = 0; j < size; j++) {
				scanf("%d", &arr[i][j]);
			}
		}

		int sum = 0;

		for (int i = 0; i < size; i++) {
			int count = 0, index;
			bool red_check = false;

			for (int j = 0; j < size; j++) {
				if (arr[j][i] == RED) { // 빨강 밑에 파랑이 있는지 확인
					red_check = true;
					index = j;
				}

				if (red_check) { // 빨강 밑에 파랑이 있는 개수가 새로운 교착상태의 개수
					if (arr[j][i] == BLUE) {
						count++;
						red_check = false;
					}
				}
			}
			sum += count;
		}
		printf("#%d %d\n", test_case, sum);
	}
	return 0;
}