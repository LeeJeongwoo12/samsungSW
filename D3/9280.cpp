#include<iostream>
#include<queue>
#include<array>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    cin >> T;
    for (test_case = 1; test_case <= T; ++test_case)
    {
        int n, m;
        cin >> n >> m;
 
        int *R = new int[n + 1]; // 요금
        int *W = new int[m + 1]; // 차량 무게
        int *P = new int[n + 1]; // 주차장
		 
        for (int i = 1; i <= n; i++) { // 요금 input
            cin >> R[i];
            P[i] = 0;
        }
        for (int i = 1; i <= m; i++) // 무게 input
            cin >> W[i];
 
        int input, sum = 0;
 
        queue <int> car; // 대기하는 차 넣을 queue
 
        for (int i = 1; i <= 2 * m; i++) {
            cin >> input;
 
            if (input > 0) { // 양수를 받을 경우
                int index = -1;
                for (int j = 1; j <= n; j++) {
                    if (P[j] == 0) {
                        index = j;
                        break;
                    }
                }
 
                if (index != -1) { // 넣을 곳이 있을 경우
                    P[index] = input;
                    sum += R[index] * W[input];
                }
                else { // 넣을 곳이 없을 경우
                    car.push(input); // 차량 번호 push
                }
            }
            else {
                input *= -1;
                for (int j = 1; j <= n; j++) {
                    if (P[j] == input) {
                        P[j] = 0; // 해당 번호의 차를 주차장에서 뺌
                        if (car.empty()) // 대기 중인 차가 없을 경우 그냥 종료
                            break;
                        else { // 대기 중인 차가 있을 경우 주차 고고
                            P[j] = car.front();
                            sum += R[j] * W[car.front()];
                            car.pop();
                        }
 
                        break;
                    }
                }
            }
        }
 
        printf("#%d %d\n", test_case, sum);
    }
    return 0;
}