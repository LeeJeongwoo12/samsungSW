#include <iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		scanf("%d", &n);

		int arr[10];

		for (int i = 1; i <= n; i++) {
			scanf("%d", &arr[i]);
		}

		if (n == 1) // ���ڰ� �ϳ��� ��� �׳� ����
			printf("#%d %d\n", test_case, arr[1]);

		else {
			int temp = arr[1];
			
			for (int i = 2; i <= n; i++) {
				if (temp + arr[i] > temp * arr[i]) // �հ� �� �� ū ������ ����
					temp += arr[i];
				else
					temp *= arr[i];
			}

			printf("#%d %d\n", test_case, temp);
		}
	}
	return 0;
}