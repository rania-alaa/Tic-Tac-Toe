/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Asmaa
 */
public class DatabaseTables {
   static class PlayerTable{
        public static String tableName="player";
        public static String playerIdColumn="playerId";
        public static String nameColumn="name";
      }
        // public static String emailColumn="email";
        // public static String passwordColumn="password";
        // public static String genderColumn="gender";
        // public static String statusColumn="status";
        // public static String statusFlagColumn="statusFlag";
       
    }
   static class GameTable{
       public static String tableName="game";
       public static String gameIdColumn="gameID";
       public static String patternColumn="pattern";
       // public static String requestFlagColumn="requestFlag";

   }
    
}
