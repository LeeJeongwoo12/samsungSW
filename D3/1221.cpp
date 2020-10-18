#include <iostream>
#include <string>
#include <map>

using namespace std;

int main(int argc, char** argv)
{
	cin.tie(0);
	ios_base::sync_with_stdio(0);

	int test_case;
	int T;
	cin >> T;

	map<string, int> string_m;

	string_m.insert(make_pair("ZRO", 0));
	string_m.insert(make_pair("ONE", 1));
	string_m.insert(make_pair("TWO", 2));
	string_m.insert(make_pair("THR", 3));
	string_m.insert(make_pair("FOR", 4));
	string_m.insert(make_pair("FIV", 5));
	string_m.insert(make_pair("SIX", 6));
	string_m.insert(make_pair("SVN", 7));
	string_m.insert(make_pair("EGT", 8));
	string_m.insert(make_pair("NIN", 9));

	map<int, string> int_m;
	
	int_m.insert(make_pair(0, "ZRO"));
	int_m.insert(make_pair(1, "ONE"));
	int_m.insert(make_pair(2, "TWO"));
	int_m.insert(make_pair(3, "THR"));
	int_m.insert(make_pair(4, "FOR"));
	int_m.insert(make_pair(5, "FIV"));
	int_m.insert(make_pair(6, "SIX"));
	int_m.insert(make_pair(7, "SVN"));
	int_m.insert(make_pair(8, "EGT"));
	int_m.insert(make_pair(9, "NIN"));

	for (test_case = 1; test_case <= T; ++test_case)
	{
		string case_num;
		int num;
		int count[10] = { 0, };
		
		cin >> case_num >> num;

		string input;
		for (int i = 0; i < num; ++i) {
			cin >> input;
			count[string_m.find(input)->second]++;
		}

		cout << "#" << test_case << "\n";

		for (int i = 0; i < 10; ++i) {
			string temp = int_m.find(i)->second;
			for (int j = 0; j < count[i]; ++j) {
				cout << temp << " ";
			}
		}
		cout << "\n";
	}


	return 0;
}