USE master
GO

IF DB_ID('BDAthenas') IS NOT NULL
	DROP DATABASE BDAthenas
GO

CREATE DATABASE BDAthenas
GO

USE BDAthenas
GO


/*
	TABLA CATEGORIA DONDE SE ESPECIFICAN LAS CATEGORIAS DE CADA PRODUCTO
*/
IF OBJECT_ID('Cat_Prod') IS NOT NULL
	DROP TABLE Cat_Prod
GO

CREATE TABLE Cat_Prod(
	ID VARCHAR(6) NOT NULL,
	Descripcion VARCHAR(50) NOT NULL,
	PRIMARY KEY (ID) 
)
GO


/*
	TABLA CLIENTE
*/
IF OBJECT_ID('Cliente') IS NOT NULL
	DROP TABLE Cliente
GO

CREATE TABLE Cliente(
	ID VARCHAR(6) NOT NULL,
	Nombre VARCHAR(100) NOT NULL,
	Apellido VARCHAR(100) NOT NULL,
	Telefono VARCHAR(15) NOT NULL,
	DNI VARCHAR(9) NOT NULL,
	Sexo CHAR(1) NOT NULL,
	PRIMARY KEY (ID) 
)
GO



/*
	TABLA PROVEEDOR
*/
IF OBJECT_ID('Proveedor') IS NOT NULL
	DROP TABLE Proveedor
GO

CREATE TABLE Proveedor(
	ID VARCHAR(6) NOT NULL,
	Rz_Social VARCHAR(100) NOT NULL,
	Representante VARCHAR(100) NOT NULL,
	Email VARCHAR(100),
	Telefono VARCHAR(15) NOT NULL,
	Direccion VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID) 
)
GO


/*
	TABLA TRABAJADOR SE REGISTRAN LOS DATOS Y EL USUARIO Y CONTRASEÑA
*/
IF OBJECT_ID('Trabajador') IS NOT NULL
	DROP TABLE Trabajador
GO

CREATE TABLE Trabajador(
	ID VARCHAR(6) NOT NULL,
	Nombre VARCHAR(100) NOT NULL,
	Apellido VARCHAR(100) NOT NULL,
	Telefono VARCHAR(15) NOT NULL,
	DNI VARCHAR(9) NOT NULL,
	Direccion VARCHAR(100) NOT NULL,
	Email VARCHAR(100),
	Usuario VARCHAR(50) NOT NULL,
	Contrasenia VARCHAR(255) NOT NULL,
	Sexo CHAR(1) NOT NULL,
	Rol VARCHAR(20) NOT NULL,
	PRIMARY KEY (ID)
)
GO


/*
	TABLA PRODUCTO
*/
IF OBJECT_ID('Producto') IS NOT NULL
	DROP TABLE Producto
GO

CREATE TABLE Producto(
	ID VARCHAR(6) NOT NULL,
	Descripcion VARCHAR(100) NOT NULL,
	Precio_Compra DECIMAL(10,2) NOT NULL,
	Precio_Venta DECIMAL(10,2) NOT NULL,
	Stock_Actual INT NOT NULL,
	Stock_Min INT NOT NULL,
	Cat_Id VARCHAR(6) NOT NULL,
	Imagen VARBINARY (MAX)  NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (Cat_Id) REFERENCES CAT_PROD (ID)
)
GO


/*
	TABLA PARA ALMACENAR LOS ESPECIFICOS DE LAS COMPRAS
*/
IF OBJECT_ID('Compra') IS NOT NULL
	DROP TABLE Compra
GO

CREATE TABLE Compra(
  Cod_Compra VARCHAR(6) NOT NULL,
  Cod_Proveedor VARCHAR(6) NOT NULL ,
  Cod_Trabajador VARCHAR(6) NOT NULL,
  Fecha DATE NOT NULL,
  IGV DECIMAL(10,2) NOT NULL DEFAULT 0.18,
  Estado int not null default 0,
  PRIMARY KEY(Cod_Compra),
  FOREIGN KEY (Cod_Proveedor) REFERENCES Proveedor (ID),
  FOREIGN KEY (Cod_Trabajador) REFERENCES Trabajador (ID)
)
GO


--IF (EXISTS(SELECT * FROM SYS.triggers WHERE name = 'Tr_Compras'))
--	DROP TRIGGER Tr_Compras
--GO

--create trigger Tr_Compras on Compra 
--after update
--as
--	declare @compra varchar(6), @estadoActual int, @estadoAnt int
--	select @compra = i.Cod_Compra, @estadoActual = i.Estado from inserted i
--	select @estadoAnt = d.Estado from deleted d
--	if @estadoAnt = 0 and @estadoActual = 1
--	begin
--		declare c_Detalle cursor for
--		select Cod_Produc, Cantidad from Det_Comp where Cod_Compra = @compra
--		declare @prod varchar(6), @cant int
--		open c_Detalle
--		fetch c_Detalle into @prod, @cant
--		while @@FETCH_STATUS = 0
--		begin
--			update Producto set Stock_Actual = Stock_Actual + @cant where ID = @prod
--			fetch c_Detalle into @prod, @cant
--		end
--	end
--	--else if @estadoAnt = 1 and @estadoActual = 1
--go

