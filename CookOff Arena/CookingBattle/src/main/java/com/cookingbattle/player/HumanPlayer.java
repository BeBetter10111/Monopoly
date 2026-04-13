package main.java.cooking.player;
import main.java.cooking.doman.Dish;
import main.java.cooking.domain.Recipe; // dung domain object
import java.util.Scanner; // doc tu ban phim
public class HumanPlayer implements IPlayer  { //dung method cua IPLayer
    private String name;
    private int score;
    private int wins;
    private int loses; //khai bao
    public HumanPlayer(String name){
        this.name = name; //gan gia tri tham so name vao thuoc tinh name
        this.score = 0; // diem ban dau
        this.wins = 0; // so luot thang thua
        this.loses = 0;
    }
    @Override // ghi de
    public String getName(){ // tra ve ten nguoi choi
        return name;
    }
    @Override
    public int getScore(){ //lay diem so va tra ve gia tri score
        return score;
    }
    public int getWins(){ //so tran thang
        return wins;
    }
    public int getLoses(){ // so tran thua
        return loses;
    }
    @Override
    public void addScore(int points /* so diem can cong them*/){
        this.score += points; //cong points vao score
    }
    public void addWin(){ // so tran thang tang them 1
        this.wins++;
    }
    public void addLoss(){ // so tran thua tang them 1
        this.loses++;
    }
    @Override
    public void resetScore(){ //reset diem ve 0 khi lam tran moi
        this.score = 0;
    }
    @Override
    public Dish cook(Recipe recipe){ // nhan vao cong thuc, tra ra mon an da nau xong
        return null;
    }
}
