# CTCI Problem 1.3
# Assuming only lowercase alphabet

def is_permutation(s1, s2):
    if len(s1) != len(s2):
        return False
    
    counts = [0 for i in range(26)]
    for c in s1:
        counts[ord(c) - 97] += 1
    
    for c in s2:
        counts[ord(c) - 97] -= 1
        if counts[ord(c) - 97] < 0:
            return False
    
    return True