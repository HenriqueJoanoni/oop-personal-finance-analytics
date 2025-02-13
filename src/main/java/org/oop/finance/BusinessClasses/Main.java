package org.oop.finance.BusinessClasses;

import org.oop.finance.Exception.DAOException;
import org.oop.finance.assets.ShowMenu;

import java.text.ParseException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws DAOException, ParseException {
        Locale.setDefault(Locale.UK);
        ShowMenu menu = new ShowMenu();
        System.out.println("""
                
                
                d8888b. d88888b d8888b. .d8888.  .d88b.  d8b   db  .d8b.  db     \s
                88  `8D 88'     88  `8D 88'  YP .8P  Y8. 888o  88 d8' `8b 88     \s
                88oodD' 88ooooo 88oobY' `8bo.   88    88 88V8o 88 88ooo88 88     \s
                88~~~   88~~~~~ 88`8b     `Y8b. 88    88 88 V8o88 88~~~88 88     \s
                88      88.     88 `88. db   8D `8b  d8' 88  V888 88   88 88booo.\s
                88      Y88888P 88   YD `8888Y'  `Y88P'  VP   V8P YP   YP Y88888P\s
                                                                                 \s
                                                                                 \s
                d88888b d888888b d8b   db  .d8b.  d8b   db  .o88b. d88888b .d8888.
                88'       `88'   888o  88 d8' `8b 888o  88 d8P  Y8 88'     88'  YP
                88ooo      88    88V8o 88 88ooo88 88V8o 88 8P      88ooooo `8bo. \s
                88~~~      88    88 V8o88 88~~~88 88 V8o88 8b      88~~~~~   `Y8b.
                88        .88.   88  V888 88   88 88  V888 Y8b  d8 88.     db   8D
                YP      Y888888P VP   V8P YP   YP VP   V8P  `Y88P' Y88888P `8888Y'
                
                """);
        menu.displayMenu();
    }
}