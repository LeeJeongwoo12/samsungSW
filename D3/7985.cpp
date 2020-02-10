#include<iostream>
#include <math.h>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        int k;
        cin >> k;
 
        int n = pow(2, k) - 1;
 
        int *arr = new int[n + 1];
 
        for (int i = 0; i < n; i++) {
            cin >> arr[i + 1];
        }
 
        printf("#%d ", test_case);
 
        for (int i = 1; i <= k; i++) {
            int head = pow(2, k - i);
            for (int j = 0; j < pow(2, i - 1); j++) {
                printf("%d ", arr[head * (2 * j + 1)]);
            }
            cout << endl;
        }
    }
    return 0;
}