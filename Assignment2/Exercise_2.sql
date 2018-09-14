--Connect to the AdventureWorks Database
USE AdventureWorks;
GO
/*Write separate queries using a join, a subquery, a CTE, and
 then an EXISTS to list all AdventureWorks customers who have not placed an order.*/

 --JOIN Query
 SELECT distinct c.CustomerID
 FROM Sales.Customer as c
 LEFT JOIN Sales.SalesOrderHeader as soh ON c.CustomerID = soh.CustomerID
 WHERE soh.CustomerID is null

 --SubQuery
  SELECT distinct c.CustomerID
 FROM Sales.Customer as c, Sales.SalesOrderHeader as soh 
 WHERE c.CustomerID not in (select soh.CustomerID from Sales.SalesOrderHeader as soh);


  --EXISTS
 SELECT distinct c.CustomerID
 FROM Sales.Customer as c, Sales.SalesOrderHeader as soh 
 WHERE not exists (select soh.CustomerID From Sales.SalesOrderHeader as soh
					 INNER JOIN Sales.SalesOrderHeader ON c.CustomerID = soh.CustomerID );
  
 --Common Table Expression (Avoid Subqueries and simplify certain syntax)
 
 WITH NotPlacedOrder(CustomerID)
 AS
 (
	 SELECT c.CustomerID as 'CustomerID'
	 FROM Sales.Customer as c
	 LEFT JOIN Sales.SalesOrderHeader as soh ON c.CustomerID = soh.CustomerID
	 WHERE soh.CustomerID is null 
)
select * from NotPlacedOrder;