
package viajeros2;
public class database {
    //PARA LA DB DE LA EXPOCICION double[][]valores1=new double[5][3];
    double[][]valores1=new double[5][3];
    double[]errores=new double[5];
    public double[] funcion(double[][] x, int agente,int var, int pob){
        double[]resultado= new double[pob];
        int z=0;
        //System.out.print("---------ERROR-------\n");
        for(int w=0;w<agente;w++){
                resultado[w]=(10*(Math.pow((x[w][z]-1),2)))+(20*(Math.pow((x[w][z+1]-2),2)))+(30*((Math.pow((x[w][z+2]-3),2))));
                
                //System.out.print(resultado[w]+" \n");
                errores[w]=resultado[w];      
        }
        //System.out.print("---------ERROR-------\n");
        /*
        System.out.print("---------ERROR-------\n");
       for(int w=0;w<agente;w++){
           resultado[w]=1+2*(x[w][z])-Math.pow(x[w][z+1],2);
           System.out.print(resultado[w]+" \n");
           errores[w]=resultado[w];
       }
       System.out.print("---------ERROR-------\n");
       */
        return resultado;
    }
    
    public double funcionP(double[][] x, int pos){
        double resultado=0;
        int z=0;
        /*
       
            
                //System.out.print("\n");
         resultado=1+2*(x[pos][z])-Math.pow(x[pos][z+1],2);
                
                //System.out.print("X1: "+x[w][z]+" X2: "+x[w][z+1]+ " X3: "+x[w][z]);
                
        
        */
        resultado=(10*(Math.pow((x[pos][z]-1),2)))+(20*(Math.pow((x[pos][z+1]-2),2)))+(30*((Math.pow((x[pos][z+2]-3),2))));
          
       
       
        return resultado;
    }
    public double funciong(double[]x){
       double resultado=0;
        int z=0;
        resultado=(10*(Math.pow((x[z]-1),2)))+(20*(Math.pow((x[z+1]-2),2)))+(30*((Math.pow((x[z+2]-3),2))));
        return resultado; 
    }
    public int variablescant(){
        int variables=3;
        return variables;
    }
    public double constante1(){
        return 2;
    }
    public double constante2(){
        return 2;
    }
    public double[] get_errores(){
        return errores;
    }
    public int PopulationSize(){
        int variables=5;
        return variables;
    }
    public double[][] iniciarPoblacion(){
        double[]LB=new double[variablescant()];
        double[]UB=new double[variablescant()];
        double[][]Valores=new double[PopulationSize()][variablescant()];
        
        int x=variablescant();
        int y=PopulationSize();
        for(int q=0;q<x;q++){
            LB[q]=0;
            
        }
        for(int q=0;q<x;q++){
            UB[q]=10;
            
        }
       
        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                Valores[i][j]=Math.round(LB[j]+(Math.random()*(UB[j]-LB[j])));
                //System.out.print(Valores[i][j]+" ");
            }
            //System.out.print("\n");
        }
        System.out.print("-----------\n");
        valores1=Valores;
        return Valores;
    }
    public double[][]get_valores(){
        return valores1;
    }
}
