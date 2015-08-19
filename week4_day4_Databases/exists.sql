use student_applications;
#get top student grade
select S1.Name, S1.Avg
from students as S1
where not exists (select S2.Avg
					from students as S2
                    where S2.Avg > S1.Avg);
                    