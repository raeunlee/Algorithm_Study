SELECT U.user_id, U.nickname, SUM(B.price) AS total_sales
FROM used_goods_user U
JOIN used_goods_board B on B.writer_id = U.user_id
WHERE B.status = 'done'
GROUP BY U.user_id
HAVING total_sales >= 700000
ORDER BY total_sales asc;