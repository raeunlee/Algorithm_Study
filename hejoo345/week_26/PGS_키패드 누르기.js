function distance(cur, center) {
    return Math.abs(cur[0] - center[0]) + Math.abs(cur[1] - center[1]);
}

function solution(numbers, hand) {
    const keypad = {
        1: [0, 0], 2: [0, 1], 3: [0, 2],
        4: [1, 0], 5: [1, 1], 6: [1, 2],
        7: [2, 0], 8: [2, 1], 9: [2, 2],
        10: [3, 0], 0: [3, 1], 12: [3, 2]
    };
    let cur_left = [3, 0];
    let cur_right = [3, 2];
    let result = '';

    numbers.forEach(num => {
        let cur_num = keypad[num];
        if (cur_num[1] === 0) {
            cur_left = cur_num;
            result += 'L';
        } else if (cur_num[1] === 2) {
            cur_right = cur_num;
            result += 'R';
        } else {
            let left_dis = distance(cur_left, cur_num);
            let right_dis = distance(cur_right, cur_num);
            if (left_dis === right_dis) {
                if (hand === 'left') {
                    cur_left = cur_num;
                    result += 'L';
                } else {
                    cur_right = cur_num;
                    result += 'R';
                }
            } else if (left_dis < right_dis) {
                cur_left = cur_num;
                result += 'L';
            } else {
                cur_right = cur_num;
                result += 'R';
            }
        }
    });
    return result;
}