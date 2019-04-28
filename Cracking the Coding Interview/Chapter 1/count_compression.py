# CTCI Problem 1.5

def count_compression(s):
    if len(s) < 3:
        return s
    
    res_list = []
    prev_char = s[0]
    curr_count = 1

    for i in range(1, len(s)):
        if s[i] == prev_char:
            curr_count += 1
        else:
            res_list.append(prev_char)
            res_list.append(str(curr_count))
            curr_count = 1
    
        prev_char = s[i]
    
    res_list.append(prev_char)
    res_list.append(str(curr_count))
    result = ''.join(res_list)
    if len(result) >= len(s):
        return s
    
    return result

if __name__ == '__main__':
    print(count_compression('aabcccccaa'))
    print(count_compression('aab'))
    print(count_compression('a'))
    print(count_compression('aaab'))
    print(count_compression('aaaabb'))