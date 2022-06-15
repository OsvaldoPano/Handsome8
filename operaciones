package viajeros2;
public class operaciones {
    database datos=new database();
    int y=datos.PopulationSize();
    int x=datos.variablescant();
    int iteracion=0;
    double[][]velocidades=new double[y][x];//Aqui se guardan las velocidades de las particulas
    double[][]posicion=new double[y][x];//Los valores de la posicion de la particula
    double[][]val_viejos=new double[y][x];//Los valores viejos de la posicion de la particula, se usa para calcular el local best y el global best
    double[][]val_nuevos=new double[y][x];//Los valores nuevos de la posicion de la particula, se usa para calcular el local best y el global best
    double[]global=new double[x];// los datos de la particula que esta en el Gbest
    int part;// Numero de la particula que es el global best
    public double[][] primeraiteracion(double[][]valores,int agente,int variables){
        //[][]valores es la posicion donde esta cada part.
        //int agente es el valor del "population"
        //int variables es la cantidad de variables con las que se trabaja
        double velocidad=0.1;//La velocidad inicial
        for(int x=0;x<agente;x++){
            for(int y=0;y<variables;y++){
                velocidades[x][y]=valores[x][y]*velocidad;// Aplico Formula: v(Xn)=0.1*x(i,j) y obtengo la 1ra velocidad
                valores[x][y]=(velocidades[x][y])+valores[x][y];//Actualizo la posicion sumando la velocidad
                if(iteracion==0){
                    val_viejos[x][y]=valores[x][y];// Al ser la primera iteracion, la posicion vieja sera la actual
                }   
            }
        }
        return valores;
    }
    public void actualizar_vel(int pos,int agente,int var,double c1, double c2,double[][]valores,double wmax,double wmin){
        //int pos la posicion del "global best" obtenido despues de la primera iteracion
        //int agente es el valor del "population size"
        //int var es la cantidad de variables con las que se trabaja
        //c1 y c2 son las constantes
        
        int a=0;
        for(int x=0;x<agente;x++){
            if(iteracion==0){
              for(int y=0;y<var;y++){
                //se aplica la formula
                velocidades[x][y]=(wmax*Math.random()+wmin)*valores[x][y]+(c1*Math.random()*((valores[x][y])-valores[x][y]))+(c2*Math.random()*(valores[pos][y]-valores[x][y]));
                //el valor que tiene el gbest, le doy 1 desde aqui aleatorio para que en la siguiente iteracion tenga algo con que compararse
                global[y]=100;
            }
                
            }else{
                
                gbest esta=new gbest();
                a=esta.Lbest(val_viejos, val_nuevos, x);//Calcula cual es el local best, si el valor anterior o el nuevo
                global=esta.cal_global(val_viejos, val_nuevos, global, agente, var);// la misma logica que el anterior xd
                for(int y=0;y<var;y++){
                if(a==0){
                    velocidades[x][y]=((wmax)*valores[x][y])+(c1*Math.random()*((val_viejos[x][y])-valores[x][y]))+(c2*Math.random()*(global[y]-valores[x][y]));
                }else{
                    velocidades[x][y]=((wmax)*valores[x][y])+(c1*Math.random()*((val_nuevos[x][y])-valores[x][y]))+(c2*Math.random()*(global[y]-valores[x][y]));
                    val_viejos[x][y]=val_nuevos[x][y];//se actualiza el valor viejo al nuevo para siempre tener el valor menor
                    part=esta.pargb;//la posicion del gbest
                }
                
                }
                
            }
            
        }   
        iteracion+=1;
    }
    public double[][]actualizar_pos(double[][]valores,int agente,int var){
        for(int x=0;x<agente;x++){
            for(int y=0;y<var;y++){
                valores[x][y]=velocidades[x][y]+valores[x][y];// a las posiciones se le suma la velocidad obtenida
                    val_nuevos[x][y]=valores[x][y];
            }
            
        }
        return valores;
    }
    public double[]respuesta(){
        return global;
    }
    public double respuesta2(){
        double res=0;
        database datos=new database();
        res=datos.funciong(global);
        return res;
    }
    
    public void guardar_posicion(double[][] valores){
        posicion=valores;
    }
    public double[][] get_posicion(){
        return posicion;
    }

    
}
