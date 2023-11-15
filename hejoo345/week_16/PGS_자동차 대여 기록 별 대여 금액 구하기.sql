WITH TMP AS (SELECT B.HISTORY_ID,
                    A.CAR_ID,
                    A.CAR_TYPE,
                    A.DAILY_FEE,
                    DATEDIFF(B.END_DATE, B.START_DATE) + 1 PERIOD,
                    (CASE
                         WHEN DATEDIFF(B.END_DATE, B.START_DATE) + 1 >= 90 THEN '90일 이상'
                         WHEN DATEDIFF(B.END_DATE, B.START_DATE) + 1 >= 30 THEN '30일 이상'
                         WHEN DATEDIFF(B.END_DATE, B.START_DATE) + 1 >= 7 THEN '7일 이상'
                         ELSE 'NONE' END)                  DURATION_TYPE
             FROM CAR_RENTAL_COMPANY_CAR A,
                  CAR_RENTAL_COMPANY_RENTAL_HISTORY B
             WHERE A.CAR_ID = B.CAR_ID
               AND A.CAR_TYPE = '트럭')

SELECT A.HISTORY_ID, ROUND(A.DAILY_FEE * A.PERIOD * (100 - IFNULL(B.DISCOUNT_RATE, 0)) / 100) FEE
FROM TMP A
         LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN B
                   ON A.DURATION_TYPE = B.DURATION_TYPE
                       AND A.CAR_TYPE = B.CAR_TYPE
ORDER BY 2 DESC, 1 DESC