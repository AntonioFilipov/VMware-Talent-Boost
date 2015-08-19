use student_applications;

select *
from students natural join applications;

#THEY ARE EQUAVILENT
select *
from students inner join applications using(SID);

                    