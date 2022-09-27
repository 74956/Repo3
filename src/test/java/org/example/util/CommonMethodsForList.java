package org.example.util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonMethodsForList {

    public static List<String> getTextFromElements(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public static void clickOnFirstElementInListOfItems(List<WebElement> list) {
        list.stream().findAny().ifPresent(WebElement::click);
    }

    public static List<Integer> convertElementsIntoInteger(List<WebElement> list) {
        String str = null;
        int b;
        List<Integer> newList = new ArrayList<>();
        List<String> listOfText = getTextFromElements(list);
        for (String s : listOfText) {
            if (s.contains(",")) {
                str = s.replace(",", "");
            } else {
                b = Integer.parseInt(str);
                newList.add(b);
            }
        }
        return newList;
    }

    public static int getRandomIndexInList(List<WebElement> list) {
        Random rnd = new Random();
        return rnd.nextInt(list.size());
    }

    public static boolean isListContainsString(List<String> list, String str) {
        boolean result = false;
        for (String s : list) {
            result = s.contains(str);
        }
        return result;
    }
}