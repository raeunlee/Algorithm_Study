function solution(s) {
    let stack = [];
    const arr = s.split("");
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] == '(') {
            stack.push(arr[i]);
        } else {
            if (stack.length == 0) return false;
            stack.pop();
        }
    }
    if (stack.length == 0) return true;
    return false;
}