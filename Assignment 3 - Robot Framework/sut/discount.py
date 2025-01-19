"""
This program is used by an online shop to determine whether
a customer should get a price discount on their next purchase,
based on their bonus points to date, and whether they are a gold customer.
Bonus points accumulate as customers make purchases.

Gold customers get a discount once they have exceeded 80 bonus points.
Other customers only get a discount once they have more than 120 bonus points.
All customers always have at least one bonus point. The maximum amount of bonus points per customer is 10 000.

he inputs are
- the number of bonusPoints the customer has,
- a flag indicating whether the customer is a gold customer or not (true or false, respectively).

The program returns one of the following:
FULLPRICE, which indicates that the customer should be charged the full price.
DISCOUNT, which indicates that the customer should be given a discount.

NOTE: for the sake of simplicity, we will ignore illegal input values at the moment
 where the first parameter is not a number, or the second parameter is not a Boolean).
"""
DISCOUNT: int = 1
FULLPRICE: int = 0
ERROR: int = -1


def discount(bonus_points: int, gold_customer: bool):

    # All customers always have at least one bonus point.
    if bonus_points < 1:
        return ERROR

    # Gold customers get a discount once they have exceeded 80 bonus points.
    if gold_customer and bonus_points >= 80:
        return DISCOUNT

    # Other customers only get a discount once they have more than 120 bonus points.
    if not gold_customer and  bonus_points >= 120:
        return DISCOUNT

    return FULLPRICE