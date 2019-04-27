# CTCI Problem 1.2
# Although description says C/C++ done in Python. Implementation in C/C++ should be similar.
# Note that python strings are immutable. Hence we are converting to char list.

def reverse(str):
    if len(str) < 2:
        return str
    
    chars = list(str)
    start = 0
    end = len(str) - 1
    while start < end:
        temp = chars[start]
        chars[start] = chars[end]
        chars[end] = temp
        start += 1
        end -= 1
    
    return ''.join(chars)
