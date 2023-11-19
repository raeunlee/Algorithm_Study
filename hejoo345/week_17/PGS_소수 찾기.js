function solution(numbers) {
    let answer = new Set();
    const arr = numbers.split("");

    // 순열 만들기
    function getPermutation(arr, fixed) {
        if (arr.length > 0) {
            for (let i = 0; i < arr.length; i++) {
                const newNum = fixed + arr[i];
                // console.log(newNum);
                const tmp = [...arr];
                tmp.splice(i, 1);

                if (isPrime(Number(newNum))) {
                    answer.add(Number(newNum));
                }
                getPermutation(tmp, newNum);
            }
        }
    }

    getPermutation(arr, '');
    return answer.size;
}

// 소수 판별하기
function isPrime(num) {
    if (num <= 1) return false;
    for (let i = 2; i * i <= num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}