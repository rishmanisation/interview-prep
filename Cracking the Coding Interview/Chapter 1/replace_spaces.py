# CTCI Problem 1.4
# Since we are given space padded string we just use that length as length of 
# new string instead of computing the number of spaces.
# Done in place but for test purposes returning a new string.
# Assume string has at least one space in it.
# Assume string is padded with spaces at the end to store the extra characters.

def replace_spaces(str, true_len):
    chars = list(str)
    new_len = len(str)
    for i in range(true_len - 1, -1, -1):
        if chars[i] == ' ':
            chars[new_len - 1] = '0'
            chars[new_len - 2] = '2'
            chars[new_len - 3] = '%'
            new_len -= 3
        else:
            chars[new_len - 1] = chars[i]
            new_len -= 1
    return ''.join(chars)
