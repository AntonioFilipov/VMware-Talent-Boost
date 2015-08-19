use student_applications;
#get top student grade
select S1.Name, S1.Avg
from students as S1
where not (S1.Avg < any(select S2.Avg
					from students as S2
                     ));
                    