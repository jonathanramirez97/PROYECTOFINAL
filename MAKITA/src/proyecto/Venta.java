package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Venta {
	 private int IdVenta;
     private String Fecha;
     private int MontoTotal ;
     private int IdCliente ;
     private int IdEmpleado ;
     private LeerConsola leerConsola;

	public Venta()
	{
		IdVenta=0;
     Fecha="";
     MontoTotal =0;
     IdCliente =0;
     IdEmpleado =0;
     leerConsola= new LeerConsola();
	}

	public Venta(int IdVenta, String Fecha, int MontoTotal , int IdCliente  , int IdEmpleado  )
 {
     this.IdVenta=IdVenta;
     this.Fecha=Fecha;
     this.MontoTotal =MontoTotal ;
     this.IdCliente =IdCliente ;
     this.IdEmpleado =IdEmpleado ;
 }

	public Venta( OperacionesSQL operacionesSQL) throws SQLException
	{
		leerConsola = new LeerConsola();

		String  query = "SELECT *  ";
		query +=       "FROM   Ventas ";

		ResultSet rs = operacionesSQL.selectSQL(query);

		try
		{
		while (rs.next())
		{
			this.IdVenta = rs.getInt(1);
			this.Fecha = rs.getString(2);
			this.MontoTotal  = rs.getInt(3);
			this.IdCliente  = rs.getInt(4);
         this.IdEmpleado =rs.getInt(5);
			mostrar();
		}
		}
		catch (Exception e)
		{
			this.IdVenta = 0;
			this.Fecha="";
         this.MontoTotal =0;
         this.IdCliente =0;
         this.IdEmpleado =0;
		}

		operacionesSQL.cerrar();

	}

	public void mostrar()
	{
		if (this.IdVenta != 0)
		{
			System.out.println ("Ventas:");
			System.out.println ("\tIdVenta: " + this.IdVenta);
			System.out.println ("\tFecha: " + this.Fecha);
			System.out.println ("\tMontoTotal : " + this.MontoTotal );
			System.out.println ("\tIdCliente : " + this.IdCliente );
         System.out.println ("\tIdEmpleado : " + this.IdEmpleado );
		}
	}

	public void leerDatos()
	{
		System.out.println ("Ingrese los datos de un Venta:");

		

		this.Fecha =leerConsola .LeerCadena("\tFecha: ", leerConsola.NoNulo);
		this.MontoTotal  = leerConsola.LeerEnteros("\tMontoTotal: ", 1, 100);
		this.IdCliente  = leerConsola.LeerEnteros("\tIdCliente: ", 1, 100);
     this.IdEmpleado  = leerConsola.LeerEnteros("\tIdEmpleado: ", 1, 100);
	}

	
	public void setFecha(String Fecha)
	{
		this.Fecha = Fecha;
	}
 
 public void setMontoTotal (int MontoTotal )
 {
     this.MontoTotal =MontoTotal ;
 }
 
 public void setIdCliente (int IdCliente )
 {
     this.IdCliente =IdCliente ;
 }

 public void setIdEmpleado (int IdEmpleado )
 {
     this.IdEmpleado =IdEmpleado ;
 }

	public int getIdVenta()
	{
		return this.IdVenta;
	}

 public String getFecha()
 {
     return this.Fecha;
 }

 public int getMontoTotal ()
 {
     return this.MontoTotal ;
 }

 public int getIdCliente ()
 {
     return this.IdCliente ;
 }

 public int getIdEmpleado ()
 {
     return this.IdEmpleado ;
 }

	public void insertar(OperacionesSQL miSQL) throws SQLException
	{
		
		String query = "INSERT INTO Ventas ";
		query +=       "SET    Fecha = '" + this.getFecha() + "', ";
		query +=       "       MontoTotal  = '" + this.getMontoTotal () + "', ";
		query +=       "       IdCliente  = '" + this.getIdCliente () + "', ";
     query +=       "       IdEmpleado  = '" + this.getIdEmpleado ()+ "' ";

		miSQL.InsertarNuevo(query);
	

	}

}
