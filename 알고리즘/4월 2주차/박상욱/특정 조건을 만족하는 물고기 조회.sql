-- 코드를 작성해주세요
Select COUNT(*) as FISH_COUNT, max(length) as MAX_LENGTH, FISH_TYPE 
FROM (
    select ID, FISH_TYPE, 
    CASE 
        WHEN LENGTH < 10 or LENGTH is null
        then 10
        else LENGTH
    END as LENGTH, 
    TIME
    from fish_info
) as FISH_INFO
group by FISH_TYPE
having avg(length) >= 33
order by FISH_TYPE;