public class Bola {
    
    private int direcao;
    private int posicaoX;
    private int posicaoY;
    
    public void setDirecao(int d){
        this.direcao = d;
    }
    
    public int getX(){
        return this.posicaoX;
    }
    
    public void setX(int x){
        this.posicaoX = x;
    }
    
    public int getY(){
        return this.posicaoY;
    }
    
    public void setY(int y){
        this.posicaoY = y;
    }
    
    public void moveBola(){
        switch(this.direcao){
            case(0):
                this. posicaoX -= 1;
                break;
            case(1):
                this. posicaoY += 1;
                break;
            case(2):
                this. posicaoX += 1;
                break;
            case(3):
                this. posicaoY -= 1;
                break;
        }
    }
    
    public void moveBola(byte a){
        if(a == 0){
            switch(this.direcao){
                case(0):
                    this. posicaoY -= 1;
                    this.direcao = 3;
                    break;
                case(1):
                    this. posicaoX += 1;
                    this.direcao = 2;
                    break;
                case(2):
                    this. posicaoY += 1;
                    this.direcao = 1;
                    break;
                case(3):
                    this. posicaoX -= 1;
                    this.direcao = 0;
                    break;
            }
        }
        else{
            switch(this.direcao){
                case(0):
                    this. posicaoY += 1;
                    this.direcao = 1;
                    break;
                case(1):
                    this. posicaoX -= 1;
                    this.direcao = 0;
                    break;
                case(2):
                    this. posicaoY -= 1;
                    this.direcao = 3;
                    break;
                case(3):
                    this. posicaoX += 1;
                    this.direcao = 2;
                    break;
            }
        }
    }
    
}
