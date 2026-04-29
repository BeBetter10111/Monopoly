package com.monopoly.model.player;

import com.monopoly.interfaces.IPlayer;
import com.monopoly.model.tile.PropertyTile;

public abstract class Player implements IPlayer { /* đóng vai trò là lớp cha, abstract dùng để đảm bảo không thể khời
 tạo trực tiếp mà thông qua lớp con*/
    protected String name;
    protected int balance;
    protected int position;
    protected static final int GoBonus = 200; //đảm bảo player nhận đc $200 if đi qua hoặc ừng tại ô Go

    public Player(String name, int initialBalance) {
        this.name = name;
        this.balance = initialBalance; // lưu số tiền ban đầu
        this.position = 0; // lưu địa chỉ ban đầu
    }

    public abstract void takeTurn(int dice1, int dice2); /* dựa vào cách hành động của từng loại người chơi, subclass
    bắt buộc phải override cái method này */

    public abstract void onLandDecision(PropertyTile property, boolean wantToBuy);

    @Override
    public int getBalance() {

        return balance; //trả về giá trị của balance
    }

    @Override
    public void move(int step) {
        int oldPosition = position; // kiểm tra vị trí cũ
        int newPosition = (position + step) % 40; // tính vị trí mới, nếu vị trí vượt quá 40 thì lấy số dư
        boolean passGo = (position + step) >= 40; // kiểm tra có vượt qua ô Go không
        this.position = newPosition; // cập nhật vi trí mới
        System.out.println(name + "move " + step + "steps to position: " + position);
        if (passGo) {
            this.balance += GoBonus;
            System.out.println("Player " + name + "passed Go \nReceive $" + GoBonus + "\nBalance: " + balance);
        }
    }

    public void addBalance(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Player: " + name + "added a new balance of " + amount + "\nBalance: " + balance);
        }
    }

    public boolean deductBalance(int amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Player: " + name + "deducted a balance of " + amount + "\nBalance: " + balance);
            return true;
        }
        System.out.println("Player: " + name + "does not have enough money to deduct");
        return false;
    }

    public String getName() {

        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isBankrupt() {

        return balance < 0;
    }

    @Override
    public String toString() {
        return "Player: " + name + "\nBalance: " + balance + "\nPosition: " + position;
    }
}

