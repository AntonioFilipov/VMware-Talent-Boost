use student_applications;

select Name, count(*) as appliedToUniversitiesCount
from students, applications
where students.SID = applications.SID
group by students.Name;
                    