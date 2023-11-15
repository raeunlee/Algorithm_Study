function solution(N, number) {
    const set = Array.from(new Array(8), () => new Set());
    for (let i = 0; i < 8; i++) {
        set[i].add(Number(`${N}`.repeat(i + 1)));
        for (let j = 0; j < i; j++) {
            for (const args1 of set[j]) {
                for (const args2 of set[i - j - 1]) {
                    set[i].add(args1 + args2);
                    set[i].add(args1 - args2);
                    set[i].add(args1 * args2);
                    set[i].add(Math.floor(args1 / args2));
                }
            }
        }
        if (set[i].has(number))
            return i + 1;
    }
    return -1;
}