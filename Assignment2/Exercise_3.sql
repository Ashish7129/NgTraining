--Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks.

USE AdventureWorks
GO

WITH CountOrder(AccountNumber, TotalDue)
AS
(
	SELECT soh.AccountNumber, SUM(soh.TotalDue) 
	FROM Sales.SalesOrderHeader AS soh
	GROUP BY soh.AccountNumber
	HAVING SUM(SOH.TotalDue) > 70000
)

SELECT * FROM(
SELECT c.AccountNumber,soh.OrderDate,
 RANK() OVER(PARTITION BY c.AccountNumber ORDER BY soh.OrderDate DESC) as OrderNo 
FROM CountOrder AS c 
INNER JOIN Sales.SalesOrderHeader AS soh ON soh.AccountNumber = c.AccountNumber
) a
WHERE a.OrderNo <= 5