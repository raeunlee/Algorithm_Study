function solution(routes) {
    let answer = 0;
    routes.sort((a, b) => a[1] - b[1]);
    let camera = -30001;
    routes.forEach(route => {
        if (route[0] > camera) {
            answer++;
            camera = route[1];
        }
    });
    return answer;
}