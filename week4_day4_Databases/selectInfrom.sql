use student_applications;

select SaR.Name
from (Select Rec as Name from universities union Select Name from students) as SaR
where Name like "N%";
                    