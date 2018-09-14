
/*
Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the 
SalesOrderDetail rows for that Sales Order including Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based 
on the end of day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. */

DECLARE @SalesOrderID int
DECLARE @CC varchar
DECLARE @Date datetime
go

CREATE FUNCTION Sales.ufn_ChangeInRate(@SalesOrderID VARCHAR(20), @CC varchar(30), @Date Date)
RETURNS TABLE	
AS 
RETURN 
	SELECT sod.OrderQty, sod.ProductID, sod.UnitPrice * cr.EndOfDayRate as 'ChangeInUnitPrice'
	FROM Sales.SalesOrderDetail as sod, Sales.CurrencyRate as cr
	WHERE sod.SalesOrderID = @SalesOrderID and cr.CurrencyRateDate = @Date and cr.ToCurrencyCode = @CC;
go
select * from Sales.ufn_ChangeInRate('43659','GBP','2011-05-31 00:00:00.000');

