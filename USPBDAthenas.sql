USE BDAthenas
GO

CREATE OR ALTER PROCEDURE USP_NextCod
(
	@tabla VARCHAR(6) OUT
)
AS
BEGIN
	IF @tabla = '1'		--CATEGORIA
	BEGIN
		SELECT @tabla = MAX(ID) FROM Cat_Prod
		SET @tabla = ISNULL(@tabla,'CT0000')
		SET @tabla = 'CT'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '2'		--CLIENTE
	BEGIN
		SELECT @tabla = MAX(ID) FROM Cliente
		SET @tabla = ISNULL(@tabla,'CL0000')
		SET @tabla = 'CL'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '3'		--PROVEEDOR
	BEGIN
		SELECT @tabla = MAX(ID) FROM Proveedor
		SET @tabla = ISNULL(@tabla,'PV0000')
		SET @tabla = 'PV'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '4'		--PRODUCTO
	BEGIN
		SELECT @tabla = MAX(ID) FROM Producto
		SET @tabla = ISNULL(@tabla,'PR0000')
		SET @tabla = 'PR'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '5'		--PROMOCION
	BEGIN
		SELECT @tabla = MAX(ID) FROM Promo
		SET @tabla = ISNULL(@tabla,'PM0000')
		SET @tabla = 'PM'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '6'		--TRABAJADOR
	BEGIN
		SELECT @tabla = MAX(ID) FROM Trabajador
		SET @tabla = ISNULL(@tabla,'TB0000')
		SET @tabla = 'TB'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '7'		--COMPRA
	BEGIN
		SELECT @tabla = MAX(Cod_Compra) FROM Compra
		SET @tabla = ISNULL(@tabla,'OC0000')
		SET @tabla = 'OC'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
	IF @tabla = '8'		--VENTA
	BEGIN
		SELECT @tabla = MAX(Cod_Venta) FROM Venta
		SET @tabla = ISNULL(@tabla,'OV0000')
		SET @tabla = 'OV'+RIGHT(RIGHT(@tabla,4)+10001,4)
	END
END
GO


CREATE OR ALTER PROCEDURE USP_CateMantenimientos
(
	@OPERACION VARCHAR(100) OUTPUT,
	@ID VARCHAR (6) = NULL,
	@Desc VARCHAR(50) = NULL
)
AS
	BEGIN
		IF(@OPERACION = 1)
		BEGIN
			IF(NOT EXISTS (SELECT * FROM Cat_Prod WHERE ID = @ID))
				BEGIN
					INSERT INTO Cat_Prod(ID, Descripcion) VALUES(@ID, @Desc)
					SET @OPERACION = 'INSERCIÓN EXITOSA'
				END
			ELSE 
				SET @OPERACION = 'CODIGO YA REGISTRADO'
		END
		ELSE IF(@OPERACION = 2)
		BEGIN
			UPDATE Cat_Prod SET Descripcion = @Desc WHERE ID = @ID
			SET @OPERACION = 'MODIFICACIÓN SATISFACTRIA'
		END
		ELSE IF(@OPERACION = 3)
		BEGIN
			DELETE FROM Cat_Prod WHERE ID = @ID
			SET @OPERACION = 'REGISTRO ELIMINADO'
		END
	END
GO

CREATE or ALTER PROCEDURE USP_ClienteMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@ID VARCHAR (6) = NULL,
@NOM VARCHAR (100) = NULL ,
@APELL VARCHAR (100) = NULL,
@TELF VARCHAR(15) = NULL,
@DNI VARCHAR(9) = NULL,
@SEXO CHAR(1) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR CLIENTE
	BEGIN
		IF NOT EXISTS(SELECT ID FROM DBO.Cliente WHERE ID = @ID)
			BEGIN
				INSERT INTO Cliente(ID,NOMBRE,APELLIDO,TELEFONO,DNI,SEXO)
				VALUES (@ID,@NOM,@APELL,@TELF,@DNI,@SEXO)
				SET @OPERACION = 'INSERCI�N SATISFACTORIA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA REGISTRADO' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR CLIENTE
	BEGIN
		UPDATE DBO.Cliente SET NOMBRE = @NOM, APELLIDO = @APELL, 
		TELEFONO = @TELF, DNI = @DNI , SEXO = @SEXO
		WHERE ID = @ID
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR CLIENTE
	BEGIN
	DELETE FROM DBO.Cliente WHERE ID = @ID
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
GO


