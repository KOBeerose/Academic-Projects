from typing import List

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool: 
        for i in range(len(board)):
            row_count = {}
            col_count = {}
            box_count = {}
            for j in range(len(board)):
                if board[i][j] != ".":
                    row_count[board[i][j]] = 1 + row_count.get(board[i][j], 0)
                if board[j][i] != ".":
                    col_count[board[j][i]] = 1 + col_count.get(board[j][i], 0)
                if board[(i//3)*3+j//3][j%3+(i%3)*3] != ".":
                    box_count[board[(i//3)*3+j//3][j%3+(i%3)*3]] = 1 + box_count.get(board[(i//3)*3+j//3][j%3+(i%3)*3], 0)
                if row_count.get(board[i][j], 0)==2 or col_count.get(board[j][i], 0)==2 or box_count.get(board[(i//3)*3+j//3][j%3+(i%3)*3], 0)==2:
                    return False
        return True
                    
                    

board = [["5","3",".",".","7",".",".",".","."] ,
         ["6",".",".","1","9","5",".",".","."] ,
         [".","9","8",".",".",".",".","6","."] ,
         ["8",".",".",".","6",".",".",".","3"] ,
         ["4",".",".","8",".","3",".",".","1"] ,
         ["7",".",".",".","2",".",".",".","6"] ,
         [".","6",".",".",".",".","2","8","."] ,
         [".",".",".","4","1","9",".",".","5"] ,
         [".",".",".",".","8",".",".","7","9"]]

 
board2 = [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]

mysolution = Solution()
print(mysolution.isValidSudoku(board))