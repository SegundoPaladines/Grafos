import javax.swing.JOptionPane;
public class Cola {	

	//SEGUNDO SANTANDER PALADINES ORTIZ
	//DAVID ALEJANDRO PASAJE OJEDA
     
    private Nodo pri,ult,aux;   
    private Pila prip, nuep, auxp; 	 
    
    public Cola () {
        pri  = null;
        ult = null;
        prip = null;
    }
    
    
    public void insertar() {
    	//DISEÑAR EL METO INSERTA POR ORDEN ASCENDENTE Y SIN NODOS REPETIDOS
    	//
    	Nodo nue;
        nue = new Nodo();        
        int informacion;
        informacion = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL ITEM A AGREGAR"));        
        nue.info = informacion;
        //nue.sig = null;

        if (pri==null)
        {            
            pri = nue;
            ult = pri;
            //ult.sig = null;
        }
        else
        {
            ult.sig = nue;
            ult = nue;
        }
        ult.sig = null;
        ult.sigFam = null;
    }

	public void insertarAYSR() {
    	//METODO INSERTAR POR ORDEN ASCENDENTE Y SIN NODOS REPETIDOS
    	//
    	Nodo nue= new Nodo();        
        int informacion= Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL ITEM A AGREGAR"));        
		nue.info = informacion;
        if (pri==null)
        {            
            pri = nue;
            ult = pri;
        }
        else{
			Nodo aux_1=pri;
			boolean repetido=false;
			boolean bandera=true;

			aux = pri;
			while(aux != null){
				auxp = aux.sigFam;
				while (auxp!=null) {
					if(auxp.inf==informacion){
						repetido=true;
					}
					auxp = auxp.sigp;
				}
				aux = aux.sig;
			}

            while((bandera==true)&&(aux_1.sig!=null)){
				if(informacion==aux_1.sig.info){
					bandera=false;
					repetido=true;
				}else if((aux_1.sig.info>informacion)){
					bandera=false;
				}
				if(bandera==true){
					aux_1=aux_1.sig;
				}
			}
			if(repetido==false){
				if(pri.info==informacion){
					System.out.println("DATO "+informacion+" YA EXISTE");
				}
				else if(aux_1==pri){
					if(informacion<pri.info){
						if(ult==pri){
							ult=pri;
							nue.sig=pri;
							pri=nue;
						}else{
							nue.sig=pri;
							pri=nue;
						}
					}else{
						if(pri==ult){
							pri.sig=nue;
							ult=nue;
						}else{
							nue.sig=pri.sig;
							pri.sig=nue;
						}
					}
				}else if(aux_1==ult){
					ult.sig=nue;
					ult=nue;
				}else{
					nue.sig=aux_1.sig;
					aux_1.sig=nue;
				}
			}else{
				System.out.println("DATO "+informacion+" YA EXISTE");
			}
        }
        ult.sig = null;
        ult.sigFam = null;
    }

    
      public void insertarFamilia() {
		
      	int principal;
      	if(pri != null){
      		int informacion;
        	informacion = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE FAMILIA: "));
			//Validando.....//
			boolean repetido=false;
			aux = pri;
			while(aux != null){
				auxp = aux.sigFam;
				while (auxp!=null) {
					if(auxp.inf==informacion){
						repetido=true;
					}
					auxp = auxp.sigp;
				}
				if(informacion==aux.info){
					repetido=true;
				}
				aux = aux.sig;
			}
			//Validado :v//
        	Pila nuep;
        	nuep = new Pila();        
        	nuep.inf = informacion;	
      		
      		principal = Integer.parseInt(JOptionPane.showInputDialog(null,"PERTENECE A: "));
      		aux = pri;
      		while(aux != null && aux.info != principal){
				aux = aux.sig;
			}
			if(repetido==false){
				if(aux == null){
					System.out.println("El Nodo principal no existe.");
			  	}else{
					if(aux.sigFam == null){
						aux.sigFam = nuep;
						nuep.sigp = null;
					}
					else{

						boolean bandera=true;
						Pila pri_p=aux.sigFam;
						Pila aux_p=aux.sigFam;
						while((bandera==true)&&(aux_p.sigp!=null)){

							if(aux_p.sigp.inf>informacion){

								bandera=false;

							}
							if(bandera==true){
								aux_p=aux_p.sigp;
							}

						}
						if(pri_p==aux_p){
							if(aux.sigFam.inf>informacion){
								nuep.sigp = aux.sigFam;
								aux.sigFam = nuep;
							}else{
								nuep.sigp=aux.sigFam.sigp;
								aux.sigFam.sigp=nuep;
							}
						}else{
							nuep.sigp=aux_p.sigp;
							aux_p.sigp=nuep;
						}
					}
				}
			}else{System.out.println("El Dato "+informacion+" Ya Existe");}
      	}
    	
    }
    public void imprimir() {
        if (pri!=null)
       	{        
	        Nodo aux=pri;	        
	        System.out.println("Datos de la Cola:\n");
	        while (aux!=null) {
	            System.out.print(aux.info+" -> ");
	            aux=aux.sig;
	        }
	        System.out.println();
	        }
        else
        	System.out.println("Cola vacia.");
    }
    
