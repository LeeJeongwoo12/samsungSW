#include <iostream>
#include <string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int num;
		cin >> num;
		string findStr, str;
		cin >> findStr;
		cin >> str;

		int n = 0;
		int count = 0;
		while (n < str.length()) { // str의 index를 안 벗어날 동안만
			if ((n = str.find(findStr, n)) != std::string::npos) { // str.find(f, n)은 f라는 문자열을 n의 index부터 찾아서 제일 처음 나오는 index를 return
				count++;
				n++; // n번째 index에 존재했으니까 그 이후부터 찾기 위하여 ++
			}
		}
		printf("#%d %d\n", test_case, count);
	}
	return 0;
}