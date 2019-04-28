# CTCI Problem 1.6

def rotate_image(image):
    N = len(image)
    layers = int(N/2)
    for i in range(layers):
        start = i
        end = N - 1 - i
        for k in range(start, end):
            offset = k - start
            top = image[start][k]
            image[start][k] = image[end - offset][start]
            image[end - offset][start] = image[end][end - offset]
            image[end][end - offset] = image[k][end]
            image[k][end] = top

def print_image(image):
    for row in image:
        for col in row:
            print(col, end=' ')
        print('')

if __name__ == '__main__':
    image = [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15], [16, 17, 18, 19, 20], [21, 22, 23, 24, 25]]
    print('Unrotated')
    print_image(image)
    
    print('Rotated')
    rotate_image(image)
    print_image(image)