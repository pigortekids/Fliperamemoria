public class Barra {
    
    private byte angulacao;
    private int posicaoX;
    private int posicaoY;
    private boolean visivel;
    
    public Barra(byte a, int pX, int pY){
        this.angulacao = a;
        this.posicaoX = pX;
        this.posicaoY = pY;
        this.visivel = true;
    }
    
    public byte getAngulacao(){
       return this.angulacao;
    }
    
    public int getX(){
        return this.posicaoX;
    }
    
    public int getY(){
        return this.posicaoY;
    }
    
    public boolean getVisivel(){
        return this.visivel;
    }
    
    public void setVisivel(boolean visivel){
        this.visivel = visivel;
    }
      
}
