import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.filechooser.*;

import javax.swing.event.*;

public class Main {

    public static void main(String[] args) {
        List<String> strList = new LinkedList<>();
        strList.add("aaaccc");
        strList.add("bbbccc");
        strList.add("cccd");

        strList.stream()
                .filter(str -> str.length() > 5)
                .forEach(str -> System.out.println(str));
    }
}