CREATE or ALTER PROCEDURE USP_CategoriaMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@ID VARCHAR (6) = NULL,
@Des VARCHAR (100) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR CATEGORIA
	BEGIN
		IF NOT EXISTS(SELECT ID FROM DBO.Cat_Prod WHERE ID = @ID)
			BEGIN
				INSERT INTO Cat_Prod(ID,Descripcion)
				VALUES (@ID,@Des)
				SET @OPERACION = 'INSERCI�N CATEGORIA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA REGISTRADO' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR CATEGORIA
	BEGIN
		UPDATE DBO.Cat_Prod SET Descripcion = @Des
		WHERE ID = @ID
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR CATEGORIA
	BEGIN
	DELETE FROM DBO.Cat_Prod WHERE ID = @ID
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
GO



CREATE or ALTER PROCEDURE USP_ProveedorMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@ID VARCHAR (6) = NULL,
@RZ VARCHAR (100) = NULL ,
@Rep VARCHAR (100) = NULL,
@Mail VARCHAR(100) = NULL,
@Tel VARCHAR(15) = NULL,
@Dir VARCHAR(100) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR PROVEEDOR
	BEGIN
		IF NOT EXISTS(SELECT ID FROM DBO.Proveedor WHERE ID = @ID)
			BEGIN
				INSERT INTO Proveedor(ID,Rz_Social,Representante,Email,Telefono,Direccion)
				VALUES (@ID,@RZ,@Rep,@Mail,@Tel,@Dir)
				SET @OPERACION = 'INSERCI�N SATISFACTORIA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA REGISTRADO' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR PROVEEDOR
	BEGIN
		UPDATE DBO.Proveedor SET Rz_Social = @RZ, Representante = @Rep, 
		Email = @Mail, Telefono = @Tel , Direccion = @Dir
		WHERE ID = @ID
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR PROVEEDOR
	BEGIN
	DELETE FROM DBO.Proveedor WHERE ID = @ID
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
GO



CREATE or ALTER PROCEDURE USP_TrabajadorMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@ID VARCHAR (6) = NULL,
@Nom VARCHAR (100) = NULL ,
@Apell VARCHAR (100) = NULL,
@Tel VARCHAR(15) = NULL,
@DNI VARCHAR(9) = NULL,
@Sexo CHAR(1) = NULL,
@Mail VARCHAR(100) = NULL,
@Dir VARCHAR(100) = NULL,
@User varchar(50) = null,
@Pass VARCHAR(255) = NULL,
@Rol VARCHAR(20) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR TRABAJADOR
	BEGIN
		IF NOT EXISTS(SELECT ID FROM DBO.Trabajador WHERE ID = @ID)
			BEGIN
				INSERT INTO Trabajador(ID,Nombre,Apellido,Telefono,DNI,Email, Direccion, Usuario, Contrasenia,Sexo, Rol)
				VALUES (@ID,@Nom,@Apell,@Tel,@DNI,@Mail, @Dir, @User, @Pass, @Sexo, @Rol)
				SET @OPERACION = 'INSERCI�N SATISFACTORIA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA REGISTRADO' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR TRABAJADOR
	BEGIN
		UPDATE DBO.Trabajador SET Nombre = @Nom, Apellido = @Apell, 
		Telefono = @Tel, DNI = @DNI , Email = @Mail, Direccion = @Dir, Usuario = @User, Contrasenia = @Pass, Sexo = @Sexo, Rol = @Rol
		WHERE ID = @ID
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR TRABAJADOR
	BEGIN
	DELETE FROM DBO.Trabajador WHERE ID = @ID
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
GO


CREATE or ALTER PROCEDURE USP_ProductoMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@ID VARCHAR (6) = NULL,
@Desc VARCHAR (100) = NULL,
@PrecioC DECIMAL(10,2) = NULL ,
@PrecioV DECIMAL(10,2) = NULL,
@StockA INT = NULL,
@StockM INT = NULL,
@Cat VARCHAR(6) = NULL,
@Img VARBINARY(MAX) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR PRODUCTO
	BEGIN
		IF NOT EXISTS(SELECT ID FROM DBO.Cliente WHERE ID = @ID)
			BEGIN
				IF @Img IS NULL
				BEGIN
					INSERT INTO Producto(ID,Descripcion,Precio_Compra,Precio_Venta,Stock_Actual,Stock_Min, Cat_Id)
					VALUES (@ID,@Desc,@PrecioC,@PrecioV,@StockA,@StockM, @Cat)
				END
				ELSE
				BEGIN
					INSERT INTO Producto(ID,Descripcion,Precio_Compra,Precio_Venta,Stock_Actual,Stock_Min, Cat_Id, Imagen)
					VALUES (@ID,@Desc,@PrecioC,@PrecioV,@StockA,@StockM, @Cat, @Img)
				END
				SET @OPERACION = 'INSERCI�N SATISFACTORIA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA REGISTRADO' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR PRODUCTO
	BEGIN
		IF @Img IS NULL
		BEGIN
			UPDATE DBO.Producto SET Descripcion = @Desc, Precio_Compra = Precio_Compra, 
			Precio_Venta = @PrecioV, Stock_Actual = @StockA , Stock_Min = @StockM, Cat_Id = @Cat
			WHERE ID = @ID
		END
		ELSE
		BEGIN
			UPDATE DBO.Producto SET Descripcion = @Desc, Precio_Compra = Precio_Compra, 
			Precio_Venta = @PrecioV, Stock_Actual = @StockA , Stock_Min = Stock_Min, Cat_Id = @Cat, Imagen = @Img
			WHERE ID = @ID
		END
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR PRODUCTO
	BEGIN
	DELETE FROM DBO.Producto WHERE ID = @ID
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
ELSE IF (@OPERACION = '4') -- ELIMINACION DE LA IMAGEN DE UN PRODUCTO
	BEGIN
		UPDATE Producto SET Imagen = NULL WHERE ID = @ID 
	END
