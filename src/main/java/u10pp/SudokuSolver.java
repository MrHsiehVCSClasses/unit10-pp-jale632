package u10pp;
import java.lang.Math.*;

class SudokuSolver{
    static int number;
    static int [][] listResult;
    static boolean success;

    public static void printResult(String s){
        System.out.println(s);
        for(int i = 0; i < listResult.length; i++){
            for(int j = 0; j < listResult.length; j++){
                System.out.printf("%3d ", listResult[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] solve(int[][] puzzle){
        number = puzzle.length;
        listResult = puzzle;
        // printResult("시작");
        dfs(0, 0);        
        // System.out.println(success);
        return listResult;
    }

    public static boolean check(int r, int c, int temp ){
        int cellSize = (int)(Math.sqrt(number));
        int tempR = (int)(r/cellSize) * cellSize; 
        int tempC = (int)(c/cellSize) * cellSize; 
        // System.out.println("중요!!!!" + number);
        for(int i = 0; i < number; i++){
            if(listResult[r][i] == temp){
                return false;
            }
        }
        for(int j = 0; j < number; j++){
            if(listResult[j][c] == temp){
                return false;
            }
        }
        for(int k = tempR; k < tempR + cellSize; k++){
            // System.out.println(tempC + "  cc  " + cellSize);
            for(int t = tempC; t < tempC + cellSize; t++){
                // System.out.println(k+ "    " + t);
                if (listResult[k][t] == temp){
                    // System.out.printf("%d,%d)=%d,temp=%d\n",k,t,listResult[k][t], temp);
                    // System.out.printf("%d,%d\n",r,c);
                    // System.out.printf("%d,%d\n",tempR,tempC);
                    // System.out.println(" ");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int r, int c){
        if(success == true){
            return true;
        }
        if(c == number){
            return dfs(r + 1, 0);
        }
        if(r == number){
            success = true;
            return true;
        }
        if(listResult[r][c] == 0){
            for(int i = 1; i < number + 1; i++){
                if(check(r, c, i) == true){
                    listResult[r][c] = i;
                    // printResult("true결과 체크 성공" + r + "  " +c);
                    if(dfs(r, c + 1) != true){
                        listResult[r][c] = 0;
                        // printResult("dfs 실패");
                    }
                }
            }
        }
        else{
            return dfs(r, c + 1);
        }  
    return success;
    }
}