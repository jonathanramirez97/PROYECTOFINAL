package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Compra {
	
	private int IdCompra;
    private String Fecha;
    private int MontoTotal ;
    private int IdProveedor ;
    private int IdEmpleado ;
    private LeerConsola leerConsola;

public Compra()
{
	IdCompra=0;
    Fecha="";
    MontoTotal =0;
    IdProveedor =0;
    IdEmpleado =0;
    leerConsola= new LeerConsola();
}
