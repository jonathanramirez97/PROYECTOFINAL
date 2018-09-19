package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoMueble {
	   private int IdTipoMueble;
       private String Nombre;
       private String Descripcion;
       private LeerConsola leerConsola;

	public TipoMueble()
	{
		IdTipoMueble=0;
       Nombre="";
       Descripcion="";
       leerConsola= new LeerConsola();
	}

	public TipoMueble(int IdTipoMueble, String Nombre, String Descripcion )
   {
       this.IdTipoMueble=IdTipoMueble;
       this.Nombre=Nombre;
       this.Descripcion=Descripcion;
   }

	public TipoMueble( OperacionesSQL operacionesSQL) throws SQLException
	{
		leerConsola = new LeerConsola();

		

		String query = "SELECT *  ";
		query +=       "FROM   tipomuebles ";

		ResultSet rs = operacionesSQL.selectSQL(query);
		
		try
		{
		while (rs.next())
		{
			this.IdTipoMueble = rs.getInt(1);
			this.Nombre = rs.getString(2);
			this.Descripcion = rs.getString(3);
			mostrar();
		}
		}
		catch(Exception e)
		{
			this.IdTipoMueble = 0;
			this.Nombre="";
           this.Descripcion="";
		}
		

		operacionesSQL.cerrar();

	}

	public void mostrar()
	{
		if (this.IdTipoMueble != 0)
		{
			System.out.println ("TipoMueble:");
			System.out.println ("\tIdTipoMueble: " + this.IdTipoMueble);
			System.out.println ("\tNombre: " + this.Nombre);
			System.out.println ("\tDescripcion: " + this.Descripcion);
		}
	}

	public void setNombre(String Nombre)
	{
		this.Nombre = Nombre;
	}
   
   public void setDescripcion(String Descripcion)
   {
       this.Descripcion=Descripcion;
   }

	public int getIdTipoMueble()
	{
		return this.IdTipoMueble;
	}

   public String getNombre()
   {
       return this.Nombre;
   }
   public String getDescripcion()
   {
       return this.Descripcion;
   }

}
