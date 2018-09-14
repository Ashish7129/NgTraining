/*Write a Procedure supplying name information from the Person.Person table and 
accepting a filter for the first name. Alter the above Store 
Procedure to supply Default Values if user does not enter any value.( Use AdventureWorks)*/

CREATE or ALTER PROCEDURE Person.GetFilteredName @firstname nvarchar(50) 
AS
	SELECT * from Person.Person as p where p.Firstname = @firstname
go



ALTER PROCEDURE Person.GetFilteredName @firstname nvarchar(50) = 'Ken'
AS
	SELECT * from Person.Person as p where p.Firstname = @firstname
go

exec Person.GetFilteredName 
