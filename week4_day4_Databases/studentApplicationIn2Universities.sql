use student_applications;
#kandidatstvali ednovremenno i v TU i v SU
select students.name
from students
where SID in (select SID from applications where applications.UName = 'SU') and SID in (select SID from applications where applications.UName = 'TU');
