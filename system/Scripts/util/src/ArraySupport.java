package java.util;

import java.game.GameLogic;
import java.game.parts.bodypart.Chassis;
import java.io.*;
import java.util.*;

public class ArrayHelper extends GameType
{

    public static void sortByValue(Vector vehicles) {
        int VehAmount = vehicles.size();
        for (int i = 0; i < VehAmount; i++) {
            for (int j = 0; j < VehAmount - i; j++) {
                Chassis veh1 = vehicles.elementData[j];
                Chassis veh2 = vehicles.elementData[j + 1];

                if (veh1.value < veh2.value) {
                    vehicles.elementData[j] = veh2;
                    vehicles.elementData[j + 1] = veh1;
                }
            }
        }
    }
}

