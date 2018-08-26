CREATE PROCEDURE `Daily`(in serial_id varchar(16))
BEGIN


    SELECT
	sum(IFNULL(e.generated_electricity,0.00)) as `sum`,
	avg(IFNULL(e.generated_electricity,0.00)) as `avg`,
	max(IFNULL(e.generated_electricity,0.00)) as `max`,
	min(IFNULL(e.generated_electricity,0.00)) as `min`,
    DATE(e.reading_at) as `date`
FROM
	crosssolar.hourly_electricity e left join crosssolar.panel p on p.id = e.panel_id
where p.serial = serial_id
group by DATE(e.reading_at);

END