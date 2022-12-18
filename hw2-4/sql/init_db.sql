CREATE TABLE IF NOT EXISTS worker(
    ID INTEGER GENERATED ALWAYS AS IDENTITY
   ,NAME VARCHAR( 1000 ) NOT NULL CHECK( length( NAME ) >= 2 )
   ,BIRTHDAY DATE CHECK( BIRTHDAY >= '1900-01-01' )
   ,LEVEL VARCHAR( 7 ) NOT NULL CHECK( LEVEL IN( 'Trainee', 'Junior', 'Middle', 'Senior' ) )
   ,SALARY INTEGER CHECK( SALARY >= 100 AND SALARY <= 100000 )
   ,PRIMARY KEY( ID )
   );
  
  CREATE TABLE IF NOT EXISTS client(
    ID INTEGER GENERATED ALWAYS AS IDENTITY
   ,NAME VARCHAR( 1000 ) NOT NULL CHECK( length( NAME ) >= 2 )
   ,PRIMARY KEY( ID )
   );
  
  CREATE TABLE IF NOT EXISTS project(
    ID INTEGER GENERATED ALWAYS AS IDENTITY
   ,CLIENT_ID INTEGER REFERENCES client( ID )
   ,START_DATE DATE
   ,FINISH_DATE DATE
   ,PRIMARY KEY( ID )
   );

   ALTER TABLE project ADD CHECK( START_DATE IS NULL OR FINISH_DATE >= START_DATE ) CHECK;
   ALTER TABLE project ADD CHECK( FINISH_DATE IS NULL OR START_DATE <= FINISH_DATE ) CHECK;

  CREATE TABLE IF NOT EXISTS project_worker (
    PROJECT_ID INT REFERENCES project( ID )
   ,WORKER_ID INT REFERENCES worker( ID )
   ,PRIMARY KEY( PROJECT_ID, WORKER_ID )
   );