select e.eid , e.ename, e.salary, e.createtime , 
       j.jid as job_jid , j.jname as job_jname, j.eid as job_eid
from employee e left join job j on e.eid = j.eid where e.eid =1