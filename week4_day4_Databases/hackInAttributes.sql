use student_applications;

select Rec, 
(select name from students as S1 where not exists (Select S2.Avg from students as S2 where S1.Avg < S2.Avg)) as TopGreader,
(select name from students as S1 where not exists (Select S2.Avg from students as S2 where S1.Avg > S2.Avg)) as WorstGrader


from universities;
                    