     public void imprimirFamilia() {
        int principal;
        if (pri!=null)
       	{        
	        
	        principal = Integer.parseInt(JOptionPane.showInputDialog(null,"PERTENECE A: "));
      		aux = pri;
      		while(aux != null && aux.info != principal)
      			aux = aux.sig;
      		if(aux == null) 	
      			System.out.println("El Nodo principal no existe.");
      		else{
      			System.out.println("Principal: "+aux.info);
      			auxp = aux.sigFam;
      			while (auxp!=null) {
	            	System.out.println("\tfamilia: " + auxp.inf);
	            	auxp = auxp.sigp;
	        	}
      		}
       	}
      			
        else
        	System.out.println("Grafo vacio.");
    }
    
    public void imprimirGrafo() {
        
        if (pri!=null)
       	{        
	        
			System.out.println("\n\n\n___________________________________________________________\n");
      		aux = pri;
      		while(aux != null){
      			System.out.println("Principal: "+aux.info);
      			auxp = aux.sigFam;
      			while (auxp!=null) {
	            	System.out.println("\tfamilia: " + auxp.inf);
	            	auxp = auxp.sigp;
	        	}
	        	aux = aux.sig;
      		}
			  System.out.println("\n___________________________________________________________");
       	}
      			
        else
        	System.out.println("Grafo vacio.");
    }
    
    
    
    
    public static void main(String[] ar) {
    	int Opcion,dato;        
    	Cola Cola1=new Cola();
        do
        {
            Opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. INGRESAR DATOS ASCENDENTE Y SIN REPETIDOS\n"+
                    "2. INGRESAR FAMILIA DATOS ASENDENTE Y SIN REPETIDOS\n"+
                    "3. LISTAR PRINCIPAL\n"+
                    "4. LISTAR POR NODO\n"+
                    "5. LISTAR GRAFO\n"+	
                    "6. SALIR\n"+
                    "--------------------------------------------------------\n"+
                    "INGRESE LA OPCION [1 - 6]","MENU Cola",JOptionPane.QUESTION_MESSAGE));
            
            switch(Opcion)
            {
				case 1: Cola1.insertarAYSR(); break;
                case 2: Cola1.insertarFamilia();break;                
                case 3: Cola1.imprimir();break;
                case 4: Cola1.imprimirFamilia();break;
                case 5: Cola1.imprimirGrafo();break;
                case 6: System.exit(0);break;
                default: JOptionPane.showMessageDialog(null,"INGRESE UNA OPCION VALIDA \n","ERROR OPCION",JOptionPane.WARNING_MESSAGE);break;
            }
        }
        while(true); 
    }
}