package viajeros2;
import jade.core.behaviours.*;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class viajero extends Agent{

int iteracion=1,pos=0;//La variable iteracion controla cuantas veces se ejecuta el proceso
double gbest=1000000;//Valor inicial del global best para poder comparar, se actualiza al menor valor que exista
operaciones proceso= new operaciones();
database datos=new database();
int x=datos.variablescant();//Obtiene los valores fijos en la database
int y=datos.PopulationSize();//Obtiene los valore fijos en la database

double[][] valores= new double[x][y];//matriz donde se guardara el valor de cada particula
double[] error=new double[datos.PopulationSize()];//Una vez iterados los valores de las particulas en la funcion a optimizar, sera aqui donde se guarden los resultados
    protected void setup() {
    addBehaviour(new MyCyclicBehaviour());
  } 
  private class MyCyclicBehaviour extends CyclicBehaviour {
        
    
    public void action() {
        
        datos.iniciarPoblacion();//se encarga de dar inicio a los valores randoms iniciales
        int agente=datos.PopulationSize();
        int mejor=0;//Guarda la posicion del global best
        double Wmax=0.5,Wmin=0.1,c1=datos.constante1(),c2=datos.constante2();
        if(iteracion==1){
                    System.out.print("ITERACION: "+iteracion+"\n");
                    valores=datos.get_valores();//Aqui se actualiza por primera y unica vez la posicion de las particulas desde la database
                    valores=proceso.primeraiteracion(valores,agente,x);//esto solo se ejecuta en la primera iteracion
                    error=datos.funcion(valores,agente,x,y);//una vez obtenida las posiciones actualizadas se iteran en la funcion a optimizar y guardo los resultados
        }else{
                    System.out.print("ITERACION: "+iteracion+"\n");
                    gbest comp=new gbest();
                    pos=comp.gbest2(pos, error);//Obtiene la posicion de la particula con el valor "error" menos, siendo este la particula con el gbest(solo se usa 1 vez)
                    mejor=pos;
                    proceso.actualizar_vel(mejor, agente, x, c1, c2, valores,Wmax,Wmin);//con el gbest conocido este se actualiza
                    valores=proceso.actualizar_pos(valores, agente, x);//se actualizan las posiciones sumando la velocidad actualizada
                    
                    for(int x1=0;x1<agente;x1++){
                        for(int y1=0;y1<x;y1++){
                            System.out.print(valores[x1][y1]+" ");
                        }
                        System.out.print("\n ");
                    }
                    
        }
        
        iteracion+=1;
        if(iteracion==250){
            pos=proceso.part;
            double[]respuesta=new double[x];
            double res=0;
            res=proceso.respuesta2();
            respuesta=proceso.respuesta();
            System.out.print("\n----------RESPUESTA--------\n");
            for(int w=0;w<x;w++){
                System.out.print(respuesta[w]+" ");
            }
            System.out.print("\n GBest: "+res);
            onEnd();
        }
    }
    
    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
    
  }
  }
/*
Este trabajo se merece un 8 siono?, tal vez no sea el trabajo honesto qwq, si pase?

*/
