use student_applications;

select *
from students inner join applications
on students.SID = applications.SID;

                    