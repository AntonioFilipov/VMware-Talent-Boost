use student_applications;

insert into students
(select SID+1, Name, Avg from students where SID = 911);
                    