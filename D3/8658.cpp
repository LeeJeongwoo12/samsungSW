#include<iostream>
#include <string>
 
using namespace std;
 
#define INF 9999999
 
#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        string input;
        int min = INF;
        int max = -1;
         
        for (int i = 0; i < 10; i++) {
            cin >> input;
            int sum = 0;
             
            for (int j = 0; j < input.length(); j++)
                sum += input[j] - '0';
 
            if (sum > max)
                max = sum;
            if (sum < min)
                min = sum;
        }
 
        printf("#%d %d %d\n", test_case, max, min);
    }
    return 0;
}