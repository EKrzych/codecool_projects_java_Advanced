package com.codecool;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ships {

    public List<BattleShip> generateBattleShips(int [][]ships) {
        return Arrays.stream(ships).map(s -> new BattleShip(s[0],s[1],s[2])).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int [][] input = {{1,2,3},{4,5,6},{5,6,7}};
        Ships ships = new Ships();
        System.out.println(ships.generateBattleShips(input));

    }
}
