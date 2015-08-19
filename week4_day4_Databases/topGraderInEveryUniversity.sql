select applications.UName, applications.UProv, max(students.avg) as 'top'
from students natural join applications
group by applications.UName;