#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> member(n);
    for (int i = 0; i < n; i++) {
        cin >> member[i];
    }

    vector<bool> member2(n, true);

    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        if (member[a - 1] > member[b - 1]) {
            member2[b - 1] = false;
        }
        else if (member[a - 1] < member[b - 1]) {
            member2[a - 1] = false;
        }
        else { // 둘이 같을 경우
            member2[a - 1] = false;
            member2[b - 1] = false;
        }
    }

    int ans = 0;
    for (bool m2 : member2) {
        if (m2) {
            ans++;
        }
    }

    cout << ans << "\n";

    return 0;
}
