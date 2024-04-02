#include <iostream>
#include <vector>
using namespace std;

int main(int argc, char** argv) {
    int m, n, k;
    cin >> m >> n >> k;

    vector<int> secret(m);
    for (int i = 0; i < m; i++) {
        cin >> secret[i];
    }

    vector<int> button(n);
    for (int i = 0; i < n; i++) {
        cin >> button[i];
    }

    int count = 0;

    if (secret.size() > button.size()) {
        count = 0;
    } else {
        for (int i = 0; i <= button.size() - secret.size(); i++) {
            vector<int> tmp(button.begin() + i, button.begin() + i + secret.size());
            if (tmp == secret) {
                count += 1;
            }
        }
    }

    if (count > 0) {
        cout << "secret";
    } else {
        cout << "normal";
    }

    return 0;
}