GO


CREATE or ALTER PROCEDURE USP_PromoMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@ID VARCHAR (6) = NULL,
@Prod VARCHAR (6) = NULL,
@Tipo INT = NULL,
@Valor DECIMAL(10,2) = NULL,
@FecIni DATE = NULL,
@FecFin DATE = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR PROMO
	BEGIN
		IF NOT EXISTS(SELECT ID FROM DBO.Promo WHERE ID = @ID)
			BEGIN
				INSERT INTO Promo(ID,Cod_Prod, Tipo, Valor, FecIni, FecFin)
				VALUES (@ID,@Prod, @Tipo, @Valor, @FecIni, @FecFin)
				SET @OPERACION = 'INSERCI�N EXITOSA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA EXISTE' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR PROMO
	BEGIN
		UPDATE DBO.Promo SET  Cod_Prod = @Prod, Tipo = @Tipo, Valor = @Valor, FecIni = @FecIni, FecFin = @FecFin
		WHERE ID = @ID
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR PROMO
	BEGIN
	DELETE FROM DBO.Promo WHERE ID = @ID
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
GO


CREATE or ALTER PROCEDURE USP_CompraMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@Compra VARCHAR (6) = NULL,
@Prov VARCHAR (6) = NULL,
@Trab VARCHAR (6) = NULL,
@Fecha date = NULL,
@igv decimal(10,2) = NULL,
@estado int = null
AS

IF(@OPERACION = '1') --======PARA INSERTAR COMPRA
	BEGIN
		IF NOT EXISTS(SELECT Cod_Compra FROM DBO.Compra WHERE Cod_Compra = @Compra)
			BEGIN
				INSERT INTO Compra(Cod_Compra,Cod_Proveedor, Cod_Trabajador, Fecha, IGV, Estado)
				VALUES (@Compra,@Prov, @Trab, @Fecha, @igv, @estado)
				SET @OPERACION = 'INSERCI�N EXITOSA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA EXISTE' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR COMPRA
	BEGIN
		UPDATE DBO.Compra SET Cod_Proveedor = @Prov, Cod_Trabajador = @Trab, Fecha = @Fecha, IGV = @igv, Estado = @estado
		WHERE Cod_Compra = @Compra
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR COMPRA
	BEGIN
		DELETE FROM DBO.Compra WHERE Cod_Compra = @Compra
		SET @OPERACION = 'REGISTRO ELIMINADO'
	END
ELSE IF(@OPERACION = 4) --========PARA MODIFICAR COMPRA RECIBIDA Y PARA RECIBIR COMPRA
	BEGIN
		UPDATE DBO.Compra SET Cod_Proveedor = @Prov, Cod_Trabajador = @Trab, Fecha = @Fecha, IGV = @igv, Estado = 1
		WHERE Cod_Compra = @Compra
	END
GO


