# Enter your code here. Read input from STDIN. Print output to STDOUT
from sys import stdin
import itertools

class Card(object):
    def __init__(self, card_string):
        value = card_string[0]
        if value >= '2' and value <= '9':
            self.rank = int(value)
        elif value == 'T':
            self.rank = 10
        elif value == 'J':
            self.rank = 11
        elif value == 'Q':
            self.rank = 12
        elif value == 'K':
            self.rank = 13
        elif value == 'A':
            self.rank = 14
        else:
            self.rank = 0
        
        self.suit = card_string[1]
    
    def get_rank(self):
        return self.rank
    
    def get_suit(self):
        return self.suit 
    
    def __repr__(self):
        return str(self.rank) + '-' + str(self.suit)

def get_ranks(hand):
    ranks = []
    for card in hand:
        ranks.append(card.get_rank())

    return ranks

def get_suits(hand):
    suits = []
    for card in hand:
        suits.append(card.get_suit())

    return suits

def evaluate_hand(hand):
    ranks = get_ranks(hand)
    suits = get_suits(hand)

    if len(set(hand)) < len(hand) or max(ranks) > 14 or min(ranks) < 2:
        return 'invalid-hand'

    if len(set(ranks)) == len(ranks) and max(ranks) - min(ranks) == len(ranks) - 1:
        if len(set(suits)) == 1:
            return 'straight-flush'
        return 'straight'

    if len(set(suits)) == 1:
        return 'flush'

    total = sum([ranks.count(x) for x in ranks])
    hand_types = {
        17: 'four-of-a-kind',
        13: 'full-house',
        11: 'three-of-a-kind',
        9: 'two-pairs',
        7: 'one-pair',
        5: 'highest-card'
    }
    return hand_types[total]

def get_best_hand(all_cards):
    all_combinations = itertools.combinations_with_replacement(all_cards, 5)
    hand_types = [
        'invalid-hand',
        'highest-card',
        'one-pair',
        'two-pairs',
        'three-of-a-kind',
        'straight',
        'flush',
        'full-house',
        'four-of-a-kind',
        'straight-flush'
    ]
    max_value = 0
    best_hands = {x: [] for x in range(len(hand_types))}
    for combination in all_combinations:
        cards = list(combination)
        hand_type = evaluate_hand(cards)
        hand_value = hand_types.index(hand_type)
        if hand_value >= max_value:
            max_value = hand_value
            best_hands[hand_value].append(cards)
    
    max_hand_index = max(k for k, v in best_hands.items() if len(best_hands[k]) > 0)
    rank_sum = 0
    max_sum = 0
    for hand in best_hands[max_hand_index]:
        ranks = get_ranks(hand)
        rank_sum = sum(ranks)
        if rank_sum > max_sum:
            max_sum = rank_sum
            best_hand = hand
    
    return best_hand

lines = [
    'TH JH QC QD QS QH KH AH 2S 6S',
    '2H 2S 3H 3S 3C 2D 3D 6C 9C TH',
    '2H 2S 3H 3S 3C 2D 9C 3D 6C TH',
    '2H AD 5H AC 7H AH 6H 9H 4H 3C',
    'AC 2D 9C 3S KD 5S 4D KS AS 4C',
    'KS AH 2H 3C 4H KC 2C TC 2D AS',
    'AH 2C 9S AD 3C QH KS JS JD KD',
    '6C 9C 8C 2D 7C 2H TC 4C 9S AH',
    '3D 5S 2H QD TD 6S KH 9H AD QH'
    ]

for line in lines:
    cards = line.strip().split()
    all_cards = []
    for card in cards:
        all_cards.append(Card(card))
    hand = cards[0:5]
    deck = cards[5:]

    print('Hand:', end=' ')
    for card in hand:
        print(card, end=' ')
    
    print('Deck:', end=' ')
    for card in deck:
        print(card, end=' ')

    best_hand = get_best_hand(all_cards)
    best_hand_type = evaluate_hand(best_hand)
    print('Best hand: ' + best_hand_type)