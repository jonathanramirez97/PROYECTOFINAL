package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mueble {
	
	private int IdMueble;
    private String NombreMueble;
    private String AltoMueble;
    private String AnchoMueble;
    private String ProfundidadMueble;
    private String ColorMueble;
    private int TipoMueble;
    private LeerConsola leerConsola;

public Mueble()
{
	this.IdMueble=0;
    this.NombreMueble="";
    this.AltoMueble="";
    this.AnchoMueble="";
    this.ProfundidadMueble="";
    this.ColorMueble="";
    this.TipoMueble=0;
    leerConsola= new LeerConsola();
}

public Mueble(int IdMueble, String NombreMueble, String AltoMueble, String AnchoMueble, String ProfundidaMueble, String ColorMueble, int TipoMueble )
{
    this.IdMueble=IdMueble;
    this.NombreMueble=NombreMueble;
    this.AltoMueble=AltoMueble;
    this.AnchoMueble=AnchoMueble;
    this.ProfundidadMueble=ProfundidaMueble;
    this.ColorMueble=ColorMueble;
    this.TipoMueble=TipoMueble;
}

public Mueble( OperacionesSQL operacionesSQL) throws SQLException
{
	leerConsola = new LeerConsola();



	String query = "SELECT *  ";
	query +=       "FROM   Muebles ";

	ResultSet rs = operacionesSQL.selectSQL(query);

	try
	{
	while (rs.next())
	{
		this.IdMueble = rs.getInt(1);
		this.NombreMueble = rs.getString(2);
		this.AltoMueble = rs.getString(3);
		this.AnchoMueble = rs.getString(4);
		this.ProfundidadMueble = rs.getString(5);
		this.ColorMueble = rs.getString(6);
		this.TipoMueble = rs.getInt(7);
		mostrar();
	}
	}
	catch (Exception e)
	{
		this.IdMueble = 0;
		this.NombreMueble = "";
		this.AltoMueble = "";
		this.AnchoMueble = "";
		this.ProfundidadMueble = "";
		this.ColorMueble = "";
		this.TipoMueble = 0;
	}

	operacionesSQL.cerrar();

}

public void mostrar()
{
	if (this.IdMueble != 0)
	{
		System.out.println ("Mueble:");
		System.out.println ("\tIdMueble: " + this.IdMueble);
		System.out.println ("\tNombreMueble: " + this.NombreMueble);
		System.out.println ("\tAltoMueble: " + this.AltoMueble);
		System.out.println ("\tAnchoMueble: " + this.AnchoMueble);
		System.out.println ("\tProfundidaMueble: " + this.ProfundidadMueble);
		System.out.println ("\tColorMueble: " + this.ColorMueble);
		System.out.println ("\tTipoMueble: " + this.TipoMueble);
	}
}

public void leerDatos()
{
	System.out.println ("Ingrese los datos de un Mueble:");

	

	this.NombreMueble =leerConsola .LeerCadena("\tNombreMueble: ", leerConsola.NoNulo);
	this.AltoMueble = leerConsola .LeerCadena("\tAltoMueble: ", leerConsola.NoNulo);
	this.AnchoMueble = leerConsola .LeerCadena("\tAnchoMueble: ", leerConsola.NoNulo);
    this.ProfundidadMueble = leerConsola .LeerCadena("\tProfundidaMueble: ", leerConsola.NoNulo);
    this.ColorMueble = leerConsola .LeerCadena("\tColorMueble: ", leerConsola.NoNulo);
	this.leerTipoMueble();
}

private void leerTipoMueble()
{
	this.TipoMueble = leerConsola.LeerEnteros("\tTipoMueble: ", 1, 5);		
}

public void setNombreMueble(String NombreMueble)
{
	this.NombreMueble = NombreMueble;
}

public void setAltoMueble(String AltoMueble)
{
    this.AltoMueble=AltoMueble;
}
public void setAnchoMueble(String AnchoMueble)
{
    this.AnchoMueble=AnchoMueble;
}

public void setProfundidaMueble(String ProfundidadMueble)
{
    this.ProfundidadMueble=ProfundidadMueble;
}

public void setColorMueble(String ColorMueble)
{
    this.ColorMueble=ColorMueble;
}

public void setTipoMueble(int TipoMueble)
{
    this.TipoMueble=TipoMueble;
}

public int getIdMueble()
{
	return this.IdMueble;
}

public String getNombreMueble()
{
    return this.NombreMueble;
}

public String getAltoMueble()
{
    return this.AltoMueble;
}

public String getAnchoMueble()
{
    return this.AnchoMueble;
}

public String getProfundidaMueble()
{
    return this.ProfundidadMueble;
}

public String getColorMueble()
{
    return this.ColorMueble;
}

public int getTipoMueble()
{
    return this.TipoMueble;
}

public void insertar(OperacionesSQL miSQL) throws SQLException
{

	

	String query = "INSERT INTO Muebles ";
	query +=       "SET    Nombre = '" + this.getNombreMueble() + "', ";
	query +=       "       Alto = '" + this.getAltoMueble() + "', ";
	query +=       "       Ancho = '" + this.getAnchoMueble() + "', ";
	query +=       "       Profundidad = '" + this.getProfundidaMueble() + "', ";
	query +=       "       Color = '" + this.getColorMueble() + "', ";
	query +=       "       IdTipoMueble = '" + this.getTipoMueble() + "' ";

	miSQL.InsertarNuevo(query);


}
}
