--Connect to the AdventureWorks Database
USE AdventureWorks;
GO


--Q1 1.	Display the number of records in the [SalesPerson] table
SELECT * FROM [Sales].[SalesPerson];

/*Q2 2.	Select both the FirstName and LastName of records 
from the Person table where the FirstName begins with the
 letter ‘B’. (Schema(s) involved: Person)*/

SELECT FirstName AS 'Fname', LastName AS 'Lname' 
FROM Person.Person
WHERE FirstName LIKE 'B%';

/*3.	Select a list of FirstName and LastName for employees 
where Title is one of Design Engineer, Tool Designer 
or Marketing Assistant.(Schema(s) involved: HumanResources, Person).*/
SELECT p.FirstName, p.LastName, q.JobTitle
FROM Person.Person AS p
INNER JOIN HumanResources.Employee AS q ON q.BusinessEntityID = p.BusinessEntityID
WHERE 
 q.JobTitle in ('Design Engineer','Tool Designer','Marketing Assistant');


/*Q4 Display the Name and Color of the Product with the 
maximum weight. (Schema(s) involved: Production).*/
SELECT Name ,Color, Weight
FROM Production.Product 
WHERE Weight >= (select MAX(Weight) from Production.Product);

/*Q5 Display Description and MaxQty fields from the
 SpecialOffer table. Some of the MaxQty values are NULL,
  in this case display the value 0.00 instead. 
  (Schema(s) involved: Sales)*/
SELECT Description, ISNULL(MaxQty,0.00) 
FROM Sales.SpecialOffer;

/*Q6 6.	Display the overall Average of the 
[CurrencyRate].[AverageRate] values for the exchange rate
 ‘USD’ to ‘GBP’ for the year 2005 i.e. FromCurrencyCode = ‘USD’and ToCurrencyCode = ‘GBP’.
 Note: The field [CurrencyRate].[AverageRate] is defined as 
'Average exchange rate for the day.' (Schema(s) involved: Sales)*/
SELECT AVG(AverageRate) AS 'Average exchange rate for the day' FROM Sales.CurrencyRate
WHERE FromCurrencyCode = 'USD' and ToCurrencyCode ='GBP' and YEAR(CurrencyRateDate) = 2011;


--Q7 7.	Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person)
SELECT FirstName , LastName, ROW_NUMBER() OVER (Order by (select 1)) SequenceNo
FROM Person.Person
WHERE FirstName like '%ss%';


/*Q8 Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
CommissionPct	Commission Band
	0.00			Band 0
	Up To 1%		Band 1
	Up To 1.5%		Band 2
	Greater 1.5%	Band 3
Display the [SalesPersonID] with an additional column entitled 
‘Commission Band’ indicating the appropriate band as above.*/

SELECT BusinessEntityID,
CASE
	WHEN CommissionPct = 0.00 THEN 'Band 0'
	WHEN CommissionPct > 0.00 and CommissionPct <=0.01 THEN 'Band 1' 
	WHEN CommissionPct > 0.01 and CommissionPct <=0.015 THEN 'Band 2'
	ELSE 'Band 3'
END
AS 'Commission Band'
FROM Sales.SalesPerson;



/*Q9.	Display the managerial hierarchy from Ruth Ellerbrock (person type – EM)
 up to CEO Ken Sanchez. Hint: use [uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) */
DECLARE @EntityID INT

SELECT @EntityID =
(SELECT BusinessEntityID
FROM Person.Person 
WHERE FirstName = 'Ruth' and LastName ='Ellerbrock'
 and PersonType ='EM'
);
EXECUTE dbo.uspGetEmployeeManagers @BusinessEntityID = @EntityID;



/*Q10 Display the ProductId of the product with the largest stock 
level. Hint: Use the Scalar-valued function [dbo]. [UfnGetStock]. 
(Schema(s) involved: Production)*/
SELECT DISTINCT ProductID , dbo.ufnGetStock(ProductID) AS 'Stocks'
FROM Production.ProductInventory
WHERE dbo.ufnGetStock(ProductID) >= 
							(SELECT MAX(dbo.ufnGetStock(ProductID)) 
							 FROM Production.ProductInventory);

