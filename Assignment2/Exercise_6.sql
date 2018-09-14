/*Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. Modify the above trigger to
 execute its check code only if the ListPrice column is   updated (Use AdventureWorks Database).*/
CREATE or ALTER TRIGGER [Production].[ListPriceUpdate] 
ON Production.Product
FOR UPDATE
AS	
BEGIN
	DECLARE @OldListPrice money
	DECLARE @NewListPrice money
	SELECT @NewListPrice = i.ListPrice FROM inserted AS i
	SELECT @OldListPrice = d.ListPrice FROM deleted AS d
	IF(@OldListPrice is not null)
		BEGIN
		 --  Old Value is greater than zero
			IF (@OldListPrice > 0.00)
			BEGIN
			  --If the Old Value is greater than New Value
				IF(@OLdListPrice > @NewListPrice)
				 BEGIN
					RAISERROR('Old value is greater than new value',16,1)
				 END
				--If the hike in the new listprice is greater than the 115 percent to the old value
				ELSE IF(@NewListPrice > 1.15 * @OldListPrice)
				 BEGIN
					RAISERROR('listPrice cannot be updated as the changes raise to be greater than 15 percent',16,1)
					ROLLBACK TRAN
				 END
			END
			ELSE
			-- New Value is zero
			BEGIN
				RAISERROR('New ListPrice value is zero', 16,1)
				RETURN
			END
		END
		-- Old value is null
		ELSE
			BEGIN
			  RAISERROR('ListPrice is not available in the table to the corresponding condition',16,1)
			  ROLLBACK TRAN
			END
	END;

--After Modification 
ALTER TRIGGER [Production].[ListPriceUpdate] 
ON Production.Product
FOR UPDATE
AS	
BEGIN
	DECLARE @OldListPrice money
	DECLARE @NewListPrice money
	SELECT @NewListPrice = i.ListPrice FROM inserted AS i
	SELECT @OldListPrice = d.ListPrice FROM deleted AS d
	IF(UPDATE(ListPrice))
	BEGIN
		IF(@OldListPrice is not null)
		BEGIN
		 --  Old Value is greater than zero
			IF (@OldListPrice > 0.00)
			BEGIN
			  --If the Old Value is greater than New Value
				IF(@OLdListPrice > @NewListPrice)
				 BEGIN
					RAISERROR('Old value is greater than new value',16,1)
				 END
				--If the hike in the new listprice is greater than the 115 percent to the old value
				ELSE IF(@NewListPrice > 1.15 * @OldListPrice)
				 BEGIN
					RAISERROR('listPrice cannot be updated as the changes raise to be greater than 15 percent',16,1)
					ROLLBACK TRAN
				 END
			END
			ELSE
			-- New Value is zero
			BEGIN
				RAISERROR('New ListPrice value is zero', 16,1)
				RETURN
			END
		END
		-- Old value is null
		ELSE
			BEGIN
			  RAISERROR('ListPrice is not available in the table to the corresponding condition',16,1)
			  ROLLBACK TRAN
			END
	END
END;



UPDATE Production.Product SET ListPrice = 3.00,Color='yellaq' where SafetyStockLevel = 1000;

Select * from Production.Product where SafetyStockLevel = 1000;