/*
	TABLA PARA ALMACENAR LOS ESPECIFICOS DE LAS VENTAS
*/
IF OBJECT_ID('Venta') IS NOT NULL
	DROP TABLE Venta 
GO 

CREATE TABLE Venta (
	Cod_Venta VARCHAR(6) NOT NULL,
	Cod_Cliente VARCHAR(6) NOT NULL,
	Cod_Trabajador VARCHAR(6) NOT NULL,
	Fecha DATE NOT NULL,
    IGV DECIMAL(10,2) NOT NULL DEFAULT 0.18,
	DescTotal DECIMAL(10,2) DEFAULT 0.0,
	PRIMARY KEY(Cod_Venta),
	FOREIGN KEY (Cod_Cliente) REFERENCES Cliente (ID),
	FOREIGN KEY (Cod_Trabajador) REFERENCES Trabajador (ID)
)
GO


/*
	CAMBIOS A DETALLES
*/
IF OBJECT_ID('Det_Venta') IS NOT NULL
	DROP TABLE Det_Venta
GO

CREATE TABLE Det_Venta(
	Cod_Venta VARCHAR(6) NOT NULL,
	Cod_Produc VARCHAR(6) NOT NULL,
	Cantidad INT NOT NULL, 
	Precio DECIMAL(10,2) NOT NULL,
	Desct DECIMAL(10,2) NULL DEFAULT 0.0,
	FOREIGN KEY (Cod_Venta) REFERENCES Venta(Cod_Venta),
	FOREIGN KEY (Cod_Produc) REFERENCES Producto (ID)
)
GO
/*
	TRIGGER DE VENTAS
*/
/*IF (EXISTS(SELECT * FROM SYS.triggers WHERE name = 'Tr_Ventas'))
	DROP TRIGGER Tr_Ventas
GO

CREATE TRIGGER Tr_Ventas ON Det_Venta
INSTEAD OF INSERT
AS
	DECLARE @vent VARCHAR(6), @prod VARCHAR(6), @cant INT, @pre DECIMAL(10,2), @desc DECIMAL(10,2)
	SELECT @vent=I.Cod_Venta, @prod=I.Cod_Produc, @cant=I.Cantidad, @pre=I.Precio, @desc=I.Desct FROM inserted I

	IF((SELECT P.Stock_Actual FROM Producto P WHERE ID=@prod ) - @cant >= 0)
	BEGIN
		INSERT INTO Det_Venta VALUES (@vent, @prod, @cant, @pre, @desc)
		UPDATE Producto SET Stock_Actual = Stock_Actual - @cant WHERE ID = @prod
	END
	ELSE
		RAISERROR('Cantidad insuficiente de producto',16,1)
GO*/

IF OBJECT_ID('Det_Comp') IS NOT NULL
	DROP TABLE Det_Comp
GO

CREATE TABLE Det_Comp(
	Cod_Compra VARCHAR(6) NOT NULL,
	Cod_Produc VARCHAR(6) NOT NULL,
	Cantidad INT NOT NULL, 
	Precio DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (Cod_Compra) REFERENCES Compra(Cod_Compra),
	FOREIGN KEY (Cod_Produc) REFERENCES Producto (ID)
)
GO

IF (EXISTS(SELECT * FROM SYS.triggers WHERE name = 'Tr_DetCompras'))
	DROP TRIGGER Tr_DetCompras
GO

--create trigger Tr_DetCompras on Det_Comp
--after update
--as
--	declare @compra varchar(6), @cantActual int,@cantAnt int, @prodAnt varchar(6), @prodActual varchar(6), @estado int
--	select @compra = i.Cod_Compra, @prodActual = i.Cod_Produc, @cantActual = i.Cantidad from inserted i
--	select @estado = Estado from Compra where Cod_Compra = @compra
--	select @prodAnt = d.Cod_Produc, @cantAnt = d.Cantidad from deleted d
--	if @estado = 1
--	begin
--		if @prodActual = @prodAnt
--		begin
--			if @cantActual <> @cantAnt
--			begin
--				update Producto set Stock_Actual = Stock_Actual - @cantAnt where ID = @prodActual
--				update Producto set Stock_Actual = Stock_Actual + @cantActual where ID = @prodActual 
--			end
--		end
--		else
--		begin
--			update Producto set Stock_Actual = Stock_Actual - @cantAnt where ID = @prodAnt
--			update Producto set Stock_Actual = Stock_Actual + @cantActual where ID = @prodActual 
--		end
--	end
--go

/*
	TABLA DE PROMOCIONES
*/
IF OBJECT_ID('Promo') IS NOT NULL
	DROP TABLE Promo
GO

CREATE TABLE Promo(
	ID VARCHAR(6) NOT NULL,
	Cod_Prod VARCHAR(6) NOT NULL,
	Tipo INT NOT NULL,
	Valor DECIMAL(10,2) NOT NULL,
	FecIni DATE,
	FecFin DATE,
	PRIMARY KEY(ID),
	FOREIGN KEY(Cod_Prod) REFERENCES Producto(ID) 
)
GO















