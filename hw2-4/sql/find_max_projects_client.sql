SELECT c.ID
      ,c.NAME
      ,COUNT( p.ID ) AS PROJECT_COUNT
FROM   CLIENT c
JOIN   PROJECT p
    ON c.ID = p.CLIENT_ID
GROUP BY c.ID
        ,c.NAME
HAVING PROJECT_COUNT = ( SELECT MAX( PROJECT_COUNT )
                         FROM   ( SELECT COUNT( p.ID ) AS PROJECT_COUNT
                                  FROM PROJECT p
                                  GROUP BY p.CLIENT_ID ) Fs );