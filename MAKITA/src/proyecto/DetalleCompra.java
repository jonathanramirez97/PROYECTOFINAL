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

	public DetalleCompra( OperacionesSQL operacionesSQL) throws SQLException
	{
		leerConsola = new LeerConsola();

		

		String query = "SELECT *  ";
		query +=       "FROM   DetalleCompra ";

		ResultSet rs = operacionesSQL.selectSQL(query);
		try
		{
		while (rs.next())
		{
			this.IdDetalleCompra = rs.getInt(1);
			this.IdCompra = rs.getInt(2);
			this.IdMueble = rs.getInt(3);
			this.Cantidad = rs.getInt(4);
           this.PrecioCompra =rs.getInt(5);
			mostrar();
		}
		}
		catch(Exception e)
		{
			this.IdDetalleCompra = 0;
			this.IdCompra=0;
           this.IdMueble=0;
           this.Cantidad=0;
           this.PrecioCompra =0;
		}

		operacionesSQL.cerrar();

	}

	public void mostrar()
	{
		if (this.IdDetalleCompra != 0)
		{
			System.out.println ("DetalleCompras:");
			System.out.println ("\tIdDetalleCompra: " + this.IdDetalleCompra);
			System.out.println ("\tIdCompra: " + this.IdCompra);
			System.out.println ("\tIdMueble: " + this.IdMueble);
			System.out.println ("\tCantidad: " + this.Cantidad);
           System.out.println ("\tPrecioCompra : " + this.PrecioCompra );
		}
	}

	public void leerDatos()
	{
		System.out.println ("Ingrese los datos de un DetalleCompra:");

		
		this.IdCompra =leerConsola.LeerEnteros("\tIdCompra: ", 1, 100);;
		this.IdMueble = leerConsola.LeerEnteros("\tIdMueble: ", 1, 100);;
		this.Cantidad = leerConsola.LeerEnteros("\tCantidad: ", 1, 100);;
       this.PrecioCompra  = leerConsola.LeerEnteros("\tPrecioCompra: ", 1,100);;
	}

	
	public void setIdCompra(int IdCompra)
	{
		this.IdCompra = IdCompra;
	}
   
   public void setIdMueble(int IdMueble)
   {
       this.IdMueble=IdMueble;
   }
   
   public void setCantidad(int Cantidad)
   {
       this.Cantidad=Cantidad;
   }

   public void setPrecioCompra (int PrecioCompra )
   {
       this.PrecioCompra =PrecioCompra ;
   }

	public int getIdDetalleCompra()
	{
		return this.IdDetalleCompra;
	}
	
	public int getIdCompra()
	   {
	       return this.IdCompra;
	   }

   public int getIdMueble()
   {
       return this.IdMueble;
   }

   public int getCantidad()
   {
       return this.Cantidad;
   }

   public int getPrecioCompra ()
   {
       return this.PrecioCompra ;
   }
  
	public void insertar(OperacionesSQL miSQL) throws SQLException
	{

		String query = "INSERT INTO DetalleCompra ";
		query +=       "SET    IdCompra = '" + this.getIdCompra() + "', ";
		query +=       "       IdMueble = '" + this.getIdMueble() + "', ";
		query +=       "       Cantidad = '" + this.getCantidad() + "', ";
       query +=       "       PrecioCompra  = '" + this.getPrecioCompra ()+ "' ";

		miSQL.InsertarNuevo(query);

	}

}
