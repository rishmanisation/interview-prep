# CTCI Problem 1.1
# Assuming only lowercase alphabets. For different character sets approach will be similar but
# map size will be different.
def has_only_unique(str):
    if len(str) < 2:
        return True
    
    map = [False for i in range(26)]
    for c in str:
        if map[ord(c) - 97]:
            return False
        map[ord(c) - 97] = True
    
    return True

