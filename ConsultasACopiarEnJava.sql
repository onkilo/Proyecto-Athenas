select v.Cod_Venta as Venta, c.ID as CodCliente, c.DNI as DNI, c.Nombre as NomCliente, c.Apellido as ApeCliente, c.Telefono as Telefono, t.ID as CodTrab, 
t.Nombre as NomTrab, t.Apellido as ApeTrab, v.Fecha as Fecha, v.IGV as IGV, isnull(v.DescTotal, 0) as DescTotal, sum(dv.Precio * dv.Cantidad) as Subtotal
from Venta v inner join Cliente c 
on v.Cod_Cliente = c.ID inner join Trabajador t 
on v.Cod_Trabajador = t.ID inner join Det_Venta dv
on v.Cod_Venta = dv.Cod_Venta
group by v.Cod_Venta, c.ID,c.DNI, c.Nombre, c.Apellido, c.Telefono, t.ID, t.Nombre, t.Apellido, v.Fecha, v.IGV, isnull(v.DescTotal, 0)
go

select dv.Cod_Venta as Venta, p.ID as CodPRod, p.Descripcion as DescProd, dv.Cantidad as Cantidad, dv.Precio as Precio, isnull(dv.Desct, 0) as DescUni from Det_Venta dv inner join Producto p on dv.Cod_Produc = p.ID
go

update Venta set DescTotal = 0.5 where Cod_Venta = 'OV0002'
go

SELECT * FROM Promo inner join Producto on Promo.Cod_Prod = Producto.id
go

select case pm.Tipo
		when 0 then pm.Valor
		when 1 then pd.Precio_Venta * (pm.Valor/100)
		end
from Promo pm inner join Producto pd 
on pd.ID = pm.Cod_Prod
where Cod_Prod = 'PR0010' and GETDATE() between FecIni and FecFin
go

select * from Det_Comp
go
SELECT * FROM Compra
GO

select oc.Cod_Compra as Compra, oc.Fecha as Fecha, oc.IGV as IGV, oc.Estado as Estado, t.ID as CodTrab, t.Nombre as NomTrab, t.Apellido as ApeTrab, pv.ID as CodProv, pv.Direccion as DirProv, pv.Rz_Social as RZProv, pv.Telefono as TelProv, sum(dc.Cantidad * dc.Precio) as Subtotal  from Compra oc inner join Det_Comp dc on oc.Cod_Compra = dc.Cod_Compra inner join Trabajador t on oc.Cod_Trabajador = t.ID inner join Proveedor pv on oc.Cod_Proveedor = pv.ID group by oc.Cod_Compra, oc.Fecha, oc.IGV, oc.Estado, t.ID , t.Nombre, t.Apellido, pv.ID, pv.Direccion, pv.Rz_Social, pv.Telefono
go

select dc.Cod_Compra as Compra, p.ID as Producto, p.Descripcion as ProdDesc, dc.Cantidad as Cantidad, dc.Precio as Precio  from Det_Comp dc inner join Producto p on dc.Cod_Produc = p.ID
GO

DECLARE @COD VARCHAR(10) = '7'
EXEC USP_NextCod @COD OUT
PRINT @COD
SELECT MAX(Cod_Compra) FROM Compra