CREATE or ALTER PROCEDURE USP_VentaMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@Venta VARCHAR (6) = NULL,
@Cliente VARCHAR (6) = NULL,
@Trab VARCHAR (6) = NULL,
@Fecha date = NULL,
@igv decimal(10,2) = NULL,
@descto decimal(10,2) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR VENTA
	BEGIN
		IF NOT EXISTS(SELECT Cod_Venta FROM DBO.Venta WHERE Cod_Venta = @Venta)
			BEGIN
				INSERT INTO Venta(Cod_Venta,Cod_Cliente, Cod_Trabajador, Fecha, IGV, DescTotal)
				VALUES (@Venta,@Cliente, @Trab, @Fecha, @igv, @descto)
				SET @OPERACION = 'INSERCI�N EXITOSA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'CODIGO YA EXISTE' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR VENTA
	BEGIN
		UPDATE DBO.Venta SET Cod_Cliente = @Cliente, Cod_Trabajador = @Trab, Fecha = @Fecha, IGV = @igv, DescTotal = @descto
		WHERE Cod_Venta = @Venta
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR VENTA
	BEGIN
	DELETE FROM DBO.Venta WHERE Cod_Venta = @Venta
	SET @OPERACION = 'REGISTRO ELIMINADO'
	END
GO


CREATE or ALTER PROCEDURE USP_DetVentMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@Venta VARCHAR (6) = NULL,
@Producto VARCHAR (6) = NULL,
@cant int = NULL,
@Precio decimal(10,2) = NULL,
@descto decimal(10,2) = NULL
AS

IF(@OPERACION = '1') --======PARA INSERTAR DETALLE DE VENTA
	BEGIN
		IF NOT EXISTS(SELECT Cod_Venta, Cod_Produc FROM DBO.Det_Venta WHERE Cod_Venta = @Venta AND Cod_Produc = @Producto)
			BEGIN
				INSERT INTO Det_Venta(Cod_Venta,Cod_Produc, Cantidad, Precio, Desct)
				VALUES (@Venta,@Producto, @cant, @Precio, @descto)
				UPDATE Producto SET Stock_Actual = Stock_Actual - @cant WHERE ID = @Producto
				SET @OPERACION = 'INSERCI�N EXITOSA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'DETALLE YA EXISTE' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR DETALLE DE VENTA
	BEGIN
		DECLARE @cantActual int--OBTENEMOS CANTIDAD ANTIGUA DEL DETALLE
		SELECT @cantActual = Cantidad FROM Det_Venta WHERE Cod_Produc = @Producto AND Cod_Produc = @Producto
		SET @cantActual -= @cant--RESTAMOS LA ANTIGUA CON LA ENTRANTE

		UPDATE DBO.Det_Venta SET Cod_Produc = @Producto, Cantidad = @cant, Precio = @Precio, Desct = @descto
		WHERE Cod_Venta = @Venta and Cod_Produc = @Producto

		UPDATE Producto SET Stock_Actual = Stock_Actual + @cantActual --SUMAMOS LA CANTIDAD AL STOCK
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR 1 DETALLE DE VENTA
	BEGIN
		DECLARE @cantBorrada int
		SELECT @cantBorrada = Cantidad FROM Det_Venta WHERE Cod_Venta = @Venta AND Cod_Produc = @Producto

		DELETE FROM DBO.Det_Venta WHERE Cod_Venta = @Venta AND Cod_Produc = @Producto

		UPDATE Producto SET Stock_Actual = Stock_Actual + @cantBorrada WHERE ID = @Producto
		SET @OPERACION = 'REGISTRO ELIMINADO'
	END
ELSE IF (@OPERACION = '4')--======PARA BORRAR TODOS LOS DETALLES DE UNA VENTA
	BEGIN
		
		DECLARE c_EliminaDet CURSOR 
		FOR SELECT Cod_Produc, Cantidad FROM Det_Venta WHERE Cod_Venta = @Venta
		DECLARE @codProd varchar(10), @cantProd int

		OPEN c_EliminaDet
		FETCH c_EliminaDet INTO @codProd, @cantProd
		WHILE @@FETCH_STATUS = 0
		BEGIN
			UPDATE Producto SET Stock_Actual = Stock_Actual + @cantProd WHERE ID = @codProd
			FETCH c_EliminaDet INTO @codProd, @cantProd
		END
		CLOSE c_EliminaDet
		DEALLOCATE c_EliminaDet

		DELETE FROM DBO.Det_Venta WHERE Cod_Venta = @Venta

		SET @OPERACION = 'REGISTROS ELIMINADOS'
	END
GO


CREATE or ALTER PROCEDURE USP_DetCompMantenimiento
@OPERACION VARCHAR(100) OUTPUT,
@Compra VARCHAR (6) = NULL,
@Producto VARCHAR (6) = NULL,
@cant int = NULL,
@Precio decimal(10,2) = NULL
AS

DECLARE @estado int
SELECT @estado = Estado FROM Compra WHERE Cod_Compra = @Compra --===>OBTENEMOS EL ESTADO PARA SABER SI ES UNA COMPRA RECIBIDA O POR RECIBIR

