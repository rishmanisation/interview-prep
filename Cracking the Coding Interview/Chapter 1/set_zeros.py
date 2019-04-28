# CTCI Problem 1.7

def set_zeros(arr):
    M = len(arr)
    N = len(arr[0])
    row_zeros = [False for i in range(M)]
    col_zeros = [False for i in range(N)]

    for i in range(M):
        for j in range(N):
            if arr[i][j] == 0:
                row_zeros[i] = True
                col_zeros[j] = True
    
    for i in range(M):
        for j in range(N):
            if row_zeros[i] or col_zeros[j]:
                arr[i][j] = 0

def print_matrix(arr):
    for row in arr:
        for col in row:
            print(col, end=' ')
        print('')

if __name__ == '__main__':
    arr = [[1, 2, 3], [4, 5, 0], [6, 7, 8], [9, 0 ,1]]
    print('Before')
    print_matrix(arr)

    set_zeros(arr)
    
    print('After')
    print_matrix(arr)