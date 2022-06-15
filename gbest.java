
package viajeros2;
class gbest {
    database datos=new database();
    int condicion;
    int y=datos.PopulationSize();
    int pargb=0;
    double[]errores= new double[y];
    public void actualizar(double error,int agente){
        errores[agente]=error;
        condicion+=1;
    }
    public boolean trigger(){
        boolean valor=false;
        if(condicion==5){
            valor=true;
            condicion=0;
        }
        return valor;
    }
    public double gbest(){
        double menor=errores[0];
        for(int x=0;x<y;x++){
            if(menor>errores[x]){
                menor=errores[x];
                
            }
        }
    
        return menor;
    }
    public int gbest2(int pos, double[]errores){//Calcula el donde esta el global best
        int menor=0;
        for(int x=0;x<y;x++){
            if(errores[pos]>errores[x]){
                menor=x;
            }
        }
      return menor;  
    }
    public int Lbest(double[][]viejos,double[][]nuevos,int x){
        double esta1=datos.funcionP(nuevos, x);//se calculan los valores en la funcion
        double esta2=datos.funcionP(viejos, x);//se calculan los valores en la funcion
        //System.out.print("DATO ERROR NUEVO: "+esta1+" \n");
        //System.out.print("DATO ERROR VIEJO: "+esta2+" \n");
        int a=0;
        if(esta1<esta2){//compara cual de los 2 es menor, segun lo que salga se tomara como local best el dato anterior o el nuevo
            a=1;
        }
        return a;
    }
    public double[]cal_global(double[][]viejo,double[][]nuevo,double[]actual,int pob,int vec){
        double[]esta1=new double[pob];
        operaciones esta=new operaciones();
        double[]res=new double[vec];
        double actual1,nuevom;
        int n1=0;
        database datos=new database();
        esta1=datos.funcion(nuevo, pob, vec, pob);
        nuevom=esta1[0];
        
        for(int x=0;x<pob;x++){
            
            if(esta1[x]<nuevom){
                nuevom=esta1[x];
                n1=x;
                
                pargb=x;
            }
        }
        
        
        actual1=datos.funciong(actual);
        
        if(actual1>=nuevom){
            System.out.print("GLOBAL BEST: "+nuevom+"\n");
            for(int x=0;x<vec;x++){
                res[x]=nuevo[n1][x];
            }
        }else{
            System.out.print("GLOBAL BEST: "+actual1+"\n");
            for(int x=0;x<vec;x++){
                res[x]=actual[x];
            }
        }
        return res;
    }
}
