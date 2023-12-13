SELECT FLAVOR
FROM (
    SELECT FLAVOR, TOTAL_ORDER
    FROM first_half
    
    UNION ALL
    
    SELECT FLAVOR, TOTAL_ORDER
    FROM july
) AS combined_data
GROUP BY FLAVOR
order by SUM(TOTAL_ORDER) desc
limit 3;