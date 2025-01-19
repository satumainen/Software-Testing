from sut import discount


class DiscountLibrary:

    def __init__(self):
        print("Discount initialized")
        self._result = None

    def get_discount(self, points, gold):
        self._result = discount.discount(points, gold)

    def result_should_be(self, expected):
        if self._result != expected:
            raise AssertionError('{} != {}'.format(self._result, expected))
