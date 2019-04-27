import has_only_unique as hou, reverse as r, is_permutation as ip, replace_spaces as rs

import unittest

class TestSolutions(unittest.TestCase):
    def test_prob_1(self):
        self.assertTrue(hou.has_only_unique('a'))
        self.assertTrue(hou.has_only_unique(''))
        self.assertFalse(hou.has_only_unique('aaab'))
        self.assertTrue(hou.has_only_unique('abcdegf'))
        self.assertFalse(hou.has_only_unique('abcbda'))
    
    def test_prob_2(self):
        self.assertEqual(r.reverse('a'), 'a')
        self.assertEqual(r.reverse('ab'), 'ba')
        self.assertEqual(r.reverse('aaaaa'), 'aaaaa')
        self.assertEqual(r.reverse('abcdfe'), 'efdcba')
        self.assertEqual(r.reverse('abcq'), 'qcba')
    
    def test_prob_3(self):
        self.assertFalse(ip.is_permutation('a', 'aa'))
        self.assertTrue(ip.is_permutation('a', 'a'))
        self.assertTrue(ip.is_permutation('ab', 'ba'))
        self.assertFalse(ip.is_permutation('ab', 'aa'))
        self.assertTrue(ip.is_permutation('abcd', 'badc'))
        self.assertFalse(ip.is_permutation('abcd', 'bacf'))
        self.assertTrue(ip.is_permutation('abcabc', 'baccab'))
        self.assertFalse(ip.is_permutation('abcabc', 'bacdab'))
    
    def test_prob_4(self):
        self.assertEqual(rs.replace_spaces('Mr John Smith    ', 13), 'Mr%20John%20Smith')
        self.assertEqual(rs.replace_spaces('Rishabh Ananthan  ', 16), 'Rishabh%20Ananthan')


if __name__ == '__main__':
    unittest.main()