from sut.Alarm import Alarm


class AlarmLibrary1:

    def __init__(self):
        self.alarm = Alarm()
        self.alarm.reset()

    def reset(self):
        self.alarm.reset()

    def verify_arm(self, expected):
        result = self.alarm.arm()
        if result != expected:
            raise AssertionError('Verify: (actual) {} != {} (expected)'.format(result, expected))

    def verify_disarm(self, expected):
        result = self.alarm.disarm()
        if result != expected:
            raise AssertionError('Disarm: (actual) {} != {} (expected)'.format(result, expected))

    def verify_close_doors(self, expected):
        result = self.alarm.close_doors()
        if result != expected:
            raise AssertionError('Close doors: (actual) {} != {} (expected)'.format(result, expected))

    def verify_open_doors(self, expected):
        result = self.alarm.open_doors()
        if result != expected:
            raise AssertionError('Open doors: (actual) {} != {} (expected)'.format(result, expected))


