# Write your MySQL query statement below
select d.name as Department,
e.name as Employee,
e.salary as Salary
from Employee e

join Department d on e.departmentid=d.id
where e.salary=(select max(salary) from Employee
where departmentid=e.departmentId)