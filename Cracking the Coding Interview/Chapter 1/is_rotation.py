# CTCI Problem 1.8

def is_substring(s1, s2):
    return s1.find(s2) != -1

def is_rotation(s1, s2):
    if not s1 or not s2 or len(s1) != len(s2):
        return False
    
    s1s1 = s1 + s1
    return is_substring(s1s1, s2)

if __name__ == '__main__':
    s1 = 'waterbottle'
    s2 = 'erbottlewat'
    print(is_rotation(s1, s2))

    s1 = 'gagagugu'
    s2 = 'agagugum'
    print(is_rotation(s1, s2))