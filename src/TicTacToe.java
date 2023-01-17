import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TicTacToe {

    //FUNCOES GERAIS
    static String terrain(char[][] terrenos) {
        String terreno = ""; //Criação String
        for (int linha = 0; linha < terrenos.length; linha++) { //Criar linha 0 até 2
            for (int coluna = 0; coluna < terrenos[linha].length; coluna++) { //Criar coluna 0 até 2
                if(terrenos[linha][coluna] != 'X' && terrenos[linha][coluna] != '◯' ){
                    if (coluna == 0) {
                        terreno += " "+ (1+(3*linha)) +" |";
                    }
                    if (coluna == 1) {
                        terreno += " "+ (2+(3*linha)) +" |";
                    }
                    if (coluna == 2) {
                        terreno += " "+ (3+(3*linha)) +" ";
                    }
                }
                else{
                    if (coluna == 0) {
                        terreno += " "+ terrenos[linha][coluna]+ " |";
                    }
                    if (coluna == 1) {
                        terreno += " "+ terrenos[linha][coluna]+ " |";
                    }
                    if (coluna == 2) {
                        terreno += " "+ terrenos[linha][coluna]+ " ";
                    }
                }

            }
            if (linha != 2) {
                terreno += "\n" + "---+".repeat(2) + "---" + "\n";
            }
        }
        return terreno;
    }
    static void positionsBoard (char[][] terreno,int posicao, int player){
        char simbolo = 'X';
        if(player %2 == 0){
            simbolo = 'X';
        }
        else if(player %2 == 1){
            simbolo = '◯';
        }
        switch(posicao){
            case 1 :
                terreno[0][0] = simbolo;
                break;
            case 2 :
                terreno[0][1] = simbolo;
                break;
            case 3 :
                terreno[0][2] = simbolo;
                break;
            case 4 :
                terreno[1][0] = simbolo;
                break;
            case 5 :
                terreno[1][1] = simbolo;
                break;
            case 6 :
                terreno[1][2] = simbolo;
                break;
            case 7 :
                terreno[2][0] = simbolo;
                break;
            case 8 :
                terreno[2][1] = simbolo;
                break;
            case 9 :
                terreno[2][2] = simbolo;
                break;
        }
    }
    static boolean endGame (char[][]terreno,int player,String player1,String player2){
        for ( int linha = 0; linha <=2;linha++){
            int coluna = 0;
            if(terreno[linha][coluna] != '\u0000'){
                if(terreno[linha][coluna] == terreno[linha][coluna+1]&& terreno[linha][coluna+1] == terreno[linha][coluna+2]){
                    if(player %2 ==  1){
                        System.out.println("\nGANHOU o(a) " + player2 + "!!!!!\n");
                    }
                    if(player %2 ==  0){
                        System.out.println("\nGANHOU o(a) " + player1 + "!!!!!\n");
                    }
                    return true;
                }
            }
        }
        for(int coluna = 0;coluna<= 2;coluna++){
            int linha= 0;
            if(terreno[linha][coluna] != '\u0000'){
                if(terreno[linha][coluna] == terreno[linha+1][coluna]&& terreno[linha+1][coluna] == terreno[linha+2][coluna]){
                    if(player %2 ==  1){
                        System.out.println("\nGANHOU o(a) " + player2 + "!!!!!");
                    }
                    if(player %2 ==  0){
                        System.out.println("\nGANHOU o(a) " + player1 + "!!!!!");
                    }
                    return true;
                }
            }
        }
        int linha = 0;
        int coluna = 0;
        if(terreno[linha][coluna] != '\u0000') {
            if (terreno[linha][coluna] == terreno[linha + 1][coluna + 1] && terreno[linha + 1][coluna + 1] == terreno[linha + 2][coluna + 2]) {
                if(player %2 ==  1){
                    System.out.println("\nGANHOU o(a) " + player2 + "!!!!!");
                }
                if(player %2 ==  0){
                    System.out.println("\nGANHOU o(a) " + player1 + "!!!!!");
                }
                return true;
            }
        }
        coluna = 2;
        if(terreno[linha][coluna] != '\u0000') {
            if (terreno[linha][coluna] == terreno[linha + 1][coluna - 1] && terreno[linha + 1][coluna - 1] == terreno[linha + 2][coluna - 2]) {
                if(player %2 ==  1){
                    System.out.println("\nGANHOU o(a) " + player2 + "!!!!!");
                }
                if(player %2 ==  0){
                    System.out.println("\nGANHOU o(a) " + player1 + "!!!!!");
                }
                return true;
            }
        }
        return false;
    }
    static boolean isPositionValid(char[][] terreno, int posicao){
        switch(posicao){
            case 1 :
                if(terreno[0][0] == 'X' || terreno[0][0] == '◯'){
                    return false;
                }
                break;
            case 2 :
                if(terreno[0][1] == 'X' || terreno[0][1] == '◯'){
                    return false;
                }
                break;
            case 3 :
                if(terreno[0][2] == 'X' || terreno[0][2] == '◯'){
                    return false;
                }
                break;
            case 4 :
                if(terreno[1][0] == 'X' || terreno[1][0] == '◯'){
                    return false;
                }
                break;
            case 5 :
                if(terreno[1][1] == 'X' || terreno[1][1] == '◯'){
                    return false;
                }
                break;
            case 6 :
                if(terreno[1][2] == 'X' || terreno[1][2] == '◯'){
                    return false;
                }
                break;
            case 7 :
                if(terreno[2][0] == 'X' || terreno[2][0] == '◯'){
                    return false;
                }
                break;
            case 8 :
                if(terreno[2][1] == 'X' || terreno[2][1] == '◯'){
                    return false;
                }
                break;
            case 9 :
                if(terreno[2][2] == 'X' || terreno[2][2] == '◯'){
                    return false;
                }
                break;
        }
        if(posicao >= 1 && posicao < 10){
            return true; //E se for maior ou igual que 0 e menor que o numero de colunas
        }
        return false;
    }
    static void printNames(String player1,String player2, int numero){
        if(numero %2 ==  1){
            System.out.println("\nTurno do "+ player1);
        }
        if(numero %2 == 0){
            System.out.println("\nTurno do "+ player2);
        }
    }
    static String[] getNames(){
        Scanner scan = new Scanner(System.in);
        String player1, player2;
        String[] result = new String[2];
        int count,i ;
        do{
            count = 0;
            i = 0;
            System.out.println("Introduza o nome do Player 1");
            player1 = scan.nextLine();
            if(player1 == null){
                System.out.println("Nome Inválido\n");
            }
            else{
                while (i != player1.length()){
                    if((player1.charAt(i) >= 65 && player1.charAt(i) <= 90) || (player1.charAt(i) >= 97 && player1.charAt(i) <= 122) || player1.charAt(i) == 32){
                        count ++;
                    }
                    i++;
                }

                if(player1.length() == 0 || count != player1.length()){
                    System.out.println("Nome Inválido\n");
                }
            }

        }while(player1.length() == 0 || count != player1.length());
        result[0] = correctFormatString(player1);
        do{
            count = 0;
            i = 0;
            System.out.println("Introduza o nome do Player 2");
            player2 = scan.nextLine();
            if(player2 == null){
                System.out.println("Nome Inválido");
            }
            else{
                while (i != player2.length()){
                    if((player2.charAt(i) >= 65 && player2.charAt(i) <= 90) || (player2.charAt(i) >= 97 && player2.charAt(i) <= 122) || player2.charAt(i) == 32){
                        count ++;
                    }
                    i++;
                }

                if(player2.length() == 0 || count != player2.length()){
                    System.out.println("Nome Inválido");
                }
            }

        }while(player2.length() == 0 || count != player2.length());
        result[1] = correctFormatString(player2);
        return result;
    }
    static String[] getOneName() {
        Scanner scan = new Scanner(System.in);
        String player1;
        String[] result = new String[2];
        int count, i;
        do {
            count = 0;
            i = 0;
            System.out.println("Introduza o seu nome(Exemplo: Bernardo Pinto)");
            player1 = scan.nextLine();
            if (player1 == null) {
                System.out.println("Nome Inválido\n");
            } else {
                while (i != player1.length()) {
                    if ((player1.charAt(i) >= 65 && player1.charAt(i) <= 90) || (player1.charAt(i) >= 97 && player1.charAt(i) <= 122) || player1.charAt(i) == 32) {
                        count++;
                    }
                    i++;
                }

                if (player1.length() == 0 || count != player1.length()) {
                    System.out.println("Nome Inválido\n");
                }
            }

        } while (player1.length() == 0 || count != player1.length());

        result[0] = correctFormatString(player1);

        return result;
    }
    static int[] getSpaces(String sentence){
        int[] result = new int[6];
        int numSpaces = 0;
        for (int i = 0; i < sentence.length(); i++) {
             if(sentence.charAt(i) == 32 && sentence.charAt(i+1) != 32){
                 result[numSpaces] = i;
                 numSpaces++;
             }

        }
        result[5] = numSpaces;
        return result;
    }
    static String correctFormatString(String name){
        int count2 = 1,numSpaces = 0,whereWeAre = 0;
        String result = "";
        String firstLtr = name.substring(0, 1).toUpperCase(), restLtrs = name.substring(1).toLowerCase();
        for (int k = 0; k <= getSpaces(name)[5]; k++) {
            firstLtr = name.substring(whereWeAre,whereWeAre+1).toUpperCase();
            if (getSpaces(name)[5] == numSpaces){
                restLtrs = name.substring(whereWeAre+1).toLowerCase();
            }
            else{
                restLtrs = name.substring(whereWeAre+1,getSpaces(name)[k]).toLowerCase();
            }
            numSpaces++;
            whereWeAre = getSpaces(name)[k] + 1;
            if (count2 == 1) {
                result = firstLtr + restLtrs;
            } else {
                result += " "+firstLtr +restLtrs;
            }
            count2++;
        }
        return result;
    }
    static int menuGame(){
        Scanner scan = new Scanner(System.in);
        int escolha = 0;
        System.out.println("\nBem Vindo ao Jogo do Galo\nMade by Piciano");
        do{
            System.out.println("\nEscolha o modo de jogo\n1 - VS\n2 - BOT Fácil\n3 - BOT Difícil(Novo Modo)\n4 - SAIR");
            String escolhaString = scan.nextLine();
            if(escolhaString == null || escolhaString.length() != 1){
                System.out.println("Posição Inválida, por favor escolha outra.");
            }
            else{
                escolha = escolhaString.charAt(0);
            }

            switch (escolha){
                case 49:
                    escolha = 1;
                    break;
                case  50:
                    escolha = 2;
                    break;
                case  51:
                    escolha = 3;
                    break;
                case  52:
                    escolha = 4;
                    break;
            }
            if(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4){
                System.out.println("\nOpção Inválida, Introduza Outra");
            }
        }while(escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4);

        return escolha;
    }

    //VERSUS
    static void versus(String[] names){
            Scanner scan = new Scanner(System.in);
            int count = 0;
            boolean end = false;
            char[][] terrain = new char[3][3];
            int player = 1;
            int posicao = 0;
            do {
                end = endGame(terrain, player, names[0], names[1]);

                if (!end) {
                    printNames(names[0], names[1], player);
                }
                System.out.println("\n" + terrain(terrain));

                if (end) {
                }
                else {
                    System.out.println("\nInsere um número (1-9):");
                    String posicaoString = scan.nextLine();

                    if(posicaoString == null || posicaoString.length() != 1){
                        System.out.println("Posição Inválida, por favor escolha outra.");
                    }
                    else{
                        posicao = posicaoString.charAt(0);
                    }

                    switch (posicao){
                        case 49:
                            posicao = 1;
                            break;
                        case  50:
                            posicao = 2;
                            break;
                        case  51:
                            posicao = 3;
                            break;
                        case  52:
                            posicao = 4;
                            break;
                        case  53:
                            posicao = 5;
                            break;
                        case  54:
                            posicao = 6;
                            break;
                        case  55:
                            posicao = 7;
                            break;
                        case  56:
                            posicao = 8;
                            break;
                        case  57:
                            posicao = 9;
                            break;
                    }


                    if (!(posicaoString == null || posicaoString.length() != 1) && !isPositionValid(terrain, posicao)) {
                        System.out.println("Posição Inválida, por favor escolha outra.");
                    }
                    if (isPositionValid(terrain, posicao)) {
                        count++;
                        player++;
                        positionsBoard(terrain, posicao, player);
                    }
                    end = endGame(terrain,player,names[0],names[1]);
                    if(end){
                        System.out.println(terrain(terrain));
                    }
                    else if(count == 9){
                        System.out.println(terrain(terrain));
                        System.out.println("\nNão houve nenhum vencedor.");
                        break;
                    }
                }
            }while (!end );
    }
    static int versusAll(){
        String[] names = getNames();
        int finalchoice = 1;
        String finalchoiceString;
        Scanner scan = new Scanner(System.in);
        do {
            if(finalchoice == 1){
                versus(names);
                System.out.println("\nGo Back?\n2 - YES\n\nPlay Again?\n1 - YES\n0 - NO");
                finalchoiceString = scan.nextLine();

                if(finalchoiceString == null){
                    System.out.println("Opção Inválida");
                }
                else if(finalchoiceString.length() == 1){
                    finalchoice = finalchoiceString.charAt(0);
                }
                switch (finalchoice){
                    case 48:
                        finalchoice = 0;
                        break;
                    case 49:
                        finalchoice = 1;
                        break;
                    case  50:
                        finalchoice = 2;
                        break;
                    case 1:
                        finalchoice = 5;
                        break;
                }
            }
            if(finalchoice == 0){
                return 0;
            }
            if (!(finalchoice == 1 || finalchoice == 2)) {
                System.out.println("Opção Inválida");
                System.out.println("\nGo Back?\n2 - YES\n\nPlay Again?\n1 - YES\n0 - NO");
                finalchoiceString = scan.nextLine();

                if(finalchoiceString == null ){
                    System.out.println("Opção Inválida");
                }
                else if(finalchoiceString.length() == 1){
                    finalchoice = finalchoiceString.charAt(0);
                }

                switch (finalchoice){
                    case 48:
                        finalchoice = 0;
                        break;
                    case 49:
                        finalchoice = 1;
                        break;
                    case  50:
                        finalchoice = 2;
                        break;
                }
            }

        } while (finalchoice != 2);
        return 2;
    }

    //BOT EASY
    static void botEasy (String[] names){
        Random random = new Random();
        names[1] = "Bot";

        Scanner scan = new Scanner(System.in);
        int count = 0;
        boolean end = false;
        char[][] terrain = new char[3][3];
        int player = 1;
        int linha = 0;
        int posicao = 0;
        do {

            end = endGame(terrain, player, names[0], names[1]);

            if (!end && player % 2 == 1) {
                printNames(names[0], names[1], player);
            }
            if(player % 2 == 1){
                if (linha != 0 && !end) {
                    System.out.println("\nO bot jogou na posição " + linha);
                }
                System.out.println("\n" + terrain(terrain));
            }

            if (end) {
            }
            else {
                if(player % 2 == 0){
                    do{
                        linha = random.nextInt(9);
                    } while (!isPositionValid(terrain,linha));
                    count++;
                    player++;
                    positionsBoard(terrain, linha, player);

                } else{
                    System.out.println("\nInsere um número (1-9):");
                    String posicaoString = scan.nextLine();

                    if(posicaoString == null || posicaoString.length() != 1){
                        System.out.println("Posição Inválida, por favor escolha outra.");
                    }
                    else{
                        posicao = posicaoString.charAt(0);
                    }

                    switch (posicao){
                        case 49:
                            posicao = 1;
                            break;
                        case  50:
                            posicao = 2;
                            break;
                        case  51:
                            posicao = 3;
                            break;
                        case  52:
                            posicao = 4;
                            break;
                        case  53:
                            posicao = 5;
                            break;
                        case  54:
                            posicao = 6;
                            break;
                        case  55:
                            posicao = 7;
                            break;
                        case  56:
                            posicao = 8;
                            break;
                        case  57:
                            posicao = 9;
                            break;
                    }


                    if (!(posicaoString == null || posicaoString.length() != 1) && !isPositionValid(terrain, posicao)) {
                        System.out.println("Posição Inválida, por favor escolha outra.");
                    }
                    if (isPositionValid(terrain, posicao)) {
                        count++;
                        player++;
                        positionsBoard(terrain, posicao, player);
                    }
                    end = endGame(terrain,player,names[0],names[1]);
                    if(end){
                        System.out.println(terrain(terrain));
                    }
                    else if(count == 9){
                        System.out.println(terrain(terrain));
                        System.out.println("\nNão houve nenhum vencedor.");
                        break;
                    }
                }
            }
        }while (!end );
    }
    static int botEasyAll(){
        String[] name = getOneName();
        int finalchoice = 1;
        String finalchoiceString ;
        Scanner scan = new Scanner(System.in);
        do {
            if(finalchoice == 1){
                botEasy(name);
                System.out.println("\nGo Back?\n2 - YES\n\nPlay Again?\n1 - YES\n0 - NO");
                finalchoiceString = scan.nextLine();

                if(finalchoiceString == null){
                    System.out.println("Opção Inválida");
                }
                else if(finalchoiceString.length() == 1){
                    finalchoice = finalchoiceString.charAt(0);
                }
                switch (finalchoice){
                    case 48:
                        finalchoice = 0;
                        break;
                    case 49:
                        finalchoice = 1;
                        break;
                    case  50:
                        finalchoice = 2;
                        break;
                    case 1:
                        finalchoice = 5;
                        break;
                }


            }
            if(finalchoice == 0){
                return 0;
            }
            if (!(finalchoice == 1 || finalchoice == 2)) {
                System.out.println("Opção Inválida");
                System.out.println("\nGo Back?\n2 - YES\n\nPlay Again?\n1 - YES\n0 - NO");
                finalchoiceString = scan.nextLine();

                if(finalchoiceString == null ){
                    System.out.println("Opção Inválida");
                }
                else if(finalchoiceString.length() == 1){
                    finalchoice = finalchoiceString.charAt(0);
                }

                switch (finalchoice){
                    case 48:
                        finalchoice = 0;
                        break;
                    case 49:
                        finalchoice = 1;
                        break;
                    case  50:
                        finalchoice = 2;
                        break;
                }
            }

        } while (finalchoice != 2);
        return 2;
    }

    //MINIMAX
    static void minimaxFinal(String[] names){
        Random random = new Random();
        names[1] = "Bot";

        int score ;
        int bestMove1 = 0;
        int bestMove2 = 0;
        int bestScore = 0;
        int numPlay = 0;


        Scanner scan = new Scanner(System.in);
        int count = 0;
        boolean end = false;
        char[][] terrain = terrainMinimax();
        int player = 1;
        int linha = 0;
        int posicao = 0;
        do {

            end = endGameMinimax2(terrain, player, names[0], names[1]);

            if (!end && player % 2 == 1) {
                printNames(names[0], names[1], player);
            }
            if(player % 2 == 1){
                if (numPlay != 0 && !end) {
                    System.out.println("\nO bot jogou na posição " + getMoveMinimax(bestMove1,bestMove2));
                }
                System.out.println("\n" + terrain(terrain));
                numPlay++;
            }

            if (end) {
            }
            else {
                if(player % 2 == 0){

                    for(int pos = 0; pos < 3; pos++){
                        for(int pos2 = 0; pos2 < 3; pos2++){
                            if(terrain[pos][pos2] == ' '){
                                terrain[pos][pos2] = '◯';
                                score = minimax(terrain,false);
                                terrain[pos][pos2] = ' ';
                                if(score >= bestScore){
                                    bestScore = score;
                                    bestMove1 = pos;
                                    bestMove2 = pos2;
                                }
                            }
                        }

                    }
                    count++;
                    player++;
                    terrain[bestMove1][bestMove2] = '◯';

                } else{
                    System.out.println("\nInsere um número (1-9):");
                    String posicaoString = scan.nextLine();

                    if(posicaoString == null || posicaoString.length() != 1){
                        System.out.println("Posição Inválida, por favor escolha outra.");
                    }
                    else{
                        posicao = posicaoString.charAt(0);
                    }

                    switch (posicao){
                        case 49:
                            posicao = 1;
                            break;
                        case  50:
                            posicao = 2;
                            break;
                        case  51:
                            posicao = 3;
                            break;
                        case  52:
                            posicao = 4;
                            break;
                        case  53:
                            posicao = 5;
                            break;
                        case  54:
                            posicao = 6;
                            break;
                        case  55:
                            posicao = 7;
                            break;
                        case  56:
                            posicao = 8;
                            break;
                        case  57:
                            posicao = 9;
                            break;
                    }


                    if (!(posicaoString == null || posicaoString.length() != 1) && !isPositionValid(terrain, posicao)) {
                        System.out.println("Posição Inválida, por favor escolha outra.");
                    }
                    if (isPositionValid(terrain, posicao)) {
                        count++;
                        player++;
                        positionsBoard(terrain, posicao, player);
                    }
                    end = endGameMinimax2(terrain,player,names[0],names[1]);
                    if(end){
                        System.out.println(terrain(terrain));
                    }
                    else if(count == 9){
                        System.out.println(terrain(terrain));
                        System.out.println("\nNão houve nenhum vencedor.");
                        break;
                    }
                }
            }
        }while (!end );
    }
    static int minimaxAll(){
        String[] name = getOneName();
        int finalchoice = 1;
        String finalchoiceString ;
        Scanner scan = new Scanner(System.in);
        do {
            if(finalchoice == 1){
                minimaxFinal(name);
                System.out.println("\nGo Back?\n2 - YES\n\nPlay Again?\n1 - YES\n0 - NO");
                finalchoiceString = scan.nextLine();

                if(finalchoiceString == null){
                    System.out.println("Opção Inválida");
                }
                else if(finalchoiceString.length() == 1){
                    finalchoice = finalchoiceString.charAt(0);
                }
                switch (finalchoice){
                    case 48:
                        finalchoice = 0;
                        break;
                    case 49:
                        finalchoice = 1;
                        break;
                    case  50:
                        finalchoice = 2;
                        break;
                    case 1:
                        finalchoice = 5;
                        break;
                }


            }
            if(finalchoice == 0){
                return 0;
            }
            if (!(finalchoice == 1 || finalchoice == 2)) {
                System.out.println("Opção Inválida");
                System.out.println("\nGo Back?\n2 - YES\n\nPlay Again?\n1 - YES\n0 - NO");
                finalchoiceString = scan.nextLine();

                if(finalchoiceString == null ){
                    System.out.println("Opção Inválida");
                }
                else if(finalchoiceString.length() == 1){
                    finalchoice = finalchoiceString.charAt(0);
                }

                switch (finalchoice){
                    case 48:
                        finalchoice = 0;
                        break;
                    case 49:
                        finalchoice = 1;
                        break;
                    case  50:
                        finalchoice = 2;
                        break;
                }
            }

        } while (finalchoice != 2);
        return 2;
    }
    static int minimax(char[][] terrain, boolean isMaximizing){
        int result = endGameMinimax(terrain);
        int score;
        if(result != ' '){
            if(result == '◯'){
                score = 1;
                return score;
            }
            else if(result == 'X'){
                score = -1;
                return score;
            }
            else if(result == 't'){
                score = 0;
                return score;
            }
        }

        if(isMaximizing){
            int bestScore = -1;
            for(int pos = 0; pos < 3; pos++){
                for(int pos2 = 0; pos2 < 3; pos2++){
                    if(terrain[pos][pos2] == ' '){
                        terrain[pos][pos2] = '◯';
                        score = minimax(terrain,false);
                        terrain[pos][pos2] = ' ';
                        bestScore = max(score,bestScore);
                    }
                }

            }
            return bestScore;
        }
        else{
            int bestScore = 0;
            for(int pos = 0; pos < 3; pos++){
                for(int pos2 = 0; pos2 < 3; pos2++){
                    if(terrain[pos][pos2] == ' '){
                        terrain[pos][pos2] = 'X';

                        score = minimax(terrain,true);
                        terrain[pos][pos2] = ' ';

                        bestScore = min(score,bestScore);

                    }
                }

            }
            return bestScore;
        }



    }

    //FUNCOES GERAIS MINIMAX
    static int getMoveMinimax(int bestMove1,int bestMove2){
        if(bestMove1 == 0 && bestMove2 == 0){
            return 1;
        }
        if(bestMove1 == 0 && bestMove2 == 1){
            return 2;
        }
        if(bestMove1 == 0 && bestMove2 == 2){
            return 3;
        }
        if(bestMove1 == 1 && bestMove2 == 0){
            return 4;
        }
        if(bestMove1 == 1 && bestMove2 == 1){
            return 5;
        }
        if(bestMove1 == 1 && bestMove2 == 2){
            return 6;
        }
        if(bestMove1 == 2 && bestMove2 == 0){
            return 7;
        }
        if(bestMove1 == 2 && bestMove2 == 1){
            return 8;
        }
        if(bestMove1 == 2 && bestMove2 == 2){
            return 9;
        }
        return 0;
    }
    static boolean endGameMinimax2 (char[][]terreno,int player,String player1,String player2){
        for ( int linha = 0; linha <=2;linha++){
            int coluna = 0;
            if(terreno[linha][coluna] != ' '){
                if( terreno[linha][coluna] == terreno[linha][coluna+1]&& terreno[linha][coluna+1] == terreno[linha][coluna+2]){
                    if(player %2 ==  1){
                        System.out.println("\nGANHOU o(a) " + player2 + "!!!!!\n");
                    }
                    if(player %2 ==  0){
                        System.out.println("\nGANHOU o(a) " + player1 + "!!!!!\n");
                    }
                    return true;
                }
            }
        }
        for(int coluna = 0;coluna<= 2;coluna++){
            int linha= 0;
            if(terreno[linha][coluna] != ' '){
                if(terreno[linha][coluna] == terreno[linha+1][coluna]&& terreno[linha+1][coluna] == terreno[linha+2][coluna]){
                    if(player %2 ==  1){
                        System.out.println("\nGANHOU o(a) " + player2 + "!!!!!");
                    }
                    if(player %2 ==  0){
                        System.out.println("\nGANHOU o(a) " + player1 + "!!!!!");
                    }
                    return true;
                }
            }
        }
        int linha = 0;
        int coluna = 0;
        if(terreno[linha][coluna] != ' ') {
            if (terreno[linha][coluna] == terreno[linha + 1][coluna + 1] && terreno[linha + 1][coluna + 1] == terreno[linha + 2][coluna + 2]) {
                if(player %2 ==  1){
                    System.out.println("\nGANHOU o(a) " + player2 + "!!!!!");
                }
                if(player %2 ==  0){
                    System.out.println("\nGANHOU o(a) " + player1 + "!!!!!");
                }
                return true;
            }
        }
        coluna = 2;
        if(terreno[linha][coluna] != ' ') {
            if (terreno[linha][coluna] == terreno[linha + 1][coluna - 1] && terreno[linha + 1][coluna - 1] == terreno[linha + 2][coluna - 2]) {
                if(player %2 ==  1){
                    System.out.println("\nGANHOU o(a) " + player2 + "!!!!!");
                }
                if(player %2 ==  0){
                    System.out.println("\nGANHOU o(a) " + player1 + "!!!!!");
                }
                return true;
            }
        }
        return false;
    }
    static char[][] terrainMinimax(){
        char[][] result = new char[3][3];
        for(int pos = 0; pos < 3; pos++){
            for(int pos2 = 0; pos2 < 3; pos2++){
                result[pos][pos2] = ' ';
            }
        }
        return result;
    }
    static char endGameMinimax (char[][]terreno){
        int count = 0;
        for ( int linha = 0; linha <=2;linha++){
            int coluna = 0;
            if(terreno[linha][coluna] != ' '){
                if(terreno[linha][coluna] == terreno[linha][coluna+1]&& terreno[linha][coluna+1] == terreno[linha][coluna+2]){
                    return terreno[linha][coluna];
                }
            }
        }
        for(int coluna = 0;coluna<= 2;coluna++){
            int linha= 0;
            if(terreno[linha][coluna] != ' '){
                if(terreno[linha][coluna] == terreno[linha+1][coluna]&& terreno[linha+1][coluna] == terreno[linha+2][coluna]){
                    return terreno[linha][coluna];
                }
            }
        }
        int linha = 0;
        int coluna = 0;
        if(terreno[linha][coluna] != ' ') {
            if (terreno[linha][coluna] == terreno[linha + 1][coluna + 1] && terreno[linha + 1][coluna + 1] == terreno[linha + 2][coluna + 2]) {
                return terreno[linha][coluna];
            }
        }
        coluna = 2;
        if(terreno[linha][coluna] != ' ') {
            if (terreno[linha][coluna] == terreno[linha + 1][coluna - 1] && terreno[linha + 1][coluna - 1] == terreno[linha + 2][coluna - 2]) {
                return terreno[linha][coluna];
            }
        }
        for(int pos = 0; pos < 3; pos++) {
            for (int pos2 = 0; pos2 < 3; pos2++) {
                if(terreno[pos][pos2] == ' '){
                    count++;
                }
            }
        }
        if(count == 0){
            return 't';
        }
        return ' ';
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        int finalchoice = 1;
        do {
            finalchoice = 1;
            choice = menuGame();
            if (choice == 4) {
                return;
            }
            if (choice == 1) {
                finalchoice = versusAll();
            } else if (choice == 2) {
                finalchoice = botEasyAll();
            } else if(choice == 3){
                finalchoice = minimaxAll();
            }
        }while(finalchoice == 2);

    }
}
