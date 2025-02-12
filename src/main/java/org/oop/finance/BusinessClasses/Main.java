package org.oop.finance.BusinessClasses;

import org.oop.finance.Exception.DAOException;
import org.oop.finance.assets.ShowMenu;

import java.text.ParseException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws DAOException, ParseException {
        Locale.setDefault(Locale.UK);
        ShowMenu menu = new ShowMenu();
        menu.displayMenu();
    }
}