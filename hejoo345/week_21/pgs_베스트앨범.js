function solution(genres, plays) {
    let answer = [];
    let songs = genres.map((genre, idx) => {
        return {
            idx,
            genre,
            play: plays[idx]
        }
    });

    let genrePlayCnt = [];
    songs.forEach(song => {
        let curGenre = genrePlayCnt.find(play => play.genre === song.genre);
        if (!curGenre) { // 없으면 push
            genrePlayCnt.push({
                genre: song.genre,
                play: song.play
            })
        } else { // 있으면 재생 횟수 더함
            curGenre.play += song.play;
        }
    });


    // 재생수 내림차순 정렬
    genrePlayCnt.sort((a, b) => b.play - a.play);

    genrePlayCnt.forEach(play => {
        let genreSongs = songs.filter(song => song.genre === play.genre); // 장르별 노래들
        genreSongs.sort((a, b) => b.play - a.play);
        answer.push(genreSongs[0].idx);
        if (genreSongs.length > 1) {
            answer.push(genreSongs[1].idx);
        }
    });
    return answer;
}