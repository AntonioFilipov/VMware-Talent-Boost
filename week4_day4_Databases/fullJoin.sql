use student_applications;

select *
from students left outer join applications using(SID)
union 
select *
from students right outer join applications using(SID);



delete
from students 
where students.SID is null or students.Avg is null or students.Name is null;

delete
from applications
where applications.SID is null;

