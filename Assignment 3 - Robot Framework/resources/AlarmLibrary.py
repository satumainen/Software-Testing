from sut.Alarm import Alarm


class AlarmLibrary:

    def __init__(self):
        self.alarm = Alarm()
        self.alarm.reset()
        self._result = 0

    def reset(self):
        self.alarm.reset()
        self._result = 0

    def arm(self):
        self._result = self.alarm.arm()

    def disarm(self):
        self._result = self.alarm.disarm()

    def close_doors(self):
        self._result = self.alarm.close_doors()

    def open_doors(self):
        self._result = self.alarm.open_doors()

    def result_should_be(self, expected):
        if self._result != expected:
            raise AssertionError('(actual) {} != {} (expected)'.format(self._result, expected))

