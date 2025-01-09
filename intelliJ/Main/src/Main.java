import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import javax.swing.event.*;

public class Main {

    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};

        Arrays.sort(arr);
        for(int n : arr) System.out.println(n);
    }
}