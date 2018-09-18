package proyecto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		  Principal p = new Principal();
          p.correr();

	}
	
	   private void correr() throws ClassNotFoundException, SQLException
       {
	
	       OperacionesSQL mSQL = new OperacionesSQL( "localhost","makita", "root","1234");
           mSQL.AbrirConexionBD();

           LeerConsola leerConsola= new LeerConsola();
           MostrarOpciones();

           int opcion = leerConsola.LeerEnteros("\tIngrese su opcion: ", 1, 13);

           switch(opcion)
           {
               case 1:
                   try{
                       TipoMueble tipoMueble = new TipoMueble();
                       tipoMueble.mostrar();
                   }
                   catch(Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 2:
                    try
                   {
                       Mueble mueble= new Mueble();
                        mueble.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 3:
                     try
                   {
                       Proveedor proveedor= new Proveedor();
                         proveedor.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 4:
                     try
                   {
                      Empleado empleado= new Empleado();
                         empleado.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 5:
                     try
                   {
                       Cliente cliente= new Cliente();
                       cliente.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, no existen datos registrados");
                   }
                   break;
               case 6:
                     try
                   {
                       Empleado empleado= new Empleado();
                         empleado.leerDatos();
                         empleado.insertar(mSQL);
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al registrar Empleado!");
                   }
                   break;
               case 7:
                      try
                   {
                       Proveedor proveedor= new Proveedor();
                          proveedor.leerDatos();
                          proveedor.insertar(mSQL);
                   }
                   catch(Exception e) 
                   {
                       System.out.println ("Se produció un error, al registrar Proveedor!");
                   }
                   break;
               case 8:
                      try
                   {
                       Mueble mueble= new Mueble();
                          mueble.leerDatos();
                          mueble.insertar(mSQL);
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al registrar Mueble!");
                   }
                   break;
               case 9:
                      try
                   {
                     Cliente cliente= new Cliente();
                          cliente.leerDatos();
                          cliente.insertar(mSQL);
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al registrar Cliente!");
                   }
                   break;
               case 10:
                      try
                   {
                       Compra compra= new Compra();
                       DetalleCompra detalleCompra= new DetalleCompra();
                       compra.leerDatos();
                          compra.insertar(mSQL);
                          detalleCompra.leerDatos();
                          detalleCompra.insertar(mSQL);
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al registrar la compra!");
                   }
                   break;
               case 11:
                      try
                   {
                       Venta venta= new Venta();
                          DetalleVenta detalleVenta= new DetalleVenta();
                          venta.leerDatos();
                          venta.insertar(mSQL);
                          detalleVenta.leerDatos();
                          detalleVenta.insertar(mSQL);
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al registrar venta!");
                   }
                   break;
               case 12:
                       try
                   {
                       Venta venta= new Venta();
                          DetalleVenta detalleVenta= new DetalleVenta();
                          venta.mostrar();
                          detalleVenta.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al mostrar las ventas!");
                   }
                   break;
               case 13:
                        try
                   {
                       Compra compra= new Compra();
                       DetalleCompra detalleCompra= new DetalleCompra();
                       compra.mostrar();
                          detalleCompra.mostrar();
                   }
                   catch (Exception e)
                   {
                       System.out.println ("Se produció un error, al mostrar la compra!");
                   }
                   break;
           }
	
       }

       private void MostrarOpciones()
       {
           System.out.println ("Ingrese su opción:");
		    System.out.println ("\t1.Mostrar tipo de muebles ");
	    	System.out.println ("\t2.Mostrar los Muebles " );
	    	System.out.println ("\t3.Mostrar los Proveedores: ");
	    	System.out.println ("\t4.Mostrar los Empleados " );
           System.out.println ("\t5.Mostrar los Clientes " );
           System.out.println ("\t6.Registrar Empleado " );
           System.out.println ("\t7.Registrar Proveedor" );
           System.out.println ("\t8.Registrar Mueble " );
           System.out.println ("\t9.Registrar Cliente " );
           System.out.println ("\t10.Registrar Compra " );
           System.out.println ("\t11.Registrar Venta " );
           System.out.println ("\t12.Mostrar Compra " );
           System.out.println ("\t13.Mostrar Venta " );
       }


}
