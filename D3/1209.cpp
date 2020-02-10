#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int trash;
		cin >> trash;
		int input[100][100];
		int col[100] = { 0, };
		int row[100] = { 0, };
		int dia[2] = { 0, };
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				int num;

				scanf("%d", &num);
				input[i][j] = num;

				col[j] += num;
				row[i] += num;

				if (i == j) { // 왼쪽위에서 오른쪽아래
					dia[0] += input[i][j];
				}

				if (i + j == 99) { // 오른쪽위에서 왼쪽아래
					dia[1] += input[i][j];
				}
			}
		}
		int max = dia[0] > dia[1] ? dia[0] : dia[1]; // 대각선 먼저 봄

		for (int i = 0; i < 100; i++) {
			if (col[i] > max)
				max = col[i];
			if (row[i] > max)
				max = row[i];
		}
		printf("#%d %d\n", test_case, max);
	}
	return 0;
}