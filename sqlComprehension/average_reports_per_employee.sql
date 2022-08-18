--select avg(reports_to) from employees;

select count (employee_id) from employees where reports_to > (select avg(reports_to) from employees);