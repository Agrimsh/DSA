select Department,Employee,Salary 
from(
    select d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        max(e.salary) over(partition by e.departmentID) as mx
    from Employee e
    join Department d
    on e.departmentId=d.id
)t
where Salary=mx

