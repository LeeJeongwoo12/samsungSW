#include <iostream>
#include <queue>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int test_num;
		cin >> test_num;

		int input;
		queue <int> q;

		for (int i = 0; i < 8; i++) {
			cin >> input;
			q.push(input);
		}

		while (q.back() != 0) {
			int temp;
			for (int i = 1; i <= 5; i++) { // 한 싸이클
				temp = q.front();
				q.pop();
				temp -= i;
				if (temp <= 0) { // 마지막 수가 0보다 작거나 같은 경우
					q.push(0); 
					break; // 암호 생성 완료
				}
				q.push(temp);
			}
		}
		printf("#%d ", test_case);

		for (int i = 0; i < 8; i++) {
			printf("%d ", q.front());
			q.pop();
		}
		printf("\n");
	}
	return 0;
}