#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    int n;
    cin >> n;
    vector<int> l(n);
    for(int i = 0; i < n; i++) cin >> l[i];

    int min_dis = 1000000;
    for (int i = 0; i < n-1; i++){
        min_dis = min(l[i+1]-l[i], min_dis);
    }

    int cnt = 0;
    for (int i = 0; i < n-1; i ++){
        if(l[i+1]-l[i] == min_dis){
            cnt += 1;
        }
    }

    cout << cnt;
    
   return 0;
}