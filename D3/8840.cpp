#include <iostream>

using ll = long long;

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		ll L;
		scanf("%lld", &L);

		ll ans = (L / 2) * (L / 2); // L/2의 제곱만큼의 회문이 생성됨
				
		printf("#%d %lld\n", test_case, ans);
	}
	return 0;
}