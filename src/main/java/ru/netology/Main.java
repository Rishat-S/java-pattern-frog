package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Frog
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<FrogCommands> commands = new ArrayList<>();
        int curCommand = -1;

        while (true) {
            String input = reader.readLine();
            if (input.equals("0")) {
                break;
            }

            // TODO

//            if (/*пользователь хочет отменить действие*/) {
//                if (curCommand < 0) {
//                    System.out.println("Нечего отменять!");
//                } else {
//                    commands.get(curCommand).undo();
//                    curCommand--;
//                }
//            } else if (/*пользователь хочет повторить действие*/) {
//                if (curCommand == commands.size() - 1) {
//                    System.out.println("Нечего отменять!");
//                } else {
//                    curCommand++;
//                    commands.get(curCommand).redo();
//                }
//            } else { //пользователь ввёл новое движение для лягушки
//                if (curCommand != commands.size() - 1) {
//                    //удаляем все команды которые были отменены
//                }
//                FrogCommand cmd = ...
//                curCommand++;
//                commands.add(cmd);
//                cmd.redo();
//            }

            //рисуем поле после команды
        }
    }
}
