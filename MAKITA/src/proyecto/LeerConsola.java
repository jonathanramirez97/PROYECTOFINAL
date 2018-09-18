package proyecto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LeerConsola {
	
	public int NoNulo=1;
    public int Nulo=0;
    public LeerConsola()
    {
        NoNulo = 1;
        Nulo = 0;
    }

     public String LeerCadena(String cadena, int tipoEntrada)
	    {
    	  
		    Scanner IngresarCadena = new Scanner(System.in);
		    System.out.print (cadena);
         String ValorCadena = null;
		    ValorCadena = IngresarCadena.nextLine();

		    return ValorCadena;
	    }
     public int LeerEnteros(String valor, int LimiteInferior, int LimiteSuperior)
	    {
		    Scanner IngresarEntero = new Scanner(System.in);
		    System.out.print (valor);
         int ValorEntero = 0;
		    ValorEntero = IngresarEntero.nextInt();
		    IngresarEntero.nextLine();
		    return ValorEntero;
	    }


}
