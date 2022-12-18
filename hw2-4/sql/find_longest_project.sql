SELECT P.ID
      ,DATEDIFF( 'MONTH', P.START_DATE, P.FINISH_DATE ) AS MONTH_COUNT
FROM   PROJECT P
GROUP BY P.ID
HAVING MONTH_COUNT = ( SELECT MAX( F.MONTH_COUNT )
                       FROM ( SELECT P.ID
                                    ,DATEDIFF( 'MONTH', P.START_DATE, P.FINISH_DATE ) AS MONTH_COUNT
                              FROM   PROJECT P ) F
                              );