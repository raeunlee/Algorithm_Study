SELECT M.member_name, R.review_text, date_format(R.review_date, '%Y-%m-%d') 
FROM rest_review R 
INNER JOIN member_profile M ON R.member_id = M.member_id
WHERE R.member_id = (
    SELECT member_id
    FROM rest_review
    GROUP BY member_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
) ORDER BY R.review_date asc, R.review_text asc;
