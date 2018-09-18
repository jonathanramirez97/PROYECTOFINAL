package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetalleVenta {
	 private int IdDetalleVenta;
     private int IdVenta;
     private int IdMueble;
     private int Cantidad;
     private int PrecioVenta ;
     private LeerConsola leerConsola;

	public DetalleVenta()
	{
		IdDetalleVenta=0;
     IdVenta=0;
     IdMueble=0;
     Cantidad=0;
     PrecioVenta =0;
     leerConsola= new LeerConsola();
	}

	public DetalleVenta(int IdDetalleVenta, int IdVenta, int IdMueble, int Cantidad , int PrecioVenta  )
 {
     this.IdDetalleVenta=IdDetalleVenta;
     this.IdVenta=IdVenta;
     this.IdMueble=IdMueble;
     this.Cantidad=Cantidad;
     this.PrecioVenta =PrecioVenta ;
 }

	public DetalleVenta(int codigo, OperacionesSQL operacionesSQL) throws SQLException
	{
		leerConsola = new LeerConsola();

		

		String query = "SELECT *  ";
		query +=       "FROM   DetalleVenta ";
		query +=       "WHERE  IdDetalleVenta = " + codigo;

		ResultSet rs = operacionesSQL.selectSQL(query);

		if (rs.next())
		{
			this.IdDetalleVenta = rs.getInt(1);
			this.IdVenta = rs.getInt(2);
			this.IdMueble = rs.getInt(3);
			this.Cantidad = rs.getInt(4);
         this.PrecioVenta =rs.getInt(5);
			
		}
		else
		{
			this.IdDetalleVenta = 0;
			this.IdVenta=0;
         this.IdMueble=0;
         this.Cantidad=0;
         this.PrecioVenta =0;
		}

		operacionesSQL.cerrar();

	}

	public void mostrar()
	{
		if (this.IdDetalleVenta != 0)
		{
			System.out.println ("DetalleVentas:");
			System.out.println ("\tIdDetalleVenta: " + this.IdDetalleVenta);
			System.out.println ("\tIdVenta: " + this.IdVenta);
			System.out.println ("\tIdMueble: " + this.IdMueble);
			System.out.println ("\tCantidad: " + this.Cantidad);
         System.out.println ("\tPrecioVenta : " + this.PrecioVenta );
		}
	}

	public void leerDatos()
	{
		System.out.println ("Ingrese los datos de un DetalleVenta:");

		

		this.IdVenta =leerConsola.LeerEnteros("\tIdVenta: ", 1, 100);
		this.IdMueble = leerConsola.LeerEnteros("\tIdMueble: ", 1, 100);
		this.Cantidad = leerConsola.LeerEnteros("\tCantidad: ", 1, 100);
     this.PrecioVenta  = leerConsola.LeerEnteros("\tPrecioVenta: ", 1,100);;
	}

	
	public void setIdVenta(int IdVenta)
	{
		this.IdVenta = IdVenta;
	}
 
 public void setIdMueble(int IdMueble)
 {
     this.IdMueble=IdMueble;
 }
 
 public void setCantidad(int Cantidad)
 {
     this.Cantidad=Cantidad;
 }

 public void setPrecioVenta (int PrecioVenta )
 {
     this.PrecioVenta =PrecioVenta ;
 }

	public int getIdDetalleVenta()
	{
		return this.IdDetalleVenta;
	}
	
	public int getIdVenta()
	{
		return this.IdVenta;
	}

 public int getIdMueble()
 {
     return this.IdMueble;
 }

 public int getCantidad()
 {
     return this.Cantidad;
 }

 public int getPrecioVenta ()
 {
     return this.PrecioVenta ;
 }

	public void insertar(OperacionesSQL miSQL) throws SQLException
	{

		String query = "INSERT INTO DetalleVenta ";
		query +=       "SET    IdVenta = '" + this.getIdVenta() + "', ";
		query +=       "       IdMueble = '" + this.getIdMueble() + "', ";
		query +=       "       Cantidad = '" + this.getCantidad() + "', ";
        query +=       "       PrecioVenta  = '" + this.getPrecioVenta ()+ "' ";

		miSQL.InsertarNuevo(query);

	}

}
