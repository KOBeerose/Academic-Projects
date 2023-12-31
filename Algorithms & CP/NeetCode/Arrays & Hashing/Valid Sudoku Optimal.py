import collections
class Solution:
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        cols = collections.defaultdict(set)
        rows = collections.defaultdict(set)
        squares = collections.defaultdict(set)
        for row in range(9):
            for col in range(9):
                if board[row][col] == ".":
                    continue
                if board[row][col] in cols[col] or board[row][col] in rows[row] or board[row][col] in squares[(row//3,col//3)]:
                    return False
                cols[col].add(board[row][col])
                rows[row].add(board[row][col])
                squares[(row//3,col//3)].add(board[row][col])
        return True

                    
                    

board =[['1', '8', '3', '2', '6', '4', '7', '5', '9'],
        ['5', '7', '9', '8', '1', '3', '2', '6', '4'],
        ['6', '2', '4', '7', '5', '9', '8', '1', '3'],
        ['2', '9', '6', '3', '7', '5', '4', '8', '1'],
        ['7', '3', '5', '4', '8', '1', '9', '2', '6'],
        ['8', '4', '1', '9', '2', '6', '3', '7', '5'],
        ['4', '6', '8', '5', '9', '2', '1', '3', '7'],
        ['3', '1', '7', '6', '4', '8', '5', '9', '2'],
        ['9', '5', '2', '1', '3', '7', '6', '4', '8']]

 
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
print(mysolution.isValidSudoku(board2))