SELECT 'OLDEST' AS TYPE
       ,w.NAME
       ,w.BIRTHDAY
FROM    worker w
WHERE   w.BIRTHDAY = ( SELECT MIN( ws.BIRTHDAY )
                       FROM worker ws )

UNION
                     
SELECT 'YOUNGEST' AS TYPE
       ,w.NAME
       ,w.BIRTHDAY
FROM    worker w
WHERE   w.BIRTHDAY = ( SELECT MAX( ws.BIRTHDAY )
                       FROM worker ws );