SELECT B.CATEGORY, sum(sales) AS TOTAL_SALES
FROM book B
JOIN book_sales BS ON B.book_id = BS.book_id
where EXTRACT(YEAR_MONTH FROM BS.sales_date) = 202201
GROUP BY B.category
order by B.category asc;