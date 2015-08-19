use student_applications;


select U1.Name as UniNama1, U2.Name as UniName2, U1.prov
from universities as U1, universities as U2
where U1.Name > U2.Name and U1.Prov = U2.Prov;