def main():
    n = int(input())
    x = n // 2 
    ans = 0
    while x >= 0:
        start = n - x
        mul = 1
        div = 1
        for a in range(x, 0, -1):
            mul *= start
            div *= a
            start -= 1
        if div != 0:
            ans += mul // div
        x -= 1
    print(int(ans) % 10007)
if __name__ == "__main__":
    main()