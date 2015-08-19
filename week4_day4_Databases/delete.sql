use student_applications;

set SQL_SAFE_UPDATES = 0;

delete from students
where students.SID = 912;
set SQL_SAFE_UPDATES = 1;

                    