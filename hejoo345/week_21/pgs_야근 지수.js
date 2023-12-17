function solution(n, works) {
    if (n >= works.reduce((acc, cur) => acc + cur, 0)) return 0;
    works = works.sort((a, b) => b - a);
    while (n != 0) {
        const max = works[0];
        for (let i = 0; i < works.length; i++) {
            if (works[i] >= max) {
                n--;
                works[i]--;
            }
            if (n == 0) break;
        }
    }
    return works.reduce((acc, cur) => acc + cur * cur, 0);
}