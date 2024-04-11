select d.dept_id, d.dept_name_en, round(avg(e.sal)) avg_sal
from hr_department d natural join hr_employees e
group by d.dept_id
order by avg(e.sal) desc;