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

	public DetalleCompra(int IdDetalleCompra, int IdCompra, int IdMueble, int Cantidad , int PrecioCompra  )
   {
       this.IdDetalleCompra=IdDetalleCompra;
       this.IdCompra=IdCompra;
       this.IdMueble=IdMueble;
       this.Cantidad=Cantidad;
       this.PrecioCompra =PrecioCompra ;
   }

	public DetalleCompra(int codigo, OperacionesSQL operacionesSQL) throws SQLException
	{
		leerConsola = new LeerConsola();

		

		String query = "SELECT *  ";
		query +=       "FROM   DetalleCompra ";
		query +=       "WHERE  IdDetalleCompra = " + codigo;

		ResultSet rs = operacionesSQL.selectSQL(query);

		if (rs.next())
		{
			this.IdDetalleCompra = rs.getInt(1);
			this.IdCompra = rs.getInt(2);
			this.IdMueble = rs.getInt(3);
			this.Cantidad = rs.getInt(4);
           this.PrecioCompra =rs.getInt(5);
			
		}
		else
		{
			this.IdDetalleCompra = 0;
			this.IdCompra=0;
           this.IdMueble=0;
           this.Cantidad=0;
           this.PrecioCompra =0;
		}

		operacionesSQL.cerrar();

	}
