public class Campo {
    
    private int tamanhoX;
    private int tamanhoY;
    private Barra barras[];
    private Bola bola;
    private int parede;
    
    public int getTamanhoX(){
        return this.tamanhoX;
    }
    
    public int getTamanhoY(){
        return this.tamanhoY;
    }
    
    public int getParede(){
        return this.parede;
    }
    
    public Bola getBola(){
        return this.bola;
    }
    
    public byte getAngulacao(int x, int y){
        
        int lugar = 0;
        
        for( int i=0 ; i<this.barras.length ; i++ ){
            if( this.barras[i].getX() == x){
                if(this.barras[i].getY() == y){
                    lugar = i;
                    break;
                }
            }
        }
        return this.barras[lugar].getAngulacao();
    }
    
    public void setBarrasVisivel(boolean visivel){
        for( int i=0 ; i<this.barras.length ; i++){
            this.barras[i].setVisivel(visivel);
        }
    }
    
    public void tornarVisivel(int x, int y){
        this.barras[this.temNoCampo(this.barras.length, x, y)].setVisivel(true);
    }
    
    public void moveBola(){
        this.bola.moveBola();
    }
    
    public void moveBola(byte a){
        this.bola.moveBola(a);
    }
    
    public Campo(int tX, int tY, int quantidadeDeBarras){
        this.tamanhoX = tX;
        this.tamanhoY = tY;
        barras = new Barra[quantidadeDeBarras];
        bola = new Bola();
    }
    
    public int temNoCampo(int ate, int x, int y){
        
        int retorno = -1;
        
        for( int i=0 ; i<ate ; i++ ){
            if( this.barras[i].getX() == x){
                if(this.barras[i].getY() == y){
                    retorno = i;
                    break;
                }
            }
        }
        return retorno;
    }
    
    public void fazerCampo(int minBatidas, int maxBatidas){
        
        int batidas = -2;
        int x = 0;
        int y = 0;
        int p = 0;
        
        while(batidas<minBatidas || batidas>maxBatidas){
            batidas = 0;
            for( int i=0 ; i<this.barras.length ; i++ ){
                x = (int)(Math.random()*this.tamanhoX);
                y = (int)(Math.random()*this.tamanhoY);
                while(this.temNoCampo(i, x, y) != -1){
                    x = (int)(Math.random()*this.tamanhoX);
                    y = (int)(Math.random()*this.tamanhoY);
                }
                byte a = (byte)(Math.random()*2);
                this.barras[i] = new Barra(a, x, y); 
            }
            p = (int)(Math.random()*4);
            int vP;
            if(p==0 || p==2){
                vP = (int)(Math.random()*this.tamanhoX);
            }
            else{
                vP = (int)(Math.random()*this.tamanhoY);
            }
            this.parede = p;
            for( int i=0 ; i<2 ; i++){
                p += 1;
                if(p == 4){
                    p=0;
                }
            }
            this.bola.setDirecao(p);
            switch(this.parede){
                case(0): 
                    this.bola.setX(0);
                    this.bola.setY(vP);
                    break;
                case(1): 
                    this.bola.setX(vP);
                    this.bola.setY(this.tamanhoY-1);
                    break;
                case(2): 
                    this.bola.setX(this.tamanhoX-1);
                    this.bola.setY(vP);
                    break;
                case(3): 
                    this.bola.setX(vP);
                    this.bola.setY(0);
                    break;
            }
            x = this.bola.getX();
            y = this.bola.getY();
            while(this.bola.getX()>-1 && this.bola.getX()<this.getTamanhoX() && 
                    this.bola.getY()>-1 && this.bola.getY()<this.getTamanhoY()){

                if(this.temNoCampo(this.barras.length, this.bola.getX(), this.bola.getY()) == -1){
                    this.moveBola();
                }
                else{
                    this.moveBola(this.getAngulacao(this.bola.getX(), this.bola.getY()));
                    batidas += 1;
                }
            }
            
        }
        this.bola.setX(x);
        this.bola.setY(y);
        this.bola.setDirecao(p);
        
    }
    
    public void mostrarCampo(boolean start, boolean bolinha){
        
        int x = 0;
        int y = 0;
        
        if(start == false){
            switch(this.parede){
                case(0): 
                    x = 1;
                    y = this.bola.getY()+2;
                    break;
                case(1): 
                    y = this.tamanhoY+2;
                    x = this.bola.getX()+2;
                    break;
                case(2): 
                    x = this.tamanhoX+2;
                    y = this.bola.getY()+2;
                    break;
                case(3): 
                    y = 1;
                    x = this.bola.getX()+2;
                    break;
            }
        }
        else{
            x = this.bola.getX() + 2;
            y = this.bola.getY() + 2;
        }
        for( int i=0 ; i<this.tamanhoX+4 ; i++ ){
            for( int j=0 ; j<this.tamanhoY+4 ; j++ ){
                if( ((i == 0 || i == this.tamanhoX+3) && (j>1 && j<this.tamanhoY+2))
                        || ((j == 0 || j == this.tamanhoY+3) && (i>1 && i<this.tamanhoY+2)) ){
                    System.out.print(" o");
                }
                else if( i == x && j == y && bolinha == true){
                    System.out.print(" o");
                }
                else if( (i == 1 && j == 1)
                        || (i == 1 && j == this.tamanhoY+2)
                        || (i == this.tamanhoX+2 && j == 1)
                        || (i == this.tamanhoX+2 && j == this.tamanhoY+2)){
                    System.out.print("  ");
                }
                else if (i == 1 || i == this.tamanhoX+2){
                    System.out.print(" -");
                }
                else if(j == 1 || j == this.tamanhoY+2){
                    System.out.print(" |");
                }
                else if(this.temNoCampo(this.barras.length, i-2, j-2) != -1 && this.barras[this.temNoCampo(this.barras.length, i-2, j-2)].getVisivel()){
                    if(this.barras[this.temNoCampo(this.barras.length, i-2, j-2)].getAngulacao() == 0){
                        System.out.print(" \\");
                    }
                    else{
                        System.out.print(" /");
                    }
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    
    }
    
}
