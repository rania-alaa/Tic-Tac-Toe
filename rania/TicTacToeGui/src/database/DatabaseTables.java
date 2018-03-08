/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author rania
 */
public class DatabaseTables {
   
    static class PlayerTable{
        public static String tableName="player";
        public static int playerIdColumn=0;
        public static String nameColumn="name";
    }
        
   static class GameTable{
       public static String tableName="game";
       public static int gameIdColumn=0;
       public static int PlayerID1Column=0;
       public static int PlayerID2Column=0;
       public static String patternColumn="pattern";
       // public static String requestFlagColumn="requestFlag";
   }   
}