IF(@OPERACION = '1') --======PARA INSERTAR DETALLE DE COMPRA
	BEGIN
		IF NOT EXISTS(SELECT Cod_Compra, Cod_Produc FROM DBO.Det_Comp WHERE Cod_Compra = @Compra AND Cod_Produc = @Producto)
			BEGIN
				
				INSERT INTO Det_Comp(Cod_Compra,Cod_Produc, Cantidad, Precio)
				VALUES (@Compra,@Producto, @cant, @Precio)

				IF(@estado = 1)
				BEGIN
					UPDATE Producto SET Stock_Actual = Stock_Actual + @cant
				END

				SET @OPERACION = 'INSERCI�N EXITOSA'
			END
		ELSE
			BEGIN
				SET @OPERACION = 'DETALLE YA EXISTE' 
			END
		END
ELSE IF (@OPERACION = '2') --======PARA MODIFICAR DETALLE DE COMPRA
	BEGIN
		DECLARE @cantActual int = 0
		IF(@estado = 1)
		BEGIN
			SELECT @cantActual = Cantidad FROM Det_Comp WHERE Cod_Compra = @Compra AND Cod_Produc = @Producto
			SET @cantActual = @cantActual + @cant
		END
		
		UPDATE DBO.Det_Comp SET Cod_Produc = @Producto, Cantidad = @cant, Precio = @Precio
		WHERE Cod_Compra = @Compra and Cod_Produc = @Producto

		UPDATE Producto SET Stock_Actual = Stock_Actual - @cantActual
		SET @OPERACION = 'ACTUALIZACI�N SATISFACTORIA'
	END
ELSE IF (@OPERACION = '3')--======PARA BORRAR 1 DETALLE DE COMPRA
	BEGIN
		DECLARE @cantActual2 int = 0
		IF(@estado = 1)
		BEGIN
			SELECT @cantActual2 = Cantidad FROM Det_Comp WHERE Cod_Compra = @Compra AND Cod_Produc = @Producto
		END
		DELETE FROM DBO.Det_Comp WHERE Cod_Compra = @Compra AND Cod_Produc = @Producto
		UPDATE Producto SET Stock_Actual = Stock_Actual - @cantActual2
		SET @OPERACION = 'REGISTRO ELIMINADO'
	END
ELSE IF (@OPERACION = '4')--======PARA BORRAR TODOS LOS DETALLES DE UNA COMPRA
	BEGIN
		IF(@estado = 1)
		BEGIN
			DECLARE c_EliminaDet CURSOR 
			FOR SELECT Cod_Produc, Cantidad FROM Det_Comp WHERE Cod_Compra = @Compra
			DECLARE @codProd varchar(10), @cantProd int

			OPEN c_EliminaDet
			FETCH c_EliminaDet INTO @codProd, @cantProd
			WHILE @@FETCH_STATUS = 0
			BEGIN
				UPDATE Producto SET Stock_Actual = Stock_Actual - @cantProd WHERE ID = @codProd
				FETCH c_EliminaDet INTO @codProd, @cantProd
			END
			CLOSE c_EliminaDet
			DEALLOCATE c_EliminaDet

		END

		DELETE FROM Det_Comp WHERE Cod_Compra = @Compra
		SET @OPERACION = 'REGISTROS ELIMINADOS'
	END
GO

--FUNCIÓN PARA DEVOLVER EL DESCUENTO DE UN PRODUCTO -> DEVUELVE 0 SI NO HAY DESCUENTO
CREATE OR ALTER FUNCTION UFC_Descuento_Producto
(
	@prod VARCHAR(10)
) RETURNS DECIMAL(10,2)
as
BEGIN
	DECLARE @desc DECIMAL(10,2)

	select @desc = case pm.Tipo
		when 0 then pm.Valor
		when 1 then pd.Precio_Venta * (pm.Valor/100)
		end
	from Promo pm inner join Producto pd 
	on pd.ID = pm.Cod_Prod
	where Cod_Prod = @prod and GETDATE() between FecIni and FecFin
	
	RETURN ISNULL(@desc, 0)
END
GO

--FUNCION PARA DETERMINAR SI UN PRODUCTO YA TIENE UNA PROMOCIÓN EN UNA DETERMINADA FECHA
CREATE OR ALTER FUNCTION UDF_ProductoPromo
(	
	@prod varchar(10),
	@fecha date
)
returns int
AS
BEGIN
	DECLARE @Resultado INT

	if(@prod IN (SELECT Cod_Prod FROM Promo where CONVERT(VARCHAR,@fecha, 101) BETWEEN FecIni AND FecFin))
		SET @Resultado = 1
	ELSE
		SET @Resultado = 0

	RETURN @Resultado
END
GO


