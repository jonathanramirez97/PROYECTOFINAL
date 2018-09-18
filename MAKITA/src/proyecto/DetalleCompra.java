package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetalleCompra {
	   private int IdDetalleCompra;
       private int IdCompra;
       private int IdMueble;
       private int Cantidad;
       private int PrecioCompra ;
       private LeerConsola leerConsola;

	public DetalleCompra()
	{
		IdDetalleCompra=0;
       IdCompra=0;
       IdMueble=0;
       Cantidad=0;
       PrecioCompra =0;
       leerConsola= new LeerConsola();
